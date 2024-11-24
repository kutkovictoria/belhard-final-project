package pageobject.object;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends TestBase {
    @Test
    public void findDuckByTitleName() {
        String expectedDuckTitleName = "Purple Duck";
        HomePage homePage = new HomePage(driver);
        homePage.searchDataViaSearchInput(expectedDuckTitleName);
        CatalogPage catalogPage = new CatalogPage(driver);

        Assert.assertEquals(catalogPage.getDuckTitleName(), expectedDuckTitleName);
    }

    @Test
    public void findAllDucksByKeywordDuck() {
        String searchInputValue = "Duck";
        HomePage homePage = new HomePage(driver);
        homePage.searchDataViaSearchInput(searchInputValue);
        CatalogPage catalogPage = new CatalogPage(driver);

        Assert.assertTrue(catalogPage.getSearchResultNames().stream().anyMatch(result -> result.contains(searchInputValue)), "Not all result names contain " + searchInputValue);
    }
}
