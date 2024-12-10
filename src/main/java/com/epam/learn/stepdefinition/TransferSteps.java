package com.example.automation;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TransferSteps extends BaseStep {
    TransferPage transferPage;

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        // Code to ensure the user is logged in
    }

    @Given("the user is logged into the system and has sufficient balance")
    public void theUserIsLoggedIntoTheSystemAndHasSufficientBalance() {
        // Code to ensure the user is logged in and has sufficient balance
    }

    @When("the user navigates to the transfer section")
    public void theUserNavigatesToTheTransferSection() {
        transferPage = new TransferPage(driver);
        transferPage.navigateToTransferSection();
    }

    @Then("the one-time transfer option should be visible and selectable")
    public void theOneTimeTransferOptionShouldBeVisibleAndSelectable() {
        Assert.assertTrue(transferPage.isOneTimeTransferOptionVisible());
    }

    @Then("the recurring transfer option should not be visible or selectable")
    public void theRecurringTransferOptionShouldNotBeVisibleOrSelectable() {
        Assert.assertFalse(transferPage.isRecurringTransferOptionVisible());
    }

    @And("selects the one-time transfer option")
    public void selectsTheOneTimeTransferOption() {
        transferPage.selectOneTimeTransferOption();
    }

    @And("enters the transfer details")
    public void entersTheTransferDetails(DataTable dataTable) {
        // Assuming dataTable contains transfer details
        String details = dataTable.asList().get(0);
        transferPage.enterTransferDetails(details);
    }

    @And("confirms the transfer")
    public void confirmsTheTransfer() {
        transferPage.confirmTransfer();
    }

    @Then("the transfer should be completed successfully")
    public void theTransferShouldBeCompletedSuccessfully() {
        Assert.assertEquals("Transfer Successful", transferPage.getConfirmationMessage());
    }

    @Then("an appropriate message should be displayed if attempted")
    public void anAppropriateMessageShouldBeDisplayedIfAttempted() {
        // Code to verify the appropriate message is displayed
    }
}
