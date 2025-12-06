package steps.api.userGrowth;

import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import services.userGrowth.UserGrowthService;

public class GetAllTemplatesSteps {

    @Given("^get all template details for \"([^\"]*)\"$")
    public void getAllTemplateDetailsFor(String arg0) throws Throwable {
        Response response = UserGrowthService.getALlTemplates(10);
        response.prettyPrint();
        Assert.assertEquals(200,response.getStatusCode());
    }
}
