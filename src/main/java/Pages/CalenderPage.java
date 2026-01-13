package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BasePage;

public class CalenderPage extends BasePage{

	public CalenderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private final By calenderBtn = By.xpath("//a[contains(@class, 'wp-block-button') and normalize-space(text())='Calendars']");
	private final By calendarTextbox = By.xpath("//input[contains(@class , 'date jp-contact-form-date grunion-field')]");
	private final By calendarSubmitBtn = By.xpath("//button[contains(@class, 'pushbutton-wide')]");
	//private final By successmessage = By.id("contact-form-success-header");
	private final By Expecteddate= By.xpath("//div[@class=\"field-value\"]");
	
	
	public String clickCalenderButton()
	{
		WebElement calenderButton = driver.findElement(calenderBtn);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(calenderButton));
		scrollToElement(calenderButton);
		clickElement(calenderButton);
		return driver.getCurrentUrl();
	}
	
	public void enterCalendarDate(String date)
	{
		WebElement calendarTextBox = driver.findElement(calendarTextbox);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(calendarTextBox));
		clickElement(calendarTextBox);
		calendarTextBox.sendKeys(date);
	}
	
	public void SubmitCalendarDate()
	{
		WebElement calendarSubmitButton = driver.findElement(calendarSubmitBtn);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(calendarSubmitButton));
		clickElement(calendarSubmitButton);
	}
	
	public String returnVisibleDate()
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement ExpectedDate = wait.until(ExpectedConditions.visibilityOfElementLocated(Expecteddate));
		return ExpectedDate.getText();
	}
	

}
