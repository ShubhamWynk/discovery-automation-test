package services.discovery;

import io.restassured.response.Response;
import services.BaseServiceClient;

import java.util.Map;

public class ZiegelService extends BaseServiceClient {
    public static Response getStaticTileDetails(String tileId, Map<String,String> params) {
        return get(params, "/ziegel-service/tile/generateTile/"+tileId);
    }
}
