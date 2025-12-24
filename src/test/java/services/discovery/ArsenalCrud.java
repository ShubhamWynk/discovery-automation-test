package services.discovery;

import io.restassured.response.Response;
import helpers.ApiHelper;
import services.BaseServiceClient;

import java.util.HashMap;
import java.util.Map;

public class ArsenalCrud extends BaseServiceClient {

    private final static String ARSENAL = "/arsenal/api";

    private String getUrl(String endPoint){
        return ARSENAL + endPoint;
    }

    public Response clearCollectionCache(String collectionId, String realm) {
        return get(
                Map.of("realm", appName),
                getUrl( "/v1/collection" + collectionId + "/clearCollectionCache")
        );
//      return baseApiUrl("discoveryUrl").get(ARSENAL + "/v1/collection" + collectionId + "/clearCollectionCache?realm=" + appName);
    }

    public Response getCollectionSearch(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return get(query, getUrl("/v1/collections"));
//        return baseApiUrl("discoveryUrl").queryParams(query).get(ARSENAL + "/v1/collections");
    }

    public Response getCollectionByCollectionId(String collectionId) {
        return get(
                Map.of("realm", appName),
                getUrl( "/v1/collection/collectionId/" + collectionId)
        );
//        return baseApiUrl("discoveryUrl").get(ARSENAL + "/v1/collection/collectionId/" + collectionId + "?realm=" + realm);
    }

    public Response getCollectionHasArtworks(String collectionId) {
        return get(
                Map.of("realm", appName),
                getUrl( "/va1/collection/" + collectionId + "/hasArtwork")
        );
//        return baseApiUrl("discoveryUrl").get(ARSENAL + "/v1/collection/" + collectionId + "/hasArtwork?realm=" + appName);
    }

    public Response getCollectionById(String id) {
        return get(
                Map.of("realm", appName),
                getUrl( "/v1/collection/" + id )
        );
//        return baseApiUrl("discoveryUrl").get(ARSENAL + "/v1/collection/" + id + "?realm=" + appName);
    }
}
