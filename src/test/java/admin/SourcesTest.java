package admin;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FrontPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.SourcePage;

public class SourcesTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    LoginPage loginPage = new LoginPage(driver);
    FrontPage frontPage = new FrontPage (driver);
    SourcePage sourcePage = new SourcePage(driver);
    public SourcesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");       
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
        frontPage.clickOnNavSourcesLink();
    }
    
    @After
    public void tearDown() {
        LogoutPage logoutPage = new LogoutPage (driver);
        logoutPage.clickOnNavCubesQADropdown();
        logoutPage.clickOnLogoutButton();
    }

     @Test
     public void deleteSourceInFirstRowTest() {
        String titleSourceInFirstRow = sourcePage.getTextTitleSourceInFirstRow();
        System.out.println(titleSourceInFirstRow);
        String titleSourceInSecondRow = sourcePage.getTextTitleSourceInSecondRow();
        System.out.println(titleSourceInSecondRow);
        sourcePage.clickOnDeleteButtonInFirstRow();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sourcePage.clickOnConfirmDeleteButton();
        
        String expectedAlertMessage = "Source \"" + titleSourceInFirstRow + "\" has been successfully deleted!";
        String actualAlertMessage = sourcePage.getAlertMessageForDeleteSorceInFirstRow();
        assertTrue("Alert message is not correct", expectedAlertMessage.equals(actualAlertMessage));
        
        String newTitleSourceInFirstRow = sourcePage.getTextTitleSourceInFirstRow();
        System.out.println(newTitleSourceInFirstRow);
        assertEquals("The first row in the Source table is not deleted", titleSourceInSecondRow, newTitleSourceInFirstRow);        
     }
     
     @Test
     public void sourceStatusFilterWithEnabled (){
        sourcePage.selectFromSourceStatusDropdown("Enabled");
        List<String> statusValues = sourcePage.getSourceStatusArrayFromSourcesTable();
        
        for (String statusWord : statusValues){
            assertEquals("Test failed, statues doesn't match", statusWord, "E");
        }
     }    
//     @Test
//     public void sourceStatusFilterWithDisabled (){
//         sourcePage.selectFromSourceStatusDropdown("Disabled");
//         List<String> statusValues = sourcePage.getSourceStatusArrayFromSourcesTable();
//         for (String statusWord : statusValues){
//             assertEquals("Test failed, statues doesn't match", statusWord, "D");
//         }
     
     @Test
     public void sourceStatusFilterWithDisabled (){
        sourcePage.selectFromSourceStatusDropdown("Disabled");
         
        String expectedAlertMessage = "There are no sources matching criteria";
        String actualAlertMessage = sourcePage.getAlertMessageForEmptyStatusFromSourcesTable();
        assertTrue("Alert message is not correct", expectedAlertMessage.equals(actualAlertMessage));
        }
}
