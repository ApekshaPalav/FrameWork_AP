package com.learnAutomation.testcases;

import com.learnAutomation.pages.BaseClass;
import com.learnAutomation.pages.LoginPage;
import com.learnAutomation.utilities.Helper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestCRM extends BaseClass
{


    @Test(priority=1)
    public void loginApp() throws IOException
    {
        logger=report.createTest("Login to CRM");
        LoginPage loginpage=PageFactory.initElements(driver,LoginPage.class);
        logger.info("Starting Application");
        loginpage.loginToCRM(excel.getStringData("Login",0,0),excel.getStringData("Login",0,1));
        logger.pass("Login Success");
    }

    @Test(priority=2)
    public void loginApp1()
    {
        logger=report.createTest("Logout");
        logger.fail("Login failed");

    }
}
