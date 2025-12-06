package services.discovery;

import io.restassured.response.Response;
import helpers.ApiHelper;

import java.util.HashMap;
import java.util.Map;

public class OrigamiCrud extends ApiHelper {

    private final static String ORIGAMI_CRUD="/origami-crud";

    // ********************* Templates *********************
    public Response getTemplateSearch(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return discoveryApiUrl().queryParams(query).when().get(ORIGAMI_CRUD+"/v1/config/templates/search");
    }

    public Response getAllTemplates(String realm) {
        return discoveryApiUrl().when().get(ORIGAMI_CRUD+"/v1/config/templates?realm="+realm);
    }

    // ********************** Fields ************************
    public Response getFieldsSearch(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return discoveryApiUrl().queryParams(query).when().get(ORIGAMI_CRUD+"/v1/config/fields");
    }

    public Response getAttributeFields(String realm) {
        return discoveryApiUrl().when().get(ORIGAMI_CRUD+"/v1/config/fields/attributes?realm"+realm);
    }

    public Response deleteFields(String id,String realm) {
        return discoveryApiUrl().when().delete(ORIGAMI_CRUD+"/v1/config/fields/"+id+"?realm"+realm);
    }

    // ********************  Attributes  ************************
    public Response getAttribute(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return discoveryApiUrl().queryParams(query).when().get(ORIGAMI_CRUD+"/v1/attributes");
    }

    public Response getAttributeFlattened(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return discoveryApiUrl().queryParams(query).when().get(ORIGAMI_CRUD+"/v1/attributes/flattened");
    }

    public Response getAttributeById(String id, String realm) {
        return discoveryApiUrl().when().get("/v1/attributes/"+id+"?realm="+realm);
    }

    // ************************ Modules **********************
    public Response getModules(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return discoveryApiUrl().queryParams(query).when().get(ORIGAMI_CRUD+"/v1/modules");
    }

    public Response getAllModules(String realm) {
        return discoveryApiUrl().when().get(ORIGAMI_CRUD+"/v1/modules/all?realm"+realm);
    }

    public Response getModulesById(String id, String realm) {
        return discoveryApiUrl().when().get(ORIGAMI_CRUD+"/v1/modules/"+id+"?realm="+realm);
    }

    // ************************* Pages ***********************
    public Response getPages(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return discoveryApiUrl().queryParams(query).when().get(ORIGAMI_CRUD+"/v1/pages");
    }

    public Response getAllPages(String realm) {
        return discoveryApiUrl().when().get(ORIGAMI_CRUD+"/v1/pages/all?realm"+realm);
    }

    public Response getPagesById(String id, String realm) {
        return discoveryApiUrl().when().get(ORIGAMI_CRUD+"/v1/pages/"+id+"?realm="+realm);
    }

    public Response getPagesByAdapterKey(String adapterKey, String realm) {
        return discoveryApiUrl().when().get(ORIGAMI_CRUD+"/v1/pages/adapter/"+adapterKey+"?realm="+realm);
    }

    public Response getPagesByKey(String key, String realm) {
        return discoveryApiUrl().when().get(ORIGAMI_CRUD+"/v1/pages/key/"+key+"?realm="+realm);
    }

    // ********************** Section *************************
    public Response getSectionVariants(String Key, String realm) {
        return discoveryApiUrl().when().get(ORIGAMI_CRUD+"/v1/sections/variants/"+Key+"?realm="+realm);
    }

    public Response getSections(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return discoveryApiUrl().queryParams(query).when().get(ORIGAMI_CRUD+"/v1/sections");
    }

    // *********************** Segment ************************
    public Response getDefaultSegments(String realm) {
        return discoveryApiUrl().when().get(ORIGAMI_CRUD+"/v1/segments/default?realm="+realm);
    }

    public Response getSegmentById(String id, String realm) {
        return discoveryApiUrl().when().get(ORIGAMI_CRUD+"/v1/segments/"+id+"?realm="+realm);
    }

    public Response deleteSegmentById(String id, String realm) {
        return discoveryApiUrl().when().delete(ORIGAMI_CRUD+"/v1/segments/"+id+"?realm="+realm);
    }

    public Response getSegments(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return discoveryApiUrl().queryParams(query).when().get(ORIGAMI_CRUD+"/v1/segments");
    }


    // ********************* config *************************
    public Response getClients(Map<String, String> query) {
        if (query == null || query.isEmpty()) {
            query = new HashMap<>();
            query.put("realm", appName);
        }
        return discoveryApiUrl().queryParams(query).when().get(ORIGAMI_CRUD+"/v1/config/clients");
    }

}
