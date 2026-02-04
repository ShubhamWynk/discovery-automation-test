package steps.api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import model.Common.UserInfo;
import model.Common.arsenalCollection.ArsenalCollection;
import net.serenitybdd.annotations.Steps;
import services.discovery.DownStreamService;
import utilities.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static helpers.ApiHelper.gson;
import static utilities.Utils.convertMapOfStringToMapOfList;

public class XstreamTopContentSteps {

    String topContentBaseUrl = DownStreamService.getCollectionUrls("xstreamTopContentApiUrl");
    String topContentUrl = topContentBaseUrl + "/v1/topcontent";
    ArsenalCollection response;

    @Steps
    DownStreamService downStreamService;

    @And("Fetch user's {string} top content from xstream-top-content with params")
    public void fetchContentFromXstreamTopContent(String useCase, DataTable dataTable) throws IOException {
        Map<String, String[]> params = convertMapOfStringToMapOfList(Utils.convertDataTableToMap(dataTable).get(0));
        ArsenalCollection req = CommonSteps.createDownStreamApiRequest(useCase, params,topContentUrl);
        Response res = downStreamService.applyTopContent(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }

    @And("Fetch user's {string} top content from xstream-top-content")
    public void fetchUserSTopContentFromXstreamTopContent(String useCase) throws IOException {
        ArsenalCollection req = CommonSteps.createDownStreamApiRequest(useCase, new HashMap<>(),topContentUrl);
        Response res = downStreamService.applyTopContent(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }
}
