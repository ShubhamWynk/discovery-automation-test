package services;

import helpers.ApiHelper;
import io.restassured.response.Response;

import java.util.Map;

public class BaseServiceClient extends ApiHelper {

    public static Response get(String baseUrl, Map<String, String> param, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .get(endPoint);
    }

    public static Response get(Map<String, String> param, String endPoint) {
        return baseApiUrl("discoveryUrl")
                .queryParams(param)
                .get(endPoint);
    }

    public static Response post(String baseUrl, Map<String, String> param, String body, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .body(body)
                .post(endPoint);
    }

    public static Response post(Map<String, String> param, String body, String endPoint) {
        return baseApiUrl("discoveryUrl")
                .queryParams(param)
                .body(body)
                .post(endPoint);
    }

    public static Response post(String body, String endPoint) {
        return baseApiUrl("discoveryUrl")
                .body(body)
                .post(endPoint);
    }

    public static Response delete(Map<String, String> param, String endPoint) {
        return baseApiUrl("discoveryUrl")
                .queryParams(param)
                .delete(endPoint);
    }

    public static Response delete(String baseUrl, Map<String, String> param, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .delete(endPoint);
    }

    public static Response put(String baseUrl, Map<String, String> param, String body, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .body(body)
                .put(endPoint);
    }

    public static Response put(Map<String, String> param, String body, String endPoint) {
        return baseApiUrl("discoveryUrl")
                .queryParams(param)
                .body(body)
                .put(endPoint);
    }
}
