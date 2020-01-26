package cucumber.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import static org.junit.Assert.*;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import cucumber.steps.serenity.baseSteps;

public class loginSteps  {

    @Managed
    @Steps
    baseSteps basesteps;

    @Given("^Open chrome browser and enter application URLs$")
    public void open_chrome_browser_and_enter_application_URLs() throws Exception {
        basesteps.goToApplication();
    }

    @Then("^I should see login page logo as \"([^\"]*)\"$")
    public void i_should_see_login_page_logo_as(String expectedLogoMSg) throws Exception {
        String actualLogoMSg = basesteps.getLoginPageLogo();
        assertEquals(expectedLogoMSg, actualLogoMSg);
    }
}
