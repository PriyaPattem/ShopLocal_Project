package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage extends BaseClass {


    @FindBy(id="email")
    WebElement email;
    @FindBy(name="password")
    WebElement password;
    @FindBy(xpath="//button[@onclick=\"return validateUserLogin();\"]")
    WebElement loginbutton;
    @FindBy(xpath="//a[normalize-space(text())=\"Sign Up\"]")
    WebElement SignUp;
    public CustomerLoginPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public IndexPage validatelogin(String username, String pwd){
        Action.EnterText(email,username);
        Action.EnterText(password,pwd);
        Action.performClick(getDriver(),loginbutton);
        //Action.implicitWait(getDriver(),5);
        return new IndexPage();
    }

    public AccountCreationPage clickOnSignUp(){
        Action.performClick(getDriver(),SignUp);
        return new AccountCreationPage();
    }
    public String getCurrntURL(){
        String currentURL = Action.getCurrentURL(getDriver());
        return currentURL;
    }

}
