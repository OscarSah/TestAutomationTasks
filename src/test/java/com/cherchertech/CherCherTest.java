package com.cherchertech;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import java.time.Duration;

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
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(disabledButton));

        // 4. Then verify the button is enabled
        Assert.assertTrue(disabledButton.isEnabled(), "Verify that : The Disabled button is enabled");
    }

    /**
     * Task3:
     *  1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
     *  2. Click on "Display button after 10 seconds"
     *  3. Explicitly wait until the button is displayed
     *  4. Then verify the button is displayed
     */
    @Test
    public void explicitlyWaitDisplayOtherButtonTest(){
        // 2. Click on "Display button after 10 seconds"
        WebElement displayButton = driver.findElement(By.id("display-other-button"));
        displayButton.click();

        // 3. Explicitly wait until the button is displayed
        WebElement hiddenButton = driver.findElement(By.id("hidden"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));
        Assert.assertTrue(hiddenButton.isDisplayed(),"Verify that : Hidden button is displayed");
    }

    /**
     * Task4:
     *  1. Go to https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver
     *  2. Click on "Change Text to Selenium Webdriver"
     *  3. Wait until in place of  "Site" text,  become "Selenium Webdriver".
     *  4. Verify this : "Site" text changed to "Selenium Webdriver".
     */
    @Test
    public void explicitlyWaitTextChangeTest(){
        // 2. Click on "Change Text to Selenium Webdriver"
        WebElement changeTextButton = driver.findElement(By.id("populate-text"));
        changeTextButton.click();

        String expectedText = "Selenium Webdriver";
        String actualText =  driver.findElement(By.id("h2")).getText();

        // 3. Wait until in place of  "Site" text,  become "Selenium Webdriver".
        wait = new WebDriverWait(driver,Duration.ofSeconds(11));
        wait.until(ExpectedConditions.textToBe(By.id("h2"),"Selenium Webdriver"));

        // 4. Verify this : "Site" text changed to "Selenium Webdriver".
        Assert.assertNotEquals(actualText,expectedText,"Verify this : \"Site\" text changed to \"Selenium Webdriver\".");

    }

}
