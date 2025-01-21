package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferDateEntryPage {

    WebDriver driver;

    @FindBy(id = "dateInput")
    WebElement dateInput;

    @FindBy(id = "submitButton")
    WebElement submitButton;

    @FindBy(id = "errorMessage")
    WebElement errorMessage;

    public TransferDateEntryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterDate(String date) {
        dateInput.clear();
        dateInput.sendKeys(date);
    }

    public void submitDate() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
