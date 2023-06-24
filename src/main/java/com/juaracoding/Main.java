package com.juaracoding;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.Login;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Main {

        static WebDriver driver;
        static Login loginPage = new Login();



        public static void main(String[] args) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            DriverSingleton.getInstance("chrome");
            js.executeScript("window.scrollBy(0,500)"); //scroll vertikal 500px
            driver = DriverSingleton.getDriver();
            driver.get("https://shop.demoqa.com/my-account/");
            loginPage.login("sindy","$Sindy1999");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            DriverSingleton.closeObjectInstance();
        }
}