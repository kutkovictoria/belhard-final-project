import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DriverTest {
    @Test
    public void click10thLink() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com");

        WebElement tenthLinkElement = driver.findElement(By.linkText("Disappearing Elements"));
        String expectedTitle = tenthLinkElement.getText();
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        allLinks.get(9).click();
        WebElement actualTitleElement = driver.findElement(By.xpath("//div[@id='content']/div[@class = 'example']/h3"));
        String actualTitle = actualTitleElement.getText();

        Assert.assertEquals(actualTitle, expectedTitle);

        driver.quit();
    }
}
