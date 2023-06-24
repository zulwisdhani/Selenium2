package com.juaracoding.pageobject.pages;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart {
    private WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public AddtoCart() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement selectColor;

    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement selectSize;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement add;
    @FindBy(xpath = "//a[contains(text(),'dark blue vice high waisted slash knee skinny jean')]")
    WebElement txtItem;

//    @FindBy(xpath = "//a[contains(text(),'dark blue sinner distress knee high waist skinny j')]")
//    WebElement txtItemTwo;
    public void btnAddtoCart() {
        txtItem.click();
        System.out.println("DARK BLUE VICE HIGH WAISTED SLASH KNEE SKINNY JEANS");
        selectColor.click();
        selectColor.sendKeys("Dark Blue");
        System.out.println("Click color");
        //driver.navigate().refresh();
        selectSize.click();
        selectSize.sendKeys("37");
        System.out.println("Click size");
        add.click();
        System.out.println("Add to Cart");
    }

//    public String getTxtProductOne() {
//        return txtItem.getText();
//    }

//    public String getTxtProductTwo() {
//        return txtItemTwo.getText();
//    }
}
