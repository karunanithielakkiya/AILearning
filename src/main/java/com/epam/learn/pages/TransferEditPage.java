package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferEditPage {

    WebDriver driver;

    @FindBy(id = "navigateToRequest")
    WebElement navigateToRequestButton;

    @FindBy(id = "editTransferDate")
    WebElement editTransferDateButton;

    @FindBy(id = "transferDateInput")
    WebElement transferDateInput;

    @FindBy(id = "confirmChanges")
    WebElement confirmChangesButton;

    @FindBy(id = "cancelChanges")
    WebElement cancelChangesButton;

    @FindBy(id = "confirmationMessage")
    WebElement confirmationMessage;

    @FindBy(id = "errorMessage")
    WebElement errorMessage;

    public TransferEditPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToSubmittedRequest() {
        navigateToRequestButton.click();
    }

    public void selectEditTransferDate() {
        editTransferDateButton.click();
    }

    public void enterTransferDate(String date) {
        transferDateInput.clear();
        transferDateInput.sendKeys(date);
    }

    public void confirmChanges() {
        confirmChangesButton.click();
    }

    public void cancelChanges() {
        cancelChangesButton.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
