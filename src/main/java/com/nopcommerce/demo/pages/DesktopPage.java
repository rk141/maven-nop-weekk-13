package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {

    By sortByFilter = By.xpath("//select[@id='products-orderby']");
    By buildYourOwnComputer = By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[1]");


    public void sortByZToA(){
        selectByValueFromDropDown(waitUntilVisibilityOfElementLocated(sortByFilter,80),"6");
    }

    public List<String> verifyProductSortedByZToAFilter() throws InterruptedException {

        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='product-grid']//h2"));
        List<String> productNameList = new ArrayList<>();

        for(WebElement name : productList){
            Thread.sleep(3500);
            productNameList.add(name.getText());
        }
        return productNameList;
    }

    public void sortByAtoZ(){

        selectByValueFromDropDown(waitUntilVisibilityOfElementLocated(sortByFilter,60),"5");
    }

    public void addProductToCart (){

        clickOnElement(waitUntilVisibilityOfElementLocated(buildYourOwnComputer,60));
    }
}
