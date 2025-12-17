package steps.api;

import io.restassured.response.Response;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.request.common.SupportedClient;
import model.request.zion.layout.module.createModule.ACTION;
import model.request.zion.layout.module.createModule.Meta;
import model.request.zion.layout.module.createModule.CreateModuleReq;
import model.request.zion.layout.postModulesPositionInSection.PostModuleInSection;
import model.response.zion.layout.module.getModles.Datum;
import model.response.zion.layout.module.getModles.GetModules;
import model.response.zion.layout.module.createModule.CreateModuleRes;
import model.response.zion.layoutConfig.getPage.GetPageResponce;
import model.response.zion.layoutConfig.getPagesList.GetPagesListResponse;
import model.response.zion.layout.section.getSectionDetails.GetSectionDetailsResponse;
import model.request.zion.layout.module.createModule.DISPLAY;
import model.response.zion.layout.section.getSectionDetails.SegmentModule;
import org.junit.Assert;
import services.zionServices.ZionServices;
import utilities.CsvReader;

import java.text.SimpleDateFormat;
import java.util.*;

import static helpers.ApiHelper.gson;

public class MigrateData {

//    private GetPagesListResponse getPagesListResponse;
//    String sec, pag, cPage;
//    private Response response;
//    private GetPageResponce getPageResponce;
//    private GetSectionDetailsResponse getSectionDetailResponse;
//    private final List<PostModuleInSection> postModuleInSection = new ArrayList<>();
//    private final List<SegmentModule> module = new ArrayList<>();
//    private final List<CreateModuleRes> createModuleReqResList = new ArrayList<>();
//    private int stateRetryCreateModule = 0;
//    private String sectionId;
//    private int position;
//    List<Datum> getModulesNoonList = new ArrayList<>();
//    List<Datum> getModulesEveningList = new ArrayList<>();
//    String[][] IPVCsvData;
//
//    List<String[]> noonMatches = new ArrayList<>();
//    List<String[]> eveningMatches = new ArrayList<>();
//
//
//    //To get all Pages in Response
//    private GetPagesListResponse getPagesRes() {
//        Map<String, String> param = new HashMap<>();
//        param.put("pageSize", "50");
//        Response getDataResponse = ZionServices.getPagesFromZion(param);
//        Assert.assertEquals(200, getDataResponse.getStatusCode());
//        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
//        return gson().fromJson(getDataResponse.body().asString(), GetPagesListResponse.class);
//    }
//
//    private GetPageResponce getSinglePageRes(String pageId) {
//        Response getDataResponse = ZionServices.getPageFromZion(pageId, new HashMap<>());
//        Assert.assertEquals(200, getDataResponse.getStatusCode());
//        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
//        return gson().fromJson(getDataResponse.body().asString(), GetPageResponce.class);
//    }
//
//    //To get data of particular session in Response by sessionId
//    private GetSectionDetailsResponse getSectionRes(String sessionId) {
//        Response getDataResponse = ZionServices.getSectionFromZion(sessionId);
//        Assert.assertEquals(200, getDataResponse.getStatusCode());
//        // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
//        return gson().fromJson(getDataResponse.body().asString(), GetSectionDetailsResponse.class);
//    }
//
//    private void postPositionOfModule(String sectionId, List<PostModuleInSection> postModuleInSection) {
//        response = ZionServices.postNewModulePositionInSection(sectionId, postModuleInSection);
//        if (!(response.getStatusCode() == 200)) {
//            postPositionOfModule(sectionId, postModuleInSection);
//        }
//        Assert.assertEquals(200, response.getStatusCode());
//    }
//
//    private void createAndAddModule() throws InterruptedException {
//        for (int i = position; i < module.size(); i++) {
//            String templateKey = module.get(i).getModule().getTemplateKey();
//            if (!(templateKey.equals("MOVIE_NOLOGO") || templateKey.equals("TVSHOW_NOLOGO_169") || templateKey.equals("TVSHOW_BIG_43") || templateKey.equals("CONTENT_PARTNER_RAIL") || templateKey.equals("BANNER") || templateKey.equals("TVSHOW_LOGO_43"))) {
//                createPositionRequest(module.get(i).getModuleId(), module.get(i).getSegmentId(), (i + 1));
//                System.out.println("+++++++++++++++ " + module.get(i).getModule().getTitle() + " +++++++++++++ " + module.get(i).getModule().getId());
//                createModuleReqResList.add(null);
////                Assert.fail();
//            } else {
//                Thread.sleep(2000);
//                switch (templateKey) {
//                    case "MOVIE_NOLOGO":
//                    case "TVSHOW_NOLOGO_169":
//                        createPayLoadForXMaster(i, "PORTRAIT_HD|286:190", "PORTRAIT|194:130", "PORTRAIT|235:157");
//                        break;
//                    case "TVSHOW_BIG_43":
//                        createPayLoadForXMaster(i, "LANDSCAPE_169_HD|177:315", "LANDSCAPE_43|118:157", "LANDSCAPE_169|152:270");
//                        break;
//                    case "CONTENT_PARTNER_RAIL":
//                        createPayLoadForContent_Partner_Rail(i);
//                        break;
//                    case "BANNER":
//                        createPayLoadForInfinityBanner(i);
//                        break;
//                    default:
//                        createPayLoadForLiveTVChannels(i);
//                        break;
//                }
//                createPositionRequest(createModuleReqResList.get(i).getId(), module.get(i).getSegmentId(), (i + 1));
//            }
//        }
//    }
//
//    private void filterPageAndChildPage(String page, String childPage) {
//        for (int i = 0; i < getPagesListResponse.getData().size(); i++) {
//            if (getPagesListResponse.getData().get(i).getTitle().equals(page)) {
//                for (int j = 0; j < getPagesListResponse.getData().get(i).getSegmentPages().size(); j++) {
//                    if (getPagesListResponse.getData().get(i).getSegmentPages().get(j).getPage().getTitle().equals(childPage)) {
//                        getPageResponce = getSinglePageRes(getPagesListResponse.getData().get(i).getSegmentPages().get(j).getPage().getId());
//                        break;
//                    }
//                }
//            }
//        }
//    }
//
//    private void attachModuleToSection() {
//        for (int i = 0; i < getPageResponce.getSections().size(); i++) {
//            if (getPageResponce.getSections().get(i).getTitle().equals(sec)) {
//                sectionId = getPageResponce.getSections().get(i).getId();
//                postPositionOfModule(getPageResponce.getSections().get(i).getId(), postModuleInSection);
//                break;
//            }
//        }
//    }
//
//    private void filterSection(String section) {
//        for (int i = 0; i < getPageResponce.getSections().size(); i++) {
//            if (getPageResponce.getSections().get(i).getTitle().equals(section)) {
//                getSectionDetailResponse = getSectionRes(getPageResponce.getSections().get(i).getId());
//                break;
//            }
//        }
//    }
//
//    private void fetchModules() {
//        for (int i = 0; i < getSectionDetailResponse.getSegmentModules().size(); i++) {
//            if (getSectionDetailResponse.getSegmentModules().get(i).getModule().getActive()) {
//                System.out.println(getSectionDetailResponse.getSegmentModules().get(i).getModule().getTitle() + "=======" + getSectionDetailResponse.getSegmentModules().get(i).getModuleId());
//                module.add(getSectionDetailResponse.getSegmentModules().get(i));
//            }
//        }
//    }
//
//    //To create new Module
//    private void createModule(Object postXMasterModule) {
//        Response postModules = ZionServices.postModuleFromZion(postXMasterModule);
//        if (!(postModules.getStatusCode() == 200) && stateRetryCreateModule < 2) {
//            stateRetryCreateModule++;
//            createModule(postXMasterModule);
//        }
//        System.out.println(" ====== STATUS ======= " + postModules.getStatusCode());
//        if (postModules.getStatusCode() == 200) {
//            stateRetryCreateModule = 0;
//            Assert.assertEquals(200, postModules.getStatusCode());
//            // assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("file/jsonSchema/getAllAssortment.json"));
//            createModuleReqResList.add(gson().fromJson(postModules.body().asString(), CreateModuleRes.class));
//            System.out.println(" ============== " + createModuleReqResList.get(createModuleReqResList.size() - 1).getTitle() + " ============== " + createModuleReqResList.get(createModuleReqResList.size() - 1).getId());
//        }
//    }
//
//    private void createPositionRequest(String moduleId, String segmentId, int position) {
//        PostModuleInSection postModuleInSectionSingle = new PostModuleInSection();
//        postModuleInSectionSingle.setModuleId(moduleId);
//        postModuleInSectionSingle.setPosition(Long.parseLong("" + position));
//        postModuleInSectionSingle.setSegmentId(segmentId);
//        postModuleInSection.add(postModuleInSectionSingle);
//    }
//
//    private List<SupportedClient> supportedClientList(int i) {
//        List<SupportedClient> supportedClientsList = new ArrayList<>();
//        for (int j = 0; j < module.get(i).getModule().getSupportedClients().size(); j++) {
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("MOBILITY_ANDROID")) {
//                supportedClientsList.add(setClientSupport("MOBILITY_ANDROID", "12810", "99999"));
//            }
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("MOBILITY_IOS")) {
//                supportedClientsList.add(setClientSupport("MOBILITY_IOS", "178", "99999"));
//            }
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("FIRESTICK_ANDROID")) {
//                supportedClientsList.add(setClientSupport("FIRESTICK_ANDROID", "71", "99999"));
//            }
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("XSTREAM_WEB")) {
//                supportedClientsList.add(setClientSupport("XSTREAM_WEB", "1", "100"));
//            }
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("SDK_ANDROID")) {
//                supportedClientsList.add(setClientSupport("SDK_ANDROID", "1", "100000000"));
//            }
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("SDK_LINUX")) {
//                supportedClientsList.add(setClientSupport("SDK_LINUX", "1", "100000000"));
//            }
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("LARGESCREEN_WEBOS")) {
//                supportedClientsList.add(setClientSupport("LARGESCREEN_WEBOS", "1", "100000000"));
//            }
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("LARGESCREEN_TIZENOS")) {
//                supportedClientsList.add(setClientSupport("LARGESCREEN_TIZENOS", "1", "100000000"));
//            }
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("LARGESCREEN_TVOS")) {
//                supportedClientsList.add(setClientSupport("LARGESCREEN_TVOS", "1", "100000000"));
//            }
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("LARGESCREEN_ANDROID")) {
//                supportedClientsList.add(setClientSupport("LARGESCREEN_ANDROID", "88", "99999"));
//            }
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("LARGESCREEN_ROKUOS")) {
//                supportedClientsList.add(setClientSupport("LARGESCREEN_ROKUOS", "1", "100000000"));
//            }
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("LARGESCREEN_LGOS")) {
//                supportedClientsList.add(setClientSupport("LARGESCREEN_LGOS", "1", "100000000"));
//            }
//            if (module.get(i).getModule().getSupportedClients().get(j).getClient().equals("STICK_ANDROID")) {
//                supportedClientsList.add(setClientSupport("STICK_ANDROID", "1", "100000000"));
//            }
//        }
//        return supportedClientsList;
//    }
//
//    public void createPayLoadForXMaster(int i, String artworkLargeScreen, String artworkMobility, String artworkWeb) {
//        CreateModuleReq postModule = new CreateModuleReq();
//        postModule.setActive(true);
//        postModule.setRealm(module.get(i).getModule().getRealm());
//        postModule.setTitle(module.get(i).getModule().getTitle());
//        postModule.setActionType("LISTING");
//        postModule.setContent(module.get(i).getModule().getContent());
//        //postXMasterModule.setSupportedClients(module.get(i).getModule().getSupportedClients());
//        postModule.setTemplateKey("X_MASTER_RAIL");
//
//        Meta Meta = new Meta();
//        ACTION action = new ACTION();
//        action.setColor("#E8EAED");
//        action.setSource("BE");
//        action.setListingType("MASTER_RAIL");
//        action.setPackageId(module.get(i).getModule().getContent().getCollectionId());
//        action.setTitle("See all");
//        action.setActionType("package");
//        action.setActionValue(module.get(i).getModule().getContent().getCollectionId());
//        action.setTitle_L2(module.get(i).getModule().getMeta().getDISPLAY().getTitle());
//        Meta.setACTION(action);
//
//
//        DISPLAY display = new DISPLAY();
//        display.setShowAll(true);
//        display.setTitle(module.get(i).getModule().getMeta().getDISPLAY().getTitle());
//        display.setTotalCount(Long.parseLong("30"));
//        display.setLsTy(module.get(i).getModule().getMeta().getDISPLAY().getLsTy());
//
//        display.setTitleColor("#E8EAED");
//        display.setSubTitleColor("#A3A7AE");
//        display.setMinCnt(Long.parseLong("6"));
//        //display.setSubTitle("setSubTitle");
//        //display.setTitleImg("setTitleImg");
//
//        display.setTitleType("TITLE");
//        //display.setTitleLottie("");
//        display.setArtwork_Largescreen(artworkLargeScreen);
//        display.setArtwork_SDK("PORTRAIT_LARGE|400:200");
//        display.setArtwork_Mobility(artworkMobility);
//        display.setArtwork_Web(artworkWeb);
//
//        List<SupportedClient> supportedClientsList = supportedClientList(i);
//
//        Meta.setDISPLAY(display);
//        postModule.setMeta(Meta);
//        postModule.setSupportedClients(supportedClientsList);
//
//        createModule(postModule);
//    }
//
//    public void createPayLoadForContent_Partner_Rail(int i) {
//        CreateModuleReq postModule = new CreateModuleReq();
//        postModule.setActive(true);
//
//        postModule.setRealm(module.get(i).getModule().getRealm());
//        postModule.setTitle(module.get(i).getModule().getTitle());
//        postModule.setContent(module.get(i).getModule().getContent());
//        postModule.setTemplateKey("X_CONTENT_PARTNER_RAIL_V2");
//        postModule.setContentActionType("CTA_LANDING");
//        postModule.setActionType("LISTING");
//
//        List<SupportedClient> supportedClientsList = supportedClientList(i);
//        postModule.setSupportedClients(supportedClientsList);
//
//        Meta Meta = new Meta();
//        DISPLAY display = new DISPLAY();
//
//        display.setShowAll(true);
//        display.setContentPageSize(Long.parseLong("10"));
//        display.setCpId("IMDB");
//        display.setLsTy(module.get(i).getModule().getMeta().getDISPLAY().getLsTy());
//        display.setTitle(module.get(i).getModule().getMeta().getDISPLAY().getTitle());
//        Meta.setDISPLAY(display);
//
//        ACTION action = new ACTION();
//        action.setPackageId(module.get(i).getModule().getContent().getCollectionId());
//        action.setActionType("package");
//        action.setActionValue(module.get(i).getModule().getContent().getCollectionId());
//        action.setTitle_L2(module.get(i).getModule().getMeta().getDISPLAY().getTitle());
//        action.setTitle("See all");
//        action.setColor("#E8EAED");
//        action.setSource("BE");
//        action.setListingType("MASTER_RAIL");
//        Meta.setACTION(action);
//
//        postModule.setMeta(Meta);
//        createModule(postModule);
//    }
//
//    public void createPayLoadForInfinityBanner(int i) {
//        CreateModuleReq postModule = new CreateModuleReq();
//        postModule.setActive(true);
//        postModule.setRealm(module.get(i).getModule().getRealm());
//        postModule.setTitle(module.get(i).getModule().getTitle());
//        postModule.setContent(module.get(i).getModule().getContent());
//        postModule.setTemplateKey("X_INFINITY_BANNER");
//
//        DISPLAY display = new DISPLAY();
//        Meta Meta = new Meta();
//        display.setShowAll(true);
//        display.setTotalCount(Long.parseLong("11"));
//        display.setLsTy(module.get(i).getModule().getMeta().getDISPLAY().getLsTy());
//        display.setMinCnt(Long.parseLong("1"));
//        Meta.setDISPLAY(display);
//        postModule.setMeta(Meta);
//
//        List<SupportedClient> supportedClientsList = supportedClientList(i);
//        postModule.setSupportedClients(supportedClientsList);
//
//        createModule(postModule);
//    }
//
//    public void createPayLoadForLiveTVChannels(int i) {
//        CreateModuleReq postModule = new CreateModuleReq();
//        postModule.setActive(true);
//        postModule.setRealm(module.get(i).getModule().getRealm());
//        postModule.setTitle(module.get(i).getModule().getTitle());
//        module.get(i).getModule().getContent().setSource("XSTREAM_MIDDLEWARE");
//        postModule.setContent(module.get(i).getModule().getContent());
//
//        postModule.setTemplateKey("X_LIVE_TVCHANNELS");
//        postModule.setActionType("LISTING");
//        // postModule.setContentActionType("LISTING");
//        List<SupportedClient> supportedClientsList = supportedClientList(i);
//        postModule.setSupportedClients(supportedClientsList);
//
//        Meta Meta = new Meta();
//
//        DISPLAY display = new DISPLAY();
//        display.setShowAll(true);
//        display.setContentSubType("LIVE");
//        display.setContentPageSize(Long.parseLong("20"));
//        display.setTotalCount((Long.parseLong("10")));
//        display.setLsTy(module.get(i).getModule().getMeta().getDISPLAY().getLsTy());
//        display.setTitle(module.get(i).getModule().getMeta().getDISPLAY().getTitle());
//        display.setArtwork_Largescreen("LANDSCAPE_169_HD|177:315");
//        display.setArtwork_SDK("PORTRAIT_LARGE|400:200");
//        display.setArtwork_Mobility("LANDSCAPE_43|118:157");
//        display.setArtwork_Web("LANDSCAPE_169|152:270");
//        Meta.setDISPLAY(display);
//
//        ACTION action = new ACTION();
//        action.setPackageId(module.get(i).getModule().getContent().getCollectionId());
//        action.setActionType("package");
//        action.setActionValue(module.get(i).getModule().getContent().getCollectionId());
//        action.setTitle_L2(module.get(i).getModule().getMeta().getDISPLAY().getTitle());
//        action.setTitle("See all");
//        action.setColor("#E8EAED");
//        action.setSource("BE");
//        action.setListingType("LIVE_TVCHANNELS");
//        Meta.setACTION(action);
//        postModule.setMeta(Meta);
//
//        createModule(postModule);
//    }
//
//    private SupportedClient setClientSupport(String client, String minBuildNo, String maxBuildNo) {
//        SupportedClient supportedClient = new SupportedClient();
//        supportedClient.setClient(client);
//        supportedClient.setMinBuildNo(Long.parseLong(minBuildNo));
//        supportedClient.setMaxBuildNo(Long.parseLong(maxBuildNo));
//        return supportedClient;
//    }
//
//    @Given("^Start Position (\\d+)$")
//    public void startPosition(int arg0) {
//        position = arg0 - 1;
//        for (int i = 0; i < position; i++) {
//            createModuleReqResList.add(null);
//        }
//    }
//
//    @Given("^User fetch sections from \"([^\"]*)\" page - \"([^\"]*)\" child Page and \"([^\"]*)\" section$")
//    public void userFetchSectionsFromPageChildPageAndSection(String page, String childPage, String section) throws Throwable {
//        System.out.println("<===== User fetch sections from " + page + " ===> " + childPage + " ======>");
//        getPagesListResponse = getPagesRes();
//        filterPageAndChildPage(page, childPage);
//        System.out.println("===== User fetch section details for " + section + "section=======");
//        filterSection(section);
//        System.out.println("================== User fetch modules and their segment ======================");
//        fetchModules();
//    }
//
//    @And("^create modules for section and attach to \"([^\"]*)\" page - \"([^\"]*)\" child Page and \"([^\"]*)\" section$")
//    public void createModulesForSectionAndAttachToPageChildPageAndSection(String page, String childPage, String section) throws Throwable {
//        sec = section;
//        pag = page;
//        cPage = childPage;
//
//        System.out.println("<====== create modules for section ======>");
//        createAndAddModule();
//        System.out.println(gson().toJson(postModuleInSection));
//        System.out.println("<===== User fetch sections from " + page + " ===> " + childPage + " ======>");
//        getPagesListResponse = getPagesRes();
//        filterPageAndChildPage(page, childPage);
//        System.out.println("==========attach it to the " + section + " section=============");
//        attachModuleToSection();
//    }
//
//    @Then("^validate data should be migrated$")
//    public void validateDataShouldBeMigrated() {
//        getSectionDetailResponse = getSectionRes(sectionId);
//        for (int i = 0; i < module.size(); i++) {
//            if (getSectionDetailResponse.getSegmentModules().get(i).getModule().getTitle().equals(module.get(i).getModule().getTitle())) {
//                System.out.println(module.get(i).getModule().getTitle() + " ****** is Migrated on position ********>" + (i + 1));
//            } else {
//                System.out.println(module.get(i).getModule().getTitle() + "<==== NOT MIGRATED ON POSITION ====>" + (i + 1));
//            }
//        }
//    }
//
////    @After
////    public void afterScenario() throws InterruptedException {
////        System.out.println(gson().toJson(postModuleInSection));
////        if (response == null && (postModuleInSection.size() > 0)) {
////            Thread.sleep(60000);
////            System.out.println("<===== User fetch sections from " + pag + " ===> " + cPage + " ======>");
////            getPagesListResponse = getPagesRes();
////            filterPageAndChildPage(pag, cPage);
////            System.out.println("========== attach it to the " + sec + " section=============");
////            attachModuleToSection();
////        }
////    }
//
//    @And("^User read csv for getting IPL match date and time$")
//    public void userReadCsvForGettingIPLMatchDateAndTime() {
//        IPVCsvData = CsvReader.readCsvFile("IPL2.csv");
//    }
//
//    @And("^User get module to update$")
//    public void userGetModuleToUpdate() {
//        String[] modules = {
//                "iOSNoonLottie", "iOSNoonImage", "AndroidNoonLottie", "AndroidNoonImage",
//                "iOSEveningLottie", "iOSEveningImage", "AndroidEveningLottie", "AndroidEveningImage"
//        };
//
//        for (String s : modules) {
//            Map<String, String> param = new HashMap<>();
//            param.put("pageSize", "500");
//            param.put("query", s);
//            Response response = ZionServices.getModuleFromZion(param);
//            Assert.assertEquals(200, response.getStatusCode());
//            GetModules getModules = gson().fromJson(response.body().asString(), GetModules.class);
//
//            for (int j = 0; j < getModules.getData().size(); j++) {
//                if (getModules.getData().get(j).getTitle().equals(s)) {
//                    if (s.contains("Noon")) {
//                        getModulesNoonList.add(getModules.getData().get(j));
//                    }
//                    if (s.contains("Evening")) {
//                        getModulesEveningList.add(getModules.getData().get(j));
//                    }
//                    break;
//                }
//            }
//        }
//    }
//
//    @Then("^User update modules acc to IPL Sheet$")
//    public void userUpdateModulesAccToIPLSheet() {
//        String currentDate = (new SimpleDateFormat("dd MMMM yyyy")).format(new Date());
//
//        for (String[] ipvCsvDatum : IPVCsvData) {
//            if (ipvCsvDatum.length != 0 && ipvCsvDatum[0].equals(currentDate)) {
//                if (ipvCsvDatum[1].contains("3:30")) {
//                    noonMatches.add(ipvCsvDatum);
//                }
//                if (ipvCsvDatum[1].contains("7:30")) {
//                    eveningMatches.add(ipvCsvDatum);
//                }
//            }
//        }
//        for (String[] eveningMatch : eveningMatches) {
//            updateIPLEveningModules(eveningMatch, true);
//        }
//        for (String[] noonMatch : noonMatches) {
//            updateIPLNoonModules(noonMatch, true);
//        }
//        if (noonMatches.size() == 0) {
//            updateIPLNoonModules(new String[0], false);
//        }
//        if (eveningMatches.size() == 0) {
//            updateIPLEveningModules(new String[0], false);
//        }
//    }
//
//    public void updateIPLEveningModules(String[] eveningMatchData, Boolean isActive) {
//        for (Datum datum : getModulesEveningList) {
//            if (eveningMatchData.length > 0) {
//                if (datum.getTitle().contains("Image")) {
//                    datum.getMeta().getACTION().setBgImgUrl(eveningMatchData[2]);
//                }
//                if (datum.getTitle().contains("Lottie")) {
//                    datum.getMeta().getACTION().setBgImgUrl(eveningMatchData[5]);
//                }
//            }
//            datum.setCollection(null);
//            datum.setSegments(null);
//            datum.setSegmentIds(null);
//            datum.setCreatedBy(null);
//            datum.setCreatedOn(null);
//            datum.setLastUpdatedBy(null);
//            datum.setLastUpdatedOn(null);
//            datum.setActive(isActive);
//            Response response = ZionServices.putModuleFromZion(datum);
//            Assert.assertEquals(200, response.getStatusCode());
//        }
//    }
//
//    public void updateIPLNoonModules(String[] noonMatch, Boolean isActive) {
//        for (Datum datum : getModulesNoonList) {
//            if (noonMatch.length > 0) {
//                if (datum.getTitle().contains("Image")) {
//                    datum.getMeta().getACTION().setBgImgUrl(noonMatch[2]);
//                }
//                if (datum.getTitle().contains("Lottie")) {
//                    datum.getMeta().getACTION().setBgImgUrl(noonMatch[5]);
//                }
//            }
//            datum.setCollection(null);
//            datum.setSegments(null);
//            datum.setSegmentIds(null);
//            datum.setCreatedBy(null);
//            datum.setCreatedOn(null);
//            datum.setLastUpdatedBy(null);
//            datum.setLastUpdatedOn(null);
//            datum.setActive(isActive);
//            Response response = ZionServices.putModuleFromZion(datum);
//            Assert.assertEquals(200, response.getStatusCode());
//        }
//    }
}
