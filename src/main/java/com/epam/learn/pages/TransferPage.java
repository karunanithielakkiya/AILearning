package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferPage {
    WebDriver driver;

    @FindBy(id = "accountNumber")
    WebElement accountNumberField;

    @FindBy(id = "amount")
    WebElement amountField;

    @FindBy(id = "recipientName")
    WebElement recipientNameField;

    @FindBy(id = "submitButton")
    WebElement submitButton;

    @FindBy(id = "errorMessage")
    WebElement errorMessage;

    @FindBy(id = "transferDetails")
    WebElement transferDetails;

    public TransferPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterAccountNumber(String accountNumber) {
        accountNumberField.sendKeys(accountNumber);
    }

    public void enterAmount(String amount) {
        amountField.sendKeys(amount);
    }

    public void enterRecipientName(String recipientName) {
        recipientNameField.sendKeys(recipientName);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isTransferVisible() {
        return transferDetails.isDisplayed();
    }
}
