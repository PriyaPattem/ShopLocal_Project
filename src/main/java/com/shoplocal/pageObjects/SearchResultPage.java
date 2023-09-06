package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BaseClass {

    public String ProductName="Women Regular Fit Solid Casual Shirt";

    public WebElement getProductResult(String productname){  // dynamic xpath for product result
        String xpath= String.format("//h4[@class=\"caption-title text-left text-truncate\"]//a[contains(normalize-space(),'%s')]",productname);
        return getDriver().findElement(By.xpath(xpath));
    }
    // @FindBy(xpath="//h4[@class=\"caption-title text-left text-truncate\"]//a[contains(normalize-space(),'Women Regular Fit Solid Casual Shirt')]")
    // WebElement productResult;

    public SearchResultPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public boolean productAvailability(){
        Action.explicitWait(getDriver(),getProductResult(ProductName),30);
        return Action.isDisplayed(getDriver(),getProductResult(ProductName));
    }

    public AddToCartPage clickOnproduct(){
        Action.performClick(getDriver(),getProductResult(ProductName));
        return new AddToCartPage();
    }
    public String getCurrntURL(){
        //System.out.println("curent url method called");
        String currentURL = Action.getCurrentURL(getDriver());
        return currentURL;
    }

}
