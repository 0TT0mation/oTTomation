package base;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

public class InvokedMethodListener implements IInvokedMethodListener {
    @BeforeSuite
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult){
        if (method.isTestMethod()){
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browser");
            driverFactory.setDriver(browserName);
        }
    }

    @BeforeSuite
    public void afterInvocation(IInvokedMethod method, ITestResult testResult){
        if (method.isTestMethod()){
            WebDriver driver = driverFactory.getDriver();
            if (driver != null){
                driver.quit();
            }
        }
    }
}
