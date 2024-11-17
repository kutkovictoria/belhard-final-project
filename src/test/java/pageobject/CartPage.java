package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private By yellowDuckCardTitle = By.xpath("//div[@id='box-checkout-cart']//strong[text()='Yellow Duck']");

    private By yellowDuckMediumSize = By.xpath("//div[@id='box-checkout-cart']//p[text()='Size: Medium']");
    private By yellowDuckPrise = By.xpath("//div[@id='box-checkout-cart']//p[text()='$20.50']");
    private By productQuantity = By.xpath("//input[@name='quantity']");
    private By updateButton = By.xpath("//button[@name='update_cart_item']");
    private By removeButton = By.xpath("//button[@name='remove_cart_item']");

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getYellowDuckTitle(){
        return driver.findElement(yellowDuckCardTitle).getText();
    }

    public String getYellowDuckMediumSize(){
        return driver.findElement(yellowDuckMediumSize).getText();
    }
    public String getYellowDuckPrise(){
        return driver.findElement(yellowDuckPrise).getText();
    }
    public String getProductQuantity(){
        return driver.findElement(productQuantity).getAttribute("value");
    }

    public void clickUpdateButton(){
        driver.findElement(updateButton).click();
    }

    public void clickRemoveButton(){
        driver.findElement(removeButton).click();
    }

}
