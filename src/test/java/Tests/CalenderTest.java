package Tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import TestBase.TestBasePage;

public class CalenderTest extends TestBasePage{
	
	String ActualDate= "2027-12-15";
	String InvalidDate= "36-24-26";
	
	@Test
	public void verifyCalendarWithValidDate()
	{
		calenderpage.clickCalenderButton();
		calenderpage.enterCalendarDate(ActualDate);
		calenderpage.SubmitCalendarDate();
		String ExpectedDate = calenderpage.returnVisibleDate();
		Assert.assertEquals(ExpectedDate,ActualDate, "Date is displayed correctly");
	}
	
	@Test
	public void verifyCalendarWithInvalidDate()
	{
		calenderpage.clickCalenderButton();
		calenderpage.enterCalendarDate(InvalidDate);
		calenderpage.SubmitCalendarDate();
		String ExpectedDate = calenderpage.returnVisibleDate();
		Assert.assertEquals(ExpectedDate,ActualDate, "Date is displayed correctly");
	}
	

}
