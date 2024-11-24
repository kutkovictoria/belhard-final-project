package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CatalogPage {
    private By yellowDuckLink = By.xpath("//div[@class='name'][text()='Yellow Duck']");
    private By searchResultLocator = By.xpath("//div[@class='name']");
    private By duckTitleName= By.xpath("//h1[@class='title']");

    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYellowDucksLink(){
        driver.findElement(yellowDuckLink).click();
    }

    public String getDuckTitleName(){
        return driver.findElement(duckTitleName).getText();
    }

    public List<String> getSearchResultNames() {
        List<String> ducksNames = new ArrayList<>();
        List<WebElement> elements = driver.findElements(searchResultLocator);
        for (WebElement element : elements) {
            ducksNames.add(element.getText());
        }
        return ducksNames;
    }
}
