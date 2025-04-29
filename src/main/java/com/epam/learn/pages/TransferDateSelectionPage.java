package com.example.transfer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferDateSelectionPage {
    WebDriver driver;

    @FindBy(id = "datePicker")
    WebElement datePicker;

    @FindBy(id = "errorMessage")
    WebElement errorMessage;

    public TransferDateSelectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectDate(String date) {
        datePicker.sendKeys(date);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
