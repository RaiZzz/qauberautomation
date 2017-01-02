package com.qauber.sanity;

import com.qauber.config.Config;
import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by Alya on 12/20/2016.
 */
public class DownloadReportAsPDF extends PageObjectModelResources {
    WebDriver driver;

    private static String downloadPath = "C:/Users/Alya/Downloads";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        setUpWithUser(User.UserType.SAU, driver);
    }

    @Test
    public void downloadReport() throws InterruptedException {
        int rowindex = 1;

        driver.get(Config.getBaseURL());
        Thread.sleep(10000);
        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(5000);
        getNavBar().clickReports();
        getReports().clickPublishedOnCheckbox();
        Thread.sleep(2000);

        getReports().selectReport(rowindex).click();
        Thread.sleep(2000);

        String viewReportID = getReportsViewReport().reportID().getText();

        getReportsViewReport().downloadAsPDFButton().click();
        Thread.sleep(5000);

        Assert.assertTrue(isFileDownloaded(downloadPath, "interview_report_" + viewReportID + ".pdf"), "Failed to download Expected document");
        Thread.sleep(5000);
    }


    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                return true;
        }

        return false;
    }

    @AfterClass
    public void breakDown() {
        breakDownHelper();
    }
}


