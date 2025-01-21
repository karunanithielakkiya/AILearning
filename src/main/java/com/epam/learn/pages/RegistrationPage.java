package com.epam.learn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "registerButton")
    private WebElement registerButton;

    @FindBy(id = "confirmationMessage")
    private WebElement confirmationMessage;

    @FindBy(id = "passwordStrengthMessage")
    private WebElement passwordStrengthMessage;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickRegister() {
        registerButton.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public String getPasswordStrengthMessage() {
        return passwordStrengthMessage.getText();
    }
}
