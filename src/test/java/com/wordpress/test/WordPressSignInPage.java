/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.test;

import java.util.concurrent.TimeoutException;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.Reporter;


/**
 *
 * @author anilg
 */
public class WordPressSignInPage extends BasePage {

    

    private final By userId = By.id("user_login");
    private final By passwordEl = By.name("pwd");
    private final By loginButton = By.id("wp-submit");
    private final By wordPressTitleSelector = By.cssSelector("a[href='https://wordpress.org/']");
    private final By loginErrorId = By.id("login_error");
    private final By HiPopup = By.cssSelector("a[class='ab-item']");
    private final By LogoutSelect= By.cssSelector("li#wp-admin-bar-logout");
 //   private final By avatarHover = By.cssSelector("li[class='menupop with-avatar']");
    private final By avatarHover = By.cssSelector("li#wp-admin-bar-my-account");
    private final By submenuSelector = By.cssSelector("ul#wp-admin-bar-user-actions");
   
    

    public WordPressSignInPage(ChromeDriver chromeDriver) {
          super(chromeDriver);
        ExpectedCondition expectedCondition ;
         WebDriverWait webWait;
         String title ;
         String expectedTitle = "Log In ‹ Wordpress Demo Site at Demo.Center — WordPress";
         
         Object element ;
         
        webWait = new WebDriverWait(chromeDriver, 7);
        title = getTitle() ;
    
        Assert.assertTrue(title.equalsIgnoreCase(expectedTitle));


    }
    
    

    public void Login(String username, String password) {
        WebElement loginElement;
        
        chromeDriver.findElement(userId).sendKeys(username);
        chromeDriver.findElement(passwordEl).sendKeys(password);
        chromeDriver.findElement(loginButton).click();

    }
    
    public void Logout()
    {
        
        System.out.println("Logout");
        HoverOverAndSelectElement(avatarHover, submenuSelector, LogoutSelect);
       
    }
    
    public String getLoginErrorText() 
    {
        WebDriverWait wait ;
        ChromeDriver driver ;
        String loginErrorText ;
        driver = getDriver();
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginErrorId));
        loginErrorText = driver.findElement(loginErrorId).getText();
        return loginErrorText ;
        
    }
}
