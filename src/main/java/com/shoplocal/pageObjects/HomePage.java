package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {


    @FindBy(xpath="//ul[@class=\"nav nav-pills d-flex justify-content-center\"]//a[@href=\"#today_deals\"]")
    WebElement TodaysDeals;

    @FindBy(xpath="//a[@href=\"#today_deals\"]//parent::li[contains(@class,'active')]")
    WebElement statusOfTodaysDeals;

    @FindBy(name="query")
    WebElement searchField;

    @FindBy(className = "shrc_btn")
    WebElement searchButton;

    public HomePage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean ClickOnTodaysDeals(){
        Action.performClick(getDriver(),TodaysDeals);
       return Action.isDisplayed(getDriver(),statusOfTodaysDeals);
    }

    public SearchResultPage searchProduct(String productname){
        Action.EnterText(searchField,productname);
        Action.performClick(getDriver(),searchButton);
        return new SearchResultPage();
    }

    public String getCurrntURL1(String homeUrl){
        Action.UrlContains(getDriver(),homeUrl);
        String currentURL = Action.getCurrentURL(getDriver());
        return currentURL;
    }
    public String getCurrntURL(){

        String currentURL = Action.getCurrentURL(getDriver());
        return currentURL;
    }


}
