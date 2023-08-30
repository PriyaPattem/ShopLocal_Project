package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BaseClass {
    
    @FindBy(xpath="//select[@name=\"sizes\"]")
    WebElement size;

    @FindBy(xpath="//span[@class=\"btn btn-add-to cart add_btn_bg btn-block \"]")
    WebElement addToCartButton;

    @FindBy(xpath="//div[@class=\"modal-content model_border \"]")
    WebElement DeliveryTypeWindow;

    public WebElement shipmentType(String type){
        String xpath= String.format("//div[@class=\"notSelected\"]//following-sibling::p[text()=%s]",type);
        return driver.findElement(By.xpath(xpath));
    }
    String shiptype1="PickUp";
    String shiptype2="Shipment";
//    @FindBy(xpath="//p[@class=\"delivery_name\" and text()=\"Shipment\"]")
//    WebElement shipmentType;

    @FindBy(id="submit")
    WebElement submitBtn;

    @FindBy(xpath="//span[@data-notify=\"message\" and text()=\"Product Added To Cart\"]")
    WebElement cartAddedToastMessage;

    @FindBy(xpath="//div[@class=\"icon_names\" and text()=\"Cart\"]")
    WebElement cartIcon;

    public AddToCartPage(){
        PageFactory.initElements(driver,this);
    }

    public void selectSize(String sizeOfProduct){
        action.click(driver,size);
        action.selectByVisibleText(sizeOfProduct,size);
    }

    public void clickOnAddToCartButton(){
        action.click(driver,addToCartButton);
    }

    public boolean visibilityOfDeliveryTypeWindow(){
        return action.isDisplayed(driver,DeliveryTypeWindow);
    }

    public void selectShipmentType(){
        action.click(driver,shipmentType(shiptype2));
    }

    public void clickOnSubmitBtn(){
        action.click(driver,submitBtn);
    }

    public boolean validateAddToCart(){
        action.explicitWait(driver,cartAddedToastMessage,20);
        return action.isDisplayed(driver,cartAddedToastMessage);
    }

    public CartCheckoutPage clickOnCartIcon(){
        action.click(driver,cartIcon);
        return new CartCheckoutPage();
    }


}
