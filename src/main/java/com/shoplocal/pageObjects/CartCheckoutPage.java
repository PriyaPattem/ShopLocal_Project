package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import com.shoplocal.actiondriver.Action;
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
    @FindBy(id="shipping")
    WebElement shippingPrice;
    @FindBy(xpath = "//span[normalize-space(text()=\"Next\") and @class=\"btn btn-theme-dark\"]")
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

    @FindBy(xpath="//button[@id=\"noRegister\"]")
    WebElement noRegister;

    public CartCheckoutPage(){
        PageFactory.initElements(driver,this);
    }
    public boolean clickOnShipmentTypeTab(){
        if(noItemsMessage.isDisplayed() && pickUpActive.isDisplayed()){
            Action.performClick(driver,shipmentTypeTab);
        }
        return productAvailabiilityInCart();
    }

    public boolean productAvailabiilityInCart(){
        return Action.isDisplayed(driver,productDetailsInCart(productNameInCart));
    }

    public void clickOnNextButton(){
        Action.explicitWait(driver,nextButton,10);
        Action.performClick(driver,nextButton);
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

    public double getShippingPrice(){
        String price = shippingPrice.getText();
        String price1=price.replaceAll("[^0-9]","");
        double shipPrice = Double.parseDouble(price1);
        double finalShipPrice=shipPrice/100;
        return finalShipPrice;
    }
    public boolean visibilityOfDeliveryAddress(){
        return Action.isDisplayed(driver,deliveryAddress);
    }

    public WebElement validateDeliveryAddressForm(String Uname, String email, String phNum, String address, String cityname, String stateName, String countryName, String zip){
        Action.explicitWait(driver,deliveryAddress,10);
        Action.EnterText(name,Uname);
        Action.EnterText(emailId,email);
        Action.EnterText(phone,phNum);
        Action.EnterText(this.address,address);
        Action.EnterText(city,cityname);
        Action.EnterText(state,stateName);
        Action.selectByVisibleText(countryName,country);
        Action.EnterText(this.zip,zip);
        Action.performClick(driver,confirmAndPayBtn);
        return cardDetailsModel;

    }

    public void clickOnNoRegister(){
        Action.performClick(driver,noRegister);
    }

    public HomePage validateCardDetails(String chName, String chAddress, String chNumber, String cardExpMonth, String cardExpYear, String cardcvv){
        Action.EnterText(cardHolderName,chName);
        Action.EnterText(cardHolderAddress,chAddress);
        Action.EnterText(cardHolderNumber,chNumber);
        Action.EnterText(cardExpiryMonth,cardExpMonth);
        Action.EnterText(cardExpiryYear,cardExpYear);
        Action.EnterText(cardCvv,cardcvv);
        Action.performClick(driver,paynowBtn);
        return new HomePage();
    }

    public String getCurrntURL(){
        String currentURL = Action.getCurrentURL(driver);
        return currentURL;
    }

}
