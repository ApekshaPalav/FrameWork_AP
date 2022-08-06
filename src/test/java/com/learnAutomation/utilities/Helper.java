package com.learnAutomation.utilities;

import com.aventstack.extentreports.utils.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper
{

    //Screenshot,Alerts,Windows,Sync,JavascriptExecutor

    public static String CaptureScreenshot(WebDriver driver)
    {
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String ScreenShotPath=System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"FreeCRM_"+getCurrentDateTime()+".png";
       try
       {
           FileHandler.copy(src, new File(ScreenShotPath));
           System.out.println("Screenshot Captured");
       }
       catch(IOException e)
       {
           System.out.println("Unable to capture screenshot"+e.getMessage());
       }
        return ScreenShotPath;

    }

    public static String getCurrentDateTime()
    {
        DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date Currentdate=new Date();
        return customformat.format(Currentdate);

    }



}
