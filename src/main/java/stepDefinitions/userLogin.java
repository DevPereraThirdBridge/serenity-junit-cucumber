package stepDefinitions;

import pages.loginPage;
import org.testng.Assert;
import pages.landingPage;
import java.io.IOException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

public class userLogin extends baseSteps {

    public WebDriver driver;
    loginPage lgnpage;
    landingPage landpage;
    String Urls;

    public userLogin(){

        driver = testHooks.driver;
        lgnpage = testHooks.lgnpage;
        Urls = testHooks.Urls;
    }

    @Given("^Open chrome browser and enter application URLs$")
    public void open_chrome_browser_and_enter_url() throws Throwable
    {

        try{

            lgnpage = lgnpage.goToLoginPage(Urls);
            logSteps(true,
                    "Given",
                    "Verify user login features",
                    "Verify user login features",
                    "Open chrome browser with application URLs",
                    driver,
                    true);

        }catch (Exception e){
            takeFailScreenShot("Given",
                    "Open chrome browser with application URLs", driver, e);
        }

    }

    @When("^I enter username as \"(.*)\", password as \"(.*)\" and click login$")
    public void userlogin(String usr, String psr) throws ClassNotFoundException, IOException {

        try{

            lgnpage = lgnpage.usrEnterLoginDetails(usr, psr);
            logSteps(false,
                    "When",
                    "",
                    "",
                    "I enter valid username, password and login",
                    driver,
                    true );
            landpage = lgnpage.usrCLickLoginBtn( landingPage.class);

        }catch (Exception e){
            takeFailScreenShot("When",
                    "I enter valid username, password and login", driver, e);
            //testStepHandle("FAIL", driver, logInfo, e);
        }
    }

    @When("^I enter incorrect username as \"(.*)\", password as \"(.*)\" and click login$")
    public void userloginInvalid(String usr, String psr) throws ClassNotFoundException, IOException {

        try{

            lgnpage = lgnpage.usrEnterLoginDetails(usr, psr);
            logSteps(false,
                    "When",
                    "",
                    "",
                    "I enter invalid username and password and login",
                    driver,
                    true );
            lgnpage = lgnpage.usrCLickLoginBtn( loginPage.class);

        }catch (Exception e){
            takeFailScreenShot("When", "I enter invalid username and password and login", driver, e);
        }
    }

    @Then("^I should see the landing page with \"(.*)\"$")
    public void userlogin(String greetingmsg) throws ClassNotFoundException, IOException {

        try{

            String actualusrGreetingMSg = landpage.getUserGreetingElementText();
            logSteps(false,
                    "Then",
                    "",
                    "",
                    "I should see landing page with greeting message",
                    driver,
                    true );
            AssertEqual("Then", "I should see landing page with greeting message", actualusrGreetingMSg, greetingmsg, driver);
        }catch (Exception e){
            takeFailScreenShot("Then", "I should see landing page with greeting message", driver, e);
        }

    }


    @Then("^I should see login page logo as \"(.*)\"$")
    public void see_page_logo(String pageLogo) throws ClassNotFoundException, IOException {

        ExtentTest logInfo = null;
        try{

            logSteps(false,
                    "Then",
                    "",
                    "",
                    "I should see login page logo",
                    driver,
                    true);

            String actualLogo = lgnpage.getLoginPageLogo();
            Assert.assertEquals(actualLogo, pageLogo);

        }catch (Exception e){
            takeFailScreenShot("Then", "I should see login page logo", driver, e);
        }

    }

    @Then("^I should see the error message as \"(.*)\"$")
    public void userErrMsg(String errorMsg) throws ClassNotFoundException, IOException {

        try{

            logSteps(false,
                    "Then",
                    "",
                    "",
                    "I should see the error message at login page",
                    driver,
                    true);

            String actualusrErrMSg = lgnpage.getErrMsgLoginPage();
            Assert.assertEquals(actualusrErrMSg, errorMsg);

        }catch (Exception e){
            takeFailScreenShot("Then", "I should see the error message at login page", driver, e);
        }

    }

    @Then("^I should see the message of \"(.*)\"$")
    public void userMsg(String msg) throws ClassNotFoundException, IOException{

        try{

            logSteps(false,
                    "Then",
                    "",
                    "",
                    "I should see the error message at login page",
                    driver,
                    true);

            String actualusrErrMSg = lgnpage.getErrMsgLoginPage();
            Assert.assertEquals(actualusrErrMSg, msg);

        }catch (Exception e){
            takeFailScreenShot("Then", "I should see the error message at login page", driver, e);
        }

    }

    @Then("^I logout from the application$")
    public void userLogout() throws ClassNotFoundException, IOException{

        try{

            lgnpage = landpage.userLogout();
            logSteps(false,
                    "Then",
                    "",
                    "",
                    "I logout from the application",
                    driver,
                    true);

        }catch (Exception e){
            takeFailScreenShot("Then", "I logout from the application", driver, e);
        }

    }

}
