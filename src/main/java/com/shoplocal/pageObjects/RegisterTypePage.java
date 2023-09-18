package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterTypePage extends BaseClass {

    @FindBy(xpath = "//h1[text()=\"Customer Registration\"]//following-sibling::a//button[text()=\"Register\"]")
    WebElement CustomerRegisterButton;

    public RegisterTypePage(){
        PageFactory.initElements(getDriver(),this);
    }

    public CustomerRegistrationPage clickOnCustomerRegister(){
        Action.explicitWait(getDriver(),CustomerRegisterButton,20);
        Action.performClick(getDriver(),CustomerRegisterButton);
        return new CustomerRegistrationPage();
    }
}
