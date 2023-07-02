package org.sonu.kumar.util.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sonu.kumar.util.AbstructComponent;

import java.util.List;

public class CheckoutPage extends AbstructComponent {

    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath ="//input[@placeholder='Select Country']" )
    WebElement enterCountryField;

    @FindBy(xpath ="//section[@class='ta-results list-group ng-star-inserted']" )
    WebElement autoSuggestionContainer;

    @FindBy(xpath ="//button[@class='ta-item list-group-item ng-star-inserted']" )
    List <WebElement> autoSuggestionCountry;

    @FindBy(xpath ="//a[@class='btnn action__submit ng-star-inserted']" )
    WebElement placeOrderButton;

    public void selectCountryDropDown(String country){
        enterCountryField.sendKeys(country);
        waitForWebElementToAppear(autoSuggestionContainer);
        List<WebElement> countryEntered = autoSuggestionCountry;
        WebElement actualCountry = countryEntered.stream().filter( count->count.getText().equalsIgnoreCase("india")).findFirst().orElse(null);
        actualCountry.click();
    }
        public ConfirmationPage goToConfirmationPage(){
            placeOrderButton.click();
            return new ConfirmationPage(driver);
        }

}
