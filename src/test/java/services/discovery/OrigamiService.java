package services.discovery;

import io.restassured.response.Response;
import helpers.ApiHelper;

import java.util.Map;

public class OrigamiService extends ApiHelper {
    public Response getDiscoveryOrigamiLayoutDebug(String page, Map<String,String> params) {
        return baseApiUrl("discoveryUrl").params(params).get("/origami-service/v1/layout/debug/"+page);
    }

    public Response getDiscoveryOrigamiLayout(String page, Map<String,String> params) {
        return baseApiUrl("discoveryUrl").params(params).get("/origami-service/v1/layout/"+page);
    }
}
