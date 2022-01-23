package com.amazon.pages;

import com.amazon.tests.AmazonTests;
import com.amazon.tests.AmznTestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ConfReader;
import utils.Driver;

/**
 * @author esalkan
 * @project TestAutomationTasks
 */
public class MainPage {
    /**
     * Task 001 :
     * 1. Go to https://www.amazon.com/
     * 2. Scroll down and scroll up on the main page
     * 3. Verify that, main page title is "Amazon.com. Spend less. Smile more."
     * 4. Verify that, "Cart" is empty(0)
     * 5. Verify that, site language is "English"
     */

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // 2. Scroll down and scroll up on the main page
    public void scrollDown() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // 2. Scroll down and scroll up on the main page
    public void scrollUp() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, 0)");
    }

    @FindBy(id = "nav-cart-count")
    public WebElement chartCounter;

    public void verifications(){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, ConfReader.getConf("amznExpectedTitle"), "Verify that, main page title is \"Amazon.com. Spend less. Smile more.\"");
        Assert.assertEquals(chartCounter.getText(), "0", "Verify that, \"Cart\" is empty(0)");
    }
}
