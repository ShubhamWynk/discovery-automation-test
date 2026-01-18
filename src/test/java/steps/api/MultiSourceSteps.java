package steps.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.Common.arsenalCollection.*;
import model.Common.arsenalCollection.constants.Operator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import model.Common.UserInfo;
import model.response.userPersona.UserPersonaDTO;
import org.junit.Assert;
import services.discovery.ArsenalService;
import services.discovery.DownStreamService;
import utilities.Utils;

import java.util.*;
import java.io.IOException;


import static helpers.ApiHelper.gson;
import static utilities.Utils.convertMapOfStringToMapOfList;


public class MultiSourceSteps {
    String multiSourceBaseUrl = DownStreamService.getCollectionUrls("multiSourceApiUrl");
    String multiSourceUrl = multiSourceBaseUrl + "/v1/content";
    ArsenalCollection response;
    ArsenalCollection req;
    MultiSourceRequest mutiSourceRequest;
    PostProcessing postProcessing;

    String[] CPList = {
            "LIONSGATEPLAY",
            "SONYLIV_VOD",
            "CHAUPAL",
            "ZEEFIVE",
            "MINITV",
            "HOTSTAR_DTH",
            "VROTT",
            "ULTRA",
            "HOICHOI",
    };

    public static Set<String> getUserLanguage(String type, UserPersonaDTO userPersona, Map<String, String> liveAttribute) {
        Set<String> userLangList = new HashSet<>();

        List<String> userSelectedLang = liveAttribute.containsKey("languages")
                ? List.of(liveAttribute.get("languages").split(","))
                : List.of(userPersona.getXstreamOnboardingUsl());
        List<String> dominantLang = type.startsWith("c")
                ? List.of(userPersona.getClickPersonaDominantLang().split(","))
                : List.of(userPersona.getXstreamDominantLanguageDaily().split(","));
        List<String> significantLang = type.startsWith("c")
                ? List.of(userPersona.getClickPersonaSignificantLang().split(","))
                : userPersona.getXstreamSignificantLanguageDaily();

        switch (type) {
            case "usl" -> userLangList.addAll(userSelectedLang);
            case "ucl", "cucl" -> {
                userLangList.addAll(dominantLang);
                userLangList.addAll(significantLang);
            }
            case "ul", "cul" -> {
                userLangList.addAll(dominantLang);
                userLangList.addAll(significantLang);
                userLangList.addAll(userSelectedLang);
            }
            case "usil", "cusil" -> userLangList.addAll(significantLang);
            case "udl", "cudl" -> userLangList.addAll(dominantLang);
            default -> Collections.emptyList();
        }
        return userLangList;
    }

    @And("build multiSource request in dynamic Meta")
    public void buildMultiSourceRequestInDynamicMeta(List<MultiSourceRequest> mutiSourceRequest) {
        this.mutiSourceRequest = mutiSourceRequest.getFirst();
    }

    @And("post process request with")
    public void postProcessRequestWith(PostProcessing postProcessing) {
        this.postProcessing = postProcessing;
        req.getDynamicMeta().getMixParam().setPostProcessing(this.postProcessing);
    }

    @And("build source collection list request for multiSource")
    public void buildSourceCollectionListRequestForMultiSource(DataTable dataTable) throws IOException {
        List<Map<String, String>> data = Utils.convertDataTableToMap(dataTable);
        List<SourceCollection> sourceCollectionList = new ArrayList<>();

        data.forEach(row -> {
            SourceCollection sourceCollection = new SourceCollection();

            sourceCollection.setCollectionId(row.get("collectionId"));
            sourceCollection.setOperator(Operator.valueOf(row.get("operator")));
            if (row.containsKey("order") && row.get("order") != null) {
                sourceCollection.setOrder(Long.valueOf(row.get("order")));
            }
            if (row.containsKey("score") && row.get("score") != null) {
                sourceCollection.setScore(Double.valueOf(row.get("score")));
            }
            if (row.containsKey("type") && row.get("type") != null) {
                sourceCollection.setType(row.get("type"));
            }
            if (row.containsKey("params") && row.get("params") != null) {
                Map<String, List<String>> params = Utils.convertIntoParamsObject(row.get("params"));
                sourceCollection.setParams(params);
            }
            if (row.containsKey("contents") && row.get("contents") != null) {
                ArsenalCollection tem = ArsenalService.getArsenalCollectionController(row.get("collectionId"), UserInfo.liveAttribute);
                List<Content> contentList = tem.getContents();
                row.get("contents").lines().forEach(con -> {
                    String[] replaceContent = con.split(":");
                    contentList.get(Integer.parseInt(replaceContent[1])).setContentId(replaceContent[0]);
                    contentList.get(Integer.parseInt(replaceContent[1])).setType(Utils.contentType(replaceContent[0]));
                });
                sourceCollection.setContents(contentList);
            }

            if (row.containsKey("contents_list") && row.get("contents_list") != null) {
                List<Content> contentList = new ArrayList<>();
                List<String> tempList = List.of(row.get("contents_list").split(","));
                tempList.forEach(con -> {
                    Content content = new Content();
                    String[] replaceContent = con.split(":");
                    content.setContentId(replaceContent[0]);
                    content.setPosition(Long.valueOf(replaceContent[1]));
                    content.setType(Utils.contentType(replaceContent[0]));
                    contentList.add(content);
                });
                sourceCollection.setContents(contentList);
            }

//            if (row.containsKey("filters")) {
//                Map<String,List<String>> params = Utils.convertIntoParamsObject(row.get("params"));
//                SourceCollection.setFilters(params);
//            }
            sourceCollectionList.add(sourceCollection);
        });
        this.mutiSourceRequest.setCollections(sourceCollectionList);
    }

    @And("pass params for multiSource request")
    public void passParamsForMultiSourceRequest(DataTable dataTable) throws IOException {
        Map<String, String[]> params = convertMapOfStringToMapOfList(Utils.convertDataTableToMap(dataTable).getFirst());
        req = CommonSteps.createDownStreamApiRequest("multi-source", params, multiSourceUrl);
        req.getDynamicMeta().getMixParam().setMultiSourceRequest(this.mutiSourceRequest);
    }

    @And("fetch response for multiSource request")
    public void fetchResponseForMultiSourceRequest() throws IOException {
        Response res = DownStreamService.applyMultiSourceCollection(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }

    @Then("Verify sports content should be visible on top of the banner")
    public void sportsContentShouldBeVisibleOnTopOfTheBanner() {
        for (int i = 0; i < response.getContents().size(); i++) {
            if (response.getContents().get(i).getExtras().containsKey("_isSports")
                    && response.getContents().get(i).getExtras().get("_isSports").equals("true")
                    && response.getContents().get(i).getExtras().get("_liveEvent").equals("true")) {
                Assert.assertTrue(response.getContents().get(i).getPosition() < 7);
                Assert.assertFalse(response.getContents().get(i).getPosition() >= 7);
            }
        }
    }

    @Then("Verify no erotic content is present in the Banner")
    public void verifyNoEroticContentIsPresentInTheBanner() throws JsonProcessingException {
        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertFalse(response.getContents().get(i).getExtras().containsKey("_adultContent"));
        }
    }

    @Then("Verify all content in Banner is from User languages")
    public void verifyAllContentInBannerIsFromUserLanguages() {
        for (int i = 0; i < response.getContents().size(); i++) {
            Assert.assertTrue(
                    getUserLanguage("cul", UserInfo.userPersona, UserInfo.liveAttribute)
                            .contains(response.getContents().get(i).getExtras().get("_language"))
            );
        }
    }

    @And("Verify if pinned tile is present then sports content should not take that position and should be visible on next position.")
    public void verifyIfPinnedTileIsPresentThenSportsContentShouldNotTakeThatPositionAndShouldBeVisibleOnNextPosition() {
        Assert.assertEquals("tlxsta_zy8n02301756717793339", response.getContents().get(0).getContentId());
        Assert.assertEquals("tlxsta_225h79991767071939478", response.getContents().get(1).getContentId());
    }

    @Then("Verify both sports content should be visible on top in dec order of score.")
    public void verifyBothSportsContentShouldBeVisibleOnTopInDecOrderOfScore() {
        Assert.assertEquals("tlxsta_9kne94541757784501944", response.getContents().get(1).getContentId());
        Assert.assertEquals("tlxsta_225h79991767071939478", response.getContents().get(0).getContentId());
    }

    @Then("Verify 1 sports content should be visible on 2 and second on 4 in dec order of score.")
    public void verifySportsContentShouldBeVisibleOnAndSecondOnInDecOrderOfScore() {
        Assert.assertEquals("tlxsta_zy8n02301756717793339", response.getContents().get(0).getContentId());
        Assert.assertEquals("tlxsta_225h79991767071939478", response.getContents().get(1).getContentId());
        Assert.assertEquals("", response.getContents().get(2).getContentId());
        Assert.assertEquals("tlxsta_9kne94541757784501944", response.getContents().get(3).getContentId());
    }

    @Then("Verify 1 sports content should be visible on 1 and second on 3 in dec order of score.")
    public void verifySportsContentShouldBeVisibleOnAndSecond() {
        Assert.assertEquals("tlxsta_225h79991767071939478", response.getContents().get(0).getContentId());
        Assert.assertEquals("tlxsta_8fw560791765539446323", response.getContents().get(1).getContentId());
        Assert.assertEquals("tlxsta_9kne94541757784501944", response.getContents().get(2).getContentId());
    }

    @Then("Verify when two promoted tile is pinned on the same position then only one should be visible")
    public void verifyWhenTwoPromotedTileIsPinnedOnTheSamePositionThenOnlyOneShouldBeVisible() {
        Assert.assertEquals("tlxsta_zy8n02301756717793339", response.getContents().get(0).getContentId());
        for (int i = 1; i < response.getContents().size(); i++) {
            Assert.assertNotEquals("tlxsta_zy8n02301756717793339", response.getContents().get(i).getContentId());
        }
    }

    @Then("Verify 3 content from Svod 2.0 and 3 content form SVOD + Avod")
    public void verifyContentFromSvodAndContentFormSVODAvod() {
        int svod2Count = 0;
        int svodAvodCount = 0;
        int avodCount = 0;
        for (int i = 0; i < 7; i++) {
            if (response.getContents().get(i).getExtras().get("_free").equals("true")
                    || response.getContents().get(i).getExtras().get("_freeFirstEpisode").equals("true")
                    || response.getContents().get(i).getExtras().get("_freeFirstSeason").equals("true")) {
                avodCount++;
            } else if (Arrays.toString(CPList).contains(response.getContents().get(i).getExtras().get("_cpId"))) {
                svodAvodCount++;
            } else svod2Count++;
        }
        Assert.assertEquals(3, svod2Count);
        Assert.assertEquals(3, svodAvodCount + avodCount);
    }

    @Then("Verify 5 content from AVod + Svod and 1 content form \\(SVOD 2.0).")
    public void verifyContentFromAVodSvodAndContentFormSVOD() {
        int svod2Count = 0;
        int svodAvodCount = 0;
        int avodCount = 0;
        for (int i = 0; i < 7; i++) {
            if (response.getContents().get(i).getExtras().get("_free").equals("true")
                    || response.getContents().get(i).getExtras().get("_freeFirstEpisode").equals("true")
                    || response.getContents().get(i).getExtras().get("_freeFirstSeason").equals("true")) {
                avodCount++;
            } else if (Arrays.toString(CPList).contains(response.getContents().get(i).getExtras().get("_cpId"))) {
                svodAvodCount++;
            } else svod2Count++;
        }
        Assert.assertEquals(1, svod2Count);
        Assert.assertEquals(5, svodAvodCount + avodCount);
    }

    @Then("Verify 3 content from AVod and 3 content form \\(SVOD and SVOD 2.0).")
    public void verifyContentFromAVodAndContentFormSVODAndSVOD() {
        int svod2Count = 0;
        int svodAvodCount = 0;
        int avodCount = 0;
        for (int i = 0; i < 7; i++) {
            if (response.getContents().get(i).getExtras().get("_free").equals("true")
                    || response.getContents().get(i).getExtras().get("_freeFirstEpisode").equals("true")
                    || response.getContents().get(i).getExtras().get("_freeFirstSeason").equals("true")) {
                avodCount++;
            } else if (Arrays.toString(CPList).contains(response.getContents().get(i).getExtras().get("_cpId"))) {
                svodAvodCount++;
            } else svod2Count++;
        }
        Assert.assertEquals(3, svod2Count + svodAvodCount);
        Assert.assertEquals(3, avodCount);
    }

    @Then("Verify Broadband upSell tile is not present on the banner")
    public void verifyBroadbandUpSellTileIsNotPresentOnTheBanner() {
        for (int i = 0; i < response.getContents().size(); i++) {
            if (!response.getContents().get(i).getExtras().containsKey("_tileSubType")) {
                Assert.assertFalse(response.getContents().get(i).getExtras().containsKey("_tileSubType"));
            } else {
                Assert.assertNotEquals("UPSELL_TILE", response.getContents().get(i).getExtras().get("_tileSubType"));
            }
        }
    }

    @Then("Verify Broadband upSell tile is present on the banner")
    public void verifyBroadbandUpSellTileIsPresentOnTheBanner() {
        boolean upsellTilePresent = false;
        for (int i = 0; true; i++) {
            if (response.getContents().get(i).getExtras().containsKey("_tileSubType")) {
                if (response.getContents().get(i).getExtras().get("_tileSubType").equals("UPSELL_TILE")) {
                    upsellTilePresent = true;
                    break;
                }
            }
        }
        Assert.assertTrue(upsellTilePresent);
    }

    @And("Verify Only unsubscribed CP is recommended from the upsell collection")
    public void verifyOnlyUnsubscribedCPIsRecommendedFromTheUpsellCollection() {
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (response.getContents().get(i).getExtras().containsKey("_tileSubType")) {
                if (response.getContents().get(i).getExtras().get("_tileSubType").equals("UPSELL_TILE")) {
                    Assert.assertEquals("AMAZON_PRIME", response.getContents().get(i).getExtras().get("_cpId"));
                    count++;
                }
            }
        }
        Assert.assertEquals(1, count);
    }
}
