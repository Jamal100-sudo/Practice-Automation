package TestBase;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Pages.AlertPage;
import Pages.CalenderPage;
import Pages.FileDownload;
import Pages.FormFieldPage;
import Pages.HomePage;
import Pages.WindowOperations;


public class TestBasePage {

    protected WebDriver driver;
    protected HomePage homePage;
    protected FormFieldPage formField;
    protected AlertPage alertPage;
    protected WindowOperations windowOperations;
    protected FileDownload fileDownload;
    protected CalenderPage calenderpage;
    protected String downloadPath = System.getProperty("user.home")+ "\\Downloads";
    @SuppressWarnings("serial")
	@BeforeClass
    public void setUp() {
    	
        
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--headless=new");
        //options.addArguments("--disable-gpu");

        // Set download preferences
        options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
            put("download.default_directory", downloadPath);
            put("download.prompt_for_download", false);
            put("plugins.always_open_pdf_externally", true); // ensures PDF is downloaded not opened
        }});

    	driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='33%'");
        
    }
    
    @BeforeMethod
    public void initPage() {
        homePage = new HomePage(driver);
        formField = new FormFieldPage(driver);
        alertPage = new AlertPage(driver);
        windowOperations = new WindowOperations(driver);
        fileDownload = new FileDownload(driver);
        calenderpage = new CalenderPage(driver);
    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        if (driver != null) {
        	Thread.sleep(5000);
            driver.quit(); // ✅ Closes browser properly
        }
    }

}