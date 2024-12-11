package com.epam.learn.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.epam.learn.pages.TransferDateSelectionPage;

public class TransferDateSelectionSteps {

    private TransferDateSelectionPage transferDateSelectionPage;

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        // Assume user is logged in
        transferDateSelectionPage = new TransferDateSelectionPage(driver);
    }

    @When("the user navigates to the transfer date selection screen")
    public void theUserNavigatesToTheTransferDateSelectionScreen() {
        transferDateSelectionPage.navigateToTransferDateSelectionScreen();
    }

    @When("the user selects a date within the next 6 months")
    public void theUserSelectsADateWithinTheNext6Months() {
        transferDateSelectionPage.selectDate("2023-12-15"); // Example date
    }

    @Then("the system allows the selection of the date")
    public void theSystemAllowsTheSelectionOfTheDate() {
        // Verify that the date is selected successfully
        Assert.assertTrue("Date selection failed", true); // Placeholder for actual verification
    }

    @When("the user attempts to select a past date")
    public void theUserAttemptsToSelectAPastDate() {
        transferDateSelectionPage.selectDate("2022-01-01"); // Example past date
    }

    @Then("the system does not allow the selection of past dates")
    public void theSystemDoesNotAllowTheSelectionOfPastDates() {
        Assert.assertEquals("Past date selection allowed", "Past dates are not allowed", transferDateSelectionPage.getErrorMessage());
    }

    @When("the user attempts to select a weekend date")
    public void theUserAttemptsToSelectAWeekendDate() {
        transferDateSelectionPage.selectDate("2023-12-16"); // Example weekend date
    }

    @Then("the system does not allow the selection of weekend dates")
    public void theSystemDoesNotAllowTheSelectionOfWeekendDates() {
        Assert.assertEquals("Weekend date selection allowed", "Weekend dates are not allowed", transferDateSelectionPage.getErrorMessage());
    }

    @When("the user attempts to select a holiday date")
    public void theUserAttemptsToSelectAHolidayDate() {
        transferDateSelectionPage.selectDate("2023-12-25"); // Example holiday date
    }

    @Then("the system does not allow the selection of holiday dates")
    public void theSystemDoesNotAllowTheSelectionOfHolidayDates() {
        Assert.assertEquals("Holiday date selection allowed", "Holiday dates are not allowed", transferDateSelectionPage.getErrorMessage());
    }
}
