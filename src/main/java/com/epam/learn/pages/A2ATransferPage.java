package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A2ATransferPage {

    WebDriver driver;

    @FindBy(id = "fromAccount")
    WebElement fromAccountInput;

    @FindBy(id = "toAccount")
    WebElement toAccountInput;

    @FindBy(id = "submitButton")
    WebElement submitButton;

    @FindBy(id = "errorMessage")
    WebElement errorMessage;

    public A2ATransferPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFromAccount(String fromAccount) {
        fromAccountInput.clear();
        fromAccountInput.sendKeys(fromAccount);
    }

    public void enterToAccount(String toAccount) {
        toAccountInput.clear();
        toAccountInput.sendKeys(toAccount);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
