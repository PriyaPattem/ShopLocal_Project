package com.shoplocal.testCases;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.pageObjects.AddToCartPage;
import com.shoplocal.pageObjects.HomePage;
import com.shoplocal.pageObjects.IndexPage;
import com.shoplocal.pageObjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {
    IndexPage indexPage;
    HomePage homePage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    @BeforeMethod
    public void setUp(){
        launchApp();
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

    @Test
    public void clickOnProductTest(){
        indexPage=new IndexPage();
        homePage=new HomePage();
        searchResultPage=new SearchResultPage();
        addToCartPage=new AddToCartPage();
        homePage=indexPage.ClickOnExplore();
        searchResultPage=homePage.searchProduct(searchResultPage.ProductName);
        addToCartPage=searchResultPage.clickOnproduct();
        String actualUrl = addToCartPage.getCurrntURL();
        boolean Url=false;
        if(actualUrl.contains("product_view")){
             Url=true;
        }
        Assert.assertTrue(Url);
    }
 /*   public void productAvailabilityTest(){
        indexPage=new IndexPage();
        homePage=new HomePage();
        searchResultPage=new SearchResultPage();
        addToCartPage=new AddToCartPage();
        homePage=indexPage.ClickOnExplore();
        searchResultPage=homePage.searchProduct(searchResultPage.ProductName);
        addToCartPage=searchResultPage.clickOnproduct();

    }*/

}
