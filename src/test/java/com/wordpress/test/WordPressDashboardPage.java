/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 *
 * @author anilg
 */
public class WordPressDashboardPage extends BasePage {
private final By  usernameSelector = By.cssSelector("span.display-name");
private final By welcomePanelSelector = By.cssSelector("div.welcome-panel-content");
private final By customizeYourSizeSelector = By.linkText("Customise Your Site");
private final By closeControl = By.className("customize-controls-close");
private final By avatarHover = By.cssSelector("li#wp-admin-bar-my-account");
private final By submenuSelector = By.cssSelector("ul#wp-admin-bar-user-actions");
private final By EditMyProfileSelector = By.cssSelector("li#wp-admin-bar-edit-profile");
private final By DefaultProfileBtnSelector = By.cssSelector("input#admin_color_fresh");
private final By ColorLightProfileSelector = By.cssSelector("input#admin_color_light");
private final By ColorBlueProfileSelector = By.cssSelector("input#admin_color_blue");
private final By ColorCoffeeProfileSelector =  By.cssSelector("input#admin_color_coffee");
private final By ColorEctoplasmProfileSelector = By.cssSelector("input#admin_color_ectoplasm");
private final By ColorMidnightProfileSelector = By.cssSelector("input#admin_color_midnight");
private final By ColorOceanProfileSelector = By.cssSelector("input#admin_color_ocean");
private final By ColorSunriseProfileSelector = By.cssSelector("input#admin_color_sunrise");
private final By adminBarLocator = By.id("wpadminbar");




    public WordPressDashboardPage(ChromeDriver driver) {
        super(driver);
        WebDriverWait wait ; 
        WebElement  element  ;
        wait = new WebDriverWait(driver, 5) ;
        element = wait.until(ExpectedConditions.presenceOfElementLocated(welcomePanelSelector));
         
        
    }
    /***
     * Function SetProfileBasedOnProfileChosen
     * Purpose - To set the profile based on the profile chosen.
     * @param profileChosen 
     */
    private void  SetProfileBasedOnProfileChosen(String profileChosen)
    {
        By selector ;
        
        
       
    switch (profileChosen) {
        case EditProfileSettings.DefaultProfile:
            selector =  DefaultProfileBtnSelector;
            break;
        case EditProfileSettings.ColorLightProfile:
            selector = ColorLightProfileSelector;
            break ;
        case EditProfileSettings.ColorBlueProfile:
            selector = ColorBlueProfileSelector;
            break ;
        case EditProfileSettings.ColorCoffeeProfile:
            selector = ColorCoffeeProfileSelector;
            break ;
        case EditProfileSettings.ColorEctoplasmProfile:
            selector = ColorEctoplasmProfileSelector ;
            break ;
        case EditProfileSettings.ColorMidnightProfile:
            selector = ColorMidnightProfileSelector ;
            break ;
        case EditProfileSettings.ColorOceanProfile:
            selector = ColorOceanProfileSelector ;
            break ;
        case EditProfileSettings.ColorSunriseProfile:
            selector = ColorSunriseProfileSelector ;
            break ;
            
        default:
            selector = DefaultProfileBtnSelector ;
            break ;     
       
    }
         wait.until(ExpectedConditions.presenceOfElementLocated(avatarHover));     
         HoverOverAndSelectElement(avatarHover, submenuSelector, EditMyProfileSelector);
         wait.until(ExpectedConditions.presenceOfElementLocated(selector));
         getDriver().findElement(selector).click();
         /* Below is not an ideal way but need time for color to change */
         
         try {
             Thread.sleep(1000);
         }
         catch (InterruptedException ie) {
             System.out.println(ie.getLocalizedMessage());
         }
        
    }
   
    public String getUsername()
    {
       String username ;
        username = getDriver().findElement(usernameSelector).getText();
        return username ;       
    }
    
    public void CustomiseYourSite()
        {
            getDriver().findElement(customizeYourSizeSelector).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(closeControl));
            getDriver().findElement(closeControl).click();        
        }
  /***
   * Function EditMyProfile
   * @param profileChosen
   * @return - The background color set as result of selecting the profile chosen.
   */  
    public String  EditMyProfile(String profileChosen)
    {
        String colorSet ;
        WebElement elementToSelect ;
        SetProfileBasedOnProfileChosen(profileChosen);
        WebElement adminBar ;
        wait.until(ExpectedConditions.presenceOfElementLocated(adminBarLocator));
        adminBar = getDriver().findElement(adminBarLocator);
        colorSet = adminBar.getCssValue("background-color");
        return colorSet ;
        
          
    }
    
}
