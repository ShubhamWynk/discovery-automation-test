package services.userGrowth;

import io.restassured.response.Response;
import helpers.ApiHelper;
import model.response.userGrowth.AddCampaignRequestPayload;
import model.response.userGrowth.AddTemplateRequestPayload;
import model.response.userGrowth.UpdateCampaign.UpdateCampaignRequestPayload;
import model.response.userGrowth.UpdateTemplate.UpdateTemplateRequestPayload;
import model.response.userGrowth.template.CreateTemplateRequestPayload;

import java.util.HashMap;
import java.util.Map;

public class UserGrowthService extends ApiHelper {

    public static Response createTemplate(String createTemplatePayload) {
        return userGrowthApiUrl().body(createTemplatePayload).post("/templates");
    }


    public static Response createCampaign(String createCampaignPayload) {
        return userGrowthApiUrl().body(createCampaignPayload).post("/campaigns");
    }


    public static Response campaignTest(String campaignId , String realm) {
        return userGrowthApiUrl().body("{\n" +
                "  \"campaignId\": \""+campaignId+"\",\n" +
                "  \"realm\": \""+realm+"\"\n" +
                "}").post("/campaigns/test");
    }


    public static Response campaignLiveForAllProdUsers(String campaignLiveForAllProdUsersPayload) {
        return userGrowthEnigmaApiUrl().body(campaignLiveForAllProdUsersPayload).post("/cdp/scheduler");
    }


    public static Response createTemplatePayload (CreateTemplateRequestPayload createTemplatePayload) {
        return userGrowthApiUrl().body(createTemplatePayload).post("/templates");
    }


    public static Response getCampaignThroughId (String realm, Object id) {
        Map<String,String> queryParam = new HashMap<>();
        queryParam.put("realm",realm);
        return userGrowthApiUrl().queryParams(queryParam).pathParams("id",id).get("/campaigns/{id}");
    }


    public static Response updateCampaign (UpdateCampaignRequestPayload updateCampaignRequestPayload, Object id) {
        return userGrowthApiUrl().body(updateCampaignRequestPayload).pathParams("id",id).put("/campaigns/{id}");
    }


    public static Response getTemplateThroughId (String realm, Object id) {
        Map<String,String> queryParam = new HashMap<>();
        queryParam.put("realm",realm);
        return userGrowthApiUrl().queryParams(queryParam).pathParams("id",id).get("/templates/{id}");
    }


    public static Response updateTemplate (UpdateTemplateRequestPayload updateTemplateRequestPayload, Object id) {
        return userGrowthApiUrl().body(updateTemplateRequestPayload).pathParams("id",id).put("/templates/{id}");
    }


    public static Response getSegmentThroughId (Object id) {
        return userGrowthApiUrl().pathParams("id",id).get("/segments/{id}");
    }


    public static Response getCampaignSplitPercentageThroughId (String realm, Object id) {
        Map<String,String> queryParam = new HashMap<>();
        queryParam.put("realm",realm);
        return userGrowthApiUrl().queryParams(queryParam).pathParams("id",id).get("/campaigns/splitPercentage/{id}");
    }


    public static Response getAllCampaignsDetails(){
        return userGrowthApiUrl().get("/campaigns");
    }


    public static Response addCampaign (AddCampaignRequestPayload addCampaignRequestPayload) {
        return userGrowthApiUrl().body(addCampaignRequestPayload).post("/campaigns");
    }


    public static Response deleteCampaign (String id) {
        Map<String,String> queryParam = new HashMap<>();
        queryParam.put("id",id);
        return userGrowthApiUrl().queryParams(queryParam).delete("/campaigns");
    }

    public static Response addTemplate(AddTemplateRequestPayload addTemplateRequestPayload) {
        return userGrowthApiUrl().body(addTemplateRequestPayload).post("/templates");
    }

    public static Response deleteTemplate (String id) {
        Map<String,String> queryParam = new HashMap<>();
        queryParam.put("id",id);
        return userGrowthApiUrl().queryParams(queryParam).delete("/templates");
    }

    public static Response getALlTemplates (Integer pageSize) {
        Map<String,String> queryParam = new HashMap<>();
        queryParam.put("pageSize",pageSize.toString());
        return userGrowthApiUrl().queryParams(queryParam).get("/templates");
    }

}
