package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    // Task :
    // Write a static method that takes a string parameter name: browserType based on the value of parameter.
    // it will set up the browser and the method will return chromedriver  or fire fox driver object named of method
    // getDriver.

    public static WebDriver getDriver(String browserType){
        WebDriver driver = null;
        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "sarafi":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
        }
        return driver;
    }
}
