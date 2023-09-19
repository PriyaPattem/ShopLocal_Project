package com.shoplocal.Base;

import com.shoplocal.Constants.DriverType;
import com.shoplocal.actiondriver.Action;
import com.shoplocal.driverFactory.DriverManagerFactory;
import com.shoplocal.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static Properties prop;
    // public static WebDriver driver;

    //Declare ThreadLocal driver
    private static ThreadLocal<WebDriver> threadLocaldriver = new ThreadLocal<>();

    public void setDriver(WebDriver driver){
        threadLocaldriver.set(driver);
    }
    public static WebDriver getDriver(){
        return threadLocaldriver.get();
    }

    @BeforeSuite(groups ={"Smoke","Sanity","Regression"})
    public void loadConfig() throws IOException {
        ExtentManager.setExtent();

        DOMConfigurator.configure("log4j.xml");

        try {
            prop = new Properties();
            // System.out.println("super constructor invoked");
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\configuration\\Dev_Config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Parameters("browser")
    public void launchApp(String browserName) {
        setDriver(DriverManagerFactory.getDriverType(DriverType.CHROME).createDriver());
        getDriver().get(prop.getProperty("baseUrl"));
        Action.implicitWait(getDriver(),20);
        Action.pageLoadTimeOut(getDriver(),20);
        Action.launchUrl(getDriver(),prop.getProperty("baseUrl"));
    }

    @AfterSuite
    public void afterSuite(){
        ExtentManager.endReport();
    }

    @Parameters("browser")
    @BeforeMethod(groups ={"Smoke","Sanity","Regression"})
    public void setUp(String browser){
        launchApp(browser);
    }

    @AfterMethod(groups ={"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }


}
