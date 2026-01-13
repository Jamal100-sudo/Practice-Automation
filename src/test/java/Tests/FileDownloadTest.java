package Tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.TestBasePage;
import Utils.FileDownloadUtils;

public class FileDownloadTest extends TestBasePage{
	
	@Test(priority = 1)
	public void verifyFileDownloadClick()
	{
		fileDownload.clickFileDownloadButton();
		String expectedUrl = "https://practice-automation.com/file-download/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Navigation failed.");
	}
	
	@Test (priority = 2)
	public void verifyPDFDownload()
	{
		fileDownload.clickPDFDownloadButton();

        File pdfFile = FileDownloadUtils.waitForFile(downloadPath, ".pdf", 30);
        Assert.assertNotNull(pdfFile, "PDF file was not downloaded!");
        System.out.println("Downloaded file: " + pdfFile.getAbsolutePath());

    }
	
	@Test(priority = 3)
	public void verifyDocDownload()
	{
		String password = "automateNow";
		fileDownload.clickDOCDownloadButton(password);
		File docFile = FileDownloadUtils.waitForFile(downloadPath, ".docx", 30);
        Assert.assertNotNull(docFile, "DOC file was not downloaded!");
        System.out.println("Downloaded file: " + docFile.getAbsolutePath());

	}

}
