/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import java.util.Map;
import java.util.Set;
import com.wordpress.utilities.GetProperties;
import java.util.Iterator;

/**
 *
 * @author anilg
 */
public class BaseTest {
    
    protected ChromeDriver driver;
    protected String wordPressURL ;
    
    @BeforeClass    
    public void BeforeClass() {
        
      
        WebDriverManager.chromedriver().setup();
        ChromeOptions options;
        Map jsonMap;
        Set entrySet;
        GetProperties getProperties;
        String url;
        Iterator iterator ;
        Object entrySetObj ;
        
        
        

        //Create driver object for Chrome
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        jsonMap = options.toJson(); // Convert chrome driver options to json
        entrySet = jsonMap.entrySet();
        iterator = entrySet.iterator() ;
   
        while (iterator.hasNext())
        {
            entrySetObj = iterator.next();
            System.out.println(entrySetObj);
        }
        getProperties = new GetProperties();
        wordPressURL = getProperties.getURL();
       
       
        
    }
    
    @AfterClass
    
    public void AfterClass() {
       System.out.println("After class");
       driver.quit();
    }
    
    public void navigateToWordPressURL()
    {
        driver.get(wordPressURL);
    }
    
}
