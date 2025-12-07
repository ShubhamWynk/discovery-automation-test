package services.common;

//import io.restassured.response.Response;
import helpers.ApiHelper;
import io.restassured.response.Response;
import model.request.catalogKibana.songsDetail.SongsDetailsFromKibanaReq;

public class KibanaService extends ApiHelper {

    public static Response getDiscoveryArsenalCollection(SongsDetailsFromKibanaReq songsDetails) {
        return kibanaApiURL().body(gson().toJson(songsDetails)).post("/api/console/proxy?path=catalog.song/_search&method=POST");
    }
}
