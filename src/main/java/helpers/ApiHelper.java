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

import java.net.URI;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    public Logger log = LoggerFactory.getLogger(ApiHelper.class);
    private static final Config conf = ConfigLoader.load();
    private static final String zionApiUrl = conf.getString("zionApiUrl");


    public static final String appName = conf.getString("appName");
    private static String auth = conf.getString("auth");
    public static Gson gson;

    private static final Headers defaultHeaders = new Headers(
            new Header("Content-Type", "application/json"),
            new Header("accept", "*/*")
    );

    protected static RequestSpecification baseApiUrl(String baseUrl) {
        RestAssured.baseURI = URI.create(conf.getString(baseUrl)).toString();
        return given().log().all().headers(defaultHeaders);
    }

    protected static RequestSpecification baseApiUrl(String baseUrl, Headers headers) {
        RestAssured.baseURI = URI.create(conf.getString(baseUrl)).toString();
        return given().log().all().headers(headers);
    }

    protected static RequestSpecification zionApiUrla() {
        RestAssured.baseURI = URI.create(zionApiUrl).toString();
        return given().log().all().header("rtkn", auth);
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

    public static String getAuth(){
        return ApiHelper.auth ;
    }

    public static String getCollectionUrls(String urlKey){
        return conf.getString(urlKey);
    }
}