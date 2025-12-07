package steps.api.userGrowth;

import io.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.response.userGrowth.Campaign.CreateCampaignResponse;
import model.response.userGrowth.CreateCampaignMultilingual.CreateCampaignMultiLangRequest;
import model.response.userGrowth.template.CreateTemplateResponse;
import services.userGrowth.UserGrowthService;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static helpers.ApiHelper.gson;

public class UserGrowthStepsForMultilingualSteps {
//    String type, filePath, templateId, usl, campaignId;
//    String userHome = System.getProperty("user.home");
//    CreateTemplateResponse createTemplateReq;
//    CreateCampaignMultiLangRequest createCampaignReq;
//    CreateCampaignResponse createCampaignResponse;
//
//    List<Map<String, List<String>>> var1 = new ArrayList<>();
//    List<Map<String, List<String>>> var2 = new ArrayList<>();
//
//    @Given("^create templates for multilingual \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\"$")
//    public void createTemplatesForMultilingualAndAndFor(String arg0, String arg1, String arg2, String arg3, DataTable dataTable) throws Throwable {
//          type = arg1;
//          usl = arg2;
//        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
//
//        if (arg0.equals("XSTREAM") && arg1.equals("SMS")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/CreateTemplateMultilingual_XSTREAM_SMS.json";
//        } else if (arg0.equals("XSTREAM") && arg1.equals("PUSH")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/CreateTemplateMultilingual_XSTREAM_PUSH.json";
//        } else if (arg0.equals("WYNK_MUSIC") && arg1.equals("SMS")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/CreateTemplateMultilingual_WYNK_SMS.json";
//        } else {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/CreateTemplateMultilingual_WYNK_PUSH.json";
//        }
//
//        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
//        createTemplateReq = gson().fromJson(jsonString, CreateTemplateResponse.class);
//
//        if (!data.isEmpty()) {
//            if (arg1.equals("SMS")) {
//                if (data.containsKey("smsHeader")) createTemplateReq.setSmsHeader(data.get("smsHeader"));
//                if (data.containsKey("smsTemplateId")) createTemplateReq.setSmsTemplateId(data.get("smsTemplateId"));
//                if (data.containsKey("smsType")) createTemplateReq.setSmsType(data.get("smsType"));
//            }
//            if (data.containsKey("name")) createTemplateReq.setName(data.get("name"));
//            if (data.containsKey("name")) createTemplateReq.setDescription(data.get("name"));
//            if (data.containsKey("messageTitle")) createTemplateReq.setMessageTitle(data.get("messageTitle"));
//            if (data.containsKey("messageBody")) createTemplateReq.setMessageBody(data.get("messageBody"));
//            if (data.containsKey("richContents"))
//                createTemplateReq.getRichContents().get(0).setValue(data.get("richContents"));
//            if (data.containsKey("action")) createTemplateReq.getAction().setValue(data.get("action"));
//            if (data.containsKey("collectionId") && !data.get("collectionId").equals("")) {
//                String[] temp = data.get("collectionId").split(", ");
//                for (int i = 0; i < temp.length; i++) {
//                    String[] temp2 = temp[i].split("-");
//                    createTemplateReq.getCollections().get(i).setCollectionId(temp2[0]);
//                    createTemplateReq.getCollections().get(i).getContentConfig().setContentFetchingStrategy(temp2[1]);
//                }
//            }
//            createTemplateReq.getEsConfig().getPlaceholderMapping().setUsl(usl);
//            jsonString = gson().toJson(createTemplateReq);
//        }
//
//        Response response = UserGrowthService.createTemplate(jsonString);
//        CreateTemplateResponse createTemplateResponse = gson().fromJson(response.body().asString(), CreateTemplateResponse.class);
//
//        templateId = createTemplateResponse.getId();
//        Map<String, List<String>> temp = new HashMap<>();
//        List<String> tempList = new ArrayList<>();
//        tempList.add(createTemplateResponse.getId());
//        temp.put(arg2, tempList);
//        if (arg3.equals("variant 1")) {
//            var1.add(temp);
//        } else {
//            var2.add(temp);
//        }
//
//        response.prettyPrint();
//        System.out.println("id = " + templateId);
//    }
//
//    @Then("^create campaign for multilingual \"([^\"]*)\" for \"([^\"]*)\"$")
//    public void createCampaignForMultilingualFor(String arg0, String arg1) throws Throwable {
//        if (arg0.equals("XSTREAM") && arg1.equals("variant 1")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/CreateCampaignMultilingual_XSTREAM_V1.json";
//        } else if (arg0.equals("WYNK_MUSIC") && arg1.equals("variant 1")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/CreateCampaignMultilingual_WYNK_V1.json";
//        } else if (arg0.equals("XSTREAM") && arg1.equals("variant 2")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/CreateCampaignMultilingual_XSTREAM_V2.json";
//        } else {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/CreateCampaignMultilingual_WYNK_V2.json";
//        }
//
//        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
//        createCampaignReq = gson().fromJson(jsonString, CreateCampaignMultiLangRequest.class);
//        if (arg1.equals("variant 1")) {
//            createCampaignReq.getVariants().get(0).setTemplateInfoMap(var1.get(0));
//        }
//        if (arg1.equals("variant 2")) {
//            createCampaignReq.getVariants().get(0).setTemplateInfoMap(var1.get(0));
//            createCampaignReq.getVariants().get(1).setTemplateInfoMap(var2.get(0));
//        }
//        createCampaignReq.setTitle(createTemplateReq.getName());
//        createCampaignReq.setDescription(createTemplateReq.getDescription());
//        createCampaignReq.setType(type);
//
//        jsonString = gson().toJson(createCampaignReq);
//        Response response = UserGrowthService.createCampaign(jsonString);
//        createCampaignResponse = gson().fromJson(response.body().asString(), CreateCampaignResponse.class);
//        campaignId = createCampaignResponse.getId();
//        System.out.println(campaignId + "==" + createCampaignResponse.getTitle());
//        response.prettyPrint();
//    }

}
