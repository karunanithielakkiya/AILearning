package com.epam.learn.stepdefinition;

import com.epam.learn.pages.TransferPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TransferSteps {
    private WebDriver driver = new ChromeDriver();
    private TransferPage transferPage = new TransferPage(driver);

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        // Code to ensure the user is logged in
    }

    @And("the user is on the transfer page")
    public void theUserIsOnTheTransferPage() {
        // Code to navigate to the transfer page
    }

    @When("the user selects 'One-Time Transfer' option")
    public void theUserSelectsOneTimeTransferOption() {
        // Code to select one-time transfer option
    }

    @And("enters valid 'FROM' account details")
    public void entersValidFROMAccountDetails() {
        transferPage.enterFromAccount("123456789");
    }

    @And("enters valid 'TO' account details")
    public void entersValidTOAccountDetails() {
        transferPage.enterToAccount("987654321");
    }

    @And("enters a valid transfer amount")
    public void entersAValidTransferAmount() {
        transferPage.enterTransferAmount("1000");
    }

    @And("selects a valid transfer date")
    public void selectsAValidTransferDate() {
        transferPage.selectTransferDate("2023-12-01");
    }

    @And("clicks on the \"Submit\" button")
    public void clicksOnTheSubmitButton() {
        transferPage.submitTransfer();
    }

    @Then("the transfer should be successfully submitted")
    public void theTransferShouldBeSuccessfullySubmitted() {
        // Code to verify successful submission
    }

    @And("a confirmation message should be displayed")
    public void aConfirmationMessageShouldBeDisplayed() {
        // Code to verify confirmation message
    }

    @And("enters an invalid transfer amount")
    public void entersAnInvalidTransferAmount() {
        transferPage.enterTransferAmount("-1000");
    }

    @Then("an error message should be displayed indicating the invalid amount")
    public void anErrorMessageShouldBeDisplayedIndicatingTheInvalidAmount() {
        // Code to verify error message for invalid amount
    }

    @And("selects a past transfer date")
    public void selectsAPastTransferDate() {
        transferPage.selectTransferDate("2022-01-01");
    }

    @Then("an error message should be displayed indicating the invalid date selection")
    public void anErrorMessageShouldBeDisplayedIndicatingTheInvalidDateSelection() {
        // Code to verify error message for past date
    }

    @Given("the user has initiated a one-time transfer")
    public void theUserHasInitiatedAOneTimeTransfer() {
        // Code to ensure a transfer has been initiated
    }

    @When("the user navigates to the transfer details page")
    public void theUserNavigatesToTheTransferDetailsPage() {
        // Code to navigate to transfer details page
    }

    @And("clicks on the \"Cancel Transfer\" button")
    public void clicksOnTheCancelTransferButton() {
        transferPage.cancelTransfer();
    }

    @Then("the transfer should be successfully canceled")
    public void theTransferShouldBeSuccessfullyCanceled() {
        // Code to verify successful cancellation
    }
}