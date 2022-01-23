package com.todomvc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;

/**
 * @author esalkan
 * @project TestAutomationTasks
 */
public class PolymerPage extends BasePage {

    @FindBy(id = "new-todo")
    public WebElement inputBox;

    public WebElement createdItemElement(String str) {
        return Driver.getDriver().findElement(By.xpath("//label[.='" + str + "']"));
    }

    @FindBy(id = "edit")
    public WebElement editBox;


}
