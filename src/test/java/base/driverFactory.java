package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class driverFactory {

    //Constants

    private static optionsManager optionsManager = new optionsManager(); //get browser options-capabilities
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();// declare a thread for each session so we can run instances in parallel
    public static String gridHub = "http://localhost:4444/wd/hub"; // grid hub link
    public static String mtlJenkins = "http://mtl1-s-jenk-112.mgcorp.co:4444/wd/hub"; // grid hub link


    public static synchronized void setDriver(String browser){    //this function creates the remotedriver based on paramater from TestNG "browser"

        if (browser.matches("chrome")){
            try {
                tlDriver.set(new RemoteWebDriver(new URL(gridHub), optionsManager.getChromeOptions()));
            } catch (MalformedURLException e){
                e.printStackTrace();
            }

        }
        else if (browser.matches("firefox")){
            try {
                tlDriver.set(new RemoteWebDriver(new URL(gridHub), optionsManager.getFirefoxOptions()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else if (browser.matches("edge")){
            try {
                tlDriver.set(new RemoteWebDriver(new URL(gridHub), optionsManager.getEdgeOptions()));
            } catch (MalformedURLException e){
                e.printStackTrace();
            }
        }

        else if (browser.matches("IE")){
            try {
                tlDriver.set(new RemoteWebDriver(new URL(gridHub), optionsManager.getIEOptions()));
            } catch (MalformedURLException e){
                e.printStackTrace();
            }
        }
    }

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }

    public static synchronized WebDriverWait getWait (WebDriver driver) {
        return new WebDriverWait(driver,20);
    }
}
