package com.wordpress.test;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.TestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

/**
 * Unit test for simple App.
 */
public class WordpressLoginTests extends BaseTest {

    /**
     * Rigorous Test :-)
     *
     *
     */
    private WordPressSignInPage signInPage ;

 @Test(priority = 1)

    public void LoginTestUsingValidUsernameAndPassword() {
        //setup the chromedriver using WebDriverManager

        String title;
        WebDriverWait wait;
        String username ;
       WordPressDashboardPage dashboardPage ;
      
       String expectedTitle = "Log In ‹ Wordpress Demo Site at Demo.Center — WordPress";
       String expectedLogoutTitle =  "Log In ‹ Wordpress Demo Site at Demo.Center — WordPress";
        signInPage .Login("admin", "demo123");
        dashboardPage = new WordPressDashboardPage(driver);
        username =  dashboardPage.getUsername();
        Assert.assertEquals(username, "admin");
        signInPage.Logout();
        title = signInPage.getTitle();
        Reporter.log("Title after logout  is " + title);
      Assert.assertTrue(title.equalsIgnoreCase(expectedLogoutTitle));
        
     
        
    }
   /** 
    * 
    *   Function LoginTestUsingValidUsernameInvalidPassword
    */ 
 // @Test(priority = 2)
    
    public void LoginTestUsingValidUsernameInvalidPassword()
    {
        String loginErrorText ;
        String expectedLoginErrorText =  ": The password you entered for the username" ;
        signInPage.Login("admin", "demo122");
        loginErrorText = signInPage.getLoginErrorText();
        Assert.assertTrue(loginErrorText.contains(expectedLoginErrorText));
       
    }

   

    @BeforeMethod()
    public void GotoWordpressPage() {
         navigateToWordPressURL();
        signInPage = new WordPressSignInPage(driver) ;

    }

        //Navigate to a URL
    //quit the browser
    
    @AfterMethod()
    
    public void CloseDriver() 
    {
  //      driver.close();
    }
    
}
