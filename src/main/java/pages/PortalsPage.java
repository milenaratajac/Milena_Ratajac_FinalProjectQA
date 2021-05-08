package pages;

import framework.Helper;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalsPage {
    private WebDriver driver;
    private By addPortalsButtonLocator = By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[1]/a");
    private By titleFieldLocator = By.xpath("//*[@id=\"title\"]");
    private By urlFiledLocator = By.xpath("//*[@id=\"url\"]");
    private By saveButtonLocator = By.id("save-portal-button");
    private By alertMessageNewPortalTitleLocator = By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[2]/div");
    private By tBodyTableLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody");
    private By tableRowsLocator = By.tagName("tr");
    private By lastRowLocator = By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[last()]/td[3]");
    private By titleArrayLocator = By.xpath(".//td[3]");
            
    public PortalsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOnAddPortalsButton (){
        driver.findElement(addPortalsButtonLocator).click();
    }
    
    public void enterNewPortalTitle (){
        String newPortalTitle = Helper.GenerateTittle();
        driver.findElement(titleFieldLocator).sendKeys(newPortalTitle);
    }
    
    public String getEnteredNewPortalTitle() {
        return driver.findElement(titleFieldLocator).getAttribute("value");
    }
    
    public void enterNewPortalUrl (){
        String newPortalUrl = Helper.GenerateUrl();
        driver.findElement(urlFiledLocator).sendKeys(newPortalUrl);
    }
    
    public void clickOnSaveButton (){
        driver.findElement(saveButtonLocator).click();
    }
    
    public String getAlertMessageTextTitle (){
        return driver.findElement(alertMessageNewPortalTitleLocator).getText();
    }
    
    public String getLastRowPortal(){
        return driver.findElement(lastRowLocator).getText();
    }
    
    public List<WebElement> getAllRowsInPortalsTable (){
        if (!driver.findElements(tableRowsLocator).isEmpty()){
            WebElement tableBody = driver.findElement(tBodyTableLocator);
            return tableBody.findElements(tableRowsLocator);
            } 
            return new ArrayList<>();
    }
    
    public List<String> getTitleArrayFromPortalsResultsTable (){
        List<String> titleValues = new ArrayList<>();
        List<WebElement> rows = this.getAllRowsInPortalsTable();
        for (WebElement row : rows){
            titleValues.add(row.findElement(titleArrayLocator).getText());
        }
        return titleValues;
    }  
}

