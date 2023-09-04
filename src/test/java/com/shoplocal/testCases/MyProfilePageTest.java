package com.shoplocal.Testcases;

import com.shoplocal.Base.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MyProfilePageTest extends BaseClass {
    @BeforeMethod
    public void setUp(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
