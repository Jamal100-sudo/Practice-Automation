package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.TestBasePage;

public class AlertTest extends TestBasePage {
	
	String promptpopupname = "Jamal";
	String ExpectedConfirmPopup = "OK or Cancel, which will it be?";
	String ActualConfirmPopup;
	String ExpectedResultTextUponAccept = "OK it is!";
	String ActualResultTextUponAccept;
	String ExpectedResultTextUponDismiss = "Cancel it is!";
	String ActualResultTextUponDismiss;
	String ExpectedPromptPopup = "Hi there, what's your name?";
	String ExpectedPromptPopupWithName = "Nice to meet you, " +promptpopupname +"!" ;
	String ExpectedResultTextPromptPopupDismiss = "Fine, be that way...";
	
	@Test (priority = 1)
	public void verifyPopupButtonClick() // Verify the Popups Button works
	{
		String ExpectedPopupURL = "https://practice-automation.com/popups/";
		String ActualPopupURL = alertPage.ClickPopups();
		Assert.assertEquals(ActualPopupURL, ExpectedPopupURL);
	}
	
	  @Test(priority = 2, dependsOnMethods = {"verifyPopupButtonClick"}) public
	  void verifyAlertPopup() throws InterruptedException { String
	  ExpectedAlertPopupText = "Hi there, pal!"; 
	  String ActualALertPopupText = alertPage.AlertPopup();
	  Assert.assertEquals(ExpectedAlertPopupText,ActualALertPopupText ); }
	 
	
	@Test(priority = 3, dependsOnMethods = {"verifyPopupButtonClick"})
	public void verifyAcceptConfirmPopup() throws InterruptedException
	{
		ActualConfirmPopup = alertPage.AcceptConfirmPopup();
		Assert.assertEquals(ExpectedConfirmPopup,ActualConfirmPopup );
		ActualResultTextUponAccept = alertPage.getConfirmPopupResultText();
		Assert.assertEquals(ExpectedResultTextUponAccept, ActualResultTextUponAccept);
	}
	
	@Test(priority = 4, dependsOnMethods = {"verifyPopupButtonClick", "verifyAcceptConfirmPopup"})
	public void verifyDismissConfirmPopup() throws InterruptedException
	{
		ActualConfirmPopup = alertPage.DismissConfirmPopup();
		Assert.assertEquals(ExpectedConfirmPopup,ActualConfirmPopup );
		ActualResultTextUponDismiss = alertPage.getConfirmPopupResultText();
		Assert.assertEquals(ExpectedResultTextUponDismiss, ActualResultTextUponDismiss);
	}
	
	@Test(priority = 5, dependsOnMethods = {"verifyPopupButtonClick"})
	public void verifyPromptPopupWithName() throws InterruptedException
	{
		alertPage.AcceptPromptPopupWithName(promptpopupname);
		ActualResultTextUponAccept = alertPage.getPromptPopupResultText();
		Assert.assertEquals(ExpectedPromptPopupWithName, ActualResultTextUponAccept);
	}
	@Test(priority = 6, dependsOnMethods = {"verifyPopupButtonClick", "verifyPromptPopupWithName"})
	public void verifyDismissPromptPopup() throws InterruptedException
	{
		alertPage.DismissPromptPopup();
		ActualResultTextUponDismiss = alertPage.getPromptPopupResultText();
		Assert.assertEquals(ExpectedResultTextPromptPopupDismiss, ActualResultTextUponDismiss);
	}

}
