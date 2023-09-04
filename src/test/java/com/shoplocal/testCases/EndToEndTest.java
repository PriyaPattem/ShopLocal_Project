package com.shoplocal.testCases;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.pageObjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseClass {
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
    public void endToendTest(){
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
        cartCheckoutPage.clickOnShipmentTypeTab();
        cartCheckoutPage.clickOnNextButton();
        cartCheckoutPage.validateDeliveryAddressForm("swathi", "swathipriya@krify.com", "9705688455", "kkd", "kkd", "AP", "Canada", "533005");
        cartCheckoutPage.clickOnNoRegister();
        homePage = this.cartCheckoutPage.validateCardDetails("swathi", "kkd", "4111111111111111", "10", "23", "123");
        String actualUrl = this.homePage.getCurrntURL();
        String text = "invoice";
        boolean Url = false;
        if (actualUrl.contains(text)) {
            Url = true;
        }
        Assert.assertTrue(Url);

    }

}
