package com.moneygaming.tests;

import com.moneygaming.pages.RegistrationPage;
import org.testng.annotations.Test;

/**
 * @author esalkan
 * @project TestAutomationTasks
 */
public class MoneyGamingTests extends MoneyGamingTestBase{
    @Test
    public void TC001() throws InterruptedException {
        RegistrationPage user = new RegistrationPage();
        user.registration();
        user.validations();
    }
}
