package steps.api.microService;

import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
//import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.request.getSongsContentList.GetSongsContantListReq;
import model.request.zion.postNewTile.PostNewTileReq;
import model.request.zion.postTileIntoCollection.*;
import model.request.zion.updateCollectionStatus.UpdateCollectionStatusReq;
import model.response.content.getSongsContentList.GetSongContentListRes;
import model.response.zion.getTileList.GetTilesListRes;
import model.response.zion.postNewCollectionRes.PostNewCollectionRes;
import model.response.zion.layout.uploadFile.UploadFilRes;
import org.junit.Assert;
import services.zionServices.ContentZionService;
import services.zionServices.ZionServices;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static helpers.ApiHelper.gson;

public class CollectionSteps {

    PostNewTileReq postNewTileReq = new PostNewTileReq();
    PostTileIntoCollectionReq postTileIntoCollectionReq = new PostTileIntoCollectionReq();
    PostNewCollectionRes postNewCollectionRes;

    public static PostNewCollectionRes updateCollectionStatus(String id, UpdateCollectionStatusReq updateCollectionStatusReq) {
        Response response = ContentZionService.updateCollectionStatus(id, updateCollectionStatusReq);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), PostNewCollectionRes.class);
    }

    public static PostNewCollectionRes postTilesIntoCollection(String id, PostTileIntoCollectionReq postTileIntoCollectionReq) {
        Response response = ContentZionService.postTilesIntoCollection(id, postTileIntoCollectionReq);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), PostNewCollectionRes.class);
    }

    public GetSongContentListRes getSongsContent(GetSongsContantListReq getSongsContantListReq){
        Response res = ContentZionService.getSongsContent(getSongsContantListReq);
        Assert.assertEquals(200, res.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(res.body().asString(), GetSongContentListRes.class);
    }

    public static GetTilesListRes getTiles(Map<String, String> param) {
        Response response = ZionServices.getTiles(param);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), GetTilesListRes.class);
    }

    public PostNewCollectionRes postNewCollection(PostTileIntoCollectionReq postTileIntoCollectionReq) {
        Response response = ContentZionService.postNewCollection(postTileIntoCollectionReq);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), PostNewCollectionRes.class);
    }

    @Given("^User create new tile with \"([^\"]*)\" segment$")
    public void userCreateNewTileWithSegment(String segment, List<PostNewTileReq> postNewTile) throws Throwable {
        postNewTileReq = postNewTile.get(0);
        postNewTileReq.setSegmentId(LayoutConfigSteps.searchSegmentsFromZion(segment));
    }

    @And("^for \"([^\"]*)\" regions and \"([^\"]*)\" File$")
    public void forRegionsAndFile(String regions, String fileName) throws Throwable {
        List<String> regionList = Arrays.asList(regions.split(", "));
        postNewTileReq.setRegions(regionList);
        postNewTileReq.setEntityId("");
        File currentDir = new File("");
        UploadFilRes uploadFilRes = LayoutConfigSteps.uploadFile(currentDir.getAbsolutePath() + "/src/test/resources/file/" + fileName);
        postNewTileReq.setThumbnailUrl(uploadFilRes.getFileUrl());
    }

    @Then("^User hit tile create api$")
    public void userHitTileCreateApi() {
        Response response = ZionServices.postNewTile(postNewTileReq);
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Given("^User create new custom rail$")
    public void userCreateNewCustomRail(List<PostTileIntoCollectionReq> postNewCollection) {
        postTileIntoCollectionReq = postNewCollection.get(0);
        Zbrew zbrew = new Zbrew();
        Draft draft = new Draft();
        draft.setCurrentStep(1);
        zbrew.setDraft(draft);
        postTileIntoCollectionReq.setZbrew(zbrew);
    }

    @And("^For \"([^\"]*)\" Language and \"([^\"]*)\" regions$")
    public void forLanguageAndRegions(String language, String regions) throws Throwable {
        List<String> regionList = Arrays.asList(regions.split(", "));
        List<String> languageList = Arrays.asList(language.split(", "));
        postTileIntoCollectionReq.setLanguages(languageList);
        postTileIntoCollectionReq.setRegions(regionList);
//        postNewCollectionRes = postNewCollection(postTileIntoCollectionReq);
    }

    @And("^User update collection by these tiles$")
    public void userUpdateCollectionByTheseTiles(DataTable dataTable) {
        List<Map<String, String>> tilesData = dataTable.asMaps(String.class, String.class);
        List<Content> contents = new ArrayList<>();
        for (int i = 0; i < tilesData.size(); i++) {
            Content content = new Content();
            Map<String, String> param = new HashMap<>();
            param.put("query", tilesData.get(i).get("Tiles"));
            param.put("sort", "-lastUpdatedOn");
            param.put("pageSize", "100");
            GetTilesListRes getTilesListRes = getTiles(param);

            for (int j = 0; j < getTilesListRes.getData().size(); j++) {
                if (getTilesListRes.getData().get(j).getDisplayTitle().equals(tilesData.get(i).get("Tiles"))) {
                    content.setContentId(getTilesListRes.getData().get(j).getId());
                    content.setType(getTilesListRes.getData().get(j).getType());
                    content.setPosition(i + 1);
                    break;
                }
            }
            contents.add(content);
        }
        postTileIntoCollectionReq.setContents(contents);
        postNewCollectionRes = postTilesIntoCollection(postNewCollectionRes.getId(), postTileIntoCollectionReq);
    }

    @Then("^User update Collection status$")
    public void userUpdateCollectionStatus(List<UpdateCollectionStatusReq> updateCollectionStatusReq) {
        postNewCollectionRes = updateCollectionStatus(postNewCollectionRes.getId(), updateCollectionStatusReq.get(0));
    }

    @And("^For \"([^\"]*)\" tags$")
    public void forTags(String tags) throws Throwable {
        List<String> tagList = Arrays.asList(tags.split(", "));
        postTileIntoCollectionReq.setTags(tagList);
    }

    @Then("^User add songs in the collection$")
    public void userAddSongsInTheCollection(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        List<Content> contents = new ArrayList<>();
        Long duration = null;
        for (int i = 0; i < data.size(); i++) {
            GetSongsContantListReq getSongsContantListReq = new GetSongsContantListReq();
            getSongsContantListReq.setLanguage(data.get(i).get("language"));
            getSongsContantListReq.setSort("-lastupdated");
            getSongsContantListReq.setPageNo(1);
            getSongsContantListReq.setPageSize(400);
            GetSongContentListRes getSongContentListRes = getSongsContent(getSongsContantListReq);
            for (int j = 0; j < getSongContentListRes.getResult().size(); j++) {
                if (getSongContentListRes.getResult().get(j).getTitle().equals(data.get(i).get("songs"))) {
                    Content content = new Content();
                    content.setType(getSongContentListRes.getResult().get(j).getContentType());
                    content.setPosition(i + 1);
                    content.setContentId(getSongContentListRes.getResult().get(j).getContentId());
                    contents.add(content);
                    duration = duration + getSongContentListRes.getResult().get(j).getDurationSeconds();
                    break;
                }
            }
        }
        postTileIntoCollectionReq.getZbrew().getDraft().setCurrentStep(2);
        postTileIntoCollectionReq.setMinContentCount(data.size());
        postTileIntoCollectionReq.setContents(contents);
        postTileIntoCollectionReq.setDuration(duration);
//        postNewCollectionRes = postNewCollection(postTileIntoCollectionReq);
    }

    @Then("^User add artworks$")
    public void userAddArtworks(DataTable dataTable) throws ParseException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Artworks artworks = new Artworks();
        List<DEFAULT> dEFAULT = new ArrayList<>();
        List<SCHEDULED> sCHEDULED = new ArrayList<>();
        for (Map<String, String> datum : data) {
            File currentDir = new File("");
            UploadFilRes uploadFilRes = LayoutConfigSteps.uploadFile(currentDir.getAbsolutePath() + "/src/test/resources/file/" + data.get(0).get("file"));

            DEFAULT DEFAULT = new DEFAULT();
            DEFAULT.setStatus("DEFAULT");
            DEFAULT.setLocation(uploadFilRes.getFileUrl());
            DEFAULT.setType(datum.get("type"));
            dEFAULT.add(DEFAULT);

            if (!(datum.get("availableFrom").equals("") && !(datum.get("availableTill").equals("")))) {
                SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
                SCHEDULED scheduled = new SCHEDULED();
                scheduled.setStatus("SCHEDULED");
                scheduled.setStatus(uploadFilRes.getFileUrl());
                scheduled.setType(datum.get("type"));
                scheduled.setAvailableFrom(DateFor.parse(datum.get("availableFrom")).getTime());
                scheduled.setAvailableTill(DateFor.parse(datum.get("availableTill")).getTime());
                sCHEDULED.add(scheduled);
            }
        }
        artworks.setDEFAULT(dEFAULT);
        artworks.setSCHEDULED(sCHEDULED);
        postTileIntoCollectionReq.getZbrew().getDraft().setCurrentStep(3);
        postTileIntoCollectionReq.setArtworks(artworks);
//        postNewCollectionRes = postNewCollection(postTileIntoCollectionReq);
    }

    @Then("^User add timelines$")
    public void userAddTimelines(DataTable dataTable) throws ParseException {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        postTileIntoCollectionReq.setAvailableFrom(DateFor.parse(data.get(0).get("availableFrom")).getTime());
        postTileIntoCollectionReq.setAvailableTill(DateFor.parse(data.get(0).get("availableTill")).getTime());
        postTileIntoCollectionReq.setRefreshFrequencyDay(Long.parseLong(data.get(0).get("refreshFrequencyDay")));
        postTileIntoCollectionReq.setRefreshFrequencyDayOfWeek(Long.parseLong(data.get(0).get("refreshFrequencyDayOfWeek")));
        postTileIntoCollectionReq.setSortStrategy("manual");
//        postNewCollectionRes = postNewCollection(postTileIntoCollectionReq);
    }
}
