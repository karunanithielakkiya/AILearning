package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferSchedulingPage {
    WebDriver driver;

    @FindBy(id = "transferDateInput")
    private WebElement transferDateInput;

    @FindBy(id = "confirmationMessage")
    private WebElement confirmationMessage;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    public TransferSchedulingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterTransferDate(String date) {
        transferDateInput.clear();
        transferDateInput.sendKeys(date);
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
