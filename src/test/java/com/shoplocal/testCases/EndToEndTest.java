package com.shoplocal.testCases;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.dataProvider.DataProviders;
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
    @BeforeMethod(groups ={"Smoke","Sanity","Regression"})
    public void setUp(String browser){
        launchApp(browser);
    }

    @AfterMethod(groups ={"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    //@Test(dataProvider = "CardDetailsData",dataProviderClass = DataProviders.class)
    @Test(dataProvider = "AddressData",dataProviderClass = DataProviders.class, groups = "Regression")
    public void endToendTest(String username,String email,String phnumber,String address, String cityname,String statename,String countryname,String zip){
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
        //cartCheckoutPage.validateDeliveryAddressForm("swathi", "swathipriya@krify.com", "9705688455", "kkd", "kkd", "AP", "Canada", "533005");
        cartCheckoutPage.validateDeliveryAddressForm(username,email,phnumber,address,cityname,statename,countryname,zip);
        cartCheckoutPage.clickOnNoRegister();
        homePage = this.cartCheckoutPage.validateCardDetails("swathi", "kkd", "4111111111111111", "10", "23", "123");
        String text = "invoice";
        String actualUrl = this.homePage.getCurrntURL1(text);
        boolean Url = false;
        if (actualUrl.contains(text)) {
            Url = true;
        }
        Assert.assertTrue(Url);

    }

}
