package steps.api.userGrowth;

import io.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.response.userGrowth.UpdateCampaign.UpdateCampaignRequestPayload;
import org.junit.Assert;
import services.userGrowth.UserGrowthService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class GetCampaignThroughIDSteps {
    String realm, id;
    UpdateCampaignRequestPayload updateCampaignRequestPayload = new UpdateCampaignRequestPayload();
    UpdateCampaignRequestPayload.ExclusionCriteria exclusionCriteria = new UpdateCampaignRequestPayload.ExclusionCriteria();
    UpdateCampaignRequestPayload.Action action = new UpdateCampaignRequestPayload.Action();
    UpdateCampaignRequestPayload.Variant variant = new UpdateCampaignRequestPayload.Variant();
    UpdateCampaignRequestPayload.TemplateInfoMap templateInfoMap = new UpdateCampaignRequestPayload.TemplateInfoMap();

    @Given("^get campaign details for \"([^\"]*)\"$")
    public void getCampaignDetailsFor(String arg0, DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        realm = arg0;
        id = data.get("id");
        Response response = UserGrowthService.getCampaignThroughId(realm, id);
        response.prettyPrint();
    }



   /* @And("^user set data which needs to be updated$")
    public void userSetDataWhichNeedsToBeUpdated(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        if (data.containsKey("description")) updateCampaignRequestPayload.setDescription(data.get("description"));
    }*/

    @Then("^update campaign for \"([^\"]*)\"$")
    public void updateCampaignFor(String arg0,DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMaps(String.class,String.class).get(0);
        realm = arg0;
        updateCampaignRequestPayload.setId(id);
        updateCampaignRequestPayload.setTags(new ArrayList<>(Arrays.asList(realm)));
        Response response = UserGrowthService.updateCampaign(updateCampaignRequestPayload, id);
        response.prettyPrint();
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertTrue(response.body().asString().contains(updateCampaignRequestPayload.getDescription()));
        Assert.assertEquals(updateCampaignRequestPayload.getDescription(),data.get("description"));
    }

    @Given("^get campaign split percentage for \"([^\"]*)\"$")
    public void getCampaignSplitPercentageFor(String arg0,DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        realm = arg0;
        id = data.get("id");
        Response response = UserGrowthService.getCampaignSplitPercentageThroughId(realm, id);
        response.prettyPrint();
    }

    @Given("^get all campaigns details$")
    public void getAllCampaignsDetails() {
    Response response = UserGrowthService.getAllCampaignsDetails();
    response.prettyPrint();
    }


    @Then("^user set data which needs to be updated and update campaign for \"([^\"]*)\"$")
    public void userSetDataWhichNeedsToBeUpdatedAndUpdateCampaignFor(String arg0, DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        if (data.containsKey("description")) updateCampaignRequestPayload.setDescription(data.get("description"));
        if (data.containsKey("title")) updateCampaignRequestPayload.setTitle(data.get("title"));
        realm = arg0;
        updateCampaignRequestPayload.setId(id);
        updateCampaignRequestPayload.setTags(new ArrayList<>(Arrays.asList(realm)));
        Response response = UserGrowthService.updateCampaign(updateCampaignRequestPayload, id);
        response.prettyPrint();
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(data.get("description"), updateCampaignRequestPayload.getDescription());
        Assert.assertEquals(data.get("title"), updateCampaignRequestPayload.getTitle());
        Assert.assertEquals(realm, updateCampaignRequestPayload.getRealm());
    }
}