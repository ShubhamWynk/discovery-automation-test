package services.discovery;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import model.Common.productOffer.ProductOffering;
import org.junit.Assert;
import services.BaseServiceClient;

import java.util.Map;

public class ZiegelService extends BaseServiceClient {

    private final static String ZIEGEL = "/ziegel-service/tile";

    private static String getUrl(String endPoint) {
        return ZIEGEL + endPoint;
    }

    private static final Headers OfferedPlansHeaders = new Headers(
            new Header("Authorization", "Basic ZGlzY292ZXJ5RVBDQVBJOjc2SjY5aCliY3NkNzZxYkBxamhoc2E="),
            new Header("x-basic-auth-client","discovery-epc-api")
    );

    public Response getDynamicTileDetails(String tileId, Map<String, String> params) {
        return get(params, getUrl("/generateTile/" + tileId));
    }

    public  Response getTileDetails(String tileId, Map<String, String> params) {
        return get(params, getUrl("/" + tileId));
    }

    public Response searchTile(Map<String, String> params) {
        return get(params, getUrl("/tiles/search"));
    }

    public Response createTile(String body, Map<String, String> params) {
        return post(params, body, "/add");
    }

    public Response updateTile(String body, Map<String, String> params) {
        return post(params, body, "/update");
    }

    public Response deleteTile(String tileId){
        return delete(Map.of("realm", appName),"/" + tileId);
    }

    public Response getPlanDetails(String offerId) {
        return baseApiUrl("productOfferingUrl",OfferedPlansHeaders)
                .queryParam("productOfferingId",offerId)
                .get("/broadband/s2s/productOffering/details");
    }

    public ProductOffering getOfferedPlans(String offerId){
        Response tempRes = this.getPlanDetails(offerId);
        Assert.assertEquals(200, tempRes.statusCode());
        return gson().fromJson(tempRes.prettyPrint(), ProductOffering.class);
    }
}
