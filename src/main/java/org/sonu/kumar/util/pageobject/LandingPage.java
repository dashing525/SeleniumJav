package org.sonu.kumar.util.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sonu.kumar.util.AbstructComponent;

public class LandingPage extends AbstructComponent {

    WebDriver driver;
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "userEmail")
    WebElement username;
    @FindBy(id = "userPassword")
    WebElement passwordEle;
    @FindBy(className = "btn")
    WebElement submit;

    public void landingDemo(){
        driver.get("https://rahulshettyacademy.com/client");
    }

    public ProductCatalogue loginApp(String email, String password) {
        driver.manage().window().maximize();
        username.sendKeys(email);
        passwordEle.sendKeys(password);
        submit.click();
        ProductCatalogue productCat = new ProductCatalogue(driver);
        return  productCat;
    }

}
