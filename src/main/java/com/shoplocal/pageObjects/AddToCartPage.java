package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
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

    @FindBy(xpath="//p[@class=\"delivery_name\" and text()=\"Shipment\"]")
    WebElement shipmentType;

    @FindBy(id="submit")
    WebElement submitBtn;
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
        action.click(driver,shipmentType);
    }

    public void clickOnSubmitBtn(){
        action.click(driver,submitBtn);
    }
}
