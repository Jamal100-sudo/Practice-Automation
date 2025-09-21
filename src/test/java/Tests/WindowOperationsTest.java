package Tests;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import TestBase.TestBasePage;

public class WindowOperationsTest extends TestBasePage {

    String parentWindowHandle;
    String ParentWindowURL = "https://practice-automation.com/window-operations/";
    String ExpectedWindowUrl = "https://automatenow.io/";

    @BeforeClass
    public void storeParentWindowHandle() {
        // After TestBasePage.setUp() runs, driver is ready
        parentWindowHandle = driver.getWindowHandle();
    }

    @Test(priority = 1)
    public void VerifyClickWindowOperations() {
        String ActualWOURL = windowOperations.ClickWindowOperations();
        Assert.assertEquals(ActualWOURL, ParentWindowURL);
    }

    @Test(priority = 2, dependsOnMethods = "VerifyClickWindowOperations")
    public void VerifyNewTabOpensSuccessfully() {
        String NewTabURL = "";
        windowOperations.ClickNewTab();

        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(parentWindowHandle)) {
                driver.switchTo().window(tab);
                NewTabURL = driver.getCurrentUrl();
                driver.close(); // optional: close the new tab
            }
        }

        Assert.assertEquals(NewTabURL, ExpectedWindowUrl);

        // ✅ Always return to parent window
        driver.switchTo().window(parentWindowHandle);
    }

    @Test(priority = 3, dependsOnMethods = {"VerifyClickWindowOperations", "VerifyNewTabOpensSuccessfully"})
    public void VerifyReplaceWindowOpensSuccessfully() {

        windowOperations.ClickReplaceWindow();
        String NewReplacedURL = driver.getCurrentUrl();
        Assert.assertEquals(NewReplacedURL, ExpectedWindowUrl);
        driver.navigate().back(); 
    }
    
    @Test (priority = 3, dependsOnMethods = {"VerifyClickWindowOperations", "VerifyNewTabOpensSuccessfully", "VerifyReplaceWindowOpensSuccessfully"})
    public void VerifyNewWindowOpensSuccessfully()
    {
    	windowOperations.ClickNewWindow();
    	String NewWindowURL= "";
    	Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindowHandle)) {
                driver.switchTo().window(window);
				NewWindowURL = driver.getCurrentUrl();
                driver.close(); // optional: close the new tab
            }
        }
       
        Assert.assertEquals(NewWindowURL, ExpectedWindowUrl);
        driver.switchTo().window(parentWindowHandle);
    } 
}