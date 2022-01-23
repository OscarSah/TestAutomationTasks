package com.zerobank.tests;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import org.testng.annotations.Test;

/**
 * @author esalkan
 * @project TestAutomationTasks
 */
public class ZeroBankTests extends ZeroBankTestBase{
    @Test
    public void TC001() throws InterruptedException {
        LoginPage zb = new LoginPage();
        // Negative Login -> Empty inputfields Test
        zb.negativeLogin();
        // Negative Login -> Wrong user credentials Test
        zb.negativeLogin1();
        // Positive Login Test -> Valid user credentials
        zb.positiveLogin();

        AccountSummaryPage zbUser = new AccountSummaryPage();
        // Account summary Feature
        zbUser.accountSummaryPage();
        zbUser.accountTypesCheck();
        zbUser.creditAccounts();

    }
}
