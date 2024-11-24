package pageobject.selenide.staticpo;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {
    private static By yellowDuckLink = By.xpath("//div[@class='name'][text()='Yellow Duck']");
    private static By searchResultLocator = By.xpath("//div[@class='name']");
    private static By duckTitleName = By.xpath("//h1[@class='title']");

    public static void clickYellowDucksLink() {
        $(yellowDuckLink).click();
    }

    public static void validateDuckTitleName(String expectedText) {
        $(duckTitleName).shouldHave(Condition.text(expectedText));
    }

    public static List<String> getSearchResultNames() {
        return $$(searchResultLocator).texts();
    }
}
