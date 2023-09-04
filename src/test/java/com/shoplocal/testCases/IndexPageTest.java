package com.shoplocal.Testcases;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.pageObjects.HomePage;
import com.shoplocal.pageObjects.IndexPage;
import com.shoplocal.pageObjects.LoginTypePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseClass {

    IndexPage indexPage;
    LoginTypePage loginTypePage;
    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void validateLogoTest(){
        indexPage = new IndexPage();
       boolean result = indexPage.ValidateLogo();
        Assert.assertTrue(result);
    }

    @Test
    public void validatePageTitleTest(){
        indexPage = new IndexPage();
        String actualTitle =indexPage.validatePageTitle();
        String expectedTitle="ShopLocally";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void clickOnLoginTest(){
        loginTypePage=new LoginTypePage();
        indexPage = new IndexPage();
        loginTypePage = indexPage.clickOnlogin();
        String actualUrl= loginTypePage.getCurrntURL();
        String expectedUrl = "https://bu1is.krify.com/shoplocal_dev/home/logins";
        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @Test
    public void clickOnexploreTest(){
        indexPage = new IndexPage();
        homePage = new HomePage();
        homePage=indexPage.ClickOnExplore();
        String actualUrl = homePage.getCurrntURL();
        String expectedUrl = "https://bu1is.krify.com/shoplocal_dev/home";
        Assert.assertEquals(actualUrl,expectedUrl);
    }

}
