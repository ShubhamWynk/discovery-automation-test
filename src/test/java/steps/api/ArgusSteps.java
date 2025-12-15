package steps.api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import model.Common.UserInfo;
import model.Common.arsenalCollection.ArsenalCollection;
import services.discovery.DownStreamService;
import utilities.Utils;

import java.io.IOException;
import java.util.Map;

import static helpers.ApiHelper.gson;
import static utilities.Utils.convertMapOfStringToMapOfList;

public class ArgusSteps {

    String argusBaseUrl = "http://argus.discovery.svc.cluster.local:8080";
    String argusUrl = argusBaseUrl + "/v1/recommendation";
    ArsenalCollection response;

    @And("Fetch content from argus for")
    public void fetchContentFromArgusFor(DataTable dataTable) throws IOException {
        Map<String, String[]> params = convertMapOfStringToMapOfList(Utils.convertDataTableToMap(dataTable).get(0));
        ArsenalCollection req = CommonSteps.createDownStreamApiRequest("", params, argusUrl);
        Response res = DownStreamService.applyArgus(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }
}
