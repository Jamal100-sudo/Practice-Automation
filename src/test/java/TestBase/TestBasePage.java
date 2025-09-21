package TestBase;


//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Pages.AlertPage;
import Pages.FormFieldPage;
import Pages.HomePage;
import Pages.WindowOperations;

public class TestBasePage {

    protected WebDriver driver;
    protected HomePage homePage;
    protected FormFieldPage formField;
    protected AlertPage alertPage;
    protected WindowOperations windowOperations;

    @BeforeClass
    public void setUp() {
    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/");
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("document.body.style.zoom='50%'");

    }
    
    @BeforeMethod
    public void initPage() {
        homePage = new HomePage(driver);
        formField = new FormFieldPage(driver);
        alertPage = new AlertPage(driver);
        windowOperations = new WindowOperations(driver);
    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        if (driver != null) {
        	Thread.sleep(5000);
            driver.quit(); // ✅ Closes browser properly
        }
    }

}