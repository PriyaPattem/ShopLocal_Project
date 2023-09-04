package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
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

    public WebElement getDeliveryTypeWindow(String type){    // dynamic xpath to select the delivery type
        String xpath= String.format("//div[@id='%s']",type);
        return getDriver().findElement(By.xpath(xpath));
    }
    String PickUp="Dummy";
    String Shipment="Dummy1";

    @FindBy(id="submit")
    WebElement submitBtn;

    @FindBy(xpath="//span[@data-notify=\"message\" and text()=\"Product Added To Cart\"]")
    WebElement cartAddedToastMessage;

    @FindBy(xpath="//div[@class=\"icon_names\" and text()=\"Cart\"]")
    WebElement cartIcon;

    @FindBy(xpath="//input[@class=\"form-control qty quantity-field cart_quantity\"]")
    WebElement quantity;

    @FindBy(xpath="//span[@onclick=\"increase_val();\"]")
    WebElement QuantityIncreaseButton;

    public AddToCartPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void selectSize(String sizeOfProduct){
        if(Action.isDisplayed(getDriver(),size)) {
            Action.performClick(getDriver(), size);
            Action.selectByVisibleText(sizeOfProduct, size);
        }
    }

    public void clickOnQuantity(){
        String productQuantity = quantity.getAttribute("value");
        Integer presentQuantity=Integer.parseInt(productQuantity);
        if(presentQuantity.equals(0)){
            Action.performClick(getDriver(),QuantityIncreaseButton);
        }
    }

    public boolean clickOnAddToCartButton(){
        Action.performClick(getDriver(),addToCartButton);
        return visibilityOfDeliveryTypeWindow();
    }

    public boolean visibilityOfDeliveryTypeWindow(){
        Action.explicitWait(getDriver(),DeliveryTypeWindow,10);
        return Action.isDisplayed(getDriver(),DeliveryTypeWindow);
    }

    public void selectShipmentType(){
        Action.performClick(getDriver(),getDeliveryTypeWindow(Shipment));
    }

    public boolean clickOnSubmitBtn(){
        Action.performClick(getDriver(),submitBtn);
        return addToCartToastMessage();
    }

    public boolean addToCartToastMessage(){
        Action.explicitWait(getDriver(),cartAddedToastMessage,20);
        return Action.isDisplayed(getDriver(),cartAddedToastMessage);
    }

    public CartCheckoutPage clickOnCartIcon(){
        Action.performClick(getDriver(),cartIcon);
        return new CartCheckoutPage();
    }
    public String getCurrntURL(){
        //System.out.println("curent url method called");
        String currentURL = Action.getCurrentURL(getDriver());
        return currentURL;
    }



}
