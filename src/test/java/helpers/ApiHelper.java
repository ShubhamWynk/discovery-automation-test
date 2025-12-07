package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.typesafe.config.Config;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import config.ConfigLoader;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.net.URI;
import io.restassured.http.Headers;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    public Logger log = LoggerFactory.getLogger(ApiHelper.class);
    private static final Config conf = ConfigLoader.load();
    private static final String watchContentApiUrl = conf.getString("watchContentApiUrl");
    private static final String zionApiUrl = conf.getString("zionApiUrl");
    private static final String catalogKibana = conf.getString("catalogKibana");
    private static final String zionApiUrl_be = conf.getString("zionApiUrl_be");
    public static final String appName = conf.getString("appName");
    private static String auth = conf.getString("auth");
    public static Gson gson;

    private static final Headers headers = new Headers(
            new Header("Content-Type", "application/json"),
            new Header("Authorization", "Bearer token123")
    );

    protected static RequestSpecification baseApiUrl(String baseUrl) {
        RestAssured.baseURI = URI.create(conf.getString(baseUrl)).toString();
        return given().log().all().headers(headers);
    }

    protected static RequestSpecification kibanaApiURL() {
        RestAssured.baseURI = URI.create(catalogKibana).toString();
        return given().log().all()
                .header("kbn-version", "7.1.1")
                .header("authority", "catalog-kibana.wynk.in")
                .header("accept", "text/plain, */*; q=0.01")
                .header("accept-encoding", "gzip, deflate, br")
                .header("content-type", "application/json")
                .header("accept-encoding", "gzip, deflate, br")
                .header("accept-encoding", "gzip, deflate, br");
    }

    protected static RequestSpecification watchContentApiUrl() {
        RestAssured.baseURI = URI.create(watchContentApiUrl).toString();
        return given().log().all()
                .header("Accept", "*/*");
    }

    protected static RequestSpecification zionApiUrlBe() {
        RestAssured.baseURI = URI.create(zionApiUrl_be).toString();
        return given().log().all().headers(headers);
    }

    protected static RequestSpecification zionApiUrl() {
        RestAssured.baseURI = URI.create(zionApiUrl).toString();
        return given().log().all()
                .header("rtkn", auth)
                .headers(headers);
    }

    protected static RequestSpecification zionApiUrla() {
        RestAssured.baseURI = URI.create(zionApiUrl).toString();
        return given().log().all()
                .header("rtkn", auth);
    }

    public static Map<String, String> getParams(String url) throws Exception {

        URI uri = new URI(url);
        String query = uri.getQuery();  // everything after '?'

        Map<String, String> map = new HashMap<>();

        if (query == null || query.isEmpty()) { return map; }

        String[] params = query.split("&");

        for (String param : params) {
            String[] pair = param.split("=", 2);

            String key = URLDecoder.decode(pair[0], StandardCharsets.UTF_8.name());
            String value = "";

            if (pair.length > 1) {
                value = URLDecoder.decode(pair[1], StandardCharsets.UTF_8.name());
            }
            map.put(key, value);
        }

        return map;
    }

    //Specify all one time default Gson config
    public static Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gson(gsonBuilder);
        return gson;
    }

    //Custom Gson config to override Default Gson  configuration
    public static Gson gson(GsonBuilder gsonBuilder) {
        gson = gsonBuilder.create();
        return gson;
    }

    public static void setAuth(String auth){
        ApiHelper.auth = auth;
    }
}