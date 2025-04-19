package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	private DriverFactory driverFactory;
	
	@Given("User navigates to register account page")
	public void user_navigates_to_register_account_page() {
		driverFactory = new DriverFactory();
		driver=driverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage=homePage.selectRegisterOption();
	    
	}

	@When("user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerPage.enterFirstName(dataMap.get("firstname"));
		registerPage.enterLastName(dataMap.get("lastname"));
		commonUtils =new CommonUtils();
		registerPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
	}
	
	@When("user enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerPage.enterFirstName(dataMap.get("firstname"));
		registerPage.enterLastName(dataMap.get("lastname"));
		registerPage.enterEmailAddress(dataMap.get("email"));
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		
	}

	@And("user selects privacy policy")
	public void user_selects_privacy_policy() {
		
		registerPage.selectPrivacyPolicy(); 
	    
	}

	@And("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		
		accountSuccessPage=registerPage.clickOnContinueButton();
	 
	}

	@Then("user account should be created successfully")
	public void user_account_should_be_created_successfully() {
		
		Assert.assertEquals("Your Account Has Been Created!",accountSuccessPage.getPageHeading());
	    
	}

	@And("user selects yes for newsletter")
	public void user_selects_yes_for_newsletter() {
		
		registerPage.selectYesToNewsletterOption();
	}

	@Then("user should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		
		Assert.assertTrue(registerPage.getDuplicateWarningMessage().contains("Warning: E-Mail Address is already registered!"));
	   
	}

	@When("user dont enter any details into the fields")
	public void user_dont_enter_any_details_into_the_fields() {
		
		//Intentionally kept blank
	
	   
	}

	@Then("user should get a proper warning messages for  every mandatory fields")
	public void user_should_get_a_proper_warning_messages_for_every_mandatory_fields() {
		
		Assert.assertTrue(registerPage.getDuplicateWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(registerPage.getFirstNameWarningMessage().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerPage.getLastNameWarningMessage().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerPage.getEmailWarningMessage().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(registerPage.getTelephoneWarningMessage().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(registerPage.getPasswordWarningMessage().contains("Password must be between 4 and 20 characters!"));
		
	}

	




}
