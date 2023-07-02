package org.kumar.sonu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sonu.kumar.util.pageobject.*;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class StandAlone {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String product = "adidas original";
        LandingPage landPage = new LandingPage(driver);
        landPage.landingDemo();
        ProductCatalogue productCat = landPage.loginApp("sonik@gmail.com","Donotuse@12");

        List <WebElement> products= productCat.getProductList();
        productCat.addToCart(product);
        CartPage cartPage =productCat.goToCartPage();

        Boolean match =cartPage.verifyProductDisplayed(product);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage= cartPage.goToCheckOutPage();
        checkoutPage.selectCountryDropDown("india");
        ConfirmationPage confirmPage =checkoutPage.goToConfirmationPage();
        String confirmMessage= confirmPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

}

