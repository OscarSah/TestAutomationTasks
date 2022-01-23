package com.todomvc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

/**
 * @author esalkan
 * @project TestAutomationTasks
 */
public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebElement getTab(String str) {
        String tab = "//div[.='" + str + "']";
        return Driver.getDriver().findElement(By.xpath(tab));
    }

    public WebElement getLink(String linkName) {
        return Driver.getDriver().findElement(By.linkText(linkName));
    }



}
