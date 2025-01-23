package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferEntryPage {
    WebDriver driver;

    @FindBy(id = "cashAmount")
    private WebElement cashAmountInput;

    @FindBy(id = "securitiesAmount")
    private WebElement securitiesAmountInput;

    @FindBy(id = "submitTransfer")
    private WebElement submitButton;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    public TransferEntryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterCashAmount(String amount) {
        cashAmountInput.clear();
        cashAmountInput.sendKeys(amount);
    }

    public void enterSecuritiesAmount(String amount) {
        securitiesAmountInput.clear();
        securitiesAmountInput.sendKeys(amount);
    }

    public void submitTransferDetails() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
