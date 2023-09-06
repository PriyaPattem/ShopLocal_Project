package com.shoplocal.testCases;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.pageObjects.HomePage;
import com.shoplocal.pageObjects.IndexPage;
import com.shoplocal.pageObjects.LoginTypePage;
import com.shoplocal.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IndexPageTest extends BaseClass {

    IndexPage indexPage;
    LoginTypePage loginTypePage;
    HomePage homePage;

    @Parameters("browser")
    @BeforeMethod(groups ={"Smoke","Sanity","Regression"})
    public void setUp(String browser){
        launchApp(browser);
    }

    @AfterMethod(groups ={"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = "Smoke")
    public void validateLogoTest(){
        Log.startTestCase("validateLogo Test");
        indexPage = new IndexPage();
        Log.info("will check for logo");
        boolean result = indexPage.ValidateLogo();
        Assert.assertTrue(result);
        Log.info("Logo is displayed");
        Log.endTestCase("validateLogoTest is success");
    }

    @Test(groups = "Smoke")
    public void validatePageTitleTest(){
        indexPage = new IndexPage();
        String actualTitle =indexPage.validatePageTitle();
        String expectedTitle="ShopLocally";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test(groups = "Smoke")
    public void clickOnLoginTest(){
        loginTypePage=new LoginTypePage();
        indexPage = new IndexPage();
        loginTypePage = indexPage.clickOnlogin();
        String actualUrl= loginTypePage.getCurrntURL();
        String expectedUrl = "https://bu1is.krify.com/shoplocal_dev/home/logins";
        Assert.assertEquals(actualUrl,expectedUrl);
    }
    @Test(groups = "Smoke")
    public void clickOnexploreTest(){
        indexPage = new IndexPage();
        homePage = new HomePage();
        homePage=indexPage.ClickOnExplore();
        String actualUrl = homePage.getCurrntURL();
        String expectedUrl = "https://bu1is.krify.com/shoplocal_dev/home";
        Assert.assertEquals(actualUrl,expectedUrl);
    }

}
