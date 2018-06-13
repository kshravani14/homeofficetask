package com.etsy.automation.config;


import com.etsy.automation.session.DataStore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    Properties properties = new Properties();
    public static WebDriver driver;
    InputStream input;

    public void loadConfig() {
        try {
            input = new FileInputStream("src" + File.separator + "test" + File.separator + "resources" + File.separator + "config" + File.separator + "config.properties");
            properties.load(input);
        } catch (IOException io) {
            System.out.println("Exception caught" + io.toString());
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

       String browser = System.getProperty("browser");
       if (browser != null && browser.equalsIgnoreCase("firefox")) {
           System.setProperty("webdriver.gecko.driver", properties.getProperty("firefoxDriver"));
           driver = new FirefoxDriver();
           driver.manage().window().maximize();
        } else {
           System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriver"));
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--start-maximized");
           driver = new ChromeDriver(options);
        }

        DataStore.setDataKey("baseURL",properties.getProperty("baseURL"));
        DataStore.setDataKey("spiceJetURL",properties.getProperty("spiceJetURL"));
    }
    public WebDriver getDriver(){
        return driver;
    }
    public void closeBrowser(){
        driver.close();

    }



}
