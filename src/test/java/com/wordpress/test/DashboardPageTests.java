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
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DashboardPageTests extends BaseTest
{
   private WordPressSignInPage signInPage ; 
   private WordPressDashboardPage dashboardPage ;
    
   @DataProvider(name="EditMyProfileParameters")
   public Object[][] getEditMyProfileParameters()
   {
       return new Object[][] 
       {  
            {
                EditProfileSettings.DefaultProfile,
                "rgba(35, 40, 45, 1)"
            },
           {
               EditProfileSettings.ColorLightProfile,
               "rgba(229, 229, 229, 1)"
           },
           {
               EditProfileSettings.ColorBlueProfile,
               "rgba(82, 172, 204, 1)"
           }  ,
        {
               EditProfileSettings.ColorCoffeeProfile,
               "rgba(89, 82, 76, 1)"
           },
        
        {  
            EditProfileSettings.ColorSunriseProfile,
            "rgba(207, 73, 68, 1)"
        }
      };
       
   }
    
    public void CreateCustomizedtest()
    {
        
          dashboardPage.CustomiseYourSite();
    }
    
    @Test (dataProvider="EditMyProfileParameters", priority=1)
   
    public void EditMyProfileTest(String profileToSet, String expectedBackground)
    {
         String myProfileBackgroundColor ;
         Reporter.log("Profile chosen was " + profileToSet);
         myProfileBackgroundColor  = dashboardPage.EditMyProfile(profileToSet) ;
         Reporter.log("Background color set was " + myProfileBackgroundColor);
         Assert.assertEquals( myProfileBackgroundColor, expectedBackground);      
    }
    
@AfterClass
    
    public void LogoutFromWordpress()
    {
         String myProfileBackgroundColor ;
        Reporter.log("In After class of Dashboard Page Tests");
         System.out.println("In After class of Dashboard Page Tests");
         /* restore profile to default */
         myProfileBackgroundColor  = dashboardPage.EditMyProfile(EditProfileSettings.DefaultProfile);
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
