package pageobject.selenide.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;

public class YellowDuckPage {
    private static By sizeDropDown = By.xpath("//select[@name='options[Size]']");
    private static By addToCartButton = By.xpath("//button[@name='add_cart_product']");

    public static void clickAddToCartButton() {
        $(addToCartButton).click();
    }

    public static void selectDuckSize() {
        Select dropdown = new Select($(sizeDropDown));
        dropdown.selectByValue("Medium");
    }

    public static void addItemToCart() {
        HomePage.clickRubberDucksLink();
        CatalogPage.clickYellowDucksLink();
        selectDuckSize();
        clickAddToCartButton();
    }
}
