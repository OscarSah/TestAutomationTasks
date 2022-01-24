package com.chercher;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;
import utils.WebDriverFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author esalkan
 * @project TestAutomationTasks
 */
public class CherCherTest {

    WebDriver driver; // Creating "driver"
    WebDriverWait wait; // Creating wait

    @BeforeMethod
    public void setUp(){ // Set-up
        driver = WebDriverFactory.getDriver("chrome"); // assign to the driver chrome browser
        driver.manage().window().maximize(); // maximize to browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // waiting elements load
        // Task1: & Task2:
        // 1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver"); // source url
    }

    @AfterMethod
    public void tearDown(){
        driver.close(); // Close the driver after each test methods.
    }

    /**
     * Task1:
     *  1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
     *  2. Click on "Click me, to Open an alert after 5 seconds"
     *  3. Explicitly wait until alert is present
     *  4. Then handle the Javascript alert
     */

    @Test
    public void explicitlyWaitAlertTest() throws InterruptedException {
        // 2. Click on "Click me, to Open an alert after 5 seconds"
        WebElement clickMeButton = driver.findElement(By.id("alert"));
        clickMeButton.click();

        // 3. Explicitly wait until alert is present
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        // 4. Then handle the Javascript alert
        Alert alert = driver.switchTo().alert(); // handling with javascript alert
        alert.accept(); // accepting alert message.
    }

    /**
     * Task2:
     *  1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
     *  2. Click on "Enable button after 10 seconds"
     *  3. Explicitly wait until the button is enabled
     *  4. Then verify the button is enabled
     */
    @Test
    public void explicitlyWaitEnableButtonTest(){
        // 2. Click on "Enable button after 10 seconds" Button
        WebElement enableButton = driver.findElement(By.id("enable-button"));
        enableButton.click();

        // 3. Explicitly wait until the button is enabled
        WebElement disabledButton = driver.findElement(By.id("disable"));
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(disabledButton));

        // 4. Then verify the button is enabled
        Assert.assertTrue(disabledButton.isEnabled(), "Verify that : The Disabled button is enabled");
    }
}
