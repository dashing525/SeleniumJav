package org.sonu.kumar.util.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sonu.kumar.util.AbstructComponent;

public class ConfirmationPage extends AbstructComponent {
    WebDriver driver;
    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath ="//h1[@class='hero-primary']")
    WebElement confirmationMessage;

    public String getConfirmationMessage(){
       return confirmationMessage.getText();
    }
}
