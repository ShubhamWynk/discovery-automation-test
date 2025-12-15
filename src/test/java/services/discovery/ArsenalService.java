package services.discovery;

import io.restassured.response.Response;
import helpers.ApiHelper;
import model.Common.arsenalCollection.ArsenalCollection;
import model.Common.arsenalCollection.ArsenalCollectionResponse;
import org.junit.Assert;

import java.util.Map;

public class ArsenalService extends ApiHelper {

    public static Response getDiscoveryArsenalCollection(String collectionId, Map<String,String> query) {
        return baseApiUrl("discoveryUrl")
                .queryParams(query)
                .queryParam("debug","true")
                .get("/arsenal/client/api/v1/collection/"+collectionId);
    }

    public static ArsenalCollection getArsenalCollectionController(String collectionId, Map<String,String> liveAttribute) {
        Response response = getDiscoveryArsenalCollection(collectionId, liveAttribute);
        Assert.assertEquals(200, response.getStatusCode());
        return gson().fromJson(response.body().asString(), ArsenalCollection.class);
    }

    public static Response getCollections(Map<String,String> param) {
        return baseApiUrl("discoveryUrl").params(param).get("/arsenal/client/api/v1/collections");
    }

    public static ArsenalCollectionResponse getArsenalCollectionControllerResponse(String collectionId, Map<String,String> liveAttribute) {
        Response response = getDiscoveryArsenalCollection(collectionId, liveAttribute);
        Assert.assertEquals(200, response.getStatusCode());
        return gson().fromJson(response.body().asString(), ArsenalCollectionResponse.class);
    }
}
