package pageobject.object;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MiniCartTest extends TestBase {

    @Test
    public void miniCartIsUpdatedWhenItemIsAddedToCart() {
        SoftAssert softAssert = new SoftAssert();

        YellowDuckPage yellowDuckPage = new YellowDuckPage(driver);
        yellowDuckPage.addItemToCart();

        HomePage homePage = new HomePage(driver);
        homePage.waitCartQuantityLabelIsVisible();

        softAssert.assertEquals(homePage.getMiniCartItemsQuantity(), 1);
        softAssert.assertEquals(homePage.getMiniCartCurrency(), '$');
        softAssert.assertEquals(homePage.getMiniCartTotalAmount(), 20.50);
        softAssert.assertAll();
    }
}
