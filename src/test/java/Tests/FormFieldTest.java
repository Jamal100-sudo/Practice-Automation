package Tests;

import TestBase.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormFieldTest extends TestBasePage {

    @Test(priority = 1)
    public void verifyFormFieldButtonClick() {
        formField.clickFormFieldButton();

        String expectedUrl = "https://practice-automation.com/form-fields/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Navigation failed.");
    }

    @Test(priority = 2)
    public void enterValidDetails() throws InterruptedException {
    	//Enter Name and Password
        formField.fillFormTextValues("Jamal", "SecurePass123");
        //Select Favorite Drink
    	String expectedDrink = "Coffee";
        String selectedDrink = formField.fillFavouriteDrinkCheckbox(expectedDrink);

        Assert.assertEquals(selectedDrink, expectedDrink, "Selected drink does not match expected value.");
        // Select Fav color
    	String expectedColor = "Red";
    	boolean selectedColor = formField.selectFavouriteColor(expectedColor);
    	Assert.assertTrue(selectedColor, "Color selection failed for: " + expectedColor);
    	
    	//Select Automation Preference
    	String ExpectedOption = "Yes";
    	String ActualOption = formField.AutomationPreference(ExpectedOption);
    	Assert.assertEquals(ActualOption, ExpectedOption);
    	
    	
    	String expectedMessageUponFormSubmit= "Message received!";
    	String actualMessageUponFormSubmit = formField.SubmitForm();
    	Assert.assertEquals(expectedMessageUponFormSubmit, actualMessageUponFormSubmit, "Incorrect Alert");
    }

}