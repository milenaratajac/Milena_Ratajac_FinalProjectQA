package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrontPage {
    private WebDriver driver;
    private By navBrzeVestiLinkLocator = By.className("navbar-brand");
    private By navDashboardLinkLocator = By.linkText("Dashboard");
    private By navSignaturesLinkLocator = By.linkText ("Signatures");
    private By navCategoriesLinkLocator = By.linkText ("Categories");
    private By navRegionsLinkLocator = By.linkText ("Regions");
    private By navPortalsLinkLocator = By.linkText ("Portals");
    private By navSourcesLinkLocator = By.linkText ("Sources");
    private By navCubesQADropdownLocator = By.className("dropdown-toggle");

    public FrontPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOnNavBrzeVestiLink (){
        driver.findElement(navBrzeVestiLinkLocator).click();
    }
    
    public void clickOnNavDashboardLink(){
        driver.findElement(navDashboardLinkLocator).click();
    }
    
    public void clickOnNavSignaturesLink (){
        driver.findElement(navSignaturesLinkLocator).click();
    }
    
    public void clickOnNavCategoriesLink (){
        driver.findElement(navCategoriesLinkLocator).click();
    }
    
    public void clickOnNavRegionsLink (){
        driver.findElement(navRegionsLinkLocator).click();
    }
    
    public void clickOnNavPortalsLink (){
        driver.findElement(navPortalsLinkLocator).click();
    }
    
    public void clickOnNavSourcesLink (){
        driver.findElement(navSourcesLinkLocator).click();
    }
    
    public void clickOnNavCubesQADropdown (){
        driver.findElement(navCubesQADropdownLocator).click();
    }
}