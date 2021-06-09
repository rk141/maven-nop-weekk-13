package com.nopcommerce.demo.homepage;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTopMenu extends TestBase {

    HomePage homePage = new HomePage();

    @Test
    public void selectMenuAndClick() throws InterruptedException {

        String expectedText = homePage.selectMenu("computers");
        String actualText = homePage.getActualText();
        Assert.assertEquals(expectedText,actualText);

    }

}
