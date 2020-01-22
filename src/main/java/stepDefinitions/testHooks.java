package stepDefinitions;

import pages.loginPage;
import cucumber.api.Scenario;
import utility.browserUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class testHooks {

    browserUtility browserutility;
    public static loginPage lgnpage;
    public static WebDriver driver;
    public static String Urls;

    @Before
    public void beforeScenario(Scenario scenario) throws Throwable {

        browserutility = new browserUtility();
        driver = browserutility.setBrowser("Chrome");
        lgnpage = new loginPage(driver);
        Urls = "https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login";
        System.out.println("Started execution for the scenario : " + scenario.getName());
    }

    @After
    public void AfterScenario(Scenario scenario) {

        if (driver != null) {
            driver.quit();
        }
        System.out.println("Completed execution for the scenario :" + scenario.getName());
    }

}
