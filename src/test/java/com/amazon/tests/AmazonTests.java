package com.amazon.tests;

import com.amazon.pages.MainPage;
import com.amazon.pages.SearchItem;
import org.testng.annotations.Test;

/**
 * @author esalkan
 * @project TestAutomationTasks
 */
public class AmazonTests extends AmznTestBase {
    /**
     * Task 001 :
     * 1. Go to https://www.amazon.com/
     * 2. Scroll down and scroll up on the main page
     * 3. Verify that, main page title contains "Amazon.com"
     * 4. Verify that, "Cart" is empty(0)
     * 5. Verify that, site language is "English"
     */

    @Test // Task 001 :
    public void TC001() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.scrollDown();
        mainPage.scrollUp();
        mainPage.verifications();
    }

    /**
     * Task 002 :
     * 1. Go to https://www.amazon.com/
     * 2. Search for "hats for men"
     * 3. Add the first hat appearing to Cart with quantity 2
     * 4. Open cart and assert that the total price and quantity are correct
     * 5. Reduce the quantity from 2 to 1 in Cart for the item selected in the step3
     * 6. Assert that the total price and quantity has been correctly changed
     */

    @Test
    public void TC002() {
        SearchItem searchItem = new SearchItem();
        searchItem.searchItem();
        searchItem.selectItemAndAddToCart();
        searchItem.reduceQuantity();
        searchItem.verifications();
    }
}
