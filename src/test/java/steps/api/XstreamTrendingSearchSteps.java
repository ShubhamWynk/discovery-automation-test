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

public class XstreamTrendingSearchSteps {

    String trendingSearchBaseUrl = DownStreamService.getCollectionUrls("discoveryTrendingServiceApiUrl");
    String trendingSearchUrl = trendingSearchBaseUrl + "/v1/trending";
    ArsenalCollection response;

    @And("Fetch top trending content for {string} with params")
    public void fetchTopTrendingContentForWithParams(String useCase, DataTable dataTable) throws IOException {
        Map<String, String[]> params = convertMapOfStringToMapOfList(Utils.convertDataTableToMap(dataTable).get(0));
        ArsenalCollection req = CommonSteps.createDownStreamApiRequest(useCase, params, trendingSearchUrl);
        Response res = DownStreamService.applyTrendingSearch(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }

    @And("Fetch top trending content for {string}")
    public void fetchTopTrendingContentFor(String useCase) throws IOException {
        ArsenalCollection req = CommonSteps.createDownStreamApiRequest(useCase, new HashMap<>(), trendingSearchUrl);
        Response res = DownStreamService.applyTrendingSearch(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }
}
