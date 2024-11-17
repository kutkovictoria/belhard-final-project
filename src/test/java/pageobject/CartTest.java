package pageobject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends TestBase{

    @Test
    public void yellowDuckIsAddedToCart() {
        SoftAssert softAssert = new SoftAssert();

        YellowDuckPage yellowDuckPage = new YellowDuckPage(driver);
        yellowDuckPage.addProductToCart();

        HomePage homePage = new HomePage(driver);
        homePage.waitCartQuantityLabelIsVisible();
        homePage.clickCartLink();

        CartPage productCardCartPage =new CartPage(driver);
        softAssert.assertEquals(productCardCartPage.getYellowDuckTitle(), "Yellow Duck");
        softAssert.assertEquals(productCardCartPage.getYellowDuckMediumSize(), "Size: Medium");
        softAssert.assertEquals(productCardCartPage.getYellowDuckPrise(), "$20.50");
        softAssert.assertEquals(productCardCartPage.getProductQuantity(), "1");
        softAssert.assertAll();
    }
}
