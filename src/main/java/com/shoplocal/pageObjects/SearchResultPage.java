package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {


    @FindBy(xpath="//h4[@class=\"caption-title text-left text-truncate\"]//a[contains(normalize-space(),'Women Regular Fit Solid Casual Shirt')]")
    WebElement productResult;

    public SearchResultPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean productAvailability(){
        return action.isDisplayed(driver,productResult);
    }

    public AddToCartPage clickOnproduct(){
        action.click(driver,productResult);
        return new AddToCartPage();
    }

}
