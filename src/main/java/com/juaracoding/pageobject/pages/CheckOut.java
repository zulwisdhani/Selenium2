package com.juaracoding.pageobject.pages;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CheckOut {
    private WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public CheckOut() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='icon_bag_alt']")
    WebElement cart;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward wp-element-button']")
    WebElement checkout;

    @FindBy(xpath = "//input[@id='billing_first_name']")
    WebElement firstname;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    WebElement lastname;

    @FindBy(xpath = "//input[@id='billing_company']")
    WebElement company;

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    WebElement selectcountry;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    WebElement address;

    @FindBy(xpath = "//input[@id='billing_city']")
    WebElement city;

    @FindBy(xpath = "//span[@id='select2-billing_state-container']")
    WebElement state;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    WebElement pin;

    @FindBy(xpath = "//input[@id='billing_phone']")
    WebElement phone;

    @FindBy(xpath = "//input[@id='billing_email']")
    WebElement email;

    @FindBy(xpath = "//span[@class='woocommerce-terms-and-conditions-checkbox-text']")
    WebElement accept;

    @FindBy(xpath = "//button[@id='place_order']")
    WebElement order;
    public void btnCheckOut(){
        cart.click();
        System.out.println("Click cart");
        checkout.click();
        System.out.println("Click check out");
        firstname.click();
        firstname.sendKeys("sindy");
        lastname.click();
        lastname.sendKeys("sindy");
        company.click();
        company.sendKeys("VIP");
        System.out.println("VIP");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        Select country = new Select(driver.findElement(By.xpath("/html/body/span/span/span[1]/input")));
        country.selectByVisibleText("Indonesia");
//        selectcountry.sendKeys("Indonesia");
        System.out.println("Indonesia");
        address.click();
        address.sendKeys("rumah");
        city.click();
        city.sendKeys("City");
        state.click();
        state.sendKeys("Riau");
        pin.click();

        phone.sendKeys("1234567890");
        email.click();
        email.sendKeys("sindy@gmail.com");
        accept.click();
        order.click();
    }

    private void delay(int detik) {
    }

}
