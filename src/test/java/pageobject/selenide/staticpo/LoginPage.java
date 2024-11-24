package pageobject.selenide.staticpo;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.xpath("//button[@type='submit'][@name='login']");
    private static By successMessage = By.xpath("//div[@class='notice success']");
    private static By errorMessage = By.xpath("//div[@class='notice errors']");

    public static void typeEmail(String email){
        $(emailInput).sendKeys(email);
    }

    public static void typePassword(String password){
        $(passwordInput).sendKeys(password);
    }

    public static void clickLoginButton(){
        $(loginButton).click();
    }

    public static void loginWithCredentials (String email, String password){
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }
    public static void validateSuccessMessage(){
        $(successMessage).shouldBe(Condition.visible);
    }
    public static void validateErrorMessage(){
        $(errorMessage).shouldBe(Condition.visible);
    }

    public static void validateSuccessMessageText(String expectedText){
        $(successMessage).shouldHave(Condition.text(expectedText));
    }
    public static void validateErrorMessageText(String expectedText){
        $(errorMessage).shouldHave(Condition.text(expectedText));
    }
}
