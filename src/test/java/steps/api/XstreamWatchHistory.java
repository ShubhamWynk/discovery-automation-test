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

public class XstreamWatchHistory {

    ArsenalCollection response;

    String watchHistoryBaseUrl = DownStreamService.getCollectionUrls("xstreamWatchHistoryApiUrl");
    String watchHistoryUrl = watchHistoryBaseUrl + "/v1/user/history/collection";
    String watchListUrl = watchHistoryBaseUrl + "/v1/user/watchlist/collection";

    private String getDownStreamUrl(String useCase){
        return useCase.equals("WATCH_LIST") ? watchListUrl : watchHistoryUrl;
    }

    @And("Fetch user's {string} watch history")
    public void fetchContentFromXstreamWatchHistory(String useCase, DataTable dataTable) throws IOException {
        Map<String, String[]> params = convertMapOfStringToMapOfList(Utils.convertDataTableToMap(dataTable).get(0));
        ArsenalCollection req = CommonSteps.createDownStreamApiRequest(useCase, params, getDownStreamUrl(useCase));
        Response res = DownStreamService.applyXstreamWatchHistory(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }

    @And("Fetch user's {string} using watch history api")
    public void fetchContentFromXstreamWatchHistory(String useCase) throws IOException {
        ArsenalCollection req = CommonSteps.createDownStreamApiRequest(useCase, new HashMap<>(), getDownStreamUrl(useCase));
        Response res = DownStreamService.applyXstreamWatchHistoryWatchList(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }
}
