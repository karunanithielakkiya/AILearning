package com.epam.learn.stepdefinition;

import com.epam.learn.pages.TransferCancelPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TransferCancelSteps {

    WebDriver driver = new ChromeDriver();
    TransferCancelPage transferCancelPage = new TransferCancelPage(driver);

    @When("the branch user navigates to the transfer details page")
    public void navigateToTransferDetailsPage() {
        transferCancelPage.navigateToTransferDetails();
    }

    @And("the branch user clicks on the cancel button")
    public void clickCancelButton() {
        transferCancelPage.clickCancelButton();
    }

    @Then("the system should display a confirmation prompt")
    public void verifyConfirmationPrompt() {
        // Implement verification of confirmation prompt
    }

    @And("the branch user confirms the cancellation")
    public void confirmCancellation() {
        transferCancelPage.confirmCancellation();
    }

    @Then("the transfer should be successfully cancelled")
    public void verifyTransferCancellation() {
        Assert.assertEquals("Transfer cancelled successfully", transferCancelPage.getConfirmationMessage());
    }

    @And("the system should display a cancellation confirmation message")
    public void verifyCancellationConfirmationMessage() {
        Assert.assertEquals("Transfer cancelled successfully", transferCancelPage.getConfirmationMessage());
    }

    @Then("the cancel button should be visible and enabled")
    public void verifyCancelButtonVisibilityAndEnabled() {
        Assert.assertTrue(transferCancelPage.isCancelButtonVisible());
        Assert.assertTrue(transferCancelPage.isCancelButtonEnabled());
    }

    @But("the branch user dismisses the confirmation prompt")
    public void dismissConfirmationPrompt() {
        transferCancelPage.dismissConfirmation();
    }

    @Then("the transfer should not be cancelled")
    public void verifyTransferNotCancelled() {
        // Implement verification that transfer is not cancelled
    }

    @And("the system should display the transfer details page")
    public void verifyTransferDetailsPageDisplayed() {
        // Implement verification of transfer details page
    }

    @When("the branch user navigates to the transfer details page of a completed transfer")
    public void navigateToCompletedTransferDetailsPage() {
        transferCancelPage.navigateToTransferDetails();
        // Additional code to ensure it's a completed transfer
    }

    @Then("the cancel button should not be visible")
    public void verifyCancelButtonNotVisible() {
        Assert.assertFalse(transferCancelPage.isCancelButtonVisible());
    }

    @Then("the system should display a message {string}")
    public void theSystemShouldDisplayAMessage(String message) {
        Assert.assertEquals(message, transferCancelPage.getCompletedMessage());
    }
}
