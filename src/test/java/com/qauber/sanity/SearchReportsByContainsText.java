package com.qauber.sanity;

import com.qauber.pagesresource.PageObjectModelResources;
import com.qauber.pagesresource.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Maksim on 12/26/2016.
 */
public class SearchReportsByContainsText extends PageObjectModelResources {

    WebDriver driver;
    int sleepTime;
    String someText = "Pet";
    String keyWord = "Clear";

    @BeforeClass
    public void setUp() throws InterruptedException
    {
        setUpWithConfigFile();
        setUpUser(User.UserType.SAU);

        testConfig().getTestRail().setCaseID(0000);
        testConfig().getTestRail().setTester("Max's Computer");

        sleepTime = testConfig().getSleepTime();
        setUpScript();

        testDriver().get(testConfig().getBaseURL());
        Thread.sleep(sleepTime);

        getLogin().loginToWave(testUser().getUsername(), testUser().getPassword());
        Thread.sleep(sleepTime);
    }

    @Test
    public void searchReportsByContainsText() throws InterruptedException
    {
        getNavBar().reportsButton().click();
        Thread.sleep(sleepTime*2);

        getReports().containsTextField().clear();
        getReports().containsTextField().sendKeys(someText);
        Thread.sleep(sleepTime*2);

        getReports().publishedDateFromIcon(keyWord);
        Thread.sleep(sleepTime*2);

        Assert.assertTrue(getReports().searchReportResultID(1).getText().contains(someText));
    }

    @AfterClass
    public void breakDown()
    {
        breakDownHelper();
    }
}