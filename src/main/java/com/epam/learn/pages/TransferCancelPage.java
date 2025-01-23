package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferCancelPage {

    WebDriver driver;

    @FindBy(id = "cancelButton")
    private WebElement cancelButton;

    @FindBy(id = "confirmationPrompt")
    private WebElement confirmationPrompt;

    @FindBy(id = "confirmationMessage")
    private WebElement confirmationMessage;

    @FindBy(id = "completedMessage")
    private WebElement completedMessage;

    public TransferCancelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToTransferDetails() {
        // Code to navigate to the transfer details page
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public boolean isCancelButtonVisible() {
        return cancelButton.isDisplayed();
    }

    public boolean isCancelButtonEnabled() {
        return cancelButton.isEnabled();
    }

    public void confirmCancellation() {
        // Code to confirm the cancellation
    }

    public void dismissConfirmation() {
        // Code to dismiss the confirmation
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public String getCompletedMessage() {
        return completedMessage.getText();
    }
}
