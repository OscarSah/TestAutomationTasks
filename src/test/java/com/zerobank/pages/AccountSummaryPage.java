package com.zerobank.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ConfReader;
import utils.Driver;

import java.util.List;

/**
 * @author esalkan
 * @project AutomationTasks
 */
public class AccountSummaryPage {

    public AccountSummaryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void accountSummaryPage(){
        // - Account summary page should have the title Zero – Account summary.
        Assert.assertEquals(Driver.getDriver().getTitle(),"Zero - Account Summary");
        navTabElements();
    }

    @FindBy(css = "ul.nav.nav-tabs>li[id]")
    public List<WebElement> navTabs;
    // //*[@class='board-header']
    // #account_summary_tab[class='active']

    public void navTabElements(){
        // - When user logs in with valid credentials, Account summary page should be displayed. [DONE]
        for (WebElement navTab : navTabs) {
            if (navTab.getText() == "Account Summary"){
                Assert.assertTrue(navTab.getText() == "Account Summary" && navTab.getAttribute("class").equals("active"), "Verify that : All is well :)");
            }
        }
    }

    // - Account summary page should have to following account types:
    @FindBy(xpath = "//*[@class='board-header']")
    public List<WebElement> accountTypes;

    public void accountTypesCheck(){
        String strConfAccType = ConfReader.getConf("zbAccTypes");
        for (WebElement accountType : accountTypes) {
            Assert.assertTrue(strConfAccType.contains(accountType.getText()));
        }
    }

    // ----- Credit Accounts table must have columns
    @FindBy(css = "div:nth-child(2)>div>div>div:nth-child(6)>div>table>thead>tr>th")
    public List<WebElement> tableColumns;

    public void creditAccounts(){
        String strCATable = ConfReader.getConf("zbCATable");
        for (WebElement tableColumn : tableColumns) {
            Assert.assertTrue(strCATable.contains(tableColumn.getText()));
        }
    }

}
