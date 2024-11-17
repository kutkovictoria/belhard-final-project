package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit'][@name='login']");
    private By successMessage = By.xpath("//div[@class='notice success']");
    private By errorMessage = By.xpath("//div[@class='notice errors']");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void typeEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void typePassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void loginWithCredentials (String email, String password){
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }
    public boolean successMessageIsDisplayed(){
        return driver.findElement(successMessage).isDisplayed();
    }

    public String getSuccessMessageText(){
        return  driver.findElement(successMessage).getText();
    }
    public boolean errorMessageIsDisplayed(){
        return driver.findElement(errorMessage).isDisplayed();
    }

    public String getErrorMessageText(){
        return  driver.findElement(errorMessage).getText();
    }
}
