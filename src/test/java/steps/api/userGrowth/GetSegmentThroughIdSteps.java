package steps.api.userGrowth;

import io.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import services.userGrowth.UserGrowthService;

import java.util.Map;

public class GetSegmentThroughIdSteps {
    String realm, id;

    @Given("^get segment details for \"([^\"]*)\"$")
    public void getSegmentDetailsFor(String arg0, DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        realm = arg0;
        id = data.get("id");
        Response response = UserGrowthService.getSegmentThroughId(id);
        response.prettyPrint();
    }
}
