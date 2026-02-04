package steps.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.ConfigLoader;
import helpers.ApiHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import model.Common.UserInfo;
import model.Common.arsenalCollection.ArsenalCollection;
import model.response.userPersona.UserPersonaDTO;
import model.response.zion.zionLoginService.ZionLoginServiceRes;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import services.BaseServiceClient;
import services.discovery.ArsenalService;
import services.discovery.DiscoveryServices;
import services.zionServices.ZionServices;
import utilities.Utils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static helpers.ApiHelper.gson;

public class CommonSteps {

    ObjectMapper mapper = new ObjectMapper();
    JsonNode userLogs;

    @Steps
    DiscoveryServices discoveryServices;

    @Steps
    ArsenalService arsenalService;

    @Steps
    ZionServices zionServices;

    static ArsenalCollection createDownStreamApiRequest(String useCase, Map<String, String[]> params, String downStreamApiUrl) throws IOException {
        String jsonPath = "src/test/resources/data/json/collection.json";
        ArsenalCollection req = gson().fromJson(Utils.jsonToBody(jsonPath), ArsenalCollection.class);
        req.getDynamicMeta().getMixParam().setUseCase(useCase);
        req.getDynamicMeta().setUrl(downStreamApiUrl);
        req.setContents(new ArrayList<>());
        req.getDynamicMeta().getMixParam().setParams(params);
        return req;
    }

    private Map<String, Map<String, Map<String, Integer>>> filteredSlotPersona(Map<String, Map<String, Map<String, Integer>>> slotPersona, long noOfDays) {
        return slotPersona.entrySet().stream()
                .filter(e -> Utils.calculateDateDifference(e.getKey()) <= noOfDays)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<String, List<String>> contentVisiblityDateMap(Map<String, Map<String, Map<String, Integer>>> temp, List<String> contentIdList) {
        Map<String, List<String>> dates = new HashMap<>();

        for (String content : contentIdList) {
            List<String> dateList = new ArrayList<>();
            for (String date : temp.keySet()) {
                if (temp.get(date).containsKey(content)) dateList.add(date);
            }
            dates.put(content, dateList);
        }
        return dates;
    }

    private Map<String, List<String>> contentVisiblitySessionMap(Map<String, Map<String, Map<String, Integer>>> temp, List<String> contentIdList) {
        Map<String, List<String>> session = new HashMap<>();

        for (String content : contentIdList) {
            List<String> sessionList = new ArrayList<>();
            for (String key : temp.keySet()) {
                Map<String, Map<String, Integer>> dateMap = temp.get(key);
                if (dateMap.containsKey(content)) {
                    List<String> tempList = new ArrayList<>(dateMap.get(content).keySet());
                    sessionList.addAll(tempList);
                }
            }
            session.put(content, sessionList);
        }
        return session;
    }

    private Map<String, Map<String, List<String>>> slotPersonaFlatten(Map<String, Map<String, Map<String, Integer>>> temp) {
        Map<String, Map<String, List<String>>> result = new HashMap<>();
        Set<String> contentId = new HashSet<>();
        for (String key : temp.keySet()) {
            contentId.addAll(temp.get(key).keySet());
        }
        List<String> contentIdList = new ArrayList<>(contentId);

//        Map<String, Integer> count = contentVisiblityCountMap(temp, contentIdList);
        Map<String, List<String>> dates = contentVisiblityDateMap(temp, contentIdList);
        Map<String, List<String>> session = contentVisiblitySessionMap(temp, contentIdList);

        for (String s : contentIdList) {
            Map<String, List<String>> resultTemp = new HashMap<>();
            List<String> tempCountList = new ArrayList<>();
            tempCountList.add(session.get(s).size() + "");
            resultTemp.put("Count", tempCountList);
            resultTemp.put("session", session.get(s));
            resultTemp.put("dates", dates.get(s));
            result.put(s, resultTemp);
        }
        return result;
    }

//    public ZionLoginServiceRes loginService() {
//        Response response = ZionServices.loginService(BaseServiceClient.zionUser, BaseServiceClient.zionUserPassword);
//        Assert.assertEquals(200, response.getStatusCode());
//        return gson().fromJson(response.body().asString(), ZionLoginServiceRes.class);
//    }

    private UserPersonaDTO getUserPersona(String uid, Boolean fetch_click_rt_persona, Boolean fetchXstreamOnboarding, Boolean fetchSlotRtPersona) {
        Response response = discoveryServices.getUserPersona(uid, fetch_click_rt_persona, fetchXstreamOnboarding, fetchSlotRtPersona);
        Assert.assertEquals(200, response.getStatusCode());
        return gson().fromJson(response.body().asString(), UserPersonaDTO.class);
    }

    private Map<String, String> getUserLiveAttributes(String arg0) throws Exception {
        Response response4 = zionServices.getUserLogs(arg0);
        Assert.assertEquals(200, response4.getStatusCode());
        userLogs = mapper.readTree(response4.getBody().asString());

        return (!userLogs.get("hits").get("hits").isEmpty())
                ? Utils.getParams(userLogs.get("hits").get("hits").get(0).get("_source").get("origamiRequest").asText())
                : new HashMap<>();
    }

    private JsonNode getUserExperiment(String arg0) throws JsonProcessingException {
        Response response3 = discoveryServices.getExperimentForUser(arg0);
        Assert.assertEquals(200, response3.getStatusCode());
        return mapper.readTree(response3.getBody().asString());
    }

    private JsonNode getUserWatchHistory(String arg0) throws JsonProcessingException {
        Response response2 = discoveryServices.getWatchHistory(arg0);
        Assert.assertEquals(200, response2.getStatusCode());
        return mapper.readTree(response2.getBody().asString());
    }

    private Map<String, Map<String, List<String>>> getUserSlotPersona() {
        UserInfo.slotPersona = UserInfo.userPersona.getRealtimePersona().getSlotPersona();
        Map<String, Map<String, Map<String, Integer>>> temp = filteredSlotPersona(UserInfo.slotPersona, 20);
        return slotPersonaFlatten(temp);
    }

    @Given("^We are using \"([^\"]*)\" as a Xstream user$")
    public void weAreUsingAsAXstreamUser(String arg0) throws Throwable {

        // Fetch Persona
        UserInfo.userPersona = getUserPersona(arg0, true, true, true);

        // User Live Attribute
        UserInfo.liveAttribute = getUserLiveAttributes(arg0);

        // Fetch Experiment
//        UserInfo.experiment = getUserExperiment(arg0);

        // Fetch Watch history
//        UserInfo.watchHistory = getUserWatchHistory(arg0);

        // User Encounter
        UserInfo.userEncounter = arsenalService.getArsenalCollectionController("axaut_goxe32721718098299613", UserInfo.liveAttribute);

        // SlotPersona
        UserInfo.slotPersonaFlatten = getUserSlotPersona();

        // TOD
    }

    @Given("^We are using \"([^\"]*)\" as a Xstream user and fetch")
    public void weAreUsingAsAXstreamUserAndFetch(String arg0, DataTable dataTable) throws Throwable {
        Map<String, Boolean> data = dataTable.asMaps(String.class, Boolean.class).getFirst();
        // Fetch Persona
        UserInfo.userPersona = getUserPersona(arg0, true, true, true);

        // User Live Attribute
        UserInfo.liveAttribute = getUserLiveAttributes(arg0);


        // Fetch Experiment
        if (data.containsKey("Experiment") && data.get("Experiment")) {
            UserInfo.experiment = getUserExperiment(arg0);
        }

        // Fetch Watch history
        if (data.containsKey("WatchHistory") && data.get("WatchHistory")) {
            UserInfo.watchHistory = getUserWatchHistory(arg0);
        }

        // User Encounter
        if (data.containsKey("VisualSkip") && data.get("VisualSkip")) {
            UserInfo.userEncounter = arsenalService.getArsenalCollectionController("axaut_goxe32721718098299613", UserInfo.liveAttribute);
        }
        // SlotPersona
        if (data.containsKey("SlotPersona") && data.get("SlotPersona")) {
            UserInfo.slotPersonaFlatten = getUserSlotPersona();
        }
        // TOD
    }

    @And("^Change user selected languages to \"([^\"]*)\"$")
    public void changePLanguagesTo(String arg1) throws Throwable {
        UserInfo.liveAttribute.put("languages", arg1);
    }

//    @Given("login with curator user")
//    public void login_with_curator_user() throws Throwable {
//        if (Objects.equals(ConfigLoader.environment, "prod")) {
//            ZionLoginServiceRes zionLoginServiceRes = loginService();
//            ApiHelper.setAuth(zionLoginServiceRes.getRtkn());
//        }
//    }

    @And("Add contentId {string} in params for recommendation")
    public void addContentIdInParamsForRecommendation(String contentId) {
        UserInfo.liveAttribute.put("contentId", contentId);
    }

    @And("change user Live Attributes to")
    public void changeUserLiveAttributesTo(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).getFirst();
        for (String key : data.keySet()) {
            UserInfo.liveAttribute.put(key, data.get(key));
        }
    }
}
