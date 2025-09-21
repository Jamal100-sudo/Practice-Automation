package Pages;

import Base.BasePage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowOperations extends BasePage {
	
	 public WindowOperations(WebDriver driver) {
	        super(driver);
	    }
	
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 public static final By WindowOperationButton = By.xpath("//a[contains(@class, 'wp-block-button__link') and normalize-space(.)='Window Operations']");
	 public static final By NewTabButton = By.xpath("//button[contains(@class, 'custom_btn') and normalize-space(.)='New Tab']");
	 public static final By ReplaceWindowButton = By.xpath("//button[contains(@class, 'custom_btn') and normalize-space(.)='Replace Window']");
	 public static final By NewWindowButton = By.xpath("//button[contains(@class, 'custom_btn') and normalize-space(.)='New Window']");
	 
	 
	 
	 public String ClickWindowOperations() 
		{
			WebElement Windowoperationbutton = driver.findElement(WindowOperationButton);
			wait.until(ExpectedConditions.elementToBeClickable(Windowoperationbutton));
			clickElement(Windowoperationbutton);
			return driver.getCurrentUrl();
		}
	 
	 public void ClickNewTab()
	 {
		 WebElement Newtabbutton = driver.findElement(NewTabButton);
			wait.until(ExpectedConditions.elementToBeClickable(Newtabbutton));
			clickElement(Newtabbutton);
	 }
	 
	 public void ClickReplaceWindow()
	 {
		 WebElement Replacewindowbutton = driver.findElement(ReplaceWindowButton);
			wait.until(ExpectedConditions.elementToBeClickable(Replacewindowbutton));
			clickElement(Replacewindowbutton);
	 }
	 
	 public void ClickNewWindow()
	 {
		 WebElement NewWindowbutton = driver.findElement(NewWindowButton);
			wait.until(ExpectedConditions.elementToBeClickable(NewWindowbutton));
			clickElement(NewWindowbutton);
	 }


}
