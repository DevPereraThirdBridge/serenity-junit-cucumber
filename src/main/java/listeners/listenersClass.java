package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import com.aventstack.extentreports.ExtentReports;

public class listenersClass extends extentReportListener implements ITestListener {

private static ExtentReports extent;

    public void onStart(ITestContext context) {
        extent = setUp();
        System.out.println("Execution started...");

    }

    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("Execution completed...");

    }

}
