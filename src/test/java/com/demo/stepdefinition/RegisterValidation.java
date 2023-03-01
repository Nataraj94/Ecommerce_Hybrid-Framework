package com.demo.stepdefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pagefactory.AccountSuccessPage;
import pagefactory.HomePage;
import pagefactory.RegisterPage;
import reuseable.BaseClass;
import utils.CommonUtils;

import java.io.IOException;
import java.util.Map;

public class RegisterValidation {

    WebDriver driver;
    private static HomePage homePage;
    private static RegisterPage registerPage;
    private static AccountSuccessPage accountSuccessPage;


    @Given("User navigates to Register Account page")
    public void user_navigates_to_register_account_page() throws IOException {

        driver= BaseClass.browserCall();
        homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.selectRegisterOption();

    }

    @When("User enters the details into below fields")
    public void user_enters_the_details_into_below_fields(DataTable dataTable) {

        Map<String,String> dataMap=dataTable.asMap(String.class,String.class);

        registerPage = new RegisterPage(driver);
        CommonUtils commonUtils = new CommonUtils();


        registerPage.enterFirstName(dataMap.get("firstName"));
        registerPage.enterLastName(dataMap.get("lastName"));
        registerPage.enterEmail(commonUtils.getEmailWithTimeStamp());
        registerPage.enterTelephoneNo(dataMap.get("telephone"));
        registerPage.enterPassword(dataMap.get("password"));
        registerPage.enterConfirmPassword(dataMap.get("password"));

    }

    @When("User enters the details into below fields with duplicate email")
    public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {

        Map<String,String> dataMap=dataTable.asMap(String.class,String.class);

        registerPage = new RegisterPage(driver);
        CommonUtils commonUtils = new CommonUtils();


        registerPage.enterFirstName(dataMap.get("firstName"));
        registerPage.enterLastName(dataMap.get("lastName"));
        registerPage.enterEmail(commonUtils.getEmailWithTimeStamp());
        registerPage.enterTelephoneNo(dataMap.get("telephone"));
        registerPage.enterPassword(dataMap.get("password"));
        registerPage.enterConfirmPassword(dataMap.get("password"));

    }

    @When("User selects Privacy Policy")
    public void user_selects_privacy_policy() {

        registerPage.clickPrivacyPolicy();
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {

        registerPage.clickContinueButton();

    }

    @Then("User account should get created successfully")
    public void user_account_should_get_created_successfully() {

        accountSuccessPage = new AccountSuccessPage(driver);
        Assert.assertEquals("Your Account Has Been Created!",accountSuccessPage.getPageTitle());

    }

    @When("User selects Yes for Newsletter")
    public void user_selects_yes_for_newsletter() {


        registerPage.selectNewsLetter();

    }

    @Then("User should get a proper warning about duplicate email")
    public void user_should_get_a_proper_warning_about_duplicate_email() {

       // Assert.assertTrue(registerPage.getWarningMessage().contains("Warning: E-Mail Address is already registered!"));

    }

    @When("User dont enter any details into fields")
    public void user_dont_enter_any_details_into_fields() {
       registerPage=new RegisterPage(driver);

        registerPage.enterFirstName("");
        registerPage.enterLastName("");
        registerPage.enterEmail("");
        registerPage.enterTelephoneNo("");
        registerPage.enterPassword("");
        registerPage.enterConfirmPassword("");

        registerPage.clickContinueButton();

    }

    @Then("User should get proper warning messages for every mandatory field")
    public void user_should_get_proper_warning_messages_for_every_mandatory_field() {

        Assert.assertTrue(registerPage.getWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
        Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.getFirstNameWarningMessage());
        Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.getLastNameWarningMessage());
        Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.getEmailWarningMessage());
        Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.getTelephoneWarningMessage());
        Assert.assertEquals("Password must be between 4 and 20 characters!",registerPage.getPasswordWarningMessage());

    }

}
