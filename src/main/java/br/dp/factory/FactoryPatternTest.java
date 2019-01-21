package br.dp.factory;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class FactoryPatternTest {

    DriverManager driverManager;
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        //driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
        driver.close();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Test
    public void launchTestAutomationGuruTest() {
        driver.get("http://testautomationguru.com");
        Assert.assertEquals("TestAutomationGuru – A technical blog on test automation", driver.getTitle());
        driver.quit();

        /*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\br\\dp\\factory\\Utils\\Automation\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/xhtml");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        driver.quit();*/
    }

    @Test
    public void launchGoogleTest() {
        driver.get("https://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();
    }

    @Test
    public void launchYahooTest() {
        driver.get("https://www.yahoo.com");
        Assert.assertEquals("Yahoo", driver.getTitle());
        driver.quit();
    }
}