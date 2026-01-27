package services.discovery;

import helpers.ApiHelper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Common.arsenalCollection.ArsenalCollection;
import services.BaseServiceClient;

import java.util.Map;

public class DownStreamService extends BaseServiceClient {

    public static Response downStreamApi(Map<String,String> query,String request ,String endPoint) {
        query.put("debug","true");
        query.put("realm",appName);
        return post(query, request,endPoint);
    }

    public static Response applyPostProcessor(ArsenalCollection request, Map<String,String> query) {
        query.put("debug","true");
        query.put("realm",appName);
        return post(query, gson().toJson(request), "/collection-processor/v1/process/collection");
    }

    public static Response applyMultiSourceCollection(ArsenalCollection request, Map<String,String> query) {
        query.put("debug","true");
        query.put("realm",appName);
        return post(query, gson().toJson(request),"/multisource-collection/v1/content");
    }

    public static Response applyTrendingSearch(ArsenalCollection request, Map<String,String> query) {
        query.put("debug","true");
        query.put("realm",appName);
        return post(query, gson().toJson(request),"/discovery-trending-service/v1/trending");
    }

    public static Response applyTopContent(ArsenalCollection request, Map<String,String> query) {
        query.put("debug","true");
        query.put("realm",appName);
        return post(query, gson().toJson(request),"/xstream-top-content/v1/topcontent");
    }

    public static Response applyArgus(ArsenalCollection request, Map<String,String> query) {
        query.put("debug","true");
        query.put("realm",appName);
        return post(query, gson().toJson(request),"/argusv1/recommendation");
    }

    public static Response applyQuasar(ArsenalCollection request, Map<String,String> query) {
        query.put("debug","true");
        query.put("realm",appName);
        return post(query, gson().toJson(request),"/quasar/content");
    }

    public static Response applyUserContent(ArsenalCollection request, Map<String,String> query) {
        query.put("debug","true");
        query.put("realm",appName);
        return post(query, gson().toJson(request),"/user-content/v1/content");
    }

    public static Response applyXstreamWatchHistory(ArsenalCollection request, Map<String,String> query) {
        query.put("debug","true");
        query.put("realm",appName);
        return post(query, gson().toJson(request),"/xstream-watch-history/v1/user/history/collection");
    }

    public static Response applyXstreamWatchHistoryWatchList(ArsenalCollection request, Map<String,String> query) {
        query.put("debug","true");
        query.put("realm",appName);
        return post(query, gson().toJson(request),"/xstream-watch-history/v1/user/watchlist/collection");
    }

    public static Response getUserOnboardingDetails(Map<String,String> query) {
        query.put("debug","true");
        query.put("realm",appName);
        return get(query,"/user-content/v1/user/xstream/onboarding/details");
    }


}
