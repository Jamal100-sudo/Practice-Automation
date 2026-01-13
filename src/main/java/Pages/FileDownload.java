package Pages;

import Base.BasePage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class FileDownload extends BasePage {

	public FileDownload(WebDriver driver) {
		super(driver);
	}
	
	private final By FileDownloadButton = By.xpath("//a[contains(@class, 'wp-block-button__link wp-element-button') and normalize-space(text())='File Download']");
	private final By PDFDownloadbtn= By.xpath("//a[contains(@class, 'wpdm-download-link download-on-click btn btn-primary') and normalize-space(text())='Download']");
	private final By DocDownloadbtn= By.xpath("//a[contains(@class, 'wpdm-download-link wpdm-download-locked btn btn-primary') and normalize-space(text())='Download']");
	private final By DocDownloadpasswordField = By.cssSelector("input[type='password']");
	private final By DocDownloadSubmitBtn = By.cssSelector("input[type='submit']");
	
	public void clickFileDownloadButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    WebElement fdButton = wait.until(ExpectedConditions.elementToBeClickable(FileDownloadButton));
	    Actions actions = new Actions(driver);
	    actions.moveToElement(fdButton).perform();
	    clickElement(fdButton);
	}
	
	public void clickPDFDownloadButton()
	{
		WebElement PDFbutton = driver.findElement((PDFDownloadbtn));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(PDFbutton));
        clickElement(PDFbutton);
	}
	
	public void clickDOCDownloadButton(String password)
	{
		WebElement Docbutton = driver.findElement((DocDownloadbtn));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(Docbutton));
        clickElement(Docbutton);
        WebElement PasswordField = driver.findElement((DocDownloadpasswordField));
        wait.until(ExpectedConditions.elementToBeClickable(PasswordField)).sendKeys(password);;
        WebElement Submitbutton = driver.findElement((DocDownloadSubmitBtn));
        clickElement(Submitbutton);
	}
	
	
}
