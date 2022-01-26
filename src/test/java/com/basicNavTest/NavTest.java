package com.basicNavTest;

import com.basicNavTest.utilities.BrowserFactory;
import com.basicNavTest.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

/**
 * @author esalkan
 * @project TestAutomationTasks
 */
public class NavTest {
    public static void main(String[] args) throws InterruptedException {
        osTypeBrowserTest("chrome");
    }

    public static void osTypeBrowserTest(String browserType) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver(browserType);

        driver.get("https://www.google.com");
        String pageTitleG = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String pageTitleE = driver.getTitle();
        driver.navigate().back();

        if (pageTitleG.equalsIgnoreCase(driver.getTitle())) {
            StringUtility.verifyEquals(pageTitleG, driver.getTitle());
        }
        driver.navigate().forward();
        if (pageTitleE.equalsIgnoreCase(driver.getTitle())) {
            StringUtility.verifyEquals(pageTitleE, driver.getTitle());
        }
        driver.quit();
    }

}
