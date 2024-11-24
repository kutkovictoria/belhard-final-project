package pageobject.selenide.staticpo;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("Cart functionality implementation")
@Feature("Cart")
public class CartTest extends TestBase {

    @Description("Check that yellow duck is added to the cart")
    @Test(description = "Yellow duck is added to cart")
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
    @Description("Check that item is removed from the cart")
    @Test(description = "Item is removed from cart")
    public void itemIsRemovedFromCart() {
        YellowDuckPage.addItemToCart();

        HomePage.waitCartQuantityLabelIsVisible("1");
        HomePage.clickCartLink();

        CartPage.clickRemoveButton();
        CartPage.validateNoItemsInCartMessageText("There are no items in your cart.");
    }
}
