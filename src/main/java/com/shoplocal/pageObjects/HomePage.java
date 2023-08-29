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
        PageFactory.initElements(driver,this);
    }

    public boolean ClickOnTodaysDeals(){
        action.click(driver,TodaysDeals);
       return action.isDisplayed(driver,statusOfTodaysDeals);
    }

    public SearchResultPage searchProduct(){
        action.EnterText(searchField,"realme narzo");
        action.click(driver,searchButton);
        return new SearchResultPage();
    }


}
