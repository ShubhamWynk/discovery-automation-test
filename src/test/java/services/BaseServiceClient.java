package services;

import helpers.ApiHelper;
import io.restassured.response.Response;

import java.util.Map;

public class BaseServiceClient extends ApiHelper {

    protected static Response get(String baseUrl, Map<String, String> param, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .get(endPoint);
    }

    protected static Response get(Map<String, String> param, String endPoint) {
        return baseApiUrl("discoveryUrl")
                .queryParams(param)
                .get(endPoint);
    }

    protected static Response post(String baseUrl, Map<String, String> param, String body, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .body(body)
                .post(endPoint);
    }

    protected static Response post(Map<String, String> param, String body, String endPoint) {
        return baseApiUrl("discoveryUrl")
                .queryParams(param)
                .body(body)
                .post(endPoint);
    }

    protected static Response post(String body, String endPoint) {
        return baseApiUrl("discoveryUrl")
                .body(body)
                .post(endPoint);
    }

    protected static Response delete(Map<String, String> param, String endPoint) {
        return baseApiUrl("discoveryUrl")
                .queryParams(param)
                .delete(endPoint);
    }

    protected static Response delete(String baseUrl, Map<String, String> param, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .delete(endPoint);
    }

    protected static Response put(String baseUrl, Map<String, String> param, String body, String endPoint) {
        return baseApiUrl(baseUrl)
                .queryParams(param)
                .body(body)
                .put(endPoint);
    }

    protected static Response put(Map<String, String> param, String body, String endPoint) {
        return baseApiUrl("discoveryUrl")
                .queryParams(param)
                .body(body)
                .put(endPoint);
    }
}
