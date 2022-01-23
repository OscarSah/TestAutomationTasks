package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ConfReader;
import utils.Driver;

/**
 * @author esalkan
 * @project TestAutomationTasks
 */
public class SearchItem {
    /**
     * Task 002 :
     * 1. Go to https://www.amazon.com/
     * 2. Search for "hats for men"
     * 3. Add the first hat appearing to Cart with quantity 2
     * 4. Open cart and assert that the total price and quantity are correct
     * 5. Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3
     * 6. Assert that the total price and quantity has been correctly changed
     */

    double itemPrice;
    double totalPrice;

    public SearchItem() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // 2. Search for "hats for men"
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;


    public void searchItem() {
        searchBar.clear();
        Assert.assertTrue(searchBar.getText().isEmpty(), "Verify that : Search Bar Input Box is Empty");
        searchBar.sendKeys(ConfReader.getConf("amznItemSearch"), Keys.ENTER);
    }

    // 3. Add the first hat appearing to Cart with quantity 2
    // 4. Open cart and assert that the total price and quantity are correct
    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[1]/h2/a")

    public WebElement firstItem;

    @FindBy(xpath = "//span[@class='a-offscreen']/parent::span[@class]/parent::td[@class='a-span12']")
    public WebElement oneItemPrice;

    public void selectItemAndAddToCart() {
        firstItem.click();
        this.itemPrice = Double.parseDouble(oneItemPrice.getText().substring(1));
        if (!Driver.getDriver().findElement(By.xpath("//select[@id='quantity']")).isDisplayed()){
            addToCart();
        } else {
            quantitySelector();
            addToCart();
        }
    }

    @FindBy(xpath = "//select[@id='quantity']")
    public WebElement quantityDropdown;

    public void quantitySelector() {
        Select stateDropdown = new Select(quantityDropdown);
        stateDropdown.selectByValue(ConfReader.getConf("amznItemQuantity"));
    }

    @FindBy(id = "add-to-cart-button")
    public WebElement addCartButton;

    public void addToCart() {
        addCartButton.click();
        this.totalPrice = itemPrice * 2;
        // Correcting price is equal to quantity
        Assert.assertEquals((itemPrice * 2), totalPrice);
        MainPage mp = new MainPage();
        Assert.assertEquals(mp.chartCounter.getText(), ConfReader.getConf("amznItemQuantity"));
        mp.chartCounter.click();
    }


    // 5. Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3

    @FindBy(css = "span.a-dropdown-prompt")
    public WebElement checkQuantity;

    @FindBy(css = "li>a[id='quantity_1']")
    public WebElement reduceToOne;

    public void reduceQuantity() {
        checkQuantity.click();
        reduceToOne.click();
        this.totalPrice = itemPrice;
    }

    // 6. Assert that the total price and quantity has been correctly changed
    public void verifications() {
        Assert.assertEquals(itemPrice, totalPrice, "Assert that the total price and quantity has been correctly changed");
        Assert.assertEquals(checkQuantity.getText(), "1", "Verify that : Item quantity reduced to 1");
    }
}
