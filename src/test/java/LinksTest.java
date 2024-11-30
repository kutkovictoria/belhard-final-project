import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LinksTest {

    WebDriver driver;

    @BeforeMethod
    public void openHomePage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

    @Test
    public void checkLogoLink() {
        WebElement logoElement = driver.findElement(By.xpath("//*[@id='logotype-wrapper']"));
        logoElement.click();
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store");
    }

    @Test
    public void checkHomeLink() {
        WebElement homeElement = driver.findElement(By.xpath("//i[@title='Home']"));
        homeElement.click();
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store");
    }

    @Test
    public void checkRubberDucksLink() {
        WebElement rubberDucksElement = driver.findElement(By.xpath("//nav[@id='site-menu']//li[@class='category-1']"));
        rubberDucksElement.click();
        Assert.assertEquals(driver.getTitle(), "Rubber Ducks | My Store");
    }

    @Test
    public void checkSubcategoryLink() {
        WebElement rubberDucksElement = driver.findElement(By.xpath("//nav[@id='site-menu']//li[@class='category-1']"));
        WebElement subcategoryElement = driver.findElement(By.xpath("//nav[@id='site-menu']//li[@class='category-2']/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(rubberDucksElement).moveToElement(subcategoryElement).click().perform();

        Assert.assertEquals(driver.getTitle(), "Subcategory | My Store");
    }

    @Test
    public void checkCartLink() {
        WebElement cartElement = driver.findElement(By.xpath("//div[@id='cart']//a[@class='content']"));
        cartElement.click();
        Assert.assertEquals(driver.getTitle(), "Checkout | My Store");
    }

    @Test
    public void checkCheckoutLink() {
        WebElement checkoutElement = driver.findElement(By.xpath("//div[@id='cart']//a[@class='link']"));
        checkoutElement.click();
        Assert.assertEquals(driver.getTitle(), "Checkout | My Store");
    }

    @Test
    public void regionalSettingsLinkChangeCurrencyToEUR() {
        WebElement changeRegionalSettingsElement = driver.findElement(By.xpath("//div[@id='region']//a[@class='fancybox-region']"));
        changeRegionalSettingsElement.click();
        WebElement currencyElement = driver.findElement(By.xpath("//select[@name='currency_code']"));
        Select dropdown = new Select(currencyElement);
        dropdown.selectByVisibleText("Euros");
        WebElement saveButton = driver.findElement(By.xpath("//*[@id='box-regional-settings']//button[@type='submit']"));
        saveButton.click();
        WebElement currencyHomePageElement = driver.findElement(By.xpath("//*[@id='region']//div[@class='currency']/span"));
        Assert.assertEquals(currencyHomePageElement.getText(), "EUR");
    }
}
