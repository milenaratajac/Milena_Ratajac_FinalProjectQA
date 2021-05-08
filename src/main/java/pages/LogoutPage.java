package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    private WebDriver driver;
    private By navCubesQADropdownLocator = By.className("dropdown-toggle");
    private By logoutButtonLocator = By.linkText("Logout");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOnNavCubesQADropdown (){
        driver.findElement(navCubesQADropdownLocator).click();
    }
    public void clickOnLogoutButton (){
        driver.findElement(logoutButtonLocator).click();
    }
}
