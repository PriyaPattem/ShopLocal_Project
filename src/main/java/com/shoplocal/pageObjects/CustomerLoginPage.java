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
        PageFactory.initElements(driver,this);
    }

    public IndexPage validatelogin(String username, String pwd){
     action.EnterText(email,username);
     action.EnterText(password,pwd);
     action.click(driver,loginbutton);
     return new IndexPage();
    }

    public AccountCreationPage clickOnSignUp(){
        action.click(driver,SignUp);
        return new AccountCreationPage();
    }

}
