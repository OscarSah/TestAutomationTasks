package com.todomvc.tests;

import com.todomvc.pages.PolymerPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author esalkan
 * @project TestAutomationTasks
 */
public class PolymerTest extends TodoMvcTestBase {

    PolymerPage polymerPage = new PolymerPage();

    @Test
    public void TC001() throws InterruptedException {
        polymerPage.getTab("JavaScript").click();
        polymerPage.getLink("Polymer").click();
        String toDoItemOne = "My First To-Do item.";
        String toDoItemTwo = "My Second To-Do item.";
        polymerPage.inputBox.sendKeys(toDoItemOne, Keys.ENTER);
        polymerPage.inputBox.sendKeys(toDoItemTwo, Keys.ENTER);
        Assert.assertTrue(polymerPage.createdItemElement(toDoItemOne).isDisplayed(), "Verify First To-Do");
        Assert.assertTrue(polymerPage.createdItemElement(toDoItemTwo).isDisplayed(), "Verify Second To-Do");

        WebElement btnForChange = polymerPage.createdItemElement(toDoItemTwo);
        actions.doubleClick(btnForChange).perform();

        for (int i = 0; i < toDoItemTwo.length(); i++) {
            polymerPage.editBox.sendKeys(Keys.BACK_SPACE);
        }
        String changedItem = "I have changed second item";
        polymerPage.editBox.sendKeys(changedItem, Keys.ENTER);

        Assert.assertTrue(polymerPage.createdItemElement(changedItem).isDisplayed(), "My second item NOT changed");

    }
}
