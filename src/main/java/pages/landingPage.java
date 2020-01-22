package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.actionUtility;

public class landingPage extends actionUtility {

    WebDriver driver;
    private By welcomeElement = By.xpath("//li[contains(text(),'Welcome Admin')]");
    private By logOutBtn = By.xpath("//a[contains(text(),'Logout')]");

    public landingPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserGreetingElementText(){
       return  getElementText( driver, welcomeElement);
    }

    public loginPage userLogout(){
        setClick(driver, logOutBtn);
        return new loginPage(driver);
    }



}
