import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openHomePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginWithValidCredentials(){
        WebElement emailAddressElement = driver.findElement(By.name("email"));
        WebElement passwordElement = driver.findElement(By.name("password"));
        WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit'][@name='login']"));
        emailAddressElement.sendKeys("nickysmith2023@yahoo.com");
        passwordElement.sendKeys("lSOnFe");
        loginButtonElement.click();
        WebElement successMessageElement = driver.findElement(By.xpath("//div[@class='notice success']"));

        Assert.assertEquals(successMessageElement.getText(),"You are now logged in as Nicky Smith.");
    }

    @Test
    public void loginWithValidEmailEmptyPassword(){
        WebElement emailAddressElement = driver.findElement(By.name("email"));
        WebElement passwordElement = driver.findElement(By.name("password"));
        WebElement loginElement = driver.findElement(By.xpath("//button[@type='submit'][@name='login']"));
        emailAddressElement.sendKeys("nickysmith2023@yahoo.com");
        passwordElement.sendKeys("");
        loginElement.click();
        WebElement errorMessageElement = driver.findElement(By.xpath("//div[@class='notice errors']"));

        Assert.assertEquals(errorMessageElement.getText(),"You must provide both email address and password.");

    }

    @Test
    public void loginWithEmptyEmailValidPassword(){
        WebElement emailAddressElement = driver.findElement(By.name("email"));
        WebElement passwordElement = driver.findElement(By.name("password"));
        WebElement loginElement = driver.findElement(By.xpath("//button[@type='submit'][@name='login']"));
        passwordElement.sendKeys("lSOnFe");
        emailAddressElement.sendKeys("");
        loginElement.click();

        Alert alert = driver.switchTo().alert(); // NoAlertPresentException: no such alert. Ask how to handle such tooltip.
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals(alertText,"Please fill out this field.");
    }
}
