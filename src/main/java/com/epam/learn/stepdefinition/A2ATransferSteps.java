package com.epam.learn.stepdefinition;

import com.epam.learn.pages.A2ATransferPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class A2ATransferSteps extends BaseStep {

    private A2ATransferPage a2aTransferPage;

    @Given("the user is logged into the BAM system")
    public void theUserIsLoggedIntoTheBAMSystem() {
        // Assume user is already logged in for simplicity
        driver.get("http://example.com/bam");
    }

    @When("the user navigates to the A2A transfer section")
    public void theUserNavigatesToTheA2ATransferSection() {
        a2aTransferPage = new A2ATransferPage(driver);
        // Navigate to A2A transfer section
    }

    @And("the user enters a valid FROM account number")
    public void theUserEntersAValidFROMAccountNumber(DataTable dataTable) {
        List<String> data = dataTable.asList();
        a2aTransferPage.enterFromAccount(data.get(0));
    }

    @And("the user enters a valid TO account number")
    public void theUserEntersAValidTOAccountNumber(DataTable dataTable) {
        List<String> data = dataTable.asList();
        a2aTransferPage.enterToAccount(data.get(0));
    }

    @And("the user enters an invalid FROM account number")
    public void theUserEntersAnInvalidFROMAccountNumber(DataTable dataTable) {
        List<String> data = dataTable.asList();
        a2aTransferPage.enterFromAccount(data.get(0));
    }

    @And("the user enters an invalid TO account number")
    public void theUserEntersAnInvalidTOAccountNumber(DataTable dataTable) {
        List<String> data = dataTable.asList();
        a2aTransferPage.enterToAccount(data.get(0));
    }

    @And("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String button) {
        a2aTransferPage.clickSubmit();
    }

    @Then("the system accepts the account details and proceeds to the next step without errors")
    public void theSystemAcceptsTheAccountDetailsAndProceedsToTheNextStepWithoutErrors() {
        // Verify the next step is reached, assuming no error message is displayed
        Assert.assertTrue("No error message should be displayed", a2aTransferPage.getErrorMessage().isEmpty());
    }

    @Then("the system displays an error message indicating that the FROM account is invalid")
    public void theSystemDisplaysAnErrorMessageIndicatingThatTheFROMAccountIsInvalid() {
        Assert.assertEquals("Invalid FROM account", a2aTransferPage.getErrorMessage());
    }

    @Then("the system displays an error message indicating that the TO account is invalid")
    public void theSystemDisplaysAnErrorMessageIndicatingThatTheTOAccountIsInvalid() {
        Assert.assertEquals("Invalid TO account", a2aTransferPage.getErrorMessage());
    }

    @Then("the system displays error messages indicating that both accounts are invalid")
    public void theSystemDisplaysErrorMessagesIndicatingThatBothAccountsAreInvalid() {
        Assert.assertEquals("Invalid FROM and TO accounts", a2aTransferPage.getErrorMessage());
    }
}
