package com.learnAutomation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BrowserFactory
{
    @BeforeMethod
    public static WebDriver startApplication(WebDriver driver,String BrowserName,String AppUrl)
    {
         if(BrowserName.equals("Chrome"))
         {
             System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver");
             driver=new ChromeDriver();

         }
         else if(BrowserName.equals("Firefox"))
         {
             System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver");
             driver=new FirefoxDriver();
         }
         else if(BrowserName.equals("IE"))
         {
             System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
             driver=new InternetExplorerDriver();
         }
         else
         {
             System.out.println("We do not support this browser");
         }

         driver.get(AppUrl);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

         return driver;

    }

    @AfterMethod
    public static void quitBrowser(WebDriver driver)
    {
        driver.quit();
    }
}
