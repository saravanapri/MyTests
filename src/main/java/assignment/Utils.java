package assignment;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utils {

    public static RemoteWebDriver getDriver(String browserName) {
        if ( "chrome".equals(browserName)) {
            return new ChromeDriver();
        }
        else if ("firefox".equals(browserName)) {
            return new FirefoxDriver();
        }
        else {
            return null;
        }

    }

    public static String[] getBrowserTestCases() {
        String[] testcases={"chrome"};
        return testcases;
    }
}
