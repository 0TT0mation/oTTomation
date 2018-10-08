package base;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class optionsManager {

    public ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-infobars");
        return options;
    }

    public FirefoxOptions getFirefoxOptions(){
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("network.proxy.type", 0);
        options.setCapability("browser.link.open_newwindow", 1); //same effect if value 3
        options.setCapability("browser.link.open_newwindow.restriction", 2); //same effect if value 0
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

    public DesiredCapabilities getIEOptions(){
        DesiredCapabilities options = DesiredCapabilities.internetExplorer();
        options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
        options.setVersion(DesiredCapabilities.internetExplorer().getVersion());
        return options;
    }

    public EdgeOptions getEdgeOptions(){
        EdgeOptions options = new EdgeOptions();
        return options;
    }
}
