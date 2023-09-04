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
        return driver.findElement(By.xpath(xpath));
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
        PageFactory.initElements(driver,this);
    }

    public void selectSize(String sizeOfProduct){
        if(Action.isDisplayed(driver,size)) {
            Action.performClick(driver, size);
            Action.selectByVisibleText(sizeOfProduct, size);
        }
    }

    public void clickOnQuantity(){
        String productQuantity = quantity.getAttribute("value");
        Integer presentQuantity=Integer.parseInt(productQuantity);
        if(presentQuantity.equals(0)){
            Action.performClick(driver,QuantityIncreaseButton);
        }
    }

    public boolean clickOnAddToCartButton(){
        Action.performClick(driver,addToCartButton);
        return visibilityOfDeliveryTypeWindow();
    }

    public boolean visibilityOfDeliveryTypeWindow(){
        Action.explicitWait(driver,DeliveryTypeWindow,10);
        return Action.isDisplayed(driver,DeliveryTypeWindow);
    }

    public void selectShipmentType(){
        Action.performClick(driver,getDeliveryTypeWindow(Shipment));
    }

    public boolean clickOnSubmitBtn(){
        Action.performClick(driver,submitBtn);
        return addToCartToastMessage();
    }

    public boolean addToCartToastMessage(){
        Action.explicitWait(driver,cartAddedToastMessage,20);
        return Action.isDisplayed(driver,cartAddedToastMessage);
    }

    public CartCheckoutPage clickOnCartIcon(){
        Action.performClick(driver,cartIcon);
        return new CartCheckoutPage();
    }
    public String getCurrntURL(){
        //System.out.println("curent url method called");
        String currentURL = Action.getCurrentURL(driver);
        return currentURL;
    }



}
