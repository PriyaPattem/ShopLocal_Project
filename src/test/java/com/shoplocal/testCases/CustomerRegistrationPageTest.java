package com.shoplocal.testCases;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.dataProvider.DataProviders;
import com.shoplocal.pageObjects.CustomerRegistrationPage;
import com.shoplocal.pageObjects.IndexPage;
import com.shoplocal.pageObjects.MyProfilePage;
import com.shoplocal.pageObjects.RegisterTypePage;
import com.shoplocal.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CustomerRegistrationPageTest extends BaseClass {

    IndexPage indexPage;
    RegisterTypePage registerTypePage;
    CustomerRegistrationPage customerRegistrationPage;
    MyProfilePage myProfilePage;

    @Test(dataProvider = "newAccountDetailsData", dataProviderClass = DataProviders.class)
    public void validateRegistrationTest(HashMap<String, String> hashMapValue){
        Log.startTestCase("validate registration page test");
        indexPage = new IndexPage();
        registerTypePage = new RegisterTypePage();
        customerRegistrationPage = new CustomerRegistrationPage();
        myProfilePage = new MyProfilePage();
        indexPage.clickOnRegister();
        registerTypePage.clickOnCustomerRegister();
        boolean testCaseStatus = customerRegistrationPage.validateRegistration(hashMapValue.get("FirstName"),
                hashMapValue.get("LastName"),
                hashMapValue.get("Email"),
                hashMapValue.get("Phone"),
                hashMapValue.get("Password"),
                hashMapValue.get("ConfirmPassword"));
        Assert.assertTrue(testCaseStatus);
//        String actualURL = myProfilePage.getCurrntURL();
//        boolean text =actualURL.contains("profile");
//        Assert.assertTrue(text);
    }

}
