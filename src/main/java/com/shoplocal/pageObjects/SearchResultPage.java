package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {

    String ProductName="Women Regular Fit Solid Casual Shirt";

    public WebElement getProductResult(String productname){
        String xpath= String.format("//h4[@class=\"caption-title text-left text-truncate\"]//a[contains(normalize-space(),'%s')]",productname);
        return driver.findElement(By.xpath(xpath));
    }
//    @FindBy(xpath="//h4[@class=\"caption-title text-left text-truncate\"]//a[contains(normalize-space(),'Women Regular Fit Solid Casual Shirt')]")
//    WebElement productResult;

    public SearchResultPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean productAvailability(){
        return action.isDisplayed(driver,getProductResult(ProductName));
    }

    public AddToCartPage clickOnproduct(){
        action.click(driver,getProductResult(ProductName));
        return new AddToCartPage();
    }

}
