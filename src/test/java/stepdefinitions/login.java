package stepdefinitions;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class login {
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	private DriverFactory driverFactory;
	
	@Given("User navigates to login page")
	public void User_navigates_to_login_page()
	{
		driverFactory = new DriverFactory();
		driver=driverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage=homePage.selectLoginOption();
	}
	
	
	
	@When("^User enters valid email address (.+) into email field$")
	public void user_has_enters_valid_email_address_into_email_field(String emailText) {
		
		loginPage.enterEmailAddress(emailText);
	   
	}

	@And("^User enters valid password (.+) into password field$")
	public void user_has_enters_valid_password_into_password_field(String passwordText) {
		
		loginPage.enterPassword(passwordText);
	    
	}

	@And("user clicks on Login button")
	public void user_clicks_on_login_button() {
	
		accountPage=loginPage.clickOnLoginButton();
		
	}

	@Then("user should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	    
	}


	@When("user enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		
	}

	@And("user enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		
		loginPage.enterPassword(invalidPasswordText);
		
	    
	}


	@Then("user should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	
	}


	@When("user dont enter any email address into email field")
	public void user_dont_enter_any_email_address_into_email_field() {
		
		loginPage.enterEmailAddress("");
		
	}

	@And("user dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		loginPage.enterPassword("");
		
	   
	}


	

}
