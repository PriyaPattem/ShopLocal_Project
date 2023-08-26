package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.shoplocal.actiondriver.Action;

public class IndexPage extends BaseClass {

    Action action=new Action();

    @FindBy(xpath = "//a[normalize-space(text())='Login']")
    WebElement LoginButton;

    @FindBy(className = "shoplocal_logo")
    WebElement Logo;

    @FindBy(xpath = "//a[@href=\"https://bu1is.krify.com/shoplocal_dev/home\"]//button[@type=\"button\"]")
    WebElement ExploreOnlineProducts;

    public IndexPage(){
        PageFactory.initElements(driver,this);
    }
    public LoginPage clickOnlogin(){
      action.click(driver,LoginButton);
      return new LoginPage();
    }

    public boolean ValidateLogo(){
       return action.isDisplayed(driver,Logo);
    }

    public HomePage ClickOnExplore(){
        action.click(driver,ExploreOnlineProducts);
        return new HomePage();
    }

    public String validatePageTitle(){
      String pageTitle =  action.getTitle(driver);
      return pageTitle;
    }


}

