package com.example.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferPage {
    WebDriver driver;

    @FindBy(id = "oneTimeTransferOption")
    WebElement oneTimeTransferOption;

    @FindBy(id = "recurringTransferOption")
    WebElement recurringTransferOption;

    @FindBy(id = "transferDetails")
    WebElement transferDetails;

    @FindBy(id = "confirmTransfer")
    WebElement confirmTransfer;

    @FindBy(id = "confirmationMessage")
    WebElement confirmationMessage;

    public TransferPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToTransferSection() {
        // Code to navigate to the transfer section
    }

    public boolean isOneTimeTransferOptionVisible() {
        return oneTimeTransferOption.isDisplayed();
    }

    public void selectOneTimeTransferOption() {
        oneTimeTransferOption.click();
    }

    public boolean isRecurringTransferOptionVisible() {
        return recurringTransferOption.isDisplayed();
    }

    public void enterTransferDetails(String details) {
        transferDetails.sendKeys(details);
    }

    public void confirmTransfer() {
        confirmTransfer.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}
