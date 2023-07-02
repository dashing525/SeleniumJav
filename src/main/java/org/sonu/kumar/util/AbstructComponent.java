package org.sonu.kumar.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sonu.kumar.util.pageobject.CartPage;

import java.time.Duration;

public class AbstructComponent {
    WebDriver driver;
    public AbstructComponent(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(css = "button[routerlink*='cart']")
    WebElement cartButton;


    public void waitForByLocatorToAppear(By byLocator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }
    public void waitForWebElementToAppear(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInvisibilityOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public CartPage goToCartPage(){
        cartButton.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
}
