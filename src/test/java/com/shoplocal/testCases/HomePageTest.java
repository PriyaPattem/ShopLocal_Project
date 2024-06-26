package com.shoplocal.testCases;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.pageObjects.HomePage;
import com.shoplocal.pageObjects.IndexPage;
import com.shoplocal.pageObjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    IndexPage indexPage;
    HomePage homePage;
    SearchResultPage searchResultPage;

    @Test(groups = "Smoke")
    public void ClickOnTodaysDealsTest() {
        indexPage = new IndexPage();
        homePage=new HomePage();
        homePage=indexPage.ClickOnExplore();
        boolean result = homePage.ClickOnTodaysDeals();
        Assert.assertTrue(result);
    }
    @Test(groups = "Smoke")
    public void searchProductTest(){
        indexPage = new IndexPage();
        homePage=new HomePage();
        searchResultPage=new SearchResultPage();
        homePage=indexPage.ClickOnExplore();
        searchResultPage=homePage.searchProduct(searchResultPage.ProductName);
        boolean result = searchResultPage.productAvailability();
        Assert.assertTrue(result);
    }
}
