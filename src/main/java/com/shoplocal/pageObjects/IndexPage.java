package com.shoplocal.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {

    @FindBy(xpath = "//a[normalize-space(text())='Login']")
    WebElement LoginButton;
}
