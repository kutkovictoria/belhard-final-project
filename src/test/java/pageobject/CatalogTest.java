package pageobject;
import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CatalogTest extends TestBase{
    @Test
    public void findYellowDuck() {
        HomePage homePage = new HomePage(driver);
        homePage.searchDataViaSearchInput("Yellow Duck");
        Assert.assertEquals(driver.getTitle(), "Yellow Duck | Subcategory | Rubber Ducks | My Store");
    }

    @Test
    public void findAllDucks() {
        String searchInputValue = "Duck";
        HomePage homePage = new HomePage(driver);
        homePage.searchDataViaSearchInput(searchInputValue);
        CatalogPage catalogPage = new CatalogPage(driver);

        Assert.assertTrue(catalogPage.getSearchResultNames().stream().anyMatch(result -> result.contains(searchInputValue)), "Not all result names contain " + searchInputValue);
    }

}
