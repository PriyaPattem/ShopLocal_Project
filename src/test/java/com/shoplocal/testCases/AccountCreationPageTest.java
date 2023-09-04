package com.shoplocal.testCases;

import com.shoplocal.Base.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AccountCreationPageTest extends BaseClass {
    @BeforeMethod
    public void setUp(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }
}
