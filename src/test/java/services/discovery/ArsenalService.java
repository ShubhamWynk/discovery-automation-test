package services.discovery;

import io.restassured.response.Response;
import helpers.ApiHelper;
import model.response.arsenalCollection.ArsenalCollectionRes;
import org.junit.Assert;

import java.util.Map;

public class ArsenalService extends ApiHelper {
    public static Response getDiscoveryArsenalCollection(String collectionId, String userID) {
        return discoveryApiUrl().when().get("/arsenal/client/api/v1/collection/"+collectionId+"?realm="+appName+"&uid="+userID+"&clangs=hi&debug=true");
    }

    public static Response getDiscoveryArsenalCollection(String collectionId, Map<String,String> query) {
        return discoveryApiUrl().when()
                .queryParams(query)
                .queryParams("debug","true")
                .get("/arsenal/client/api/v1/collection/"+collectionId);
    }

    public static ArsenalCollectionRes getArsenalCollectionController(String collectionId, String uid) {
        Response response = getDiscoveryArsenalCollection(collectionId, uid);
        Assert.assertEquals(200, response.getStatusCode());
        return gson().fromJson(response.body().asString(), ArsenalCollectionRes.class);
    }

    public static ArsenalCollectionRes getArsenalCollectionController(String collectionId, Map<String,String> liveAttribute) {
        Response response = getDiscoveryArsenalCollection(collectionId, liveAttribute);
        Assert.assertEquals(200, response.getStatusCode());
        return gson().fromJson(response.body().asString(), ArsenalCollectionRes.class);
    }

    public static Response getCollections(Map<String,String> param) {
        return discoveryApiUrl().when().params(param).get("/arsenal/client/api/v1/collections");
    }
}
