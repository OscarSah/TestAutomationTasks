package com.moneygaming.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfReader;
import utils.Driver;

import java.time.Duration;

/**
 * @author esalkan
 * @project AutomationTasks
 */
public class MoneyGamingTestBase {

    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;
    protected JavascriptExecutor jse;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        action = new Actions(driver);
        jse = (JavascriptExecutor) driver;
        // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfReader.getConf("mgUrl"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
