package com.shoplocal.testCases;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.pageObjects.CustomerLoginPage;
import com.shoplocal.pageObjects.IndexPage;
import com.shoplocal.pageObjects.LoginTypePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTypePageTest extends BaseClass {

    IndexPage indexPage ;
    LoginTypePage loginTypePage;
    CustomerLoginPage customerLoginPage;



    @Test(groups = "Smoke")
    public void clickOnCustomerLoginTest() {
        loginTypePage=new LoginTypePage();
        indexPage = new IndexPage();
        loginTypePage = indexPage.clickOnlogin();
        customerLoginPage=loginTypePage.clickOnCustomerLogin();
        String actualUrl= customerLoginPage.getCurrntURL();
        String expectedUrl="https://bu1is.krify.com/shoplocal_dev/home/login_set/login";
        Assert.assertEquals(actualUrl,expectedUrl);
    }

}
