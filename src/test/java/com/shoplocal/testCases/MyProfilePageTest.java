package com.shoplocal.testCases;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.pageObjects.MyProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyProfilePageTest extends BaseClass {
    MyProfilePage myProfilePage;


    @Test
    public void visibilityOfOrderHistoryTest(){
        myProfilePage = new MyProfilePage();
        boolean result = myProfilePage.visibilityOfOrderHistory();
        Assert.assertTrue(result);
    }

}
