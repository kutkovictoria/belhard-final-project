package pageobject.selenide.staticpo;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CatalogTest extends TestBase {
    @Test
    public void findDuckByTitleName() {
        String expectedDuckTitleName = "Purple Duck";
        HomePage.searchDataViaSearchInput(expectedDuckTitleName);
        CatalogPage.validateDuckTitleName(expectedDuckTitleName);
    }

    @Test
    public void findAllDucksByKeywordDuck() {
        String searchInputValue = "Duck";
        HomePage.searchDataViaSearchInput(searchInputValue);

        Assert.assertTrue(CatalogPage.getSearchResultNames().stream().anyMatch(result -> result.contains(searchInputValue)), "Not all result names contain " + searchInputValue);
    }
}
