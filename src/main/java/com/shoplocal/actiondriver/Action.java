package com.shoplocal.actiondriver;

import com.shoplocal.Base.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Action extends BaseClass {
    public Action(WebDriver driver) {
        super(driver);
    }

    public void sendKeys(By element, String data) {
        shortwait.until(ExpectedConditions.presenceOfElementLocated(element));
        shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(data);
    }

    public void scrollIntoView(By Element)  {
        shortwait.until(ExpectedConditions.presenceOfElementLocated(Element));
        WebElement element = driver.findElement(Element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }

    }
    public void scrollAndSendKeys(By element, String data){
        scrollIntoView(element);
        sendKeys(element,data);

    }


    public String scrollAndGetText(By element){
        try {
            scrollIntoView(element);
            return getText(element);
        }catch (StaleElementReferenceException e){
            try {
                Thread.sleep(6000);
            }catch (Exception f){

            }
            scrollIntoView(element);
            return getText(element);
        }
    }
    public String getText(By element){

        shortwait.until(ExpectedConditions.presenceOfElementLocated(element));
        return shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(element))).getText();
    }
    public void scrollAndselectOptionsByVisibleText(By element,String option){
        scrollIntoView(element);
        selectOptionsByVisibleText(element,option);
    }
    public void selectOptionsByVisibleText(By element,String option){
        waitForvisibility(element);
        long startTime=System.currentTimeMillis();
        long endTime=startTime+15000;
        while (startTime<endTime){
            if(  new Select(driver.findElement(element)).getOptions().size()>=2){
                break;
            }
        }
        Select select=new Select(driver.findElement(element));
        for(WebElement element1:select.getOptions()){
            System.out.println(element1.getText());
        }
        select.selectByVisibleText(option);

        System.out.println("option count"+select.getOptions().size());
    }

    public void performClick(By element){
        shortwait.until(ExpectedConditions.presenceOfElementLocated(element));
        scrollIntoView(element);
        shortwait.until(ExpectedConditions.elementToBeClickable(element));
        shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(element))).click();
    }
    public void clickElementInterceptionException(By element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(element));
    }
    public void scrollAndPerformClick(By element){
        scrollIntoView(element);
        performClick(element);

    }
    public boolean scrollAndwaitForInvisibility(By element){
        scrollIntoView(element);
        return waitForInvisibility(element);
    }
    public boolean waitForInvisibility(By element){
        shortwait.until(ExpectedConditions.presenceOfElementLocated(element));
        return   shortwait.until(ExpectedConditions.invisibilityOf(driver.findElement(element)));
    }



    public void scrollAndWaitForVisibility(By element){
        scrollIntoView(element);
        waitForvisibility(element);

    }
    public void waitForvisibility(By element){
        shortwait.until(ExpectedConditions.presenceOfElementLocated(element));
        shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }
    public void longwaitForInvisibility(By element){
        longwait.until(ExpectedConditions.presenceOfElementLocated(element));
        longwait.until(ExpectedConditions.invisibilityOf(driver.findElement(element)));
    }
   /* public void invisibleLoading(){
        try {
            new YourQuote(driver).invisibilityOfLoading();
        }catch (Exception e){

        }
    }*/
    public String scrollAndGetAttribute(By element,String attribute){
        scrollIntoView(element);
        return getAttribute(element,attribute);
    }
    public String getAttribute(By element,String attribute){
        shortwait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).getAttribute(attribute);
    }
    public void scrollup(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1550)");
        try {
            Thread.sleep(500);
        }catch (Exception e){

        }
    }
    public void scrolldown(String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+value+")");

        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
    }


    public String JSDropDownValue(String element,WebDriver driver){

        shortwait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
        long startTime=System.currentTimeMillis();
        long endTime=startTime+15000;
        while (startTime<endTime){
            if(  new Select(driver.findElement(By.id(element))).getOptions().size()>=2){
                break;
            }
        }
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return    js.executeScript("return document.getElementById('"+element+"').options[document.getElementById('"+element+"').selectedIndex].text").toString();
    }
    public String JSGetText(String element,WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return     js.executeScript("return document.getElementById('"+element+"').value").toString();

    }

    public void scrollTop() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0)");
        Thread.sleep(800);
    }
}
