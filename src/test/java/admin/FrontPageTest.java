package admin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FrontPage;
import pages.LoginPage;
import pages.LogoutPage;

public class FrontPageTest {
    private static WebDriver driver;
    FrontPage frontPage = new FrontPage(driver);
   
    public FrontPageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
//        LogoutPage logoutPage = new LogoutPage(driver);
//        logoutPage.clickOnNavCubesQADropdown();
//        logoutPage.clickOnLogoutButton();
    }
    
    @Test
    public void TestNavBrzeVesti (){
          frontPage.clickOnNavBrzeVestiLink();
          String expectedResult = "http://bvtest.school.cubes.rs/";
          String actualResult = driver.getCurrentUrl();
          
          assertTrue("User is not on Brze Vesti page", expectedResult.equals(actualResult));
          driver.navigate().back();
    }

    @Test
     public void TestNavSignaturesLink() {       
          frontPage.clickOnNavSignaturesLink();
          String expectedResult = "http://bvtest.school.cubes.rs/admin/signatures";
          String actualResult = driver.getCurrentUrl();
        
          assertTrue("User is not an Signatures page", expectedResult.equals(actualResult));
    }
     
    @Test 
      public void TestNavCategoriesLink(){
          frontPage.clickOnNavCategoriesLink();
          String expectedResult = "http://bvtest.school.cubes.rs/admin/categories";
          String actualResult = driver.getCurrentUrl();
        
          assertTrue("Usr is not on Caregory page", expectedResult.equals(actualResult));
    }
      
    @Test
      public void TestNavRegionsLink (){
          frontPage.clickOnNavRegionsLink();
          String expectedResult = "http://bvtest.school.cubes.rs/admin/regions";
          String actualResult = driver.getCurrentUrl();
          
          assertTrue("User is not on Regions page", expectedResult.equals(actualResult));
    }
      
    @Test
      public void TestNavPortalsLink (){
          frontPage.clickOnNavPortalsLink();
          String expectedResult = "http://bvtest.school.cubes.rs/admin/portals";
          String actualResult = driver.getCurrentUrl();
          
          assertTrue("User is not on Portals page", expectedResult.equals(actualResult));
    }
      
    @Test
      public void TestNavSourcesLink (){
          frontPage.clickOnNavSourcesLink();
          String expectedResult = "http://bvtest.school.cubes.rs/admin/sources";
          String actualResult = driver.getCurrentUrl();
           
          assertTrue("User is not on Sources page", expectedResult.equals(actualResult));
    }
}

