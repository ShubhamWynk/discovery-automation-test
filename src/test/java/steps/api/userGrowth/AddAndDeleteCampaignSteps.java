package steps.api.userGrowth;

import io.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.response.userGrowth.AddCampaignRequestPayload;
import services.userGrowth.UserGrowthService;

import java.util.Map;

public class AddAndDeleteCampaignSteps {
    String realm,id;
    AddCampaignRequestPayload addCampaignRequestPayload = new AddCampaignRequestPayload();
    AddCampaignRequestPayload.Action action = new AddCampaignRequestPayload.Action();
    AddCampaignRequestPayload.Variant variant = new AddCampaignRequestPayload.Variant();
    AddCampaignRequestPayload.TemplateInfoMap templateInfoMap = new AddCampaignRequestPayload.TemplateInfoMap();


    @Given("^add campaign details for realm \"([^\"]*)\"$")
    public void addCampaignDetailsForRealm(String arg0,DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        realm = arg0;
        addCampaignRequestPayload.setId(data.get("id"));
        addCampaignRequestPayload.setDescription(data.get("description"));
        addCampaignRequestPayload.setTitle(data.get("title"));
        Response response = UserGrowthService.addCampaign(addCampaignRequestPayload);
        response.prettyPrint();

    }

    @Then("^delete campaign$")
    public void deleteCampaign(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        id = data.get("id");
        Response response = UserGrowthService.deleteCampaign(id);
        response.prettyPrint();
    }

}
