package com.example.transfer;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class TransferDateSelectionSteps extends BaseStep {
    TransferDateSelectionPage transferDateSelectionPage;

    @Given("the user is on the transfer date selection page")
    public void the_user_is_on_the_transfer_date_selection_page() {
        driver.get("http://example.com/transfer-date-selection");
        transferDateSelectionPage = new TransferDateSelectionPage(driver);
    }

    @When("the user attempts to select a transfer date")
    public void the_user_attempts_to_select_a_transfer_date() {
        // This step is a placeholder for any pre-selection actions
    }

    @When("the user selects a date within 6 months from the current date")
    public void the_user_selects_a_date_within_6_months_from_the_current_date(DataTable dataTable) {
        List<String> data = dataTable.asList();
        String date = data.get(0);
        transferDateSelectionPage.selectDate(date);
    }

    @Then("the date should be accepted as a valid transfer date")
    public void the_date_should_be_accepted_as_a_valid_transfer_date() {
        Assert.assertTrue("Date should be accepted", transferDateSelectionPage.getErrorMessage().isEmpty());
    }

    @When("the user selects a past date")
    public void the_user_selects_a_past_date(DataTable dataTable) {
        List<String> data = dataTable.asList();
        String date = data.get(0);
        transferDateSelectionPage.selectDate(date);
    }

    @Then("the system should display an error message {string}")
    public void the_system_should_display_an_error_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, transferDateSelectionPage.getErrorMessage());
    }

    @Then("the date should not be accepted as a valid transfer date")
    public void the_date_should_not_be_accepted_as_a_valid_transfer_date() {
        Assert.assertFalse("Date should not be accepted", transferDateSelectionPage.getErrorMessage().isEmpty());
    }

    @When("the user selects a weekend date")
    public void the_user_selects_a_weekend_date(DataTable dataTable) {
        List<String> data = dataTable.asList();
        String date = data.get(0);
        transferDateSelectionPage.selectDate(date);
    }

    @When("the user selects a holiday")
    public void the_user_selects_a_holiday(DataTable dataTable) {
        List<String> data = dataTable.asList();
        String date = data.get(0);
        transferDateSelectionPage.selectDate(date);
    }

    @When("the user selects a valid weekday within 6 months from the current date")
    public void the_user_selects_a_valid_weekday_within_6_months_from_the_current_date(DataTable dataTable) {
        List<String> data = dataTable.asList();
        String date = data.get(0);
        transferDateSelectionPage.selectDate(date);
    }
}
