package services.discovery;

import groovy.util.logging.Slf4j;
import helpers.ApiHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Common.arsenalCollection.ArsenalCollection;

import java.util.Map;

public class DownStreamService extends ApiHelper {

    public static RequestSpecification downStreamApiRequestSpecification(ArsenalCollection request, Map<String,String> query) {
        return baseApiUrl("discoveryUrl")
                .queryParams(query)
                .queryParam("debug","true")
                .queryParam("realm",appName)
                .body(gson().toJson(request));
    }

    public static Response applyPostProcessor(ArsenalCollection request, Map<String,String> query) {
        return downStreamApiRequestSpecification(request,query)
                .post("/collection-processor/v1/process/collection");
    }

    public static Response applyMultiSourceCollection(ArsenalCollection request, Map<String,String> query) {
        return downStreamApiRequestSpecification(request,query)
                .post("/multisource-collection/v1/content");
    }

    public static Response applyTrendingSearch(ArsenalCollection request, Map<String,String> query) {
        return downStreamApiRequestSpecification(request,query)
                .post("/discovery-trending-service/v1/trending");
    }

    public static Response applyTopContent(ArsenalCollection request, Map<String,String> query) {
        return downStreamApiRequestSpecification(request,query)
                .post("/xstream-top-content/v1/topcontent");
    }

    public static Response applyArgus(ArsenalCollection request, Map<String,String> query) {
        return downStreamApiRequestSpecification(request,query)
                .post("/argusv1/recommendation");
    }

    public static Response applyQuasar(ArsenalCollection request, Map<String,String> query) {
        return downStreamApiRequestSpecification(request,query)
                .post("/quasar/content");
    }

    public static Response applyUserContent(ArsenalCollection request, Map<String,String> query) {
        return downStreamApiRequestSpecification(request,query)
                .post("/user-content/v1/content");
    }

    public static Response applyXstreamWatchHistory(ArsenalCollection request, Map<String,String> query) {
        return downStreamApiRequestSpecification(request,query)
                .post("/xstream-watch-history/v1/user/history/collection");
    }

    public static Response applyXstreamWatchHistoryWatchList(ArsenalCollection request, Map<String,String> query) {
        return downStreamApiRequestSpecification(request,query)
                .post("/xstream-watch-history/v1/user/watchlist/collection");
    }
}
