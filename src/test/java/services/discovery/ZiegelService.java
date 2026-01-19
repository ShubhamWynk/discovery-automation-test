package services.discovery;

import io.restassured.response.Response;
import services.BaseServiceClient;

import java.util.Map;

public class ZiegelService extends BaseServiceClient {

    private final static String ZIEGEL = "/ziegel-service/tile";

    private static String getUrl(String endPoint) {
        return ZIEGEL + endPoint;
    }

    public static Response getDynamicTileDetails(String tileId, Map<String, String> params) {
        return get(params, getUrl("/generateTile/" + tileId));
    }

    public static Response getTileDetails(String tileId, Map<String, String> params) {
        return get(params, getUrl("/" + tileId));
    }

    public static Response searchTile(Map<String, String> params) {
        return get(params, getUrl("/tiles/search"));
    }

    public static Response createTile(String body, Map<String, String> params) {
        return post(params, body, "/add");
    }

    public static Response updateTile(String body, Map<String, String> params) {
        return post(params, body, "/update");
    }

    public static Response deleteTile(String tileId, Map<String, String> params){
        return delete(params,"/" + tileId);
    }
}
