package services.discovery;

import helpers.ApiHelper;
import io.restassured.response.Response;
import model.Common.arsenalCollection.ArsenalCollection;

import java.util.Map;

public class DownStreamService extends ApiHelper {

    public static Response applyPostProcessor(ArsenalCollection collection, Map<String,String> query) {
        return baseApiUrl("discoveryUrl")
                .queryParams(query)
                .queryParam("debug","true")
                .queryParam("realm",appName)
                .body(gson().toJson(collection))
                .post("/collection-processor/v1/process/collection");
    }

    public static Response applyMultiSourceCollection(ArsenalCollection collection, Map<String,String> query) {
        return baseApiUrl("discoveryUrl")
                .queryParams(query)
                .queryParam("debug","true")
                .queryParam("realm",appName)
                .body(gson().toJson(collection))
                .post("/multisource-collection/v1/content");
    }

    public static Response applyTrendingSearch(ArsenalCollection collection, Map<String,String> query) {
        return baseApiUrl("discoveryUrl")
                .queryParams(query)
                .queryParam("debug","true")
                .queryParam("realm",appName)
                .body(gson().toJson(collection))
                .post("/discovery-trending-service/v1/trending");
    }

    public static Response applyTopContent(ArsenalCollection collection, Map<String,String> query) {
        return baseApiUrl("discoveryUrl")
                .queryParams(query)
                .queryParam("debug","true")
                .queryParam("realm",appName)
                .body(gson().toJson(collection))
                .post("/xstream-top-content/v1/topcontent");
    }

    public static Response applyArgus(ArsenalCollection collection, Map<String,String> query) {
        return baseApiUrl("discoveryUrl")
                .queryParams(query)
                .queryParam("debug","true")
                .queryParam("realm",appName)
                .body(gson().toJson(collection))
                .post("/argusv1/recommendation");
    }

    public static Response applyQuasar(ArsenalCollection collection, Map<String,String> query) {
        return baseApiUrl("discoveryUrl")
                .queryParams(query)
                .queryParam("debug","true")
                .queryParam("realm",appName)
                .body(gson().toJson(collection))
                .post("/quasar/content");
    }

    public static Response applyUserContent(ArsenalCollection collection, Map<String,String> query) {
        return baseApiUrl("discoveryUrl")
                .queryParams(query)
                .queryParam("debug","true")
                .queryParam("realm",appName)
                .body(gson().toJson(collection))
                .post("/user-content/v1/content");
    }

    public static Response applyXstreamWatchHistory(ArsenalCollection collection, Map<String,String> query) {
        return baseApiUrl("discoveryUrl")
                .queryParams(query)
                .queryParam("debug","true")
                .queryParam("realm",appName)
                .body(gson().toJson(collection))
                .post("/xstream-watch-history/v1/user/history/collection");
    }

    public static Response applyXstreamWatchHistoryWatchList(ArsenalCollection collection, Map<String,String> query) {
        return baseApiUrl("discoveryUrl")
                .queryParams(query)
                .queryParam("debug","true")
                .queryParam("realm",appName)
                .body(gson().toJson(collection))
                .post("/xstream-watch-history/v1/user/watchlist/collection");
    }
}
