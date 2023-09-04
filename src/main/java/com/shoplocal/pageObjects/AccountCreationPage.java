package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
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
        Action.EnterText(firstName,fname);
        Action.EnterText(lastName,lname);
        Action.EnterText(email,mail);
        Action.EnterText(phone,phNum);
        Action.EnterText(password,pwd);
        Action.EnterText(confirmPassword,confirmPwd);
        Action.performClick(driver,ageCheckbox);
        Action.performClick(driver,termsCheckbox);
        Action.performClick(driver,registorButton);
        return new MyProfilePage();
    }

    public String getCurrntURL(){
        System.out.println("curent url method called");
        String currentURL = Action.getCurrentURL(driver);
        return currentURL;
    }

    public void validateRegistrationFromCheckout(){

    }



}
