package steps.api.userGrowth;

import static helpers.ApiHelper.gson;

public class UserGrowthSteps {
//    String templateId, templateId2, campaignId, filePath;
//    CreateTemplateResponse createTemplateReq;
//    CreateCampaignResponse createCampaignReq;
//    CreateCampaignResponse createCampaignResponse;
//    CampaignLiveForAllProdUsersRequest campaignLiveForAllProdUsersRequest;
//    MakeCampaignLiveForAllUsersResponse makeCampaignLiveForAllUsersResponse;
//    String userHome = System.getProperty("user.home");
//    String type;

//    @Given("^create templates for \"([^\"]*)\" and \"([^\"]*)\"$")
//    public void createTemplatesForAnd(String arg0, String arg1, DataTable dataTable) throws Throwable {
//        type = arg1;
//        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
//
//        if (arg0.equals("XSTREAM") && arg1.equals("SMS")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/Template.json";
//        } else if (arg0.equals("XSTREAM") && arg1.equals("PUSH")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/TemplateForXSTREAM_PUSH.json";
//        } else if (arg0.equals("WYNK_MUSIC") && arg1.equals("SMS")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/TemplateForWYNK_SMS.json";
//        } else {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/TemplateForWYNK_PUSH.json";
//        }
//
//        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
//        createTemplateReq = gson().fromJson(jsonString, CreateTemplateResponse.class);
//
//        if (data.size() > 0) {
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
//            jsonString = gson().toJson(createTemplateReq);
//        }
//
//
//        Response response = UserGrowthService.createTemplate(jsonString);
//        CreateTemplateResponse createTemplateResponse = gson().fromJson(response.body().asString(), CreateTemplateResponse.class);
//        templateId = createTemplateResponse.getId();
//        response.prettyPrint();
//        System.out.println("id = " + templateId);
//    }

//    @Then("^create campaign \"([^\"]*)\" for \"([^\"]*)\"$")
//    public void createCampaignFor(String arg0, String arg1) throws Throwable {
////        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
//        if (arg0.equals("XSTREAM") && arg1.equals("variant 1")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/CreateCampaign.json";
//        } else if (arg0.equals("WYNK_MUSIC") && arg1.equals("variant 1")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/CreateCampaign_WYNK.json";
//        } else if (arg0.equals("XSTREAM") && arg1.equals("variant 2")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/CreateCampaign_XSTREAM_V2.json";
//        } else {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/CreateCampaign_WYNK_V2.json";
//        }
//
//        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
//        createCampaignReq = gson().fromJson(jsonString, CreateCampaignResponse.class);
//
//        createCampaignReq.getVariants().get(0).getTemplateInfoMap().setFALLBACK(new ArrayList<>(Arrays.asList(templateId)));
//        if (arg1.equals("variant 2")) {
//            createCampaignReq.getVariants().get(1).getTemplateInfoMap().setFALLBACK(new ArrayList<>(Arrays.asList(templateId2)));
//        }
//        createCampaignReq.setTitle(createTemplateReq.getName());
//        createCampaignReq.setDescription(createTemplateReq.getDescription());
//        createCampaignReq.setType(type);
//
////        if (data.containsKey("title") && !data.get("tile").equals("")) {
////            createCampaignReq.setTitle(data.get("title"));
////        }
//
//
//        jsonString = gson().toJson(createCampaignReq);
//
//        Response response = UserGrowthService.createCampaign(jsonString);
//        createCampaignResponse = gson().fromJson(response.body().asString(), CreateCampaignResponse.class);
//        campaignId = createCampaignResponse.getId();
//        System.out.println(campaignId + "==" + createCampaignResponse.getTitle());
//        response.prettyPrint();
//    }
//
//    @Then("^make campaign live \"([^\"]*)\"$")
//    public void makeCampaignLive(String arg0) throws Throwable {
//        Response response = UserGrowthService.campaignTest(campaignId, arg0);
//        response.prettyPrint();
//    }
//
//    @Then("^make campaign live for all users \"([^\"]*)\"$")
//    public void makeCampaignLiveForAllProdUsers(String arg0, DataTable dataTable) throws Throwable {
//
//        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
//        if (!data.isEmpty()) {
//            if (arg0.equals("XSTREAM")) {
//                if (data.containsKey("campaignId"))
//                    campaignLiveForAllProdUsersRequest.setCampaignId(data.get("campaignId"));
//                if (data.containsKey("campaignName"))
//                    campaignLiveForAllProdUsersRequest.setCampaignName(data.get("campaignName"));
//                if (data.containsKey("realm")) campaignLiveForAllProdUsersRequest.setRealm(data.get("realm"));
//            }
//            Files.readAllBytes(Paths.get(filePath));
//            String jsonString;
//            campaignLiveForAllProdUsersRequest.setCreatedBy("paridhi.jain@wynk.in");
//            campaignLiveForAllProdUsersRequest.setScheduleCron("30 5 26 * FRI");
//            campaignLiveForAllProdUsersRequest.setSegmentId("664d9063b1093c47ab38a393");
//            campaignLiveForAllProdUsersRequest.setSegmentationTrigger(false);
//            campaignLiveForAllProdUsersRequest.setD1(true);
//            campaignLiveForAllProdUsersRequest.setEndDate("2025-03-01");
//            campaignLiveForAllProdUsersRequest.setDeployable(true);
//            campaignLiveForAllProdUsersRequest.setProd(true);
//            campaignLiveForAllProdUsersRequest.setPageSize(0);
//            jsonString = gson().toJson(campaignLiveForAllProdUsersRequest);
//            Response response = UserGrowthService.campaignLiveForAllProdUsers(jsonString);
//            response.prettyPrint();
//            System.out.println("statusCode = " + makeCampaignLiveForAllUsersResponse.getStatusCode());
//            System.out.println("statusCodeValue = " + makeCampaignLiveForAllUsersResponse.getStatusCodeValue());
//        }
//    }
//
//    @Given("^create templates for \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\"$")
//    public void createTemplatesForAndFor(String arg0, String arg1, String arg2, DataTable dataTable) throws Throwable {
//        type = arg1;
//        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
//
//        if (arg0.equals("XSTREAM") && arg1.equals("SMS")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/Template.json";
//        } else if (arg0.equals("XSTREAM") && arg1.equals("PUSH")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/TemplateForXSTREAM_PUSH.json";
//        } else if (arg0.equals("WYNK_MUSIC") && arg1.equals("SMS")) {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/TemplateForWYNK_SMS.json";
//        } else {
//            filePath = userHome + "/Documents/Migration_Scripts/src/test/java/model/request/ugpCampaign/TemplateForWYNK_PUSH.json";
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
//                createTemplateReq.setType(data.get("type"));
//                createTemplateReq.setRealm(data.get("realm"));
//            }
//            if (data.containsKey("name")) createTemplateReq.setName(data.get("name"));
//            if (data.containsKey("name")) createTemplateReq.setDescription(data.get("name"));
//            if (data.containsKey("messageTitle")) createTemplateReq.setMessageTitle(data.get("messageTitle"));
//            if (data.containsKey("messageBody")) createTemplateReq.setMessageBody(data.get("messageBody"));
//            if (data.containsKey("richContents"))
//                createTemplateReq.getRichContents().get(0).setValue(data.get("richContents"));
//            if (data.containsKey("action")) createTemplateReq.getAction().setValue(data.get("action"));
//
//            if (data.containsKey("collectionId") && !data.get("collectionId").equals("")) {
//                String[] temp = data.get("collectionId").split(", ");
//                for (int i = 0; i < temp.length; i++) {
//                    String[] temp2 = temp[i].split("-");
//                    createTemplateReq.getCollections().get(i).setCollectionId(temp2[0]);
//                    createTemplateReq.getCollections().get(i).getContentConfig().setContentFetchingStrategy(temp2[1]);
//                }
//            }
//            jsonString = gson().toJson(createTemplateReq);
//        }
//
//
//        Response response = UserGrowthService.createTemplate(jsonString);
//        CreateTemplateResponse createTemplateResponse = gson().fromJson(response.body().asString(), CreateTemplateResponse.class);
//        if (arg2.equals("variant 1")) {
//            templateId = createTemplateResponse.getId();
//        }
//        templateId2 = createTemplateResponse.getId();
//        response.prettyPrint();
//        System.out.println("id = " + templateId);
//    }
}
