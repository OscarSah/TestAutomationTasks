package com.zerobank.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ConfReader;
import utils.Driver;


/**
 * @author esalkan
 * @project AutomationTasks
 */
public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Home page Sign-in Button
    @FindBy(id = "signin_button")
    public WebElement signinButton;

    // Login Form Error Message When user try to enter with invalid credentials
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement loginErrorMessage;

    // Login-Form, userlogin input field
    @FindBy(id = "user_login")
    public WebElement userLogin;

    // Login-Form, userpassword input field
    @FindBy(id = "user_password")
    public WebElement userPassword;

    // Login-Form, sign-in(submit) button
    @FindBy(css = ".btn[name='submit']")
    public WebElement submitButton;

    // - Users with blank username or password should also not be able to login. [DONE]
    // - When user tries to login with invalid information, error message “Login and/or password are wrong.” should be displayed.[DONE]
    public void negativeLogin(){
        signinButton.click(); // Reach the login for with sign-in button.
        submitButton.click();
        Assert.assertTrue(loginErrorMessage.isDisplayed(), "Verify that : Error Message is Displayed."); // Checking Error Message is Displayed.
    }

    // - Users with wrong username or wrong password should not be able to login. [DONE]
    // - When user tries to login with invalid information, error message “Login and/or password are wrong.” should be displayed.[DONE]
    public void negativeLogin1(){
        // We will not use signinButton.click(), negativeLogin() method already called and we are already
        // Perform negative login test and now we are performing positive login.
        // signinButton.click(); // Reach the login for with sign-in button.
        fillTheFormWithInValidCredentials(); // With invalid user credentials filling the form.
        Assert.assertTrue(loginErrorMessage.isDisplayed(), "Verify that : Error Message is Displayed."); // Checking Error Message is Displayed.
    }


    // Only authorized users should be able to login to the application. [DONE]
    public void positiveLogin(){
        // We will not use signinButton.click(), negativeLogin() method already called and we are already
        // Perform negative login test and now we are performing positive login.
        // signinButton.click(); // Reach the login for with sign-in button.
        fillTheFormWithValidCredentials(); // With valid user credentials filling the form.
    }

    public void fillTheFormWithValidCredentials(){
        userLogin.sendKeys(ConfReader.getConf("zbUserName")); // From conf.properties username
        userPassword.sendKeys(ConfReader.getConf("zbPassword")); // From conf.properties password
        submitButton.click();
    }

    public void fillTheFormWithInValidCredentials(){
        userLogin.sendKeys(Faker.instance().name().username()); // From java faker, username
        userPassword.sendKeys(Faker.instance().number().digits(8)); // From java faker, password.
        submitButton.click();
    }

}
