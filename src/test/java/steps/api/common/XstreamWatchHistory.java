package steps.api.common;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import model.Common.UserInfo;
import model.Common.arsenalCollection.ArsenalCollection;
import model.response.zion.layout.segment.PostNewSegment.PostNewSegmentRes;
import services.discovery.DownStreamService;
import utilities.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static helpers.ApiHelper.gson;
import static utilities.Utils.convertMapOfStringToMapOfList;

public class XstreamWatchHistory {

    ArsenalCollection response;

    String jsonPath = "src/test/resources/data/json/collection.json";

    String watchHistoryBaseUrl = "http://xstream-watch-history.discovery.svc.cluster.local:8080/v1";
    String watchHistoryUrl = watchHistoryBaseUrl + "/user/history/collection";
    String watchListUrl = watchHistoryBaseUrl + "/user/watchlist/collection";

    public ArsenalCollection createWatchHistoryRequest(String useCase, Map<String, String[]> params) throws IOException {
        ArsenalCollection req = gson().fromJson(Utils.jsonToBody(jsonPath), ArsenalCollection.class);
        req.getDynamicMeta().getMixParam().setUseCase(useCase);
        req.getDynamicMeta().setUrl(useCase.equals("WATCH_LIST") ? watchListUrl : watchHistoryUrl);
        req.setContents(new ArrayList<>());
        req.getDynamicMeta().getMixParam().setParams(params);
        return req;
    }

    @And("Fetch user's {string} watch history")
    public void fetchContentFromXstreamWatchHistory(String useCase, DataTable dataTable) throws IOException {
        Map<String, String[]> params = convertMapOfStringToMapOfList(Utils.convertDataTableToMap(dataTable).get(0));
        ArsenalCollection req = createWatchHistoryRequest(useCase, params);
        Response res = DownStreamService.applyXstreamWatchHistory(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }

    @And("Fetch user's {string} using watch history api")
    public void fetchContentFromXstreamWatchHistory(String useCase) throws IOException {
        ArsenalCollection req = createWatchHistoryRequest(useCase, new HashMap<>());
        Response res = DownStreamService.applyXstreamWatchHistoryWatchList(req, UserInfo.liveAttribute);
        response = gson().fromJson(res.body().asString(), ArsenalCollection.class);
    }
}
