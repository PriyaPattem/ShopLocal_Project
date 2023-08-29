package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTypePage extends BaseClass {

    @FindBy(xpath="//button[text()=\"Login\"]//ancestor::a//parent::div//child::h1[text()=\"Customer Login\"]")
    WebElement customerLogin;

    public LoginTypePage(){
        PageFactory.initElements(driver,this);
    }

    public CustomerLoginPage clickOnCustomerLogin(){
        action.click(driver,customerLogin);
        return new CustomerLoginPage();
    }


}
