package cucumber;

import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"./src/test/resources/features/userLogin.feature"},
        glue = {"steps"}
        )

public class userLoginRunner {
}
