package com.shoplocal.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static java.time.temporal.ChronoUnit.SECONDS;

public class BaseClass {
    public static WebDriver driver;
 public static Properties prop;

    public     WebDriverWait shortwait;
    public  WebDriverWait mediumwait;
    public  WebDriverWait longwait;
    public BaseClass(WebDriver driver) {
        this.driver = driver;
        shortwait = new WebDriverWait(driver, Duration.of(40, SECONDS));
        mediumwait = new WebDriverWait(driver, Duration.of(30, SECONDS));
        longwait = new WebDriverWait(driver, Duration.of(60, SECONDS));
    }

 @BeforeTest
   public void loadConfig(){
        try{
            prop=new Properties();
            System.out.println("super constructor invoked");
            FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\configuration\\Dev_Config.properties");
            prop.load(fis);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
   }

public static void launchApp(){
    WebDriverManager.chromedriver().setup();
    String browserName = prop.getProperty("browser");

    if(browserName.contains("Chrome")){
        driver = new ChromeDriver();
    } else if (browserName.contains("FireFox")) {
        driver = new FirefoxDriver();
    } else if (browserName.contains("Edge")) {
        driver = new EdgeDriver();
    }
    driver.get(prop.getProperty("baseUrl"));
}

}
