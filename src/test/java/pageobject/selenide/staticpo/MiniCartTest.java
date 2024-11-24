package pageobject.selenide.staticpo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MiniCartTest extends TestBase {

    @Test
    public void miniCartIsUpdatedWhenItemIsAddedToCart() {
        SoftAssert softAssert = new SoftAssert();

        YellowDuckPage.addItemToCart();
        HomePage.waitCartQuantityLabelIsVisible("1");

        softAssert.assertEquals(HomePage.getMiniCartItemsQuantity(), 1);
        softAssert.assertEquals(HomePage.getMiniCartCurrency(),'$');
        softAssert.assertEquals(HomePage.getMiniCartTotalAmount(), 20.50);
        softAssert.assertAll();
    }
}
