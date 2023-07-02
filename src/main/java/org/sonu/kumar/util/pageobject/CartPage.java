package org.sonu.kumar.util.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sonu.kumar.util.AbstructComponent;

import java.util.List;

public class CartPage extends AbstructComponent {

    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = ".cartSection h3")
    List<WebElement> carts;

    @FindBy (xpath = "//ul[@style='list-style-type: none;']//button")
    WebElement checkoutButton;

    public Boolean verifyProductDisplayed(String product){
        Boolean match= carts.stream().allMatch(cart ->cart.getText().equalsIgnoreCase(product));
        return match;
    }
    public CheckoutPage goToCheckOutPage(){
        checkoutButton.click();
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        return checkoutPage;
    }

}
