package pageobject.selenide.staticpo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends TestBase {

    @Test
    public void yellowDuckIsAddedToCart() {
        SoftAssert softAssert = new SoftAssert();
        YellowDuckPage.addItemToCart();

        HomePage.waitCartQuantityLabelIsVisible("1");
        HomePage.clickCartLink();

        CartPage.validateDuckCardTitle("Yellow Duck");
        CartPage.validateDuckSize("Size: Medium");
        softAssert.assertEquals(CartPage.getDuckPrise(), 20.50);
        softAssert.assertEquals(CartPage.getItemsQuantity(),1);
        softAssert.assertAll();

    }
    @Test
    public void productIsRemovedFromCart() {
        YellowDuckPage.addItemToCart();

        HomePage.waitCartQuantityLabelIsVisible("1");
        HomePage.clickCartLink();

        CartPage.clickRemoveButton();
        CartPage.validateNoItemsInCartMessageText("There are no items in your cart.");
    }
}
