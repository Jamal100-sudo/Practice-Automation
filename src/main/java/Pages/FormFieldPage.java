package Pages;

import Base.BasePage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class FormFieldPage extends BasePage {

    public FormFieldPage(WebDriver driver) {
        super(driver);
    }

    private final By formFieldButton = By.xpath("//a[contains(@class, 'wp-block-button__link') and normalize-space(text())='Form Fields']");
    private final By formFieldName = By.id("name-input");
    private final By formFieldPassword = By.xpath("//input[@type='password']");
    private final By formFavouriteDrinkCheckbox = By.name("fav_drink");
    private final By formFavouriteColor = By.name("fav_color");
    private final By formAutomationPreferenceDropdown = By.id("automation");
    private final By formFieldSubmitButton = By.cssSelector("button[data-testid='submit-btn']");

    public void clickFormFieldButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement button = driver.findElement((formFieldButton));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        clickElement(button);
    }

    public void fillFormTextValues(String name, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement nameField = driver.findElement((formFieldName));
        wait.until(ExpectedConditions.visibilityOf(nameField));
        typeText(nameField, name);
        WebElement passwordField = driver.findElement((formFieldPassword));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        typeText(passwordField, password);
    }
    public String fillFavouriteDrinkCheckbox(String drinkName)
    {
    	List<WebElement> checkboxes = driver.findElements(formFavouriteDrinkCheckbox);
    	
        for (WebElement checkbox : checkboxes) {
            if (checkbox.getAttribute("value").equalsIgnoreCase(drinkName)) {
            	scrollToElement(checkbox);
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
                return checkbox.getAttribute("value");
            }
        }
        return null;
    }
    
    public boolean selectFavouriteColor(String colorname)
    {
    	
    	List<WebElement> colors = driver.findElements(formFavouriteColor);
    	
    	for (WebElement color:colors)
    	{
    		if (color.getAttribute("value").equalsIgnoreCase(colorname)) {
    			scrollToElement(color);
                if (!color.isSelected()) {
                	color.click();
                }
                return true;
            }
        }
    	return false;
    }
    
    public String AutomationPreference(String preference) throws InterruptedException 
    {
    	
    	WebElement dropdown = driver.findElement(formAutomationPreferenceDropdown);
    	scrollToElement(dropdown);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.elementToBeClickable(dropdown));
    	return selectDropdownByVisibleText(dropdown, preference);
    	
    }
    public String SubmitForm() throws InterruptedException
    {
    	WebElement submitButton = driver.findElement(formFieldSubmitButton);
    	scrollToElement(submitButton);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(submitButton));
    	clickElement(submitButton);
    	wait.until(ExpectedConditions.alertIsPresent());
    	return AcceptAlertWithText();
    }
}
    
