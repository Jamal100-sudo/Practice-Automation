package Base;



//import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected Actions action;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
        this.action = new Actions(driver);
        applyZoom();
    }

    // Click an element
    public void clickElement(WebElement element) {
        element.click();
    }
    
    public void applyZoom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");
    }

    // Type text into an input field
    public void typeText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    // Scroll to an element
    public void scrollToElement(WebElement locator) 
    {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", locator);
    }


    // Select dropdown by visible text
    public String selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
        String SelectedOption = select.getFirstSelectedOption().getText();
    	return SelectedOption;
    }

    // Hover over an element
    public void hoverOverElement(WebElement element) {
        action.moveToElement(element).perform();
    }

    // Get text from an element
    public String getElementText(WebElement element) {
        return element.getText();
    }

    // Check if element is visible
    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public String AcceptAlertWithText() throws InterruptedException
    {
    	Alert alert = driver.switchTo().alert();
    	String AlertText = alert.getText();
    	alert.accept();
    	return AlertText;	
    }
}

