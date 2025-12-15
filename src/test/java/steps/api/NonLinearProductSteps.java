package steps.api;


import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import model.Common.UserInfo;
import model.Common.arsenalCollection.ArsenalCollection;
import org.junit.Assert;
import services.discovery.ArsenalService;

public class NonLinearProductSteps {
    UserInfo userInfo = new UserInfo();
    ArsenalCollection version1Collections;

    @And("^Fetch content from arsenal collection \"([^\"]*)\"$")
    public void fetchContentFromArsenalCollection(String collectionId) throws Throwable {
        version1Collections = ArsenalService.getArsenalCollectionController(collectionId, UserInfo.liveAttribute);
    }


    @Then("^Verify content type should be \"([^\"]*)\"$")
    public void verifyContentTypeShouldBe(String arg0) throws Throwable {
        for (int i = 0; i < version1Collections.getContents().size(); i++) {
            Assert.assertEquals(arg0, version1Collections.getContents().get(i).getType());
        }
    }

    @Then("^Verify content status should be \"([^\"]*)\"$")
    public void verifyContentStatusShouldBe(String arg0) throws Throwable {
        for (int i = 0; i < version1Collections.getContents().size(); i++) {
            Assert.assertEquals(arg0, version1Collections.getContents().get(i).getExtras().get("_state"));
        }
    }

    @And("^Verify Content language is same from user P(\\d+) language$")
    public void verifyContentLanguageIsSameFromUserPLanguage(int arg0) {

    }

    @Then("^Verify content genres should be from \"([^\"]*)\"$")
    public void verifyContentGenresShouldBeFrom(String arg0) throws Throwable {
        String[] expectedGenres = arg0.split(", ");

        for (int i = 0; i < version1Collections.getContents().size(); i++) {
            boolean flag = false;
            for (String expectedGenre : expectedGenres) {
                if (version1Collections.getContents().get(i).getExtras().get("_genres").contains(expectedGenre.trim().toLowerCase())) {
                    flag = true;
                    break;
                }
            }
            Assert.assertTrue(flag);
        }
    }

    @Then("^Verify content partner should be \"([^\"]*)\"$")
    public void verifyContentPartnerShouldBe(String arg0) throws Throwable {
        for (int i = 0; i < version1Collections.getContents().size(); i++) {
            Assert.assertTrue(arg0.contains(version1Collections.getContents().get(i).getExtras().get("_cpId")));
        }
    }

    @Then("^Verify Content language is same from user P1 language if P0 is not available$")
    public void verifyContentLanguageIsSameFromUserPLanguageIfPIsNotAvaliable() {

    }

}
