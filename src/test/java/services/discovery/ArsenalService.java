package services.discovery;

import io.restassured.response.Response;
import helpers.ApiHelper;
import model.Common.arsenalCollection.ArsenalCollection;
import model.Common.arsenalCollection.ArsenalCollectionResponse;
import org.junit.Assert;
import services.BaseServiceClient;

import java.util.Map;

public class ArsenalService extends BaseServiceClient {

    public static Response getDiscoveryArsenalCollection(String collectionId, Map<String,String> query) {
        query.put("debug","true");
        return get(query,"/arsenal/client/api/v1/collection/"+collectionId);
    }

    public static Response getCollections(Map<String,String> param) {
        return get(param,"/arsenal/client/api/v1/collections");
    }

    public static ArsenalCollection getArsenalCollectionController(String collectionId, Map<String,String> liveAttribute) {
        Response response = getDiscoveryArsenalCollection(collectionId, liveAttribute);
        Assert.assertEquals(200, response.getStatusCode());
        return gson().fromJson(response.body().asString(), ArsenalCollection.class);
    }

    public static ArsenalCollectionResponse getArsenalCollectionControllerResponse(String collectionId, Map<String,String> liveAttribute) {
        Response response = getDiscoveryArsenalCollection(collectionId, liveAttribute);
        Assert.assertEquals(200, response.getStatusCode());
        return gson().fromJson(response.body().asString(), ArsenalCollectionResponse.class);
    }
}
