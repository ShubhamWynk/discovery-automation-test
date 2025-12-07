package steps.api.common;

import io.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import helpers.ApiHelper;
import model.request.common.SupportedClient;
import model.request.zion.layoutConfigReq.PostNewSection.PostNewSectionReq;
import model.request.zion.layoutConfigReq.postNewField.Attributes;
import model.request.zion.layoutConfigReq.postNewField.Meta;
import model.request.zion.layoutConfigReq.postNewField.PostNewFieldReq;
import model.request.zion.layoutConfigReq.postNewPage.SegmentSection;
import model.request.zion.layoutConfigReq.postNewPage.PostNewPageReq;
import model.request.zion.layoutConfigReq.postNewPage.SegmentPage;
import model.request.zion.layoutConfigReq.postTemplates.PostNewTemplate;
import model.response.zion.layout.section.getSectionDetails.GetSectionDetailsResponse;
import model.response.zion.layoutConfig.getTemplates.GetTemplatesRes;
import model.response.zion.layoutConfig.PostNewField.PostNewFieldRes;
import model.response.zion.layoutConfig.PostNewSection.PostNewSectionRes;
import model.response.zion.layoutConfig.PostNewTemplate.PostNewTemplateRes;
import model.response.zion.layoutConfig.getAllFields.GetAllFieldsResponse;
import model.response.zion.layoutConfig.getPage.GetPageResponce;
import model.response.zion.layoutConfig.getPagesList.GetPagesListResponse;
import model.response.zion.layout.section.getSections.GetSectionsListRes;
import model.response.zion.layout.segment.getSegment.GetSegmentation;
import model.response.zion.layoutConfig.postNewChildPage.PostNewChildPageRes;
import model.response.zion.layout.uploadFile.UploadFilRes;
import model.response.zion.layoutConfig.getPage.SegmentModule;
import model.response.zion.zionLoginService.ZionLoginServiceRes;
import org.junit.Assert;
import services.zionServices.ZionServices;
import config.ConfigLoader;

import java.util.*;
import static helpers.ApiHelper.gson;

public class LayoutConfigSteps {
    List<PostNewSectionRes> postNewSectionResList = new ArrayList<>();
    List<PostNewChildPageRes> postNewChildPageResList = new ArrayList<>();
    PostNewFieldRes postNewFieldRes;
    List<PostNewPageReq> postNewPageReqList = new ArrayList<>();
    PostNewPageReq postNewPageReq = new PostNewPageReq();
    PostNewFieldReq postNewFieldReq = new PostNewFieldReq();
    PostNewTemplate postNewTemplate = new PostNewTemplate();
    PostNewTemplateRes postNewTemplateRes;

    public ZionLoginServiceRes loginService(String email,String pass){
        Response response = ZionServices.loginService(email,pass);
        Assert.assertEquals(200, response.getStatusCode());
        return gson().fromJson(response.body().asString(), ZionLoginServiceRes.class);
    }

    public static GetSegmentation getSegmentsFromZion(String segment) {
        Map<String, String> param = new HashMap<>();
        param.put("query", segment);
        param.put("pageNo", "0");
        param.put("pageSize", "50");
        param.put("types", "DEFAULT,PARENT,CHILD");
        Response segmentRes = ZionServices.getSegmentsFromZion(param);
        Assert.assertEquals(200, segmentRes.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(segmentRes.body().asString(), GetSegmentation.class);
    }

    public static String searchSegmentsFromZion(String segment) {
        GetSegmentation getSegmentation = getSegmentsFromZion(segment);
        for (int i = 0; i < getSegmentation.getData().size(); i++) {
            if (getSegmentation.getData().get(i).getName().equals(segment)) {
                return getSegmentation.getData().get(i).getId();
            }
        }
        return null;
    }

    public GetPageResponce getPageFromZion(String id, Map<String, String> param) {
        Response getDataResponse = ZionServices.getPageFromZion(id, param);
        Assert.assertEquals(200, getDataResponse.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(getDataResponse.body().asString(), GetPageResponce.class);
    }

    public GetTemplatesRes getPageFromZion() {
        Response response = ZionServices.getLayoutTemplateFromZion(new HashMap<>());
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), GetTemplatesRes.class);
    }

    public static UploadFilRes uploadFile(String filePath) {
        Response uploadFile = ZionServices.uploadFile(filePath);
        Assert.assertEquals(200, uploadFile.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(uploadFile.body().asString(), UploadFilRes.class);
    }

    public GetSectionDetailsResponse getSectionFromZion(String id, Map<String, String> param) {
        Response response = ZionServices.getSectionFromZion(id, param);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), GetSectionDetailsResponse.class);
    }

    public static GetAllFieldsResponse[] getLayoutFieldsFromZion(Map<String, String> param) {
        Response response = ZionServices.getLayoutFieldsFromZion(param);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), GetAllFieldsResponse[].class);
    }

    public static PostNewFieldRes postNewField(PostNewFieldReq postNewFieldReq) {
        Response response = ZionServices.postNewField(postNewFieldReq);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), PostNewFieldRes.class);
    }

    public static PostNewFieldRes editField(String id,PostNewFieldReq postNewFieldReq) {
        Response response = ZionServices.editField(id,postNewFieldReq);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), PostNewFieldRes.class);
    }

    public PostNewChildPageRes postNewPage(PostNewPageReq postNewChildPageReq) {
        Response response = ZionServices.postNewPage(postNewChildPageReq);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), PostNewChildPageRes.class);
    }

    public PostNewChildPageRes updatePage(PostNewPageReq postNewChildPageReq) {
        Response response = ZionServices.editPage(postNewChildPageReq);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), PostNewChildPageRes.class);
    }

    public GetSectionsListRes getLayoutSectionsFromZion(Map<String, String> param) {
        Response sectionRes = ZionServices.getLayoutSectionsFromZion(param);
        Assert.assertEquals(200, sectionRes.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(sectionRes.body().asString(), GetSectionsListRes.class);
    }

    public PostNewSectionRes postNewSection(PostNewSectionReq postNewSectionReq) {
        Response response = ZionServices.postNewSection(postNewSectionReq);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), PostNewSectionRes.class);
    }

    public PostNewSectionRes putSection(PostNewSectionReq postNewSectionReq) {
        Response response = ZionServices.putSection(postNewSectionReq);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), PostNewSectionRes.class);
    }

    public GetPagesListResponse getPagesFromZion(String page, String pageType) {
        Map<String, String> param2 = new HashMap<>();
        param2.put("query", page);
        param2.put("pageNo", "0");
        param2.put("pageSize", "50");
        param2.put("pageType", pageType);
        Response childPageRes = ZionServices.getPagesFromZion(param2);
        Assert.assertEquals(200, childPageRes.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(childPageRes.body().asString(), GetPagesListResponse.class);
    }

    public PostNewTemplateRes postNewTemplate(PostNewTemplate postNewTemplate) {
        Response response = ZionServices.postNewTemplate(postNewTemplate);
        Assert.assertEquals(200, response.getStatusCode());
        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
        return gson().fromJson(response.body().asString(), PostNewTemplateRes.class);
    }

//    @Given("^login with curator user$")
//    public void loginWithCuratorUser() {
//        if(Objects.equals(ConfigLoader.environment, "prod")){
//            ZionLoginServiceRes zionLoginServiceRes = loginService("shubhamgupta212755@gmail.com","U2FsdGVkX19NQaev3NfCf/RPc7QSo16B39TywmXFdzk=");
//            ApiHelper.setAuth(zionLoginServiceRes.getRtkn());
//        }
//    }

    @Given("^User create new section$")
    public void userCreateNewSection(List<PostNewSectionReq> postNewSection) throws Throwable {
        for (PostNewSectionReq postNewSectionReq : postNewSection) {
            List<SegmentModule> segmentModules = new ArrayList<>();
            postNewSectionReq.setSegmentModules(segmentModules);
            postNewSectionResList.add(postNewSection(postNewSectionReq));
        }
    }

    @Given("^User create new page$")
    public void userCreateNewPage(List<PostNewPageReq> postNewPage) {
        for (int i = 0; i < postNewPage.size(); i++) {
            postNewPageReqList.add(postNewPage.get(i));
            postNewPageReqList.get(i).setId("");
        }
    }

    @Given("^User create payload for new template$")
    public void userCreateNewTemplate(List<PostNewTemplate> postNewTemplates) {
        postNewTemplate = postNewTemplates.get(0);
    }

    @And("^User add supported client$")
    public void userAddSupportedClient(List<SupportedClient> supportedClients) {
        postNewTemplate.setSupportedClients(supportedClients);
    }

    @Then("^User hit post template endpoint to create new template$")
    public void userHitPostTemplateEndpointToCreateNewTemplate() {
        PostNewTemplateRes postNewTemplateRes = postNewTemplate(postNewTemplate);
        Assert.assertNotNull(postNewTemplateRes.getId());
    }

    @Then("^Verify Template should be added$")
    public void verifyTemplateShouldBeAdded() {
        Response response = ZionServices.getLayoutTemplateFromZion(new HashMap<>());
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertTrue(response.body().asString().contains(postNewTemplateRes.getId()));
        Assert.assertTrue(response.body().asString().contains(postNewTemplateRes.getTitle()));
    }

    @Then("^User delete template$")
    public void userDeleteTemplate() {
        Response response = ZionServices.deleteTemplate("");
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Then("^User delete field$")
    public void userDeleteField() {
        Response response = ZionServices.deleteField("");
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Then("^User delete section$")
    public void userDeleteSection() {
        Response response = ZionServices.deleteSectionsFromZion("");
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Given("^User create payload for new field$")
    public void userCreatePayloadForNewField(List<PostNewFieldReq> postNewFieldReq) {
        this.postNewFieldReq = postNewFieldReq.get(0);
        Attributes attributes = new Attributes();
        attributes.setRequired(true);
        this.postNewFieldReq.setAttributes(attributes);
        Meta meta = new Meta();
        meta.setDefaultValue(Long.parseLong(""));
        this.postNewFieldReq.setMeta(meta);
    }

    @Then("^User hit post Field endpoint to create new Field$")
    public void userHitPostFieldEndpointToCreateNewField() {
        postNewFieldRes = postNewField(postNewFieldReq);
    }

    @Then("^Verify Field should be added$")
    public void verifyFieldShouldBeAdded() {
        GetAllFieldsResponse[] getAllFieldsRes = getLayoutFieldsFromZion(new HashMap<>());
        for (GetAllFieldsResponse getAllFieldsRe : getAllFieldsRes) {
            if (getAllFieldsRe.getTitle().equals(postNewFieldRes.getTitle())) {
                Assert.assertEquals(getAllFieldsRe.getTitle(), postNewFieldRes.getTitle());
                Assert.assertEquals(getAllFieldsRe.getId(), postNewFieldRes.getId());
                return;
            }
        }
        Assert.fail();
    }

    @Then("^Verify new \"([^\"]*)\" page should be added$")
    public void verifyNewPageShouldBeAdded(String arg0) throws Throwable {
        for (PostNewChildPageRes newChildPageRes : postNewChildPageResList) {
            GetPagesListResponse getPageListRes = getPagesFromZion(newChildPageRes.getTitle(), arg0);
            boolean isAvaliable = false;
            for (int i = 0; i < getPageListRes.getData().size(); i++) {
                if (getPageListRes.getData().get(i).getTitle().equals(newChildPageRes.getTitle())) {
                    Assert.assertEquals(getPageListRes.getData().get(i).getTitle(), newChildPageRes.getTitle());
                    Assert.assertEquals(getPageListRes.getData().get(i).getId(), newChildPageRes.getId());
                    isAvaliable = true;
                    break;
                }
            }
            if (!isAvaliable) {
                Assert.fail();
            }
            GetPageResponce getPageResponce = getPageFromZion(newChildPageRes.getId(), new HashMap<>());
            Assert.assertEquals(getPageResponce.getId(), newChildPageRes.getId());
            Assert.assertEquals(getPageResponce.getPageType(), newChildPageRes.getPageType());
            Assert.assertEquals(getPageResponce.getKey(), newChildPageRes.getKey());
            Assert.assertEquals(getPageResponce.getCreatedOn(), newChildPageRes.getCreatedOn());
            Assert.assertEquals(getPageResponce.getLastUpdatedBy(), newChildPageRes.getLastUpdatedBy());
            Assert.assertEquals(getPageResponce.getCreatedBy(), newChildPageRes.getCreatedBy());
        }
    }

    @Then("^Verify new section should be added$")
    public void verifyNewSectionShouldBeAdded() {
        for (PostNewSectionRes postNewSectionRes : postNewSectionResList) {
            Map<String, String> param2 = new HashMap<>();
            param2.put("query", postNewSectionRes.getTitle());
            param2.put("pageNo", "0");
            param2.put("pageSize", "400");
            GetSectionsListRes getSectionsListRes = getLayoutSectionsFromZion(param2);
            boolean isAvaliable = false;
            for (int i = 0; i < getSectionsListRes.getData().size(); i++) {
                if (getSectionsListRes.getData().get(i).getTitle().equals(postNewSectionRes.getTitle())) {
                    Assert.assertEquals(getSectionsListRes.getData().get(i).getTitle(), postNewSectionRes.getTitle());
                    Assert.assertEquals(getSectionsListRes.getData().get(i).getId(), postNewSectionRes.getId());
                    isAvaliable = true;
                    break;
                }
            }
            if (!isAvaliable) {
                Assert.fail();
            }
        }
        for (PostNewSectionRes postNewSectionRes : postNewSectionResList) {
            GetSectionDetailsResponse getSectionDetailsResponse = getSectionFromZion(postNewSectionRes.getId(), new HashMap<>());
            Assert.assertEquals(getSectionDetailsResponse.getId(), postNewSectionRes.getId());
            Assert.assertEquals(getSectionDetailsResponse.getTitle(), postNewSectionRes.getTitle());
            Assert.assertEquals(getSectionDetailsResponse.getCreatedBy(), postNewSectionRes.getCreatedBy());
        }
    }

    @Then("^User attach child page and segment in page$")
    public void userAttachChildPageAndSegmentInPage(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < rows.size(); i++) {
            Map<String, String> row = rows.get(i);
            List<SegmentPage> segmentPageList = new ArrayList<>();
            String[] childPage = row.get("Child Page").split(",");
            String[] segments = row.get("Segment").split(",");

            for (int j = 0; j < childPage.length; j++) {
                SegmentPage segmentPage = new SegmentPage();
                segmentPage.setSegmentId(searchSegmentsFromZion(segments[j]));
                GetPagesListResponse getSectionsListRes = getPagesFromZion(childPage[j], "CHILD");
                segmentPage.setPageId(getSectionsListRes.getData().get(0).getId());
                segmentPage.setIsFallback(row.get("isFallback").split(",")[j].equals("true"));
                segmentPage.setTagRank(false);
                segmentPageList.add(segmentPage);
            }
            postNewPageReqList.get(i).setAdapterKeys(Arrays.asList(row.get("adapterKeys").split(", ")));
            postNewPageReqList.get(i).setSegmentPages(segmentPageList);
            postNewChildPageResList.add(postNewPage(postNewPageReqList.get(i)));
        }
    }

    @Then("^User attach Sections and segment in page$")
    public void userAttachSectionsAndSegmentInPage(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (int i=0;i<rows.size();i++) {
            Map<String, String> row = rows.get(i);

            String[] sections = row.get("Sections").split(", ");
            String[] segments = row.get("Segment").split(", ");
            List<SegmentSection> segmentSectionList = new ArrayList<>();

            for (int j = 0; j < sections.length; j++) {
                SegmentSection segmentSection = new SegmentSection();
                Map<String, String> param2 = new HashMap<>();
                param2.put("query", sections[j]);
                GetSectionsListRes getSectionsListRes = getLayoutSectionsFromZion(param2);
                segmentSection.setSectionId(getSectionsListRes.getData().get(j).getId());
                segmentSection.setWeight(j + 1);
                segmentSection.setTagRank(false);
                segmentSection.setSegmentId(searchSegmentsFromZion(segments[j]));
                segmentSectionList.add(segmentSection);
            }
            postNewPageReqList.get(i).setSegmentSections(segmentSectionList);
            postNewChildPageResList.add(postNewPage(postNewPageReqList.get(i)));
        }
    }

    @Given("^User Edit \"([^\"]*)\" page$")
    public void userEditPage(String pageName, DataTable dataTable) throws Throwable {
        Map<String, String> row = dataTable.asMaps(String.class, String.class).get(0);
        GetPageResponce GetPageResponce = null;
        GetPagesListResponse getPageListRes = getPagesFromZion(pageName, row.get("pageType"));
        if (getPageListRes.getData().size() == 1) {
            GetPageResponce = getPageListRes.getData().get(0);
        }
        if (getPageListRes.getData().size() > 1) {
            for (int i = 0; i < getPageListRes.getData().size(); i++) {
                if (getPageListRes.getData().get(i).getTitle().equals(pageName)) {
                    GetPageResponce = getPageListRes.getData().get(i);
                    break;
                }
            }
        }
        assert GetPageResponce != null;

        String title = row.get("title").equals("") ? GetPageResponce.getTitle() : row.get("title");
        String key = row.get("key").equals("") ? GetPageResponce.getKey() : row.get("key");
        String pageType = row.get("pageType").equals("") ? GetPageResponce.getPageType() : row.get("pageType");
        String[] adapterKeys = row.get("adapterKeys").equals("") ? GetPageResponce.getAdapterKeys() : row.get("adapterKeys").split(", ");
        Boolean isEmptyAllowed = row.get("isEmptyAllowed").equals("") ? GetPageResponce.getIsEmptyAllowed() : Boolean.valueOf(row.get("isEmptyAllowed"));
        postNewPageReq.setTitle(title);
        postNewPageReq.setKey(key);
        //postNewPageReq.setIsEmptyAllowed(isEmptyAllowed);
        postNewPageReq.setPageType(pageType);
        postNewPageReq.setId(GetPageResponce.getId());
        postNewPageReq.setAdapterKeys(Arrays.asList(adapterKeys));

        List<SegmentPage> segmentPageList = new ArrayList<>();
        String[] childPage = row.get("Child Page").split(",");
        String[] segments = row.get("Segment").split(",");
        boolean status = !row.get("Child Page").equals("");

        for (int j = 0; j < (status ? childPage.length : GetPageResponce.getSegmentPages().size()); j++) {
            SegmentPage segmentPage = new SegmentPage();
            segmentPage.setSegmentId(status ? searchSegmentsFromZion(segments[j]) : GetPageResponce.getSegmentPages().get(j).getSegment().getId());
            GetPagesListResponse getSectionsListRes = getPagesFromZion(status ? childPage[j] : GetPageResponce.getSegmentPages().get(j).getPage().getTitle(), "CHILD");
            segmentPage.setPageId(getSectionsListRes.getData().get(0).getId());
            segmentPage.setIsFallback(status ? row.get("isFallback").split(",")[j].equals("true") : GetPageResponce.getSegmentPages().get(j).getIsFallback());
            segmentPage.setTagRank(false);
            segmentPageList.add(segmentPage);
        }
        postNewPageReq.setSegmentPages(segmentPageList);

        postNewChildPageResList.add(updatePage(postNewPageReq));
    }

    @Given("^User Edit \"([^\"]*)\" child page$")
    public void userEditChildPage(String pageName, DataTable dataTable) throws Throwable {
        Map<String, String> row = dataTable.asMaps(String.class, String.class).get(0);
        GetPageResponce GetPageResponce = null;
        GetPagesListResponse getPageListRes = getPagesFromZion(pageName, row.get("pageType"));
        if (getPageListRes.getData().size() == 1) {
            GetPageResponce = getPageListRes.getData().get(0);
        }
        if (getPageListRes.getData().size() > 1) {
            for (int i = 0; i < getPageListRes.getData().size(); i++) {
                if (getPageListRes.getData().get(i).getTitle().equals(pageName)) {
                    GetPageResponce = getPageListRes.getData().get(i);
                    break;
                }
            }
        }
        assert GetPageResponce != null;

        String title = row.get("title").equals("") ? GetPageResponce.getTitle() : row.get("title");
        String key = row.get("key").equals("") ? GetPageResponce.getKey() : row.get("key");
        String pageType = row.get("pageType").equals("") ? GetPageResponce.getPageType() : row.get("pageType");

        postNewPageReq.setTitle(title);
        postNewPageReq.setKey(key);

        postNewPageReq.setPageType(pageType);
        postNewPageReq.setId(GetPageResponce.getId());


        String[] sections = row.get("Sections").split(", ");
        String[] segments = row.get("Segment").split(", ");
        List<SegmentSection> segmentSectionList = new ArrayList<>();
        boolean status = !row.get("Sections").equals("");
        for (int j = 0; j < (status ? sections.length : GetPageResponce.getSegmentSections().size()); j++) {
            SegmentSection segmentSection = new SegmentSection();
            Map<String, String> param2 = new HashMap<>();
            param2.put("query", status ? sections[j] : GetPageResponce.getSegmentSections().get(j).getSection().getTitle());
            GetSectionsListRes getSectionsListRes = getLayoutSectionsFromZion(param2);
            segmentSection.setSectionId(getSectionsListRes.getData().get(j).getId());
            segmentSection.setWeight(j + 1);
            segmentSection.setTagRank(false);
            segmentSection.setSegmentId(searchSegmentsFromZion(status ? segments[j] : GetPageResponce.getSegmentSections().get(j).getSegment().getName()));
            segmentSectionList.add(segmentSection);
        }
        postNewPageReq.setSegmentSections(segmentSectionList);
        postNewChildPageResList.add(updatePage(postNewPageReq));
    }

    @Given("^User Edit \"([^\"]*)\" section$")
    public void userEditSection(String sectionName, List<PostNewSectionReq> postNewSection) throws Throwable {
        Map<String, String> param2 = new HashMap<>();
        param2.put("query", sectionName);
        param2.put("pageNo", "0");
        param2.put("pageSize", "400");
        GetSectionsListRes getSectionsListRes = getLayoutSectionsFromZion(param2);
        for (int i = 0; i < getSectionsListRes.getData().size(); i++) {
            if (getSectionsListRes.getData().get(i).getTitle().equals(sectionName)) {
                postNewSection.get(0).setId(getSectionsListRes.getData().get(i).getId());
                Long moduleLimit = postNewSection.get(0).getModuleLimit() != null ? postNewSection.get(0).getModuleLimit() : getSectionsListRes.getData().get(i).getModuleLimit();
                postNewSection.get(0).setModuleLimit(moduleLimit);
                List<SegmentModule> segmentModules = new ArrayList<>();
                for (int j = 0; j < getSectionsListRes.getData().get(i).getSegmentModules().size(); j++) {
                    SegmentModule segmentModule = new SegmentModule();
                    segmentModule.setWeight(j + 1);
                    segmentModule.setSegmentId(getSectionsListRes.getData().get(i).getSegmentModules().get(j).getSegmentId());
                    segmentModule.setModuleId(getSectionsListRes.getData().get(i).getSegmentModules().get(j).getModuleId());
                    segmentModules.add(segmentModule);
                }
                postNewSection.get(0).setSegmentModules(segmentModules);
                postNewSectionResList.add(putSection(postNewSection.get(0)));
                break;
            }
        }
    }

    @Given("^User edit \"([^\"]*)\" field$")
    public void userEditField(String arg0,List<PostNewFieldReq> postNewFieldReq) throws Throwable {
        GetAllFieldsResponse[] getAllFieldsRes = getLayoutFieldsFromZion(new HashMap<>());
        GetAllFieldsResponse getAllFieldRes = null;
        for (GetAllFieldsResponse getAllFieldsRe : getAllFieldsRes) {
            if (getAllFieldsRe.getTitle().equals(arg0)) {
                getAllFieldRes=getAllFieldsRe;
                break;
            }
        }

        this.postNewFieldReq = postNewFieldReq.get(0);
        this.postNewFieldReq.setTitle(Objects.equals(this.postNewFieldReq.getTitle(), "") ?getAllFieldRes.getTitle():this.postNewFieldReq.getTitle());
        this.postNewFieldReq.setKey(Objects.equals(this.postNewFieldReq.getKey(), "") ?getAllFieldRes.getKey():this.postNewFieldReq.getKey());
        this.postNewFieldReq.setType(Objects.equals(this.postNewFieldReq.getType(), "") ?getAllFieldRes.getType():this.postNewFieldReq.getType());
        this.postNewFieldReq.setCategory(Objects.equals(this.postNewFieldReq.getCategory(), "") ?getAllFieldRes.getCategory():this.postNewFieldReq.getCategory());
        this.postNewFieldReq.setSource(Objects.equals(this.postNewFieldReq.getSource(), "") ?getAllFieldRes.getSource():this.postNewFieldReq.getSource());
        this.postNewFieldReq.setAction(Objects.equals(this.postNewFieldReq.getAction(), "") ?getAllFieldRes.getAction():this.postNewFieldReq.getAction());
        this.postNewFieldReq.setTemplateKey(Objects.equals(this.postNewFieldReq.getTemplateKey(), "") ?getAllFieldRes.getTemplateKey():this.postNewFieldReq.getTemplateKey());

        Attributes attributes = new Attributes();
        attributes.setRequired(true);
        this.postNewFieldReq.setAttributes(attributes);
        Meta meta = new Meta();
        meta.setDefaultValue(Long.parseLong(""));
        this.postNewFieldReq.setMeta(this.postNewFieldReq.getMeta());
        assert getAllFieldRes != null;
        postNewFieldRes = editField(getAllFieldRes.getId(),postNewFieldReq.get(0));
    }

    @And("^User edit supported client$")
    public void userEditSupportedClient(List<SupportedClient> supportedClients) {
        if(supportedClients.get(0).getClient().equals("-")){
            supportedClients.remove(0);
//            supportedClients.add();
        }
        postNewTemplate.setSupportedClients(supportedClients);
    }

    @Given("^User Edit \"([^\"]*)\" template \"([^\"]*)\" template Type$")
    public void userEditTemplateTemplateType(String template, String templateType) throws Throwable {
        GetTemplatesRes GetTemplatesRes = getPageFromZion();
    }
}
