package services.zionServices;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import helpers.ApiHelper;
import model.request.zion.layoutConfigReq.PostNewSection.PostNewSectionReq;
import model.request.zion.layoutConfigReq.postNewField.PostNewFieldReq;
import model.request.zion.layout.postModulesPositionInSection.PostModuleInSection;
import model.request.zion.layoutConfigReq.postNewPage.PostNewPageReq;
import model.request.zion.layoutConfigReq.postTemplates.PostNewTemplate;
import model.request.zion.postNewTile.PostNewTileReq;
import model.request.zion.layout.segments.postSegment.PostSegment;
import model.request.zion.layout.segments.updateSegment.UpdateSegment;
import services.BaseServiceClient;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ZionServices extends BaseServiceClient {

    private static final Headers headers = new Headers(
            new Header("Content-Type", "application/json"),
            new Header("accept", "*/*")
    );

    public static Response uploadFile(String filePath) {
        File file =new File(filePath);
        return zionApiUrla().multiPart(file).post("/uploadFile");
    }

    public static String getJsonBody(String uid) {
        return "{"
                +     "\"size\":20,"
                +     "\"query\":{"
                +         "\"bool\":{"
                +             "\"must\":["
                +                 "{\"term\":{\"transactionName.keyword\":\"origamiRequest\"}},"
                +                 "{\"term\":{\"uid.keyword\":\"" + uid + "\"}},"
                +                 "{\"term\":{\"pageId.keyword\":\"homepage2\"}}"
                +             "]"
                +         "}"
                +     "},"
                +     "\"_source\":["
                +         "\"startTime\",\"endTime\",\"@timestamp\",\"pageId\",\"uid\",\"transactionName\",\"message\",\"origamiRequest\""
                +     "],"
                +     "\"sort\":["
                +         "{\"@timestamp\":{\"order\":\"desc\"}}"
                +     "]"
                + "}";
    }

    public static Response getLayoutConfigFromZion(Map<String, String> param) {
        param.put("realm",appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .queryParams(param).get("/layout/config");
    }

    public static Response getLayoutFieldsFromZion(Map<String, String> param) {
        param.put("realm",appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .queryParams(param).get("/layout/fields");
    }

    public static Response getTiles(Map<String, String> param) {
        param.put("realm",appName);
        param.put("pageNo","0");
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .queryParams(param).get("/tile/tiles/search?pageSize=10&query=Shubham&sort=-lastUpdatedOn");
    }

    public static Response getLayoutTemplateFromZion(Map<String, String> param) {
        param.put("realm",appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .queryParams(param).get("/layout/templates");
    }

    public static Response getLayoutSectionsFromZion(Map<String, String> param) {
        param.put("realm",appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .queryParams(param).get("/layout/sections");
    }

    public static Response deleteSectionsFromZion(String sectionId) {
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .delete("/layout/sections"+sectionId+"?realm="+appName);
    }

    public static Response getSegmentsFromZion(Map<String, String> param) {
        param.put("realm",appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .queryParams(param).get("/layout/segments");
    }

    public static Response getSegmentFromZionById(String segmentId, Map<String, String> param) {
        param.put("realm",appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .queryParams(param).get("/layout/segments/"+segmentId);
    }

    public static Response getSectionFromZion(String sectionId,Map<String, String> param) {
        param.put("realm",appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .queryParams(param).get("/layout/sections/"+sectionId);
    }

    public static Response getSectionFromZion(String sectionId) {
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .get("/layout/sections/"+sectionId+"?realm="+appName);
    }

    public static Response getPagesFromZion(Map<String, String> param) {
        param.put("realm",appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .queryParams(param).get("/layout/pages");
    }

    public static Response getPageFromZion(String pageId,Map<String, String> param) {
        param.put("realm",appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .queryParams(param).get("/layout/pages/"+pageId);
    }

    public static Response postSegment(PostSegment postSegment) {
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(postSegment)).post("/layout/segments?realm="+appName);
    }

    public static Response getUserLogs(String arg0) {
        return baseApiUrl("logstashUrl",headers)
                .header("Authorization", "Basic ZGV2LWRlYnVnOklQMW9uRHQ3MDNLZA==")
                .body(getJsonBody(arg0)).post("/atv-package-layout-service-prd-logstash-*/_search");
    }

    public static Response postNewTemplate(PostNewTemplate postTemplate) {
        postTemplate.setRealm(appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(postTemplate)).post("/layout/templates?realm="+appName);
    }

    public static Response postNewField(PostNewFieldReq postNewFieldReq) {
        postNewFieldReq.setRealm(appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(postNewFieldReq)).post("/layout/fields?realm="+appName);
    }

    public static Response editField(String fieldId,PostNewFieldReq postNewFieldReq) {
        postNewFieldReq.setRealm(appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(postNewFieldReq)).put("/layout/fields/"+fieldId+"?realm="+appName);
    }

    public static Response deleteTemplate(String templateId) {
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .delete("/layout/templates/"+templateId+"?realm="+appName);
    }

    public static Response deleteField(String fieldId) {
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .delete("/layout/fields/"+fieldId+"?realm="+appName);
    }

    public static Response getModuleFromZion(Map<String, String> param) {
        param.put("realm",appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .queryParams(param).get("/layout/modules");
    }

    public static Response postModuleFromZion(Object postXMasterModule) {
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(postXMasterModule)).post("/layout/modules?realm="+appName);
    }

    public static Response putModuleFromZion(Object postXMasterModule) {
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(postXMasterModule)).put("/layout/modules?realm="+appName);
    }

    public static Response postNewSection(PostNewSectionReq postNewSectionRes) {
        postNewSectionRes.setRealm(appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(postNewSectionRes)).post("/layout/sections?realm="+appName);
    }

    public static Response putSection(PostNewSectionReq postNewSectionRes) {
        postNewSectionRes.setRealm(appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(postNewSectionRes)).put("/layout/sections/?realm="+appName);
    }

    public static Response postNewPage(PostNewPageReq postNewChildPageReq) {
        postNewChildPageReq.setRealm(appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(postNewChildPageReq)).post("/layout/pages?realm="+appName);
    }

    public static Response editPage(PostNewPageReq postNewChildPageReq) {
        postNewChildPageReq.setRealm(appName);
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(postNewChildPageReq)).put("/layout/pages?realm="+appName);
    }

    public static Response postNewModulePositionInSection(String sectionId, List<PostModuleInSection> postModuleInSection) {
        System.out.println(gson().toJson(postModuleInSection));
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(postModuleInSection)).post("/layout/sections/"+sectionId+"/add?realm="+appName);
    }

    public static Response postNewTile(PostNewTileReq postNewTileReq) {
        postNewTileReq.setRealm(appName);
        postNewTileReq.setStatus("ACTIVE");
        postNewTileReq.setType("TILE");
        postNewTileReq.setStatus("ACTIVE");
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(postNewTileReq)).post("/tile/add?realm="+appName);
    }

    public static Response updateExistingSegment(UpdateSegment updateSegment) {
        return baseApiUrl("zionApiUrl",headers)
                .header("rtkn", BaseServiceClient.getAuth())
                .body(gson().toJson(updateSegment)).put("/layout/segments?realm="+appName);
    }

    public static Response loginService(String email,String password) {
        return baseApiUrl("zionApiUrl_be")
                .header("rtkn", BaseServiceClient.getAuth())
                .body("{\"email\": \""+email+"\", \"password\": \""+password+"\"}").post("/user/zion/sign-in?realm=WYNK_MUSIC");
    }
}
