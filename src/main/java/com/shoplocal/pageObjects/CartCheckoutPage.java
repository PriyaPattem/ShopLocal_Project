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

    // xpath=//tbody[@id="orderData"]/.//a[normalize-space("Women Regular Fit Solid Casual Shirt")]

    @FindBy(xpath="//p[@class=\"noItem\"]")
    WebElement noItemsMessage;
    @FindBy(xpath="//li[@class=\"nav-item active\"]")
    WebElement pickUpActive;
    @FindBy(xpath="//li[@onclick=\"changeDeliveryStatus(`shipment`)\"]")
    WebElement shipmentTypeTab;

    @FindBy(xpath="//div[text()=\"Subtotal\"]//following-sibling::div[@id=\"total\"]")
    WebElement subTotal;
    @FindBy(xpath="//div[@class=\"grand_total\"]")
    WebElement grandTotal;
    @FindBy(xpath = "//span[normalize-space(text()=\"Next\") and @onclick=\"checkItemStatus(`shipment`,`36`,`726`)\"]")
    WebElement nextButton;

    @FindBy(xpath="//div[@class=\"delivery_address\"]")
    WebElement deliveryAddress;

    // -------------Delivery address WebElements--------------------
    @FindBy(id="firstname")
    WebElement name;
    @FindBy(id="emailId")
    WebElement emailId;
    @FindBy(id="phone")
    WebElement phone;
    @FindBy(id="address1")
    WebElement address;
    @FindBy(id="city")
    WebElement city;
    @FindBy(id="state")
    WebElement state;
    @FindBy(id="country")
    WebElement country;
    @FindBy(id="zip")
    WebElement zip;
    @FindBy(xpath="//span[@onclick=\"checkAddress();\"]")
    WebElement confirmAndPayBtn;

    // --------------------Card Details web elements------------------------
    @FindBy(xpath="//div[normalize-space(text()=\"Card Details\")]//div[@class=\"modal-body form-login popup_body mt-5\"]")
    WebElement cardDetailsModel;
    @FindBy(id="chname")
    WebElement cardHolderName;
    @FindBy(name="chaddress")
    WebElement cardHolderAddress;
    @FindBy(id="card_holder_number")
    WebElement cardHolderNumber;
    @FindBy(id="card_expiry_month")
    WebElement cardExpiryMonth;
    @FindBy(id="card_expiry_year")
    WebElement cardExpiryYear;
    @FindBy(id="card_cvc")
    WebElement cardCvv;
    @FindBy(xpath="//button[@onclick=\"stripePay(event)\"]")
    WebElement paynowBtn;

    public CartCheckoutPage(){
        PageFactory.initElements(driver,this);
    }
    public void clickOnShipmentTypeTab(){
        if(noItemsMessage.isDisplayed() && pickUpActive.isDisplayed()){
            action.click(driver,shipmentTypeTab);
        }
    }

    public boolean productAvailabiilityInCart(){
        return action.isDisplayed(driver,productDetailsInCart(productNameInCart));
    }

    public void clickOnNextButton(){
        action.click(driver,nextButton);
    }

    public double getSubTotal(){
        String price=subTotal.getText();
        String price1=price.replaceAll("[^0-9]","");
        double subprice=Double.parseDouble(price1);
        double finalSubtotal= subprice/100;
        return finalSubtotal;
    }

    public double getGrandTotal(){
        String price=grandTotal.getText();
        String price1=price.replaceAll("[^0-9]","");
        double grandprice=Double.parseDouble(price1);
        double finalGrandPrice=grandprice/100;
        return finalGrandPrice;
    }
    public boolean visibilityOfDeliveryAddress(){
        return action.isDisplayed(driver,deliveryAddress);
    }

    public WebElement validateDeliveryAddressForm(String Uname, String email, String phNum, String address, String cityname, String stateName, String countryName, String zip){
        action.EnterText(name,Uname);
        action.EnterText(emailId,email);
        action.EnterText(phone,phNum);
        action.EnterText(this.address,address);
        action.EnterText(city,cityname);
        action.EnterText(state,stateName);
        action.selectByVisibleText(countryName,country);
        action.EnterText(this.zip,zip);
        action.click(driver,confirmAndPayBtn);
        return cardDetailsModel;

    }

    public HomePage validateCardDetails(String chName, String chAddress, String chNumber, String cardExpMonth, String cardExpYear, String cardcvv){
        action.EnterText(cardHolderName,chName);
        action.EnterText(cardHolderAddress,chAddress);
        action.EnterText(cardHolderNumber,chNumber);
        action.EnterText(cardExpiryMonth,cardExpMonth);
        action.EnterText(cardExpiryYear,cardExpYear);
        action.EnterText(cardCvv,cardcvv);
        action.click(driver,paynowBtn);
        return new HomePage();
    }
    

}
