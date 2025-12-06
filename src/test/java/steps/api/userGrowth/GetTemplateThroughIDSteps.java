package steps.api.userGrowth;

import io.cucumber.java.Before;
import io.restassured.response.Response;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.response.userGrowth.UpdateTemplate.UpdateTemplateRequestPayload;
import services.userGrowth.UserGrowthService;

import java.util.Map;

public class GetTemplateThroughIDSteps {
    String realm,id;
    UpdateTemplateRequestPayload updateTemplateRequestPayload = new UpdateTemplateRequestPayload();
    UpdateTemplateRequestPayload.RichContent richContent = new UpdateTemplateRequestPayload.RichContent();
    UpdateTemplateRequestPayload.Action action = new UpdateTemplateRequestPayload.Action();
    UpdateTemplateRequestPayload.Collection collection = new UpdateTemplateRequestPayload.Collection();
    UpdateTemplateRequestPayload.ContentConfig contentConfig = new UpdateTemplateRequestPayload.ContentConfig();
    UpdateTemplateRequestPayload.Params params = new UpdateTemplateRequestPayload.Params();

    @Given("^get template details for \"([^\"]*)\"$")
    public void getTemplateDetailsFor(String arg0, DataTable dataTable) throws Throwable {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        realm = arg0;
        id = data.get("id");
        Response response = UserGrowthService.getTemplateThroughId(realm,id);
        response.prettyPrint();
    }
    @Before
    public void setUp(){

//        updateTemplateRequestPayload.setName("avod");
//        updateTemplateRequestPayload.setType("SMS");
//        updateTemplateRequestPayload.setActive(true);
//        updateTemplateRequestPayload.setMessageTitle("");
//        updateTemplateRequestPayload.setMessageSubtitle("");
//        updateTemplateRequestPayload.setMessageBody("");
//        updateTemplateRequestPayload.setLanguageCode("EN");
//        updateTemplateRequestPayload.setBackgroundColor("");
//        updateTemplateRequestPayload.setLargeIcon(true);
//        updateTemplateRequestPayload.setLargeIconUrl("");
//        updateTemplateRequestPayload.setMakeNotificationSticky(true);
//        updateTemplateRequestPayload.setAppRefreshInBackground(true);
//        updateTemplateRequestPayload.setCreatedBy("string");
//        updateTemplateRequestPayload.setCreatedOn(0);
//        updateTemplateRequestPayload.setLastUpdatedBy("");
//        updateTemplateRequestPayload.setLastUpdatedOn(0);
//        updateTemplateRequestPayload.setWhatsappTemplateId("");
//        updateTemplateRequestPayload.setSmsType("PROMOTIONAL");
//        updateTemplateRequestPayload.setSmsTemplateId("");
//        updateTemplateRequestPayload.setSmsHeader("650015");
//        richContent.setId("");
//        richContent.setValue("");
//        richContent.setFallbackValue("");
//        richContent.setType("IMAGE");
//        ArrayList<UpdateTemplateRequestPayload.RichContent> richContentArrayList = new ArrayList<>();
//        richContentArrayList.add(richContent);
//        updateTemplateRequestPayload.setRichContents(richContentArrayList);
//        action.setType("DEEPLINK");
//        action.setValue("");
//        updateTemplateRequestPayload.setWhatsappDynamicHeaders(new ArrayList<>(Arrays.asList("string")));
//        updateTemplateRequestPayload.setWhatsappDynamicBody(new ArrayList<>(Arrays.asList("string")));
//        updateTemplateRequestPayload.setWhatsappDynamicFooters(new ArrayList<>(Arrays.asList("string")));
//        collection.setCollectionType("");
//        collection.setCollectionId("");
//        params.setAdditionalProp1("string");
//        params.setAdditionalProp2("string");
//        params.setAdditionalProp3("string");
//        collection.setParams(params);
//        contentConfig.setContentFetchingStrategy("FIRST");
//        collection.setContentConfig(contentConfig);
//        ArrayList<UpdateTemplateRequestPayload.Collection> collectionArrayList = new ArrayList<>();
//        collectionArrayList.add(collection);
//        updateTemplateRequestPayload.setCollections(collectionArrayList);

    }

    @And("^user set data for template which needs to be updated$")
    public void userSetDataForTemplateWhichNeedsToBeUpdated(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
        if (data.containsKey("description")) updateTemplateRequestPayload.setDescription(data.get("description"));

    }

    @Then("^update template for \"([^\"]*)\"$")
    public void updateTemplateFor(String arg0) throws Throwable {
        realm = arg0;
        updateTemplateRequestPayload.setId(id);
        updateTemplateRequestPayload.setRealm(realm);
        Response response = UserGrowthService.updateTemplate(updateTemplateRequestPayload,id);
        response.prettyPrint();
    }
}
