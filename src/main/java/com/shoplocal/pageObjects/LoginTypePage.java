package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTypePage extends BaseClass {

    @FindBy(xpath="//h1[text()=\"Customer Login\"]//following-sibling::a/button")
    WebElement customerLogin;


    public LoginTypePage(){
        PageFactory.initElements(getDriver(),this);
    }

    public String getCurrntURL(){
        String currentURL = Action.getCurrentURL(getDriver());
        return currentURL;
    }

    public CustomerLoginPage clickOnCustomerLogin(){
        Action.performClick(getDriver(),customerLogin);
        return new CustomerLoginPage();
    }


}
