package com.nopcommerce.demo.computers;

import com.nopcommerce.demo.pages.BuildYourOWNCOmputer;
import com.nopcommerce.demo.pages.ComputersPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends TestBase {

    ComputersPage computersPage = new ComputersPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOWNCOmputer buildYourOwnComputer = new BuildYourOWNCOmputer();


    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {

        computersPage.clickOnComputers();
        Thread.sleep(3500);
        computersPage.clickOnDesktop();
        desktopPage.sortByZToA();

        Thread.sleep(3500);
        List<String> actualProductNameList = desktopPage.verifyProductSortedByZToAFilter();
        List<String> sortedProductNameList = new ArrayList<>(actualProductNameList);
        Collections.sort(sortedProductNameList,Collections.<String>reverseOrder());
        Assert.assertEquals(actualProductNameList,sortedProductNameList);
    }

    @Test
    public void  verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        computersPage.clickOnComputers();
        Thread.sleep(3000);
        computersPage.clickOnDesktop();

        desktopPage.sortByAtoZ();
        Thread.sleep(3500);
        desktopPage.addProductToCart();

        Thread.sleep(3500);
        String expectedBuildYourOwnComputerText = "Build your own computer";
        Assert.assertEquals(buildYourOwnComputer.actualBuildYourOwnComputerText(),expectedBuildYourOwnComputerText);
        Thread.sleep(3500);
        buildYourOwnComputer.selectIntelPentiumProcessor();
        buildYourOwnComputer.select8BGRAM();
        Thread.sleep(3500);
        buildYourOwnComputer.clickOn400GBRadioButton();
        buildYourOwnComputer.clickOnVistaPremiumRadioButton();
        Thread.sleep(2900);
        buildYourOwnComputer.checkBoxTotalCommander();
        Thread.sleep(2900);
        String expectedTotalPrice = "$1,475.00";
        Assert.assertEquals(buildYourOwnComputer.actualTotalPrice(),expectedTotalPrice);
        Thread.sleep(3500);
        buildYourOwnComputer.clickToAddBuildProductToCart();
        Thread.sleep(3500);
        String expectedTopGreenBarText = "The product has been added to your shopping cart";
        Assert.assertEquals(buildYourOwnComputer.actualTopGreenBarText(),expectedTopGreenBarText);

    }


}
