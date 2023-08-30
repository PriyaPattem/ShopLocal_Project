package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartCheckoutPage extends BaseClass {

    SearchResultPage searchresult=new SearchResultPage();
   String productNameInCart = searchresult.ProductName;

   public WebElement productDetailsInCart(String text){
       String xpath=String.format("//tbody[@id=\"orderData\"]/.//a[normalize-space('%s')]",text);
       return driver.findElement(By.xpath(xpath));
   }

    //  xpath=//tbody[@id="orderData"]/.//a[normalize-space("Women Regular Fit Solid Casual Shirt")]

    @FindBy(xpath="//p[@class=\"noItem\"]")
    WebElement noItemsMessage;

    @FindBy(xpath="//li[@class=\"nav-item active\"]")
    WebElement pickUpActive;

    @FindBy(xpath="//li[@onclick=\"changeDeliveryStatus(`shipment`)\"]")
    WebElement shipmentTypeTab;

    public CartCheckoutPage(){
        PageFactory.initElements(driver,this);
    }
    public void clickOnShipmentTypeTab(){

        if(noItemsMessage.isDisplayed() && pickUpActive.isDisplayed()){
            action.click(driver,shipmentTypeTab);
        }
    }

    public boolean productAvailabiility(){
        return action.isDisplayed(driver,productDetailsInCart(productNameInCart));
    }



}
