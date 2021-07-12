package com.demoblaze.pages;

import com.demoblaze.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    public Homepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Laptops")
    public WebElement laptopsCategory;

    @FindBy(linkText = "Sony vaio i5")
    public WebElement sonyVaioI5;

    @FindBy(linkText = "Add to cart")
    public WebElement addToCartButton;

    @FindBy(linkText = "Dell i7 8gb")
    public WebElement dellI78gb;

    @FindBy(id = "cartur")
    public  WebElement goToCart;

    @FindBy(id = "totalp")
    public WebElement totalPrice;

    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseButton;
}
