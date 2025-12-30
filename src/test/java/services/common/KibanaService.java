package services.common;

//import io.restassured.response.Response;

import helpers.ApiHelper;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import model.request.catalogKibana.songsDetail.SongsDetailsFromKibanaReq;
import services.BaseServiceClient;

public class KibanaService extends BaseServiceClient {

    private static final Headers kibanaHeaders = new Headers(
            new Header("kbn-version", "7.1.1"),
            new Header("authority", "catalog-kibana.wynk.in"),
            new Header("accept", "text/plain, */*; q=0.01"),
            new Header("accept-encoding", "gzip, deflate, br"),
            new Header("content-type", "application/json"),
            new Header("accept-encoding", "gzip, deflate, br"),
            new Header("accept-encoding", "gzip, deflate, br")
    );

    public static Response getDiscoveryArsenalCollection(SongsDetailsFromKibanaReq songsDetails) {
        return baseApiUrl("catalogKibana", kibanaHeaders).body(gson().toJson(songsDetails)).post("/api/console/proxy?path=catalog.song/_search&method=POST");
    }
}
