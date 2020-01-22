package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.actionUtility;

public class indexPage extends actionUtility {

    WebDriver driver;
    private By empName = By.xpath("//input[@id='empsearch_employee_name_empName']");
    private By empSupName = By.xpath("//input[@id='empsearch_supervisor_name']");
    private By empId = By.xpath("//input[@id='empsearch_id']");
    private By empJobTitle = By.xpath("//select[@id='empsearch_job_title']");
    private By empStatus = By.xpath("//select[@id='empsearch_employee_status']");
    private By empSubUnit = By.xpath("//select[@id='empsearch_sub_unit']");
    private By empInclude = By.xpath("//select[@id='empsearch_termination']");


}
