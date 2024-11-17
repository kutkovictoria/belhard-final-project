package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {
    private By yellowDuckLink = By.xpath("//div[@class= 'name'][text() = 'Yellow Duck']");

    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYellowDucksLink(){
        driver.findElement(yellowDuckLink).click();
    }

}
