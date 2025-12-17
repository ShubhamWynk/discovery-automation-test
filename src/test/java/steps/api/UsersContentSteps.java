package steps.api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import model.Common.UserInfo;
import model.Common.arsenalCollection.ArsenalCollection;
import services.discovery.DownStreamService;
import utilities.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static helpers.ApiHelper.gson;
import static utilities.Utils.convertMapOfStringToMapOfList;

public class UsersContentSteps {

    String userContentBaseUrl = DownStreamService.getCollectionUrls("userContentApiUrl");
    String userContentUrl = userContentBaseUrl + "/v1/topcontent";
    ArsenalCollection response;

    @And("Fetch user's en-countered content for {string} with params")
    public void fetchUserSEncountredContentForWithParrams(String useCase,DataTable dataTable) throws IOException {
        Map<String, String[]> params = convertMapOfStringToMapOfList(Utils.convertDataTableToMap(dataTable).get(0));
        ArsenalCollection req = CommonSteps.createDownStreamApiRequest(useCase, params,userContentUrl);
        Response res = DownStreamService.applyUserContent(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }

    @And("Fetch user's en-countered content for {string}")
    public void fetchUserSEncountredContentFor(String useCase) throws IOException {
        ArsenalCollection req = CommonSteps.createDownStreamApiRequest(useCase, new HashMap<>(),userContentUrl);
        Response res = DownStreamService.applyUserContent(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }
}
