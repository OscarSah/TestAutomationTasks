package com.todomvc.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfReader;
import utils.Driver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author esalkan
 * @project TestAutomationTasks
 */
public abstract class TodoMvcTestBase {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    @BeforeMethod

    public void setUp(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String url = ConfReader.getConf("todoMvcUrl");
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
