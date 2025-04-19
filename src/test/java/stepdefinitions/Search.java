package stepdefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {

	WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	private DriverFactory driverFactory;

	@Given("user opens the application")
	public void user_opens_the_application() {
		driverFactory = new DriverFactory();
		driver = driverFactory.getDriver();

	}

	@When("user enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {

		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(validProductText);

	}

	@And("user clicks on search button")
	public void user_clicks_on_search_button() {

		searchResultsPage = homePage.clickOnSearchButton();

	}

	@Then("user should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {

		Assert.assertTrue(searchResultsPage.displayStatusOfValidProduct());
		
	}

	@When("user enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(invalidProductText);

	}

	@Then("user should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {

		Assert.assertEquals("There is no product that matches the search criteria.",
				searchResultsPage.getMessageText());

	}

	@When("user dont enters any product name into search box field")
	public void user_dont_enters_any_product_name_into_search_box_ield() {
		// Intentionally kept blank
		homePage = new HomePage(driver);

	}

}
