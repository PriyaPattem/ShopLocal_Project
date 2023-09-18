package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerRegistrationPage extends BaseClass {
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

    @FindBy(xpath = "//span[text()=\"OTP Verification Code\"]")
    WebElement otpTitle;

    @FindBy(xpath = "//div[@class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 d-flex otp_box mb-2\"]")
    WebElement otpField;

    @FindBy(xpath = "//button[@onclick=\"return otpcheck();\"]")
    WebElement verifyOtpButton;

    public CustomerRegistrationPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean validateRegistration(String fname, String lname, String mail, String phNum, String pwd, String confirmPwd){
        Action.EnterText(firstName,fname);
        Action.EnterText(lastName,lname);
        Action.EnterText(email,mail);
        Action.EnterText(phone,phNum);
        Action.EnterText(password,pwd);
        Action.EnterText(confirmPassword,confirmPwd);
        Action.performClick(getDriver(),ageCheckbox);
        Action.performClick(getDriver(),termsCheckbox);
        Action.performClick(getDriver(),registorButton);
        return verifyOtpTitle();
    }

    public String getCurrntURL(){
        System.out.println("curent url method called");
        String currentURL = Action.getCurrentURL(getDriver());
        return currentURL;
    }

    public boolean verifyOtpTitle(){
        Action.explicitWait(getDriver(), otpTitle, 20);
        return Action.isDisplayed(getDriver(), otpTitle);
    }
    public MyProfilePage enterOTP(String otp){
        Action.EnterText(otpField,otp);
        Action.performClick(getDriver(), verifyOtpButton);
        return new MyProfilePage();
    }


    public void validateRegistrationFromCheckout(){

    }
}
