package testRunner;

import java.io.File;
import cucumber.api.testng.*;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import static org.apache.commons.io.FileUtils.cleanDirectory;

@CucumberOptions(
        features = "./src/test/java/features",
        glue = {"stepDefinitions"},
        tags = {"@userLogin"})

public class runCucumberTest {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        File reportDir = new File("./target/reports/");
        cleanDirectory(reportDir);
    }

    @Test(dataProvider = "features")
    public void feature(PickleEventWrapper eventwrapper,CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
    }

    @DataProvider(parallel=true)
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}

