package steps.api.common;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import model.Common.UserInfo;
import model.Common.arsenalCollection.ArsenalCollection;
import services.discovery.DownStreamService;
import utilities.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static helpers.ApiHelper.gson;
import static utilities.Utils.convertMapOfStringToMapOfList;

public class XstreamTopContentSteps {

    ArsenalCollection response;

    String jsonPath = "src/test/resources/data/json/collection.json";

    String topContentBaseUrl = "http://xstream-top-content.discovery.svc.cluster.local:8080";
    String topContentUrl = topContentBaseUrl + "/v1/topcontent";


    public ArsenalCollection createTopContentRequest(String useCase, Map<String, String[]> params) throws IOException {
        ArsenalCollection req = gson().fromJson(Utils.jsonToBody(jsonPath), ArsenalCollection.class);
        req.getDynamicMeta().getMixParam().setUseCase(useCase);
        req.getDynamicMeta().setUrl(topContentUrl);
        req.setContents(new ArrayList<>());
        req.getDynamicMeta().getMixParam().setParams(params);
        return req;
    }
//
    @And("Fetch user's {string} top content from xstream-top-content with params")
    public void fetchContentFromXstreamTopContent(String useCase, DataTable dataTable) throws IOException {
        Map<String, String[]> params = convertMapOfStringToMapOfList(Utils.convertDataTableToMap(dataTable).get(0));
        ArsenalCollection req = createTopContentRequest(useCase, params);
        Response res = DownStreamService.applyTopContent(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }

    @And("Fetch user's {string} top content from xstream-top-content")
    public void fetchUserSTopContentFromXstreamTopContent(String useCase) throws IOException {
        ArsenalCollection req = createTopContentRequest(useCase, new HashMap<>());
        Response res = DownStreamService.applyTopContent(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }
}
