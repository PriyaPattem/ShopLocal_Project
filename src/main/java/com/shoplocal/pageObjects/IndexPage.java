package com.shoplocal.pageObjects;

import com.shoplocal.Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BaseClass {

    @FindBy(xpath = "//a[normalize-space(text())='Login']")
    WebElement LoginButton;


}
