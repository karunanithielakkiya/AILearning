package com.epam.learn.stepdefinition;

import com.epam.learn.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserRegistrationSteps {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Given("the user is on the registration page")
    public void the_user_is_on_the_registration_page() {
        driver = new ChromeDriver();
        driver.get("http://example.com/registration");
        registrationPage = new RegistrationPage(driver);
    }

    @When("the user enters a unique email address {string} in the email field")
    public void the_user_enters_a_unique_email_address_in_the_email_field(String email) {
        registrationPage.enterEmail(email);
    }

    @When("the user enters a valid password {string} in the password field")
    public void the_user_enters_a_valid_password_in_the_password_field(String password) {
        registrationPage.enterPassword(password);
    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String button) {
        if (button.equals("Register")) {
            registrationPage.clickRegister();
        }
    }

    @Then("the user should be successfully registered")
    public void the_user_should_be_successfully_registered() {
        Assert.assertEquals("Registration successful!", registrationPage.getConfirmationMessage());
    }

    @Then("a confirmation message should be displayed")
    public void a_confirmation_message_should_be_displayed() {
        Assert.assertTrue(registrationPage.getConfirmationMessage().contains("successfully registered"));
    }

    @When("the user enters a weak password {string} in the password field")
    public void the_user_enters_a_weak_password_in_the_password_field(String password) {
        registrationPage.enterPassword(password);
    }

    @Then("the system should display a message indicating that the password is too weak")
    public void the_system_should_display_a_message_indicating_that_the_password_is_too_weak() {
        Assert.assertTrue(registrationPage.getPasswordStrengthMessage().contains("password is too weak"));
    }

    @Then("suggest using a stronger password")
    public void suggest_using_a_stronger_password() {
        Assert.assertTrue(registrationPage.getPasswordStrengthMessage().contains("use a stronger password"));
    }
}
