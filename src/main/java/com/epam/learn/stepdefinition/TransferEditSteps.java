package com.epam.learn.stepdefinition;

import com.epam.learn.pages.TransferEditPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TransferEditSteps {
    WebDriver driver = new ChromeDriver();
    TransferEditPage transferEditPage = new TransferEditPage(driver);

    @Given("the branch user is logged into the system")
    public void theBranchUserIsLoggedIntoTheSystem() {
        // Assume user is already logged in
    }

    @And("the user has submitted a transfer request")
    public void theUserHasSubmittedATransferRequest() {
        // Assume transfer request is already submitted
    }

    @When("the user navigates to the submitted transfer request")
    public void theUserNavigatesToTheSubmittedTransferRequest() {
        transferEditPage.navigateToSubmittedRequest();
    }

    @And("the user selects the option to edit the transfer date")
    public void theUserSelectsTheOptionToEditTheTransferDate() {
        transferEditPage.selectEditTransferDate();
    }

    @And("the user enters a new valid transfer date")
    public void theUserEntersANewValidTransferDate(DataTable dataTable) {
        String newDate = dataTable.cell(0, 0);
        transferEditPage.enterTransferDate(newDate);
    }

    @And("the user confirms the changes")
    public void theUserConfirmsTheChanges() {
        transferEditPage.confirmChanges();
    }

    @Then("the system should update the transfer date successfully")
    public void theSystemShouldUpdateTheTransferDateSuccessfully() {
        Assert.assertEquals("Transfer date updated successfully", transferEditPage.getConfirmationMessage());
    }

    @When("the user enters an invalid transfer date")
    public void theUserEntersAnInvalidTransferDate() {
        transferEditPage.enterTransferDate("invalid-date");
    }

    @Then("the system should display an error message {string}")
    public void theSystemShouldDisplayAnErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, transferEditPage.getErrorMessage());
    }

    @When("the user enters a past date")
    public void theUserEntersAPastDate() {
        transferEditPage.enterTransferDate("2023-01-01");
    }

    @Then("the system should display an error message {string}")
    public void theSystemShouldDisplayAnErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, transferEditPage.getErrorMessage());
    }

    @When("the user decides to cancel the changes")
    public void theUserDecidesToCancelTheChanges() {
        transferEditPage.cancelChanges();
    }

    @Then("the system should retain the original transfer date")
    public void theSystemShouldRetainTheOriginalTransferDate() {
        Assert.assertNotEquals("Transfer date updated successfully", transferEditPage.getConfirmationMessage());
    }
}
