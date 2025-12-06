package steps.api.userGrowth;

import io.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.response.userGrowth.AddTemplateRequestPayload;
import services.userGrowth.UserGrowthService;

import java.util.Map;

public class AddAndDeleteTemplateSteps {
    String id , realm;
    AddTemplateRequestPayload addTemplateRequestPayload = new AddTemplateRequestPayload();
    AddTemplateRequestPayload.CatalogConfig catalogConfig = new AddTemplateRequestPayload.CatalogConfig();
    AddTemplateRequestPayload.PlaceholderMapping placeholderMappingCC = new AddTemplateRequestPayload.PlaceholderMapping();
    AddTemplateRequestPayload.EsConfig esConfig = new AddTemplateRequestPayload.EsConfig();
    AddTemplateRequestPayload.PlaceholderMapping placeholderMappingEC = new AddTemplateRequestPayload.PlaceholderMapping();
    AddTemplateRequestPayload.Action action = new AddTemplateRequestPayload.Action();
    AddTemplateRequestPayload.Params params = new AddTemplateRequestPayload.Params();
    AddTemplateRequestPayload.ContentConfig contentConfig = new AddTemplateRequestPayload.ContentConfig();
    AddTemplateRequestPayload.Collection collection = new AddTemplateRequestPayload.Collection();
    AddTemplateRequestPayload.RichContent richContent = new AddTemplateRequestPayload.RichContent();


    @Given("^add template details for realm \"([^\"]*)\"$")
    public void addTemplateDetailsForRealm(String arg0, DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        realm = arg0;
        addTemplateRequestPayload.setId(data.get("id"));
        addTemplateRequestPayload.setRealm(realm);
        addTemplateRequestPayload.setDescription(data.get("description"));
        addTemplateRequestPayload.setName(data.get("name"));
        addTemplateRequestPayload.setType(data.get("type"));
        addTemplateRequestPayload.setSmsType(data.get("smsType"));
        addTemplateRequestPayload.setSmsHeader(data.get("smsHeader"));
        addTemplateRequestPayload.setMessageBody(data.get("messageBody"));
        Response response = UserGrowthService.addTemplate(addTemplateRequestPayload);
        response.prettyPrint();
    }

    @Then("^delete template$")
    public void deleteTemplate(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        id = data.get("id");
        Response response = UserGrowthService.deleteTemplate(id);
        response.prettyPrint();
    }


}
