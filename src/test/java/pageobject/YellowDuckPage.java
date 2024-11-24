package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class YellowDuckPage {
    private By sizeDropDown = By.xpath("//select[@name='options[Size]']");
    private By addToCartButton = By.xpath("//button[@name='add_cart_product']");

    private WebDriver driver;

    public YellowDuckPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void selectDuckSize() {
        Select dropdown = new Select(driver.findElement(sizeDropDown));
        dropdown.selectByValue("Medium");
    }

    public void addProductToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.clickRubberDucksLink();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickYellowDucksLink();

        selectDuckSize();
        clickAddToCartButton();
    }
}
