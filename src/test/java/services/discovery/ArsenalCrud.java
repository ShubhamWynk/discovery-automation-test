package services.discovery;

import io.restassured.response.Response;
import helpers.ApiHelper;

import java.util.HashMap;
import java.util.Map;

public class ArsenalCrud extends ApiHelper {

    private final static String ARSENAL="/arsenal/api";

    public Response clearCollectionCache(String collectionId,String realm) {
        return baseApiUrl("discoveryUrl").get(ARSENAL+"/v1/collection"+collectionId+"/clearCollectionCache?realm="+appName);
    }

    public Response getCollectionSearch(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return baseApiUrl("discoveryUrl").queryParams(query).get(ARSENAL+"/v1/collections");
    }

    public Response getCollectionByCollectionId(String collectionId,String realm) {
        return baseApiUrl("discoveryUrl").get(ARSENAL+"/v1/collection/collectionId/"+collectionId+"?realm="+realm);
    }

    public Response getCollectionHasArtworks(String collectionId,String realm) {
        return baseApiUrl("discoveryUrl").get(ARSENAL+"/v1/collection/"+collectionId+"/hasArtwork?realm="+realm);
    }

    public Response getCollectionById(String id,String realm) {
        return baseApiUrl("discoveryUrl").get(ARSENAL+"/v1/collection/"+id+"?realm="+realm);
    }
}
