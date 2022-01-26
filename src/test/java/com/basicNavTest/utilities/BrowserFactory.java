package com.basicNavTest.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
public class BrowserFactory {
    public static WebDriver getDriver(String browserType) {
        // A Null WebDriver
        WebDriver driver = null;
        //Operating system name
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().startsWith("windows") && browserType.equalsIgnoreCase("safari")){
            System.out.println("Os Type is : " + osName + ", Chosen Browser Type is : " + browserType);
            System.out.println("System can not start the " + browserType);
            return driver = null;
        } else if (osName.toLowerCase().startsWith("mac") && browserType.equalsIgnoreCase("edge")) {
            System.out.println("Os Type is : " + osName + ", Chosen Browser Type is : " + browserType);
            System.out.println("System can not start the " + browserType);
            return driver = null;
        } else {
            switch (browserType.toLowerCase()){
                case "chrome":
                    WebDriverManager.safaridriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }
        }
        return driver;
    }
}
