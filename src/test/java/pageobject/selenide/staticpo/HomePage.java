package pageobject.selenide.staticpo;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class HomePage {

    private static By rubberDucksLink = By.xpath("//nav[@id='site-menu']//li[@class='category-1']");
    private static By cartLink = By.xpath("//div[@id='cart']//a[@class='content']");
    private static By cartQuantityLabel = By.xpath("//div[@id='cart']//span[@class='quantity']");
    private static By searchInput = By.xpath("//input[@type='search']");
    private static By miniCartItemsQuantity = By.className("quantity");
    private static By miniCartAmount = By.className("formatted_value");

    public static int getMiniCartItemsQuantity() {
        return Integer.parseInt($(miniCartItemsQuantity).getText());
    }

    public static char getMiniCartCurrency() {
        return $(miniCartAmount).getText().replaceAll("\\d.\\d", "")
                .replaceAll("\\d,\\d", "")
                .replaceAll(" ", "").toCharArray()[0];
    }

    public static double getMiniCartTotalAmount() {
        return Double.parseDouble($(miniCartAmount)
                .getText().replaceAll("\\$", "")
                .replaceAll("€", ""));
    }

    public static void clickRubberDucksLink() {
        $(rubberDucksLink).click();
    }

    public static void clickCartLink() {
        $(cartLink).click();
    }

    public static void waitCartQuantityLabelIsVisible(String expectedText) {
        $(cartQuantityLabel).shouldHave(text(expectedText));
    }

    public static void searchDataViaSearchInput(String searchData) {
        $(searchInput).setValue(searchData).pressEnter();
    }
}
