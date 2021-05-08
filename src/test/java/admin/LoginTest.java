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
import pages.LoginPage;
import pages.LogoutPage;

public class LoginTest {
     private static WebDriver driver;
     LoginPage loginPage = new LoginPage(driver);
    
    public LoginTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidCredentialsLogin() {
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        
        assertTrue("Bad URL redirection.", expectedUrl.equals(actualUrl));
        
        LogoutPage logoutPage = new LogoutPage (driver);
        logoutPage.clickOnNavCubesQADropdown();
        logoutPage.clickOnLogoutButton();
    }
    
    @Test
    public void testInvalidCredentialsLogin() {
        loginPage.enterEmail("qa123@cuber.rs");
        loginPage.enterPassword("cubesqa123");
        loginPage.clickOnLoginButton();
        
        String expectedEmailErrorMessage = "These credentials do not match our records.";
        String actualEmailErrorMessage = loginPage.errorMessageTextWithInvalidCredentials();
        assertTrue("Email hepl message is not corect", expectedEmailErrorMessage.equals(actualEmailErrorMessage));
    }
    
    @Test
    public void testEmptyCredentialsLogin() {
        loginPage.clickOnLoginButton();
        
        String expectedEmailErrorMessage = "The email field is required.";
        String actualEmailErrorMessage = loginPage.emailErrorMessageText();
        assertTrue("Email hepl message is not corect", expectedEmailErrorMessage.equals(actualEmailErrorMessage));
        
        String expectedPasswordErrorMessage = "The password field is required.";
        String actualPasswordErrorMessage = loginPage.passwordErrorMessageText();
        assertTrue("Password help message is not corect", expectedPasswordErrorMessage.equals(actualPasswordErrorMessage));
    }
    
    @Test
    public void testEmptyFieldEmailValidPasswordLogin() {
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
        
        String expectedEmailErrorMessage = "The email field is required.";
        String actualEmailErrorMessage = loginPage.emailErrorMessageText();
        assertTrue("Email hepl message is not corect", expectedEmailErrorMessage.equals(actualEmailErrorMessage));
    }
    
    @Test
    public void testEmptyFieldEmailInvalidPasswordLogin() {
        loginPage.enterPassword("cubesqa123");
        loginPage.clickOnLoginButton();
        
        String expectedEmailErrorMessage = "The email field is required.";
        String actualEmailErrorMessage = loginPage.emailErrorMessageText();
        assertTrue("Email hepl message is not corect", expectedEmailErrorMessage.equals(actualEmailErrorMessage));
    }
    
    @Test
    public void testValidEmailEmptyFieldPasswordLogin() {
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.clickOnLoginButton();
        
        String expectedPasswordErrorMessage = "The password field is required.";
        String actualPasswordErrorMessage = loginPage.passwordErrorMessageText();
        assertTrue("Password help message is not corect", expectedPasswordErrorMessage.equals(actualPasswordErrorMessage));
    }
    
    @Test
    public void testValidEmailInvalidPasswordLogin() {
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("cubesqa123");
        loginPage.clickOnLoginButton();
        
        String expectedEmailErrorMessage = "These credentials do not match our records.";
        String actualEmailErrorMessage = loginPage.errorMessageTextWithInvalidCredentials();
        assertTrue("Email hepl message is not corect", expectedEmailErrorMessage.equals(actualEmailErrorMessage));
    }
    
    @Test
    public void testInvalidEmailEmptyFieldPasswordLogin() {
        loginPage.enterEmail("qa123@cuber.rs");
        loginPage.clickOnLoginButton();
        
        String expectedPasswordErrorMessage = "The password field is required.";
        String actualPasswordErrorMessage = loginPage.passwordErrorMessageText();
        assertTrue("Password help message is not corect", expectedPasswordErrorMessage.equals(actualPasswordErrorMessage));
    }
    
    @Test
    public void testInvalidEmailValidPasswordLogin() {
        loginPage.enterEmail("qa123@cubes.rs");
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
        
        String expectedEmailErrorMessage = "These credentials do not match our records.";
        String actualEmailErrorMessage = loginPage.errorMessageTextWithInvalidCredentials();
        assertTrue("Email hepl message is not corect", expectedEmailErrorMessage.equals(actualEmailErrorMessage));
    }
}
