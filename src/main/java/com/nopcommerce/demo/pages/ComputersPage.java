package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;

public class ComputersPage extends Utility {

    By computersLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']");

    HomePage homePage = new HomePage();
    By desktopLink = By.xpath("//h2[@class='title']/a[@href='/desktops']");

    public void clickOnComputers(){

        clickOnElement(waitUntilVisibilityOfElementLocated(computersLink,70));
    }

    public void clickOnDesktop(){

        clickOnElement(waitUntilVisibilityOfElementLocated(desktopLink,90));
    }

}
