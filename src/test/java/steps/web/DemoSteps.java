package steps.web;


//import io.cucumber.java.en.Given;
import io.cucumber.java.en.Given;
import pages.DemoPage;

public class DemoSteps {
    DemoPage demoPage;

    @Given("User is on google landing page")
    public void user_is_on_google_landing_page() throws Exception {
       demoPage.navigateToUrl();
    }


}
