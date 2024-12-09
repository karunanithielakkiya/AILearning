package com.epam.learn.stepdefinition;

import com.epam.learn.pages.TransferSchedulingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TransferSchedulingSteps {
    private WebDriver driver;
    private TransferSchedulingPage transferSchedulingPage;

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        // Assume user is logged in
    }

    @Given("the user is on the transfer scheduling page")
    public void theUserIsOnTheTransferSchedulingPage() {
        driver = new ChromeDriver();
        transferSchedulingPage = new TransferSchedulingPage(driver);
        driver.get("http://example.com/transfer-scheduling");
    }

    @When("the user selects a transfer date within 6 months from the current date")
    public void theUserSelectsAValidTransferDate() {
        transferSchedulingPage.enterTransferDate("2023-06-15");
    }

    @When("the selected date is a weekday and not a holiday")
    public void theSelectedDateIsAWeekdayAndNotAHoliday() {
        // Assume date is valid
    }

    @Then("the transfer date should be accepted")
    public void theTransferDateShouldBeAccepted() {
        String confirmationMessage = transferSchedulingPage.getConfirmationMessage();
        Assert.assertEquals("Transfer date scheduled successfully", confirmationMessage);
    }

    @Then("the user should see a confirmation message {string}")
    public void theUserShouldSeeAConfirmationMessage(String expectedMessage) {
        String actualMessage = transferSchedulingPage.getConfirmationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("the user selects a transfer date {string}")
    public void theUserSelectsATransferDate(String transferDate) {
        transferSchedulingPage.enterTransferDate(transferDate);
    }

    @Then("the system should display an error message {string}")
    public void theSystemShouldDisplayAnErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = transferSchedulingPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("the transfer date should not be accepted")
    public void theTransferDateShouldNotBeAccepted() {
        String errorMessage = transferSchedulingPage.getErrorMessage();
        Assert.assertNotNull(errorMessage);
    }

    @When("the user tests the transfer date selection functionality on different devices")
    public void theUserTestsTheTransferDateSelectionFunctionalityOnDifferentDevices() {
        // Implement device compatibility checks
    }
}
