package cucumber.steps.serenity;

import pages.basePage;
import pages.loginPage;
import pages.landingPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class baseSteps extends ScenarioSteps {

    basePage basepage;
    loginPage loginpage;
    landingPage landingpage;

    @Step("Navigate to Orange HRM Application")
    public loginPage goToApplication(){
        return basepage.goToApplication();
    }

    @Step("User getting the login page logo")
    public String getLoginPageLogo(){
        return loginpage.getLoginPageLogo();
    }

    @Step("User login with valid credentials")
    public landingPage userLogin(){
        return loginpage.userLogin("opensourcecms","opensourcecms");
    }

    @Step("User getting the welcome message")
    public String getWelComeMsg(){
        return landingpage.getWelComeMsg();
    }
}
