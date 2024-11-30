package pageobject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private By rubberDucksLink = By.xpath("//nav[@id='site-menu']//li[@class='category-1']");
    private By cartLink = By.xpath("//div[@id='cart']//a[@class='content']");
    private By cartQuantityLabel = By.xpath("//div[@id='cart']//span[@class='quantity']");
    private By searchInput = By.xpath("//input[@type='search']");
    private By miniCartItemsQuantity = By.className("quantity");
    private By miniCartAmount = By.className("formatted_value");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public int getMiniCartItemsQuantity() {
        return Integer.parseInt(driver.findElement(miniCartItemsQuantity).getText());
    }
    public char getMiniCartCurrency() {
        return driver.findElement(miniCartAmount).getText().replaceAll("\\d.\\d", "")
                .replaceAll("\\d,\\d", "")
                .replaceAll(" ", "").toCharArray()[0];
    }
    public double getMiniCartTotalAmount() {
        return Double.parseDouble(driver.findElement(miniCartAmount).getText().replaceAll("\\$", "").replaceAll("€", ""));
    }

    public void clickRubberDucksLink(){
        driver.findElement(rubberDucksLink).click();
    }

    public void clickCartLink(){
        driver.findElement(cartLink).click();
    }
    public void waitCartQuantityLabelIsVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBe(cartQuantityLabel, "1"));
    }

    public void searchDataViaSearchInput(String searchData){
      driver.findElement(searchInput).sendKeys(searchData);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
    }
}
