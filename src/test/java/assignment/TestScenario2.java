package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestScenario2 {

    @Test(description = "Test to search the expected results, after search")
    public void TestCase2(){

        String []browserTestCases = Utils.getBrowserTestCases();
        for(String browserName : browserTestCases) {

            RemoteWebDriver driver= Utils.getDriver(browserName);
            driver.get("https://www.ebay.com/");

            WebElement searchelement = driver.findElement(By.id("gh-ac"));
            searchelement.sendKeys("MacBook");

            WebElement search = driver.findElement(By.id("gh-btn"));
            search.click();

            WebElement changecategory = driver.findElement(By.id("gh-cat"));
            changecategory.click();

            WebElement dropdownElement = driver.findElement(By.id("gh-cat"));
            Select dropdown = new Select(dropdownElement);

            dropdown.selectByVisibleText("Computers/Tablets & Networking");

            WebElement searchagain = driver.findElement(By.id("gh-btn"));
            searchagain.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.titleIs("MacBook in Computers/Tablets & Networking for sale | eBay"
            ));

            List<WebElement> titleElements = driver.findElements(By.className("s-item__title"));
            WebElement titleElement = titleElements.get(1);
            String title = titleElement.getText().toLowerCase();
            boolean isContain = title.contains("macbook");
            Assert.assertEquals(isContain, true);
        }
    }


}
