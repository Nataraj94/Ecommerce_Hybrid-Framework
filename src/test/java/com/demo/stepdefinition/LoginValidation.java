package com.demo.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pagefactory.AccountPage;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import reuseable.BaseClass;
import utils.CommonUtils;

import java.io.IOException;

public class LoginValidation {

    WebDriver driver;

    public HomePage homePage;
    public LoginPage loginPage;
    public AccountPage accountPage;
    public CommonUtils commonUtils;

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() throws IOException {

        driver= BaseClass.browserCall();
        homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.selectLoginOption();

    }


    @When("^User enters valid email address (.+) into email field$")
    public void User_enters_valid_email_address_into_email_field(String emailText) {

        loginPage = new LoginPage(driver);
        loginPage.enterEmailAddress(emailText);


    }

    @And("^User enters valid password (.+) into password field$")
    public void user_enters_valid_password_into_password_field(String passwordText) {

        loginPage.enterPassword(passwordText);

    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {

       loginPage.clickLogin();

    }

    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {

        accountPage = new AccountPage(driver);
        Assert.assertTrue(accountPage.AccountPageValidation());

    }

    @When("User enters invalid email address into email field")
    public void user_enters_invalid_email_address_into_email_field() {

        loginPage=new LoginPage(driver);

        commonUtils = new CommonUtils();
        loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());

    }

    @When("User enters invalid password {string} into password field")
    public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {

        loginPage.enterPassword(invalidPasswordText);

    }

    @Then("User should get a proper warning message about credentials mismatch")
    public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {

        Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));

    }

    @When("User dont enter email address into email field")
    public void user_dont_enter_email_address_into_email_field() {

        loginPage.enterEmailAddress(" ");

    }

    @When("User dont enter password into password field")
    public void user_dont_enter_password_into_password_field() {

        loginPage.enterPassword(" ");

    }

}
