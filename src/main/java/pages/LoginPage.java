package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By emailFieldLocator = By.name("email");
    private By passwordFieldLocator = By.name("password");
    private By loginButtonLocator = By.className("btn-primary");
    private By emailErrorMessageLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[1]/div/span/strong");
    private By passwordErrorMessageLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[2]/div/span/strong");
    private By invalidCredentialsErorMessageLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[1]/div/span/strong");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void enterEmail (String email){
        driver.findElement(emailFieldLocator).sendKeys(email);
    }
    
    public void enterPassword (String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    
    public void clickOnLoginButton (){
        driver.findElement(loginButtonLocator).click();
    }

    public String emailErrorMessageText() {
        return driver.findElement(emailErrorMessageLocator).getText();
    }

    public String passwordErrorMessageText() {
        return driver.findElement(passwordErrorMessageLocator).getText();
    }
    
    public String errorMessageTextWithInvalidCredentials (){
        return driver.findElement(invalidCredentialsErorMessageLocator).getText();
    }
}
