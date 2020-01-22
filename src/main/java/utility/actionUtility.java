package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.loginPage;

public class actionUtility {

    WebDriver driver;

    public actionUtility(){this.driver = driver;}

    public loginPage navigateToApp( WebDriver driver, String aURL) {
        driver.navigate().to(aURL);
        return PageFactory.initElements(driver,loginPage.class);
    }

    public String getElementText( WebDriver driver, By locator){
        return driver.findElement(locator).getText();
    }

    public String getTitle(WebDriver driver){
        return driver.getTitle();
    }

    public void setText(WebDriver driver, By locator, String setText){
        driver.findElement(locator).sendKeys(setText);
    }

    public void setClick( WebDriver driver, By locator){
        driver.findElement(locator).click();
    }

}
