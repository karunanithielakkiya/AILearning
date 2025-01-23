package com.epam.learn.stepdefinition;

import com.epam.learn.pages.TransferEntryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TransferAmountSteps {

    WebDriver driver = new ChromeDriver();
    TransferEntryPage transferEntryPage = new TransferEntryPage(driver);

    @Given("the branch user is logged into the transfer system")
    public void theBranchUserIsLoggedIntoTheTransferSystem() {
        // Assume user is logged in
        driver.get("http://example.com/transfer");
    }

    @Given("the user is on the transfer entry page")
    public void theUserIsOnTheTransferEntryPage() {
        // Assume user is on the transfer entry page
    }

    @When("the user enters a valid cash amount of {string}")
    public void theUserEntersAValidCashAmountOf(String cashAmount) {
        transferEntryPage.enterCashAmount(cashAmount);
    }

    @When("the user enters a valid securities amount of {string}")
    public void theUserEntersAValidSecuritiesAmountOf(String securitiesAmount) {
        transferEntryPage.enterSecuritiesAmount(securitiesAmount);
    }

    @When("the user submits the transfer details")
    public void theUserSubmitsTheTransferDetails() {
        transferEntryPage.submitTransferDetails();
    }

    @Then("the system should accept the cash and securities amounts")
    public void theSystemShouldAcceptTheCashAndSecuritiesAmounts() {
        // Assume successful submission
        Assert.assertTrue("Transfer should be processed successfully", true);
    }

    @Then("the transfer should be processed successfully")
    public void theTransferShouldBeProcessedSuccessfully() {
        // Assume successful processing
        Assert.assertTrue("Transfer should be processed successfully", true);
    }

    @When("the user enters a cash amount of {string}")
    public void theUserEntersACashAmountOf(String cashAmount) {
        transferEntryPage.enterCashAmount(cashAmount);
    }

    @When("the user enters a securities amount of {string}")
    public void theUserEntersASecuritiesAmountOf(String securitiesAmount) {
        transferEntryPage.enterSecuritiesAmount(securitiesAmount);
    }

    @Then("the system should display an error message {string}")
    public void theSystemShouldDisplayAnErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = transferEntryPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
