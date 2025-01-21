package com.epam.learn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferPage {
    private WebDriver driver;

    private By fromAccountField = By.id("fromAccount");
    private By toAccountField = By.id("toAccount");
    private By transferAmountField = By.id("transferAmount");
    private By transferDateField = By.id("transferDate");
    private By submitButton = By.id("submitTransfer");
    private By cancelButton = By.id("cancelTransfer");

    public TransferPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFromAccount(String fromAccount) {
        driver.findElement(fromAccountField).sendKeys(fromAccount);
    }

    public void enterToAccount(String toAccount) {
        driver.findElement(toAccountField).sendKeys(toAccount);
    }

    public void enterTransferAmount(String amount) {
        driver.findElement(transferAmountField).sendKeys(amount);
    }

    public void selectTransferDate(String date) {
        driver.findElement(transferDateField).sendKeys(date);
    }

    public void submitTransfer() {
        driver.findElement(submitButton).click();
    }

    public void cancelTransfer() {
        driver.findElement(cancelButton).click();
    }
}