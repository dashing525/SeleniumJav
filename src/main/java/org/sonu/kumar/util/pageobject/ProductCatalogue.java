package org.sonu.kumar.util.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sonu.kumar.util.AbstructComponent;

import java.util.List;

public class ProductCatalogue extends AbstructComponent {
    WebDriver driver;
    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // List<WebElement> name= driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement loadingIcon;

    By byProductName= By.cssSelector(".mb-3");
    By addToCart= By.cssSelector(".card-body button:last-of-type");
    By toastContainer= By.cssSelector("#toast-container");

    public List<WebElement> getProductList(){
        waitForByLocatorToAppear(byProductName);
        return products;
    }

    public  WebElement getProductByName(String productName){
        WebElement prod = getProductList().stream().filter(prodName ->prodName.findElement(By.cssSelector("b")).
                getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        return prod;
    }
    public void addToCart(String product){
        WebElement prod = getProductByName(product);
        prod.findElement(addToCart).click();
        waitForByLocatorToAppear(toastContainer);
        waitForInvisibilityOfElement(loadingIcon);


    }
}

