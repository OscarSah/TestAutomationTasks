package com.moneygaming.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ConfReader;
import utils.Driver;

import java.time.Duration;

/**
 * @author esalkan
 * @project AutomationTasks
 */
public class RegistrationPage {

    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='newUser green']")
    public WebElement join; // Button

    @FindBy(xpath = "//*[@name='map(terms)']")
    public WebElement termsAndConditions; // Check Box

    @FindAll({
            @FindBy(xpath = "//*[@name='map(title)']"),
            @FindBy(xpath = "//*[@id='title']")
    })
    public WebElement title;

    @FindBy(xpath = "//*[@name='map(firstName)']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@name='map(lastName)']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='form']")
    public WebElement joinNow;

    @FindBy(xpath = "//label[@class='error'][@for='dob']")
    public WebElement dobErr;

    public void registration() {
        Faker person = new Faker();
        join.click();
        Select stateDropdown = new Select(title);
        stateDropdown.selectByValue(ConfReader.getConf("title"));
        firstName.sendKeys(person.name().firstName());
        lastName.sendKeys(person.name().lastName());
        termsAndConditions.click();
        joinNow.click();
    }

    public void validations(){
        Assert.assertTrue(dobErr.isDisplayed());
    }
}
