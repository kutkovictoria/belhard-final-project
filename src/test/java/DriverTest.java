import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DriverTest {
    @Test
    public void click10thLink() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        WebElement expected10thLink = driver.findElement(By.linkText("Disappearing Elements"));
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        allLinks.get(9).click();

        Assert.assertEquals(allLinks.get(9), expected10thLink);

        driver.quit();
    }
}
