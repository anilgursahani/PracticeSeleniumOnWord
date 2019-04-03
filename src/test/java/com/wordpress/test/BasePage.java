/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.test;


import java.util.List;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

/**
 *
 * @author anilg
 */
public class BasePage {

    protected ChromeDriver chromeDriver;

    public BasePage(ChromeDriver driver) {
        chromeDriver = driver;
    }

    public String getTitle() {
        return chromeDriver.getTitle();
    }
    
    public ChromeDriver getDriver()
    {
        return chromeDriver ;
    }
    
    public void SelectFromPopup(By popupMenuId, String text)
    {
        WebElement popupMenu ;
        Select select ;
      
        popupMenu = chromeDriver.findElement(popupMenuId);
         select = new Select(popupMenu);
         select.selectByVisibleText(text);
       
    }
    
    public void HoverOverAndSelectElement(By hoverSelector, By submenuSelector, By elementToSelectSelector)
    {
        Actions actions  ;
        WebElement hoverElement ;
      
        WebDriverWait wait ;
        String aText ;
        System.out.println("HoverOverAndSelectElement");
        hoverElement = chromeDriver.findElement(hoverSelector);
        WebElement elementToSelect ;
        Action mouseOverHover ;
        Action mouseOverElementToSelect ;
        List<WebElement> elements ;
        int numElements ;
        WebElement logoutElement ;
        
        
        
        wait = new WebDriverWait(chromeDriver,2);  
         actions = new Actions(chromeDriver);
         actions.moveToElement(hoverElement);
         mouseOverHover = actions.build();
         mouseOverHover.perform();
         
         logoutElement  = chromeDriver.findElement( elementToSelectSelector);
         System.out.println("Log out element is " + logoutElement);
         try {
              logoutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(elementToSelectSelector));
         }  
         
         catch (org.openqa.selenium.TimeoutException te)
         {
              Reporter.log("Timeout Exception " + te.getLocalizedMessage());
          }
         
         System.out.println("Log out element is " + logoutElement);
         
          actions = new Actions(chromeDriver);
                
        actions.moveToElement(logoutElement);
        actions.click().build().perform();
 
        
  

    
         
    }
}
