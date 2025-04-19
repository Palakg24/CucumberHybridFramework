package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement we = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			we = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e)

		{
			e.printStackTrace();
		}
		return we;
	}

	public void clickOnElement(WebElement element, long durationInSeconds) {

		WebElement we = waitForElement(element, durationInSeconds);
		we.click();
	}

	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}

	public void selectOptionInDropdown(WebElement element, String dropdownOption, long durationInSeconds) {
		Select select = new Select(element);
		WebElement webElement = waitForElement(element, durationInSeconds);

		select.selectByVisibleText(dropdownOption);
	}

	public Alert waitForAlert(long durationInSeconds) {
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}

	public void acceptAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}

	public void dismissAlert(long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}

	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {

		WebElement we = waitForVisibilityOfElement(element, durationInSeconds);

		Actions actions = new Actions(driver);
		actions.moveToElement(we).click().build().perform();

	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		WebElement we = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			we = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return we;
	}

	public void javaScriptClick(WebElement element, long durationInSeconds) {
		WebElement we = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("argument[0].click();", we);
	}

	public void javaScriptType(String textToBeTyped, WebElement element, long durationInSeconds) {
		WebElement we = waitForVisibilityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + textToBeTyped + "'", we);
	}
	
	public String getTextFromElement(WebElement element, long durationInSeconds)
	{
		WebElement we = waitForElement(element, durationInSeconds);
		return we.getText();
	}
	
	public boolean isElementDisplayed(WebElement element, long durationInSeconds)
	{
		
		try {
		WebElement we = waitForVisibilityOfElement(element, durationInSeconds);
		return we.isDisplayed();
		}catch(Throwable e)
		{
			return false;
		}
		
	}

}
