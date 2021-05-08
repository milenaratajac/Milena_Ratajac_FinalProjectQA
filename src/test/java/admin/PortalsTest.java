package admin;

import framework.Helper;
import java.util.List;
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
import pages.PortalsPage;
import org.openqa.selenium.WebElement;

public class PortalsTest {
    private static WebDriver driver;
    //private static WebDriverWait wait;
    LoginPage loginPage = new LoginPage(driver);
    PortalsPage portalsPage = new PortalsPage(driver);
    Helper helper = new Helper();
    FrontPage frontPage = new FrontPage (driver);

    public PortalsTest() {
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
        frontPage.clickOnNavPortalsLink();
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void AddNewPortalsTest() {
        portalsPage.clickOnAddPortalsButton();
        portalsPage.enterNewPortalTitle();
        String newPortalTitle = portalsPage.getEnteredNewPortalTitle();
        portalsPage.enterNewPortalUrl();
        portalsPage.clickOnSaveButton();
        
        String expectedAlertMessage = "Portal \"" + newPortalTitle + "\" has been successfully saved!";
        String actualAlertMessage = portalsPage.getAlertMessageTextTitle();
        assertTrue("Alert message is not correct", expectedAlertMessage.equals(actualAlertMessage));
    
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
        String lastRowPortalTitle = portalsPage.getLastRowPortal();
        assertTrue("New Portal is not on last row on results table.", lastRowPortalTitle.equals(newPortalTitle));

        List<String> titleValues = portalsPage.getTitleArrayFromPortalsResultsTable();
        System.out.println(titleValues);
        System.out.println (newPortalTitle);
        assertTrue("New Portal is not in results table", titleValues.contains(newPortalTitle));
     }
}



        