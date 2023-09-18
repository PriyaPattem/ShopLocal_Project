package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.shoplocal.actiondriver.Action;

public class IndexPage extends BaseClass {

    @FindBy(xpath = "//a[normalize-space(text())='Login']")
    WebElement LoginButton;

    @FindBy(xpath="//a[normalize-space(text())=\"Registration\"]")
    WebElement RegisterButton;

    @FindBy(xpath="//div[@class=\"shoplocal_logo\"]")
    WebElement Logo;

    @FindBy(xpath = "//a[@href=\"https://bu1is.krify.com/shoplocal_dev/home\"]//button[@type=\"button\"]")
    WebElement ExploreOnlineProducts;

    @FindBy(xpath="//iframe[@src=\"data:text/html;charset=utf-8,%3Cbody%3E%3C%2Fbody%3E\"]")
    WebElement switchToFrame;

    public IndexPage(){
        PageFactory.initElements(getDriver(),this);
    }
    public LoginTypePage clickOnlogin(){
        //Action.explicitWait(getDriver(),switchToFrame,20);
       // Action.switchToFrameByWebElement(getDriver(),switchToFrame);
        Action.explicitWait(getDriver(),LoginButton,20);
        Action.performClick(getDriver(),LoginButton);
      return new LoginTypePage();
    }

    public RegisterTypePage clickOnRegister(){
        Action.explicitWait(getDriver(),RegisterButton,20);
        Action.performClick(getDriver(),RegisterButton);
        return new RegisterTypePage();
    }

    public boolean ValidateLogo(){
        Action.switchToFrameByWebElement(getDriver(),switchToFrame);
        //action.explicitWait(getDriver(),Logo,20);
       return Action.isDisplayed(getDriver(),Logo);

    }

    public HomePage ClickOnExplore(){
        Action.performClick(getDriver(),ExploreOnlineProducts);
        return new HomePage();
    }

    public String validatePageTitle(){
      String pageTitle =  Action.getTitle(getDriver());
      return pageTitle;
    }
    public String getCurrntURL(String indexUrl){
        Action.UrlToBe(getDriver(),indexUrl);
        String currentURL = Action.getCurrentURL(getDriver());
        return currentURL;
    }


}

