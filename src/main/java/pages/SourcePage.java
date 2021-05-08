package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SourcePage {
    private WebDriver driver;
    private By deleteButtonInFirstRowLocator = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[1]/td[8]/div/button[2]/span");
    private By confirmDeleteButtonLocator = By.xpath("//*[@id=\"sourceDeleteDialog\"]/div/div/div[3]/button[2]");
    private By tBodyLocator = By.xpath("//*[@id=\"sourcesTable\"]/tbody");
    private By tableRowsLocator = By.tagName("tr");
    private By titleSourceInFirstRowLocator = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[1]/td[2]");
    private By alertMessageForDeleteSourceLocator = By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[2]/div");
    private By titleSourceInSecondRowLocator = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[2]/td[2]");
    private By titleSourceInLastRowLocator = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[last()]/td[2]");
    private By deleteButtonInLastRowLocator = By.xpath("//*[@id=\"sourcesTable\"]/tbody/tr[last()]/td[last()]/div/button[2]");
    private By titleArrayLocator = By.xpath(".//td[2]");
    private By statusDropdownLocator = By.name("status");
    private By statusArrayLocator = By.xpath(".//td[7]/span");
    
    public SourcePage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOnDeleteButtonInFirstRow (){
        driver.findElement(deleteButtonInFirstRowLocator).click();
    }
    
    public void clickOnConfirmDeleteButton (){
        driver.findElement(confirmDeleteButtonLocator).click();
    }
    
    public String getAlertMessageForDeleteSorceInFirstRow (){
        return driver.findElement(alertMessageForDeleteSourceLocator).getText();
    }
    
    public String getTextTitleSourceInFirstRow (){
        return driver.findElement(titleSourceInFirstRowLocator).getText();
    }

    public String getTextTitleSourceInSecondRow() {
        return driver.findElement(titleSourceInSecondRowLocator).getText();
    }
    
     public List<WebElement> getAllRowsInSourcesTable (){
        if (!driver.findElements(tableRowsLocator).isEmpty()){
            WebElement tableBody = driver.findElement(tBodyLocator);
            return tableBody.findElements(tableRowsLocator);
            } 
            return new ArrayList<>();
    }
     
     public void selectFromSourceStatusDropdown (String statusName){
         Select statusDropdown = new Select(driver.findElement(statusDropdownLocator));
         statusDropdown.selectByVisibleText(statusName);
     }
     
     public List<String> getSourceStatusArrayFromSourcesTable (){
        List<String> statusValues = new ArrayList<>();
        List<WebElement> rows = this.getAllRowsInSourcesTable();
        for (WebElement row : rows){
             WebElement statusField = row.findElement(statusArrayLocator);
             String statusText = statusField.getText();
             statusValues.add(statusText);
        }
        return statusValues;
     }
     
     public String getAlertMessageForEmptyStatusFromSourcesTable (){
        List<String> statusValues = new ArrayList<>();
        List<WebElement> rows = this.getAllRowsInSourcesTable();
        for (WebElement row : rows){
             WebElement statusField = row.findElement(statusArrayLocator);
             String statusText = statusField.getText();
             statusValues.isEmpty();
        }
        return driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div[1]/div/div/div/div[2]/div/p")).getText();
     }
}