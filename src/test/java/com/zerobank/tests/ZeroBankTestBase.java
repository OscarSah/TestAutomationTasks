package com.zerobank.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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
public class ZeroBankTestBase {

    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfReader.getConf("zbUrl"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
