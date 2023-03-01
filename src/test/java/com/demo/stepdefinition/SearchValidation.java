package com.demo.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pagefactory.HomePage;
import pagefactory.SearchResultPage;
import reuseable.BaseClass;

import java.io.IOException;

public class SearchValidation {

    WebDriver driver;

    HomePage homePage;
    SearchResultPage searchResultPage;

    @Given("User opens the Application")
    public void user_opens_the_application() throws IOException {

        driver = BaseClass.browserCall();

    }

    @When("User enters valid product {string} into Search box field")
    public void user_enters_valid_product_into_search_box_field(String validProductText) {

        homePage = new HomePage(driver);
        homePage.enterSearchBox(validProductText);

    }

    @When("User clicks on Search button")
    public void user_clicks_on_search_button() {

        homePage.clickOnSearchButton();

    }

    @Then("User should get valid product displayed in search results")
    public void user_should_get_valid_product_displayed_in_search_results() {

        searchResultPage= new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.displayOfValidProduct());
    }

    @When("User enters invalid product {string} into Search box field")
    public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {

        homePage = new HomePage(driver);
        homePage.enterSearchBox(invalidProductText);

    }

    @Then("User should get a message about no product matching")
    public void user_should_get_a_message_about_no_product_matching() {

        searchResultPage=new SearchResultPage(driver);
        Assert.assertEquals("There is no product that matches the search criteria.",searchResultPage.getMessageText());

    }

    @When("User dont enter any product name into Search box field")
    public void user_dont_enter_any_product_name_into_search_box_field() {

        homePage = new HomePage(driver);
        homePage.clickOnSearchButton();

    }
}
