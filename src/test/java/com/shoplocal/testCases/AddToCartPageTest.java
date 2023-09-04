package com.shoplocal.testCases;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartPageTest extends BaseClass {

    IndexPage indexPage;
    HomePage homePage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    CartCheckoutPage cartCheckoutPage;
    @BeforeMethod
    public void setUp(){
        launchApp();
    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

    @Test
    public void addToCartTest(){
        indexPage=new IndexPage();
        homePage=new HomePage();
        searchResultPage=new SearchResultPage();
        addToCartPage=new AddToCartPage();
        homePage=indexPage.ClickOnExplore();
        searchResultPage=homePage.searchProduct(searchResultPage.ProductName);
        addToCartPage=searchResultPage.clickOnproduct();
        addToCartPage.selectSize("M");
        addToCartPage.clickOnQuantity();
        boolean result =addToCartPage.clickOnAddToCartButton();
        Assert.assertTrue(result);
    }

    @Test
    public void shipmentSelectionTest(){
        indexPage=new IndexPage();
        homePage=new HomePage();
        searchResultPage=new SearchResultPage();
        addToCartPage=new AddToCartPage();
        homePage=indexPage.ClickOnExplore();
        searchResultPage=homePage.searchProduct(searchResultPage.ProductName);
        addToCartPage=searchResultPage.clickOnproduct();
        addToCartPage.selectSize("M");
        addToCartPage.clickOnQuantity();
        addToCartPage.clickOnAddToCartButton();
        addToCartPage.selectShipmentType();
        boolean result = addToCartPage.clickOnSubmitBtn();
        Assert.assertTrue(result);
    }

    @Test
    public void clickOnCartIconText(){
        indexPage=new IndexPage();
        homePage=new HomePage();
        searchResultPage=new SearchResultPage();
        cartCheckoutPage=new CartCheckoutPage();
        addToCartPage=new AddToCartPage();
        homePage=indexPage.ClickOnExplore();
        searchResultPage=homePage.searchProduct(searchResultPage.ProductName);
        addToCartPage=searchResultPage.clickOnproduct();
        addToCartPage.selectSize("M");
        addToCartPage.clickOnQuantity();
        addToCartPage.clickOnAddToCartButton();
        addToCartPage.selectShipmentType();
        addToCartPage.clickOnSubmitBtn();
        cartCheckoutPage =addToCartPage.clickOnCartIcon();
        String actualUrl = cartCheckoutPage.getCurrntURL();
        String expectedUrl = "https://bu1is.krify.com/shoplocal_dev/home/cart_checkout";
        Assert.assertEquals(actualUrl,expectedUrl);
    }

}
