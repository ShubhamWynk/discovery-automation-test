package steps.api.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.ConfigLoader;
import helpers.ApiHelper;
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
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import static helpers.ApiHelper.gson;

public class CommonSteps {

    ObjectMapper mapper = new ObjectMapper();
    JsonNode userLogs;

    private static String jsonPath = "src/test/resources/data/json/collection.json";

    public static ArsenalCollection createDownStreamApiRequest(String useCase, Map<String, String[]> params,String downStreamApiUrl) throws IOException {
        ArsenalCollection req = gson().fromJson(Utils.jsonToBody(jsonPath), ArsenalCollection.class);
        req.getDynamicMeta().getMixParam().setUseCase(useCase);
        req.getDynamicMeta().setUrl(downStreamApiUrl);
        req.setContents(new ArrayList<>());
        req.getDynamicMeta().getMixParam().setParams(params);
        return req;
    }

    public ZionLoginServiceRes loginService(String email,String pass){
        Response response = ZionServices.loginService(email,pass);
        Assert.assertEquals(200, response.getStatusCode());
        return gson().fromJson(response.body().asString(), ZionLoginServiceRes.class);
    }

    @Given("^We are using \"([^\"]*)\" as a Xstream user$")
    public void weAreUsingAsAXstreamUser(String arg0) throws Throwable {
        //Fetch Persona
        Response response = DiscoveryServices.getUserPersona(arg0,true,true,true,true);
        Assert.assertEquals(200, response.getStatusCode());
        UserInfo.userPersona=(mapper.readTree(response.getBody().asString()));

        // User Live Attribute
        ZionLoginServiceRes zionLoginServiceRes = loginService("shubhamgupta212755@gmail.com","U2FsdGVkX19NQaev3NfCf/RPc7QSo16B39TywmXFdzk=");
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
        UserInfo.userEncounter = ArsenalService.getArsenalCollectionController("axaut_goxe32721718098299613",UserInfo.liveAttribute);

        //TOD

    }

    @Given("login with curator user")
    public void login_with_curator_user() throws Throwable {
        if(Objects.equals(ConfigLoader.environment, "prod")){
            ZionLoginServiceRes zionLoginServiceRes = loginService("shubhamgupta212755@gmail.com","U2FsdGVkX19NQaev3NfCf/RPc7QSo16B39TywmXFdzk=");
            ApiHelper.setAuth(zionLoginServiceRes.getRtkn());
        }
    }
}
