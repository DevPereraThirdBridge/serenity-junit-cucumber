package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import static java.util.concurrent.TimeUnit.SECONDS;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

import java.io.IOException;
import java.util.Properties;

public class browserUtility {
    WebDriver driver;

    public WebDriver setBrowser( String brType)throws Throwable{
        if(brType.equalsIgnoreCase("IE")) {
            InternetExplorerDriverManager.iedriver().arch32().setup();
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            driver.manage().window().maximize();
            return driver;
        }else if(brType.equalsIgnoreCase("Chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
            chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
            chromeCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            chromeCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            ChromeDriver driver = new ChromeDriver(chromeCapabilities);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);

            return driver;
        }else if(brType.equalsIgnoreCase("FireFox")){
            FirefoxDriverManager.firefoxdriver().setup();
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            driver.manage().window().maximize();
            return driver;
        }else {
            return null;
        }
    }
}
