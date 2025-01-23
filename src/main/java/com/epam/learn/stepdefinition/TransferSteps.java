package com.epam.learn.stepdefinition;

import com.epam.learn.pages.TransferPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class TransferSteps {
    WebDriver driver = new ChromeDriver();
    TransferPage transferPage = new TransferPage(driver);

    @Given("the branch user is logged into the system")
    public void theBranchUserIsLoggedIntoTheSystem() {
        // Assume user is logged in
    }

    @Given("the branch user is on the transfer submission page")
    public void theBranchUserIsOnTheTransferSubmissionPage() {
        driver.get("http://example.com/transfer");
    }

    @When("the branch user enters all required transfer details correctly")
    public void theBranchUserEntersAllRequiredTransferDetailsCorrectly(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            transferPage.enterAccountNumber(row.get("accountNumber"));
            transferPage.enterAmount(row.get("amount"));
            transferPage.enterRecipientName(row.get("recipientName"));
        }
    }

    @When("the branch user clicks on the submit button")
    public void theBranchUserClicksOnTheSubmitButton() {
        transferPage.clickSubmitButton();
    }

    @Then("the transfer should be submitted successfully")
    public void theTransferShouldBeSubmittedSuccessfully() {
        Assert.assertTrue(transferPage.isTransferVisible());
    }

    @Then("the transfer should be visible on the Transfer Details screen")
    public void theTransferShouldBeVisibleOnTheTransferDetailsScreen() {
        Assert.assertTrue(transferPage.isTransferVisible());
    }

    @When("the branch user enters {string} incorrectly or leaves it blank")
    public void theBranchUserEntersIncorrectlyOrLeavesItBlank(String missingDetail) {
        if (missingDetail.equals("account number")) {
            transferPage.enterAccountNumber("");
        } else if (missingDetail.equals("amount")) {
            transferPage.enterAmount("");
        } else if (missingDetail.equals("recipient name")) {
            transferPage.enterRecipientName("");
        }
    }

    @Then("the transfer should not be submitted")
    public void theTransferShouldNotBeSubmitted() {
        Assert.assertFalse(transferPage.isTransferVisible());
    }

    @Then("the user should receive an error message {string}")
    public void theUserShouldReceiveAnErrorMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, transferPage.getErrorMessage());
    }
}
