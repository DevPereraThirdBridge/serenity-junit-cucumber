package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utility.actionUtility;


public class loginPage extends actionUtility{

    WebDriver driver;
    private By username = By.xpath("//input[@id='txtUsername']");
    private By userpassword = By.xpath("//input[@id='txtPassword']");
    private By lgnBtn = By.xpath("//input[@id='btnLogin']");
    private By lgnLogo = By.xpath("//div[@id='logInPanelHeading']");
    private By errMSg = By.xpath("//span[@id='spanMessage']");

    public loginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public loginPage goToLoginPage( String URLs) throws Throwable {
        return navigateToApp( driver, URLs);
    }

    public String getLoginPageLogo(){
        return getElementText( driver, lgnLogo);
    }

    public loginPage usrEnterLoginDetails( String usr, String psr){
            setText( driver, username, usr);
            setText( driver, userpassword, psr);
            return this;
    }

    public <T>T usrCLickLoginBtn( Class<T> expectedPage){
        setClick(driver, lgnBtn);
        return PageFactory.initElements(driver, expectedPage);
    }

    public String getErrMsgLoginPage(){
        return getElementText( driver, errMSg);
    }

}
