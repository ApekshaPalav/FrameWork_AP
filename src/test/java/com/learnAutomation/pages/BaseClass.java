package com.learnAutomation.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.learnAutomation.utilities.BrowserFactory;
import com.learnAutomation.utilities.ConfigDataProvider;
import com.learnAutomation.utilities.ExcelDataProvider;
import com.learnAutomation.utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class BaseClass
{
    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;
    public ExtentReports report;
    public ExtentTest logger;
    @BeforeSuite
    public void setUpSuite() throws IOException
    {
        Reporter.log("Setting up report and test started",true);
         excel=new ExcelDataProvider();
         config=new ConfigDataProvider();
         ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html"));
        report=new ExtentReports();
        report.attachReporter(extent);
        Reporter.log("Setting Done -Test can be started",true);
    }

    @BeforeClass
    public void setup()
    {
        Reporter.log("Trying to start the browser and getting application Ready",true);
        driver= BrowserFactory.startApplication(driver,config.getBrowser(),config.getUrl());
        Reporter.log("Browser and Application is up and running",true);
    }

    @AfterClass
    public void teardown()
    {
        BrowserFactory.quitBrowser(driver);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        Reporter.log("Test in after method",true);
        if(result.getStatus()==ITestResult.FAILURE)
        {
            Reporter.log("Test Fail Screenshot",true);
            logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());

        }
        else if(result.getStatus()==ITestResult.SUCCESS)
        {
            Reporter.log("Test Pass Screenshot",true);
            logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());

        }
      /*  else if(result.getStatus()==ITestResult.SKIP)
        {
            logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
        }*/
        Reporter.log("Testcompleted",true);

        report.flush();
    }
}
