package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Driver;

import java.util.*;

/**
 * @author esalkan
 * @project AutomationTasks
 */
public class AccountActivityPage {
    public AccountActivityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Account Activity")
    public WebElement accountActivityTab;

    public void userAccountActivity(){
        // Switch tab to Account Activity
        accountActivityTab.click();
        // - Account Activity page should have the title Zero – Account Activity.
        Assert.assertEquals(Driver.getDriver().getTitle(),"Zero - Account Activity", "Verify that : Title is as expected.");
        dropdownOptionsCheck();
    }

    // - In the Account drop down default option should be Savings.
    @FindBy(id = "aa_accountId")
    public WebElement accountActivityDropdown;

    public void dropdownOptionsCheck(){
        Select accountDropdown = new Select(accountActivityDropdown);
        Assert.assertEquals(accountDropdown.getFirstSelectedOption().getText(), "Savings");

    }



}
