package steps.api;

import constant.Operator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import model.Common.UserInfo;
import model.Common.arsenalCollection.ArsenalCollection;
import model.Common.arsenalCollection.Content;
import model.Common.arsenalCollection.MultiSourceRequest;
import model.Common.arsenalCollection.SourceCollection;
import org.junit.Assert;
import services.discovery.ArsenalService;
import services.discovery.DownStreamService;
import utilities.Utils;

import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static helpers.ApiHelper.gson;
import static utilities.Utils.convertMapOfStringToMapOfList;


public class MultiSourceSteps {
    String multiSourceBaseUrl = DownStreamService.getCollectionUrls("multiSourceApiUrl");
    String multiSourceUrl = multiSourceBaseUrl + "/v1/content";
    ArsenalCollection response;

    MultiSourceRequest mutiSourceRequest;

    @And("build multiSource request in dynamic Meta")
    public void buildMultiSourceRequestInDynamicMeta(List<MultiSourceRequest> mutiSourceRequest) {
        this.mutiSourceRequest = mutiSourceRequest.getFirst();
    }

    @And("build source collection list request for multiSource")
    public void buildSourceCollectionListRequestForMultiSource(DataTable dataTable) throws IOException {
        List<Map<String, String>> data = Utils.convertDataTableToMap(dataTable);
        List<SourceCollection> sourceCollectionList = new ArrayList<>();

        data.forEach(row -> {
            SourceCollection sourceCollection = new SourceCollection();

            sourceCollection.setCollectionId(row.get("collectionId"));
            sourceCollection.setOperator(Operator.valueOf(row.get("operator")));
            if (row.containsKey("order")) {
                sourceCollection.setOrder(Long.valueOf(row.get("order")));
            }
            if (row.containsKey("score")) {
                sourceCollection.setScore(Double.valueOf(row.get("score")));
            }
            if (row.containsKey("type")) {
                sourceCollection.setType(row.get("type"));
            }
            if (row.containsKey("params")) {
                Map<String, List<String>> params = Utils.convertIntoParamsObject(row.get("params"));
                sourceCollection.setParams(params);
            }
            if(row.containsKey("contents")){
                ArsenalCollection tem = ArsenalService.getArsenalCollectionController(row.get("collectionId"), UserInfo.liveAttribute);
                List<Content> contentList = tem.getContents();
                row.get("contents").lines().forEach(con -> {
                    String[] replaceContent = con.split(":");
                    contentList.get(Integer.parseInt(replaceContent[1])).setContentId(replaceContent[0]);
                    contentList.get(Integer.parseInt(replaceContent[1])).setType(Utils.contentType(replaceContent[0]));
                });
            }
//            if (row.containsKey("filters")) {
//                Map<String,List<String>> params = Utils.convertIntoParamsObject(row.get("params"));
//                SourceCollection.setFilters(params);
//            }
            sourceCollectionList.add(sourceCollection);
        });
        this.mutiSourceRequest.setCollections(sourceCollectionList);
    }

    @And("fetch response for multiSource request")
    public void fetchResponseForMultiSourceRequest(DataTable dataTable) throws IOException {
        Map<String, String[]> params = convertMapOfStringToMapOfList(Utils.convertDataTableToMap(dataTable).get(0));
        ArsenalCollection req = CommonSteps.createDownStreamApiRequest("multi-source", params, multiSourceUrl);
        req.getDynamicMeta().getMixParam().setMultiSourceRequest(this.mutiSourceRequest);
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
}
