package com.binance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author esalkan
 * @project TestNGSelenium
 * @github https://github.com/esalkan/TestNGSelenium
 */
public class BtcUsdt {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.binance.com/en/trade/BTC_USDT?layout=pro");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void currencyGet() throws InterruptedException, ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
        WebElement high24Hours = driver.findElement(By.xpath("//*[@id=\"__APP\"]/div/div/div[2]/div/div[1]/div/div/div/div/div/div[2]/div/div/div[2]/div[2]"));
        WebElement low24Hours = driver.findElement(By.xpath("//*[@id=\"__APP\"]/div/div/div[2]/div/div[1]/div/div/div/div/div/div[2]/div/div/div[3]/div[2]"));
        String dailyMostHighSTR = high24Hours.getText();
        String dailyLowSTR = low24Hours.getText();

        Number num1 = format.parse(dailyMostHighSTR);
        Number num2 = format.parse(dailyLowSTR);

        double d = num1.doubleValue();
        double d2 = num2.doubleValue();
        double ort = (d + d2) / 2;
        System.out.println("dailyMostHighSTR = " + dailyMostHighSTR);
        System.out.println("dailyLowSTR = " + dailyLowSTR);
        System.out.println("Average : " + ort);
    }
}
