package com.epam.learn.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.epam.learn.pages.TransferDateEntryPage;

public class TransferDateEntrySteps {

    TransferDateEntryPage transferDateEntryPage;

    @Given("the user is logged into the system")
    public void the_user_is_logged_into_the_system() {
        // Assume user is already logged in
    }

    @Given("the user navigates to the transfer date entry screen")
    public void the_user_navigates_to_the_transfer_date_entry_screen() {
        // Navigate to the transfer date entry screen
        transferDateEntryPage = new TransferDateEntryPage(driver);
    }

    @When("the user enters a date within 6 months from the current date")
    public void the_user_enters_a_date_within_6_months_from_the_current_date() {
        transferDateEntryPage.enterDate("2024-04-15"); // Example date
    }

    @When("the user enters a past date")
    public void the_user_enters_a_past_date() {
        transferDateEntryPage.enterDate("2023-01-01"); // Example past date
    }

    @When("the user enters a date that falls on a weekend")
    public void the_user_enters_a_date_that_falls_on_a_weekend() {
        transferDateEntryPage.enterDate("2024-04-13"); // Example weekend date
    }

    @When("the user enters a date that is a recognized holiday")
    public void the_user_enters_a_date_that_is_a_recognized_holiday() {
        transferDateEntryPage.enterDate("2024-12-25"); // Example holiday date
    }

    @When("the user submits the date")
    public void the_user_submits_the_date() {
        transferDateEntryPage.submitDate();
    }

    @Then("the system accepts the date without any error messages")
    public void the_system_accepts_the_date_without_any_error_messages() {
        String errorMessage = transferDateEntryPage.getErrorMessage();
        Assert.assertTrue("Error message should be empty", errorMessage.isEmpty());
    }

    @Then("the system displays an error message indicating that past dates are not allowed")
    public void the_system_displays_an_error_message_indicating_that_past_dates_are_not_allowed() {
        String errorMessage = transferDateEntryPage.getErrorMessage();
        Assert.assertEquals("Past dates are not allowed", errorMessage);
    }

    @Then("the system displays an error message indicating that weekend dates are not allowed")
    public void the_system_displays_an_error_message_indicating_that_weekend_dates_are_not_allowed() {
        String errorMessage = transferDateEntryPage.getErrorMessage();
        Assert.assertEquals("Weekend dates are not allowed", errorMessage);
    }

    @Then("the system displays an error message indicating that holiday dates are not allowed")
    public void the_system_displays_an_error_message_indicating_that_holiday_dates_are_not_allowed() {
        String errorMessage = transferDateEntryPage.getErrorMessage();
        Assert.assertEquals("Holiday dates are not allowed", errorMessage);
    }
}
