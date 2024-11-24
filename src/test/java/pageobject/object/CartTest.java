package pageobject.object;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class CartTest extends TestBase{

    @Test
    public void yellowDuckIsAddedToCart() {
        SoftAssert softAssert = new SoftAssert();

        YellowDuckPage yellowDuckPage = new YellowDuckPage(driver);
        yellowDuckPage.addItemToCart();

        HomePage homePage = new HomePage(driver);
        homePage.waitCartQuantityLabelIsVisible();
        homePage.clickCartLink();

        CartPage cartPage = new CartPage(driver);
        softAssert.assertEquals(cartPage.getDuckCardTitle(), "Yellow Duck");
        softAssert.assertEquals(cartPage.getDuckSize(), "Size: Medium");
        softAssert.assertEquals(cartPage.getDuckPrise(), 20.50);
        softAssert.assertEquals(cartPage.getItemsQuantity(), 1);
        softAssert.assertAll();
    }
    @Test
    public void itemIsRemovedFromCart() {
        YellowDuckPage yellowDuckPage = new YellowDuckPage(driver);
        yellowDuckPage.addItemToCart();

        HomePage homePage = new HomePage(driver);
        homePage.waitCartQuantityLabelIsVisible();
        homePage.clickCartLink();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickRemoveButton();

        Assert.assertEquals(cartPage.getNoItemsInCartMessageText(), "There are no items in your cart.");
    }
}
