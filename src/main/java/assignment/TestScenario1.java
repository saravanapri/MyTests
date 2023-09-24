package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario1 {

    @Test(description = "Test to verify the filters tags , after applied filter")
    public void TestCase1() throws InterruptedException
    {
        String []browserTestCases = Utils.getBrowserTestCases();
        for(String browserName : browserTestCases) {

            RemoteWebDriver driver= Utils.getDriver(browserName);
            driver.get("https://www.ebay.com/");
            driver.manage().window().maximize();

            WebElement category= driver.findElement(By.id("gh-shop-a"));
            category.click();

            WebElement subcategory= driver.findElement(By.partialLinkText("Cell phones & accessories"));
            subcategory.click();

            WebElement subcategory2= driver.findElement(By.partialLinkText("Cell Phones & Smartphones"));
            subcategory2.click();


            WebElement allfilters = driver.findElement(By.cssSelector("button[aria-label='All Filters']"));
            allfilters.click();

            Thread.sleep(5000);
            WebElement price = driver.findElement(By.id("c3-mainPanel-price"));
            price.click();

            Thread.sleep(5000);
            WebElement element = driver.findElement(By.cssSelector("input[aria-label='Minimum Value, US Dollar']"));
            element.sendKeys("100");

            WebElement element2 = driver.findElement(By.cssSelector("input[aria-label='Maximum Value, US Dollar']"));
            element2.sendKeys("500");

            WebElement screensize = driver.findElement(By.id("c3-mainPanel-Screen%20Size"));
            screensize.click();

            Thread.sleep(5000);

            WebElement screensize1 = driver.findElement(By.id("c3-subPanel-Screen%20Size_5.0%20-%205.4%20in_cbx"));
            screensize1.click();

            WebElement itemlocation = driver.findElement(By.id("c3-mainPanel-location"));
            itemlocation.click();

            Thread.sleep(5000);
            WebElement loc1 = driver.findElement(By.cssSelector("input[type='radio'][aria-label='US Only']"));
            loc1.click();

            WebElement apply = driver.findElement(By.cssSelector("button.x-overlay-footer__apply-btn[aria-label='Apply']"));
            apply.click();

            Thread.sleep(5000);
            List<WebElement> dropDownElements = driver.findElements(By.className("x-flyout__button"));
            WebElement dropDown = dropDownElements.get(0);
            dropDown.click();

            Assert.assertEquals(dropDown.getText(), "3 filters applied");
            List<WebElement> titleElements = driver.findElements(By.className("brm__item-label"));

            Assert.assertEquals(titleElements.get(0).getText(), "Screen Size: 5.0 - 5.4 in\nfilter applied");
            Assert.assertEquals(titleElements.get(1).getText(), "Price: $100.00 to $500.00\nfilter applied");
            Assert.assertEquals(titleElements.get(2).getText(), "Item Location: US Only\nfilter applied");

        }

    }



}
