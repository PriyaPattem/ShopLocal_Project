package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage extends BaseClass {

    @FindBy(xpath="//label[@for=\"username\" and text()=\"First Name\"]")
    WebElement firstName;
    @FindBy(xpath="//label[@for=\"surname\" and text()=\"Last Name\"]")
    WebElement lastName;
    @FindBy(id="email")
    WebElement email;
    @FindBy(id="phone")
    WebElement phone;
    @FindBy(id="password1")
    WebElement password;
    @FindBy(id="password2")
    WebElement confirmPassword;
    @FindBy(id="age_check")
    WebElement ageCheckbox;
    @FindBy(id="terms_check")
    WebElement termsCheckbox;
    @FindBy(xpath="//button[@onclick=\"return validateUserRegister();\"]")
    WebElement registorButton;

    public AccountCreationPage(){
        PageFactory.initElements(driver,this);
    }

    public MyProfilePage validateRegistration(String fname, String lname, String mail, String phNum, String pwd, String confirmPwd){
        action.EnterText(firstName,fname);
        action.EnterText(lastName,lname);
        action.EnterText(email,mail);
        action.EnterText(phone,phNum);
        action.EnterText(password,pwd);
        action.EnterText(confirmPassword,confirmPwd);
        action.click(driver,ageCheckbox);
        action.click(driver,termsCheckbox);
        action.click(driver,registorButton);
        return new MyProfilePage();
    }

    public void validateRegistrationFromCheckout(){

    }



}
