package steps.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import model.Common.UserInfo;
import model.Common.arsenalCollection.ArsenalCollectionResponse;
import org.junit.Assert;
import services.discovery.ArsenalService;

import java.util.HashMap;

public class YouTubeRecommendationsSteps {

    UserInfo userInfo = new UserInfo();
    ArsenalCollectionResponse arsenalCollectionResponse;

    @Given("We are using {string} as a Xstream user and {string} as realm")
    public void weAreUsingAsAXstreamUserAndAsRealm(String uid,String realm) {
        if (UserInfo.liveAttribute == null) {
            UserInfo.liveAttribute = new HashMap<>();
        }
        UserInfo.liveAttribute.put("uid", uid);
        UserInfo.liveAttribute.put("realm", "XSTREAM");
        System.out.println("User UID set to: " + uid);
        System.out.println("Realm set to: " + realm);
    }

    @And("Fetch content from YouTube arsenal collection {string}")
    public void fetchContentFromYouTubeArsenalCollection(String collectionId) throws Throwable {
        arsenalCollectionResponse = ArsenalService.getArsenalCollectionControllerResponse(collectionId, UserInfo.liveAttribute);
        System.out.println("Fetched content for collectionId: " + collectionId);
    }

    @Then("Verify content type for YouTube should be {string}")
    public void verifyContentTypeForYouTubeShouldBe(String expectedType) throws Throwable {
        for (int i = 0; i < arsenalCollectionResponse.getContents().size(); i++) {
            Assert.assertEquals(expectedType, arsenalCollectionResponse.getContents().get(i).getType());
        }
        System.out.println("Content type verified: " + expectedType);
    }

    @Then("Verify model source should be {string}")
    public void verifyModelSourceShouldBe(String expectedSource) throws Throwable {
        for (int i = 0; i < arsenalCollectionResponse.getContents().size(); i++) {
            Assert.assertEquals(expectedSource, arsenalCollectionResponse.getContents().get(i).getExtras().get_modelSource());
        }
        System.out.println("Model source verified: " + expectedSource);
    }

}
