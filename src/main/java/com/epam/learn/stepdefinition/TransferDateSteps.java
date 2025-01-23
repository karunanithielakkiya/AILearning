package com.epam.learn.stepdefinition;

import com.epam.learn.pages.TransferDatePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TransferDateSteps {

    WebDriver driver = new ChromeDriver();
    TransferDatePage transferDatePage = new TransferDatePage(driver);

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        // Assume user is logged in
    }

    @Given("the user is on the transfer date entry page")
    public void theUserIsOnTheTransferDateEntryPage() {
        driver.get("http://example.com/transfer-date-entry");
    }

    @When("the user enters a transfer date that is within 6 months from today")
    public void theUserEntersAValidTransferDate() {
        transferDatePage.enterTransferDate("2024-04-01"); // Example date within 6 months
    }

    @When("the date is a weekday and not a holiday")
    public void theDateIsAWeekdayAndNotAHoliday() {
        // Assume the date is a valid weekday and not a holiday
    }

    @Then("the system should accept the transfer date")
    public void theSystemShouldAcceptTheTransferDate() {
        Assert.assertEquals("Transfer date accepted", transferDatePage.getConfirmationMessage());
    }

    @When("the user enters a transfer date {string}")
    public void theUserEntersATransferDate(String transferDate) {
        transferDatePage.enterTransferDate(transferDate);
    }

    @Then("the system should display an error message {string}")
    public void theSystemShouldDisplayAnErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, transferDatePage.getErrorMessage());
    }

    @Then("the transfer date should not be accepted")
    public void theTransferDateShouldNotBeAccepted() {
        Assert.assertNotEquals("Transfer date accepted", transferDatePage.getConfirmationMessage());
    }

    @When("the user attempts to enter a transfer date on a weekend or holiday")
    public void theUserAttemptsToEnterATransferDateOnAWeekendOrHoliday() {
        transferDatePage.enterTransferDate("2023-12-25"); // Example holiday date
    }

    @Then("the system should prevent the entry")
    public void theSystemShouldPreventTheEntry() {
        Assert.assertEquals("Please select a valid weekday that is not a holiday", transferDatePage.getErrorMessage());
    }

    @Then("the system should display a message {string}")
    public void theSystemShouldDisplayAMessage(String message) {
        Assert.assertEquals(message, transferDatePage.getErrorMessage());
    }

    @When("the user attempts to enter a past transfer date")
    public void theUserAttemptsToEnterAPastTransferDate() {
        transferDatePage.enterTransferDate("2023-01-01");
    }

    @Then("the system should prevent the entry")
    public void theSystemShouldPreventTheEntry() {
        Assert.assertEquals("Transfer date cannot be in the past", transferDatePage.getErrorMessage());
    }
}
