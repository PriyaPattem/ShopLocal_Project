package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.shoplocal.actiondriver.Action;

public class IndexPage extends BaseClass {

    @FindBy(xpath = "//a[normalize-space(text())='Login']")
    WebElement LoginButton;

    @FindBy(xpath="//div[@class=\"shoplocal_logo\"]")
    WebElement Logo;

    @FindBy(xpath = "//a[@href=\"https://bu1is.krify.com/shoplocal_dev/home\"]//button[@type=\"button\"]")
    WebElement ExploreOnlineProducts;

    @FindBy(xpath="//iframe[@src=\"data:text/html;charset=utf-8,%3Cbody%3E%3C%2Fbody%3E\"]")
    WebElement switchToFrame;

    public IndexPage(){
        PageFactory.initElements(driver,this);
    }
    public LoginTypePage clickOnlogin(){
        //Action.explicitWait(driver,switchToFrame,20);
       // Action.switchToFrameByWebElement(driver,switchToFrame);
        Action.explicitWait(driver,LoginButton,20);
        Action.performClick(driver,LoginButton);
      return new LoginTypePage();
    }

    public boolean ValidateLogo(){
        Action.switchToFrameByWebElement(driver,switchToFrame);
        //action.explicitWait(driver,Logo,20);
       return Action.isDisplayed(driver,Logo);

    }

    public HomePage ClickOnExplore(){
        Action.performClick(driver,ExploreOnlineProducts);
        return new HomePage();
    }

    public String validatePageTitle(){
      String pageTitle =  Action.getTitle(driver);
      return pageTitle;
    }
    public String getCurrntURL(){
        System.out.println("curent url method called");
        String currentURL = Action.getCurrentURL(driver);
        return currentURL;
    }


}

