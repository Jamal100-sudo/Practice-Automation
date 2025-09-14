package Pages;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.BasePage;

public class AlertPage extends BasePage{

	public AlertPage(WebDriver driver) {
		super(driver);
		
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	public final By PopupsButton = By.xpath("//a[contains(@class, 'wp-block-button__link') and normalize-space(text())='Popups']");
	public final By AlertPopupButton = By.id("alert");
	public final By ConfirmPopupButton = By.id("confirm");
	public final By PromptPopupButton = By.id("prompt");
	public final By ConfirmPopupResultText = By.id("confirmResult");
	public final By PromptPopupResultText = By.id("promptResult");
	
	//Click on the Popup Button and Return the Page title
	public String ClickPopups() 
	{
		WebElement Alertpopupbutton = driver.findElement(PopupsButton);
		wait.until(ExpectedConditions.elementToBeClickable(Alertpopupbutton));
		clickElement(Alertpopupbutton);
		return driver.getCurrentUrl();
	}
	
	//Click on the ALert Popup Button
	
	  public String AlertPopup() throws InterruptedException 
	  { 
		  WebElement AlertPopupWebelement = driver.findElement(AlertPopupButton);
		  wait.until(ExpectedConditions.elementToBeClickable(AlertPopupWebelement));
		  clickElement(AlertPopupWebelement);
		  wait.until(ExpectedConditions.alertIsPresent()); 
		  return AcceptAlertWithText(); 
	  }
	 
	
	//Click on the Confirm Popup Button and Accept
	public String AcceptConfirmPopup() throws InterruptedException
	{
		WebElement ConfirmPopupWebelement = driver.findElement(ConfirmPopupButton);
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmPopupWebelement));
		clickElement(ConfirmPopupWebelement);
		wait.until(ExpectedConditions.alertIsPresent());
		return AcceptAlertWithText();
	}
	
	public String DismissConfirmPopup() throws InterruptedException
	{
		WebElement ConfirmPopupWebelement = driver.findElement(ConfirmPopupButton);
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmPopupWebelement));
		clickElement(ConfirmPopupWebelement);
		wait.until(ExpectedConditions.alertIsPresent());
		return DismissAlertWithText();
	}
	
	public String AcceptPromptPopupWithName(String PromptPopupName) throws InterruptedException
	{
		WebElement PromptPopupWebelement = driver.findElement(PromptPopupButton);
		wait.until(ExpectedConditions.elementToBeClickable(PromptPopupWebelement));
		clickElement(PromptPopupWebelement);
		wait.until(ExpectedConditions.alertIsPresent());
		return AcceptAlertWithInput(PromptPopupName);
	}
	
	public String DismissPromptPopup() throws InterruptedException
	{
		WebElement PromptPopupWebelement = driver.findElement(PromptPopupButton);
		wait.until(ExpectedConditions.elementToBeClickable(PromptPopupWebelement));
		clickElement(PromptPopupWebelement);
		wait.until(ExpectedConditions.alertIsPresent());
		return DismissAlertWithText();
	}
	
	public String getConfirmPopupResultText()
	{
		WebElement ConfirmPopupresultTextWebelement = driver.findElement(ConfirmPopupResultText);
		return ConfirmPopupresultTextWebelement.getText();
	}
	
	public String getPromptPopupResultText()
	{
		WebElement PromptPopupresultTextWebelement = driver.findElement(PromptPopupResultText);
		return PromptPopupresultTextWebelement.getText();
	}

}
