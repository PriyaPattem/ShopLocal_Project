package com.shoplocal.testCases;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CartCheckoutPageTest extends BaseClass {
    IndexPage indexPage;
    HomePage homePage;
    SearchResultPage searchResultPage;
    AddToCartPage addToCartPage;
    CartCheckoutPage cartCheckoutPage;
    @Parameters("browser")
    @BeforeMethod(groups ={"Smoke","Sanity","Regression"})
    public void setUp(String browser){
        launchApp(browser);
    }
    @AfterMethod(groups ={"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = "Regression")
    public void switchTabAndProductAvailability(){
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
        boolean result = cartCheckoutPage.clickOnShipmentTypeTab();
        Assert.assertTrue(result);
    }

    @Test(groups = "Regression")
    public void verifyTotalPrice(){
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
        boolean result = cartCheckoutPage.clickOnShipmentTypeTab();
        Double subTotal = cartCheckoutPage.getSubTotal();
        Double grandTotal = cartCheckoutPage.getGrandTotal();
        Double shipprice = cartCheckoutPage.getShippingPrice();
        Double expectedTotalPrice= subTotal+shipprice;
        Assert.assertEquals(grandTotal,expectedTotalPrice);
    }


}
