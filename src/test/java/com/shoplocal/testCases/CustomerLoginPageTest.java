package com.shoplocal.testCases;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.dataProvider.DataProviders;
import com.shoplocal.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.image.DataBuffer;

public class CustomerLoginPageTest extends BaseClass {
    IndexPage indexPage;
    LoginTypePage loginTypePage;
    CustomerLoginPage customerLoginPage;
    HomePage homePage;
    AccountCreationPage accountCreationPage;


    @Test(dataProvider = "CustomerLoginData", dataProviderClass = DataProviders.class,groups = {"Smoke","Sanity"})
    public void validateLoginTest(String uname,String pwd){
        indexPage=new IndexPage();
        loginTypePage=new LoginTypePage();
        customerLoginPage=new CustomerLoginPage();
        homePage=new HomePage();
        loginTypePage = indexPage.clickOnlogin();
        customerLoginPage=loginTypePage.clickOnCustomerLogin();
        //indexPage = customerLoginPage.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
        indexPage = customerLoginPage.validatelogin(uname,pwd);
        String expectedUrl="https://bu1is.krify.com/shoplocal_dev/";
        String actualUrl= indexPage.getCurrntURL(expectedUrl);
        Assert.assertEquals(actualUrl,expectedUrl);
        System.out.println("validateLoginTest passed");
    }

    @Test(groups = "Smoke")
    public void clickOnSignUpTest(){
        indexPage=new IndexPage();
        loginTypePage=new LoginTypePage();
        customerLoginPage=new CustomerLoginPage();
        homePage=new HomePage();
        loginTypePage = indexPage.clickOnlogin();
        customerLoginPage=loginTypePage.clickOnCustomerLogin();
        accountCreationPage =customerLoginPage.clickOnSignUp();
        String actualUrl= accountCreationPage.getCurrntURL();
        String expectedUrl="https://bu1is.krify.com/shoplocal_dev/home/login_set/registration";
        Assert.assertEquals(actualUrl,expectedUrl);
    }
}
