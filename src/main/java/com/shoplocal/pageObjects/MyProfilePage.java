package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends BaseClass {
    @FindBy(xpath="//a[@class=\"pnav_order_history\"]")
    WebElement orderHistory;

    public MyProfilePage(){
        PageFactory.initElements(driver,this);
    }

    public boolean visibilityOfOrderHistory(){
       return Action.isDisplayed(driver,orderHistory);
    }

}
