package com.learnAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage
{
    WebDriver driver;
    public LoginPage(WebDriver LDriver)
    {
       this.driver=driver;
    }
    @FindBy(name="email")
    WebElement Email;

    @FindBy(name="password")
    WebElement Password;

    @FindBy(xpath="//div[text()=\"Login\"]")
    WebElement LoginBtn;


    public void loginToCRM(String email,String password)
    {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException IE) {
        }
            Email.sendKeys(email);
            Password.sendKeys(password);
            LoginBtn.click();

    }
}
