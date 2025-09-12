package Tests;
import TestBase.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.*;


public class HomePageTest extends TestBasePage {
    @Test
    public void verifyHomePageIsAccessible() 
    {
        Assert.assertTrue(homePage.getHomePageTitle().contains("Learn and Practice Automation"),"Home page is not accessible or title is missing.");
    }
}
