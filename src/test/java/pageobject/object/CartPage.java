package pageobject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private By duckCardTitle = By.xpath("//div[@id='box-checkout-cart']//strong");  ////strong[text()='Yellow Duck']
    private By duckSize = By.xpath("//div[@id='box-checkout-cart']//p[2]");
    private By duckPrise = By.xpath("//div[@id='box-checkout-cart']//p[3]");
    private By itemsQuantity = By.xpath("//input[@name='quantity']");
    private By removeButton = By.xpath("//button[@name='remove_cart_item']");
    private By noItemsInCartMessage = By.xpath("//div[@id='checkout-cart-wrapper']/p/em");


    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getDuckCardTitle() {
        return driver.findElement(duckCardTitle).getText();
    }

    public String getDuckSize() {
        return driver.findElement(duckSize).getText();
    }

    public double getDuckPrise() {
        return Double.parseDouble(driver.findElement(duckPrise).getText().replaceAll("\\$", "").replaceAll("€", ""));
    }

    public int getItemsQuantity() {
        return Integer.parseInt(driver.findElement(itemsQuantity).getAttribute("value"));
    }

    public void clickRemoveButton() {
        driver.findElement(removeButton).click();
    }

    public String getNoItemsInCartMessageText() {
        return driver.findElement(noItemsInCartMessage).getText();
    }
}
