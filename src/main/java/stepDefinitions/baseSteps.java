package stepDefinitions;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import listeners.extentReportListener;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import java.io.IOException;

public class baseSteps extends extentReportListener {

    public WebDriver driver;
    ExtentTest logInfo = null;
    public baseSteps(){
        driver = testHooks.driver;
    }

    public void logSteps(boolean startstep, String steps, String featureName, String scenarioName, String stepDescription, WebDriver driver, boolean screenshot) throws ClassNotFoundException, IOException {
        if(startstep == true && screenshot == true) {
            test = extent.createTest(Feature.class, featureName);
            test = test.createNode(Scenario.class, scenarioName);
            logInfo = test.createNode(new GherkinKeyword(steps), stepDescription);
            logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

        }else if(startstep == true && screenshot == false){
            test = extent.createTest(Feature.class, featureName);
            test = test.createNode(Scenario.class, scenarioName);
            logInfo = test.createNode(new GherkinKeyword(steps), stepDescription);

        }else if(startstep == false && screenshot == true){
            logInfo = test.createNode(new GherkinKeyword(steps),stepDescription);
            logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

        }else{
            logInfo = test.createNode(new GherkinKeyword(steps),stepDescription);
        }
    }

    public void takeFailScreenShot(String steps, String stepDescription, WebDriver driver, Exception e) throws ClassNotFoundException, IOException {
           logInfo = test.createNode(new GherkinKeyword(steps), stepDescription);
           testStepHandle( driver, logInfo, e);
    }

    public void AssertEqual(String steps, String stepDescription, String actualText, String expectedText, WebDriver driver) throws IOException, ClassNotFoundException {
        try {
            Assert.assertEquals(actualText, expectedText);
        }catch (AssertionError e){
            logInfo = test.createNode(new GherkinKeyword(steps), stepDescription);
            testStepHandle( driver, logInfo, e);
        }

    }
}
