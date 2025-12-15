package steps.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.ConfigLoader;
import helpers.ApiHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import model.Common.UserInfo;
import model.Common.arsenalCollection.ArsenalCollection;
import model.response.zion.zionLoginService.ZionLoginServiceRes;
import org.junit.Assert;
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

    private static String jsonPath = "src/test/resources/data/json/collection.json";

    public static ArsenalCollection createDownStreamApiRequest(String useCase, Map<String, String[]> params, String downStreamApiUrl) throws IOException {
        ArsenalCollection req = gson().fromJson(Utils.jsonToBody(jsonPath), ArsenalCollection.class);
        req.getDynamicMeta().getMixParam().setUseCase(useCase);
        req.getDynamicMeta().setUrl(downStreamApiUrl);
        req.setContents(new ArrayList<>());
        req.getDynamicMeta().getMixParam().setParams(params);
        return req;
    }

    public static Map<String, Map<String, Map<String, Integer>>> filteredSlotPersona(Map<String, Map<String,Map<String,Integer>>> slotPersona, long noOfDays) {
        return slotPersona.entrySet().stream()
                .filter(e -> Utils.calculateDateDifference(e.getKey()) <= noOfDays)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Integer> contentVisiblityCountMap(Map<String, Map<String, Map<String, Integer>>> temp, List<String> contentIdList) {
        Map<String, Integer> count = new HashMap<>();

        for (String content : contentIdList) {
            int tempSize = 0;
            for (String key : temp.keySet()) {
                if (temp.get(key).containsKey(content))
                    tempSize = tempSize + temp.get(key).get(content).size();

                count.put(content, tempSize);
            }
        }
        return count;
    }

    public static Map<String, List<String>> contentVisiblityDateMap(Map<String, Map<String, Map<String, Integer>>> temp, List<String> contentIdList) {
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

    public static Map<String, List<String>> contentVisiblitySessionMap(Map<String, Map<String, Map<String, Integer>>> temp, List<String> contentIdList) {
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

    public static Map<String,Map<String,List<String>>> slotPersonaFlatten(Map<String, Map<String, Map<String, Integer>>> temp) {
        Map<String,Map<String,List<String>>> result = new HashMap<>();
        Set<String> contentId = new HashSet<>();
        for (String key : temp.keySet()) {
            contentId.addAll(temp.get(key).keySet());
        }
        List<String> contentIdList = new ArrayList<>(contentId);

        Map<String, Integer> count = contentVisiblityCountMap(temp,contentIdList);
        Map<String, List<String>> dates = contentVisiblityDateMap(temp,contentIdList);
        Map<String, List<String>> session = contentVisiblitySessionMap(temp,contentIdList);

        for (String s : contentIdList) {
            Map<String,List<String>> resultTemp = new HashMap<>();
            List<String> tempCountList = new ArrayList<>();
            tempCountList.add(session.get(s).size()+"");
            resultTemp.put("Count",tempCountList);
            resultTemp.put("session",session.get(s));
            resultTemp.put("dates",dates.get(s));
            result.put(s,resultTemp);
        }
        return result;
    }

    public ZionLoginServiceRes loginService(String email, String pass) {
        Response response = ZionServices.loginService(email, pass);
        Assert.assertEquals(200, response.getStatusCode());
        return gson().fromJson(response.body().asString(), ZionLoginServiceRes.class);
    }

    @Given("^We are using \"([^\"]*)\" as a Xstream user$")
    public void weAreUsingAsAXstreamUser(String arg0) throws Throwable {

        //Fetch Persona
        Response response = DiscoveryServices.getUserPersona(arg0, true, true, true);
        Assert.assertEquals(200, response.getStatusCode());
        UserInfo.userPersona = mapper.readTree(response.getBody().asString());

        // User Live Attribute
        ZionLoginServiceRes zionLoginServiceRes = loginService("shubhamgupta212755@gmail.com", "U2FsdGVkX19NQaev3NfCf/RPc7QSo16B39TywmXFdzk=");
        ApiHelper.setAuth(zionLoginServiceRes.getRtkn());
        Response response4 = ZionServices.getUserLogs(arg0);
        Assert.assertEquals(200, response4.getStatusCode());
        userLogs = mapper.readTree(response4.getBody().asString());
        UserInfo.liveAttribute = Utils.getParams(userLogs.get("hits").get("hits").get(0).get("_source").get("origamiRequest").asText());

        //Fetch Experiment
        Response response3 = DiscoveryServices.getExperimentForUser(arg0);
        Assert.assertEquals(200, response3.getStatusCode());
        UserInfo.experiment = mapper.readTree(response3.getBody().asString());

        //Fetch Watch history
        Response response2 = DiscoveryServices.getWatchHistory(arg0);
        Assert.assertEquals(200, response2.getStatusCode());
        UserInfo.watchHistory = mapper.readTree(response2.getBody().asString());

        //User Encounter
        UserInfo.userEncounter = ArsenalService.getArsenalCollectionController("axaut_goxe32721718098299613", UserInfo.liveAttribute);

//        SlotPersona
        ObjectMapper mapper = new ObjectMapper();
        JsonNode slotPersona = UserInfo.userPersona.get("realtime-persona").get("slotPersonaPayload");
        UserInfo.slotPersona = mapper.convertValue(slotPersona, new TypeReference<>() {});
        Map<String, Map<String, Map<String, Integer>>> temp = filteredSlotPersona(UserInfo.slotPersona,20);
        UserInfo.slotPersonaFlatten = slotPersonaFlatten(temp);

        //TOD

    }

    @And("^Change user selected languages to \"([^\"]*)\"$")
    public void changePLanguagesTo(String arg1) throws Throwable {
        UserInfo.liveAttribute.put("languages",arg1);
    }

    @Given("login with curator user")
    public void login_with_curator_user() throws Throwable {
        if (Objects.equals(ConfigLoader.environment, "prod")) {
            ZionLoginServiceRes zionLoginServiceRes = loginService("shubhamgupta212755@gmail.com", "U2FsdGVkX19NQaev3NfCf/RPc7QSo16B39TywmXFdzk=");
            ApiHelper.setAuth(zionLoginServiceRes.getRtkn());
        }
    }

    @And("Add contentId {string} in params for recommendation")
    public void addContentIdInParamsForRecommendation(String contentId) {
        UserInfo.liveAttribute.put("contentId",contentId);
    }
}
