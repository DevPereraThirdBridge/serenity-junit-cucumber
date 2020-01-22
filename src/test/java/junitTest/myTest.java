package junitTest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class myTest {

    @Managed
    WebDriver driver;

    @Test
    public void navigateToGooglePage() {
        driver.navigate().to("https://www.google.com");
    }
}
