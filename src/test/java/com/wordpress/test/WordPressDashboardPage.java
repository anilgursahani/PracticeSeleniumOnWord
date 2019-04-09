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


    public WordPressDashboardPage(ChromeDriver driver) {
        super(driver);
        WebDriverWait wait ; 
        WebElement  element  ;
        wait = new WebDriverWait(driver, 5) ;
        element = wait.until(ExpectedConditions.presenceOfElementLocated(welcomePanelSelector));
         
        
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
    
}
