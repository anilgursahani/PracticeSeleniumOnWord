/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.test;



/**
 *
 * @author anilg
 */
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class DashboardPageTests extends BaseTest
{
   private WordPressSignInPage signInPage ; 
   private WordPressDashboardPage dashboardPage ;
    @Test
    
    public void CreateCustomizedtest()
    {
          Reporter.log("Create customized test");
          dashboardPage.CustomiseYourSite();
    }
    
@AfterClass
    
    public void LogoutFromWordpress()
    {
         Reporter.log("In After class of Dashboard Page Tests");
         System.out.println("In After class of Dashboard Page Tests");
        signInPage.Logout();
    }
    
    
@BeforeClass
    
    public void LoginToWordpressPage()
    {
      String username ;
      Object dashboardPageFound ;
      System.out.println("In Before class of Dashboard Page Tests");
       Reporter.log("In Before class of Dashboard Page Tests");
       System.out.println("driver is  " + driver);
        signInPage = new WordPressSignInPage(driver) ;
        signInPage.Login("admin", "demo123");
        dashboardPageFound = signInPage.WaitForDashboardPage();
        Assert.assertNotNull(dashboardPageFound);
        dashboardPage = new WordPressDashboardPage(driver);
        username =  dashboardPage.getUsername();
        Assert.assertEquals(username, "admin");
        

    }
    
}
