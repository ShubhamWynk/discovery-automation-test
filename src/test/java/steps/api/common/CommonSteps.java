package steps.api.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import model.Common.UserInfo;
import org.junit.Assert;
import services.discovery.ArsenalService;
import services.discovery.DiscoveryServices;
import services.zionServices.ZionServices;

public class CommonSteps {

    ObjectMapper mapper = new ObjectMapper();
    JsonNode userLogs;

    @Given("^We are using \"([^\"]*)\" as a Xstream user$")
    public void weAreUsingAsAXstreamUser(String arg0) throws Throwable {
        //Fetch Persona
        Response response = DiscoveryServices.getUserPersona(arg0);
        Assert.assertEquals(200, response.getStatusCode());
        UserInfo.userPersona=(mapper.readTree(response.getBody().asString()));

        // User Live Attribute
        Response response4 = ZionServices.getUserLogs(arg0);
        Assert.assertEquals(200, response4.getStatusCode());
        userLogs = mapper.readTree(response4.getBody().asString());
        UserInfo.liveAttribute = ZionServices.getParams(userLogs.get("hits").get("hits").get(0).get("_source").get("origamiRequest").asText());

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
    }

}
