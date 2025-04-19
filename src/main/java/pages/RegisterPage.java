package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.tr.Fakat;
import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;

	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@value='1'][@name='newsletter']")
	private WebElement yesToNewsletterOption;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public String getPasswordWarningMessage()
	{
		return elementUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public String getTelephoneWarningMessage()
	{
		return elementUtils.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getEmailWarningMessage()
	{
		return elementUtils.getTextFromElement(emailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getLastNameWarningMessage()
	{
		return elementUtils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	
	public String getFirstNameWarningMessage()
	{
		return elementUtils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getDuplicateWarningMessage()
	{
		return elementUtils.getTextFromElement(duplicateWarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void selectYesToNewsletterOption()
	{
		elementUtils.clickOnElement(yesToNewsletterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public AccountSuccessPage clickOnContinueButton()
	{
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		return new AccountSuccessPage(driver);
	}
	
	public void selectPrivacyPolicy()
	{
		elementUtils.clickOnElement(privacyPolicy, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterConfirmPassword(String confirmPasswordText)
	{
		elementUtils.typeTextIntoElement(confirmPasswordField, confirmPasswordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterPassword(String passwordText)
	{
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterTelephone(String telephoneText)
	{
		elementUtils.typeTextIntoElement(telephoneField, telephoneText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterEmailAddress(String emailText)
	{
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterLastName(String lastNameText)
	{
		elementUtils.typeTextIntoElement(lastNameField, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterFirstName(String firstNameText)
	{
		elementUtils.typeTextIntoElement(firstNameField, firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	

}
