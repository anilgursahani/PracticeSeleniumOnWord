/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wordpress.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 *
 * @author anilg
 */
public class GetProperties {

    private Properties prop;

    public GetProperties() {
        FileInputStream fis;
        File src;

        try {
            src = new File("src/test/resources/config.properties");
            fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception exc) {
            System.out.println("Exception: " + exc.getLocalizedMessage());
        }

    }

    public String getURL() {
        String url;
        url = prop.getProperty("url");
        return url;

    }
}
