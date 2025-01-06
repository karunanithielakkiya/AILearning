package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferDateSelectionPage {

    WebDriver driver;

    @FindBy(id = "transferDateInput")
    private WebElement transferDateInput;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    public TransferDateSelectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToTransferDateSelectionScreen() {
        // Code to navigate to the transfer date selection screen
    }

    public void selectDate(String date) {
        transferDateInput.clear();
        transferDateInput.sendKeys(date);
        transferDateInput.submit();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
