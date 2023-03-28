package cubes.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cubes.helper.MyWebDriver;
import cubes.pages.LoginPage;


public class LoginTest {

	private static WebDriver driver; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = MyWebDriver.getDriver("chrome");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//Login with empty fields
	@Test
	public void tc01() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login("", "");
				
		assertTrue("Email error missing!", loginPage.checkEmailError("Email* is required field"));
		assertTrue("Password error missing!", loginPage.checkPasswordError("Password* is required field"));
	}
	
	//Login with incorrect Email format
		@Test
		public void tc02() {
			LoginPage loginPage = new LoginPage(driver);
			
			loginPage.insertEmail("abc123");
			loginPage.insertPassword("");
			loginPage.clickOnLogin();
			
			assertTrue("Email error missing!", loginPage.checkEmailError("Email* is required field"));
			assertTrue("Password error missing!", loginPage.checkPasswordError("Password* is required field"));
		}
			
	   //Login with invalid Email
		@Test
		public void tc03() {
			LoginPage loginPage = new LoginPage(driver);
			
			loginPage.insertEmail("example@mail123.com");
			loginPage.insertPassword("");
			loginPage.clickOnLogin();
			
			assertTrue("Password error missing!", loginPage.checkPasswordError("Password* is required field"));
	
		}	

		//Login with valid Email
		@Test
		public void tc04() {
			LoginPage loginPage = new LoginPage(driver);
			
			loginPage.insertEmail("kursqa@cubes.edu.rs");
			loginPage.insertPassword("");
			loginPage.clickOnLogin();
			
			assertTrue("Password error missing!", loginPage.checkPasswordError("Password* is required field"));

		}
			
		//Login with empty Email field and incorrect password		
		@Test
		public void tc05() {
			LoginPage loginPage = new LoginPage(driver);
			
			loginPage.insertEmail("");
			loginPage.insertPassword("abcabc");
			loginPage.clickOnLogin();
			
				
			assertTrue("Email error missing!", loginPage.checkEmailError("Email* is required field"));
		}
				
		//Login with empty Email field and valid password
		@Test
		public void tc06() {
			LoginPage loginPage = new LoginPage(driver);

			loginPage.insertEmail("");
			loginPage.insertPassword("cubesqa");
			loginPage.clickOnLogin();
			
				
			assertTrue("Email error missing!", loginPage.checkEmailError("Email* is required field"));
		}
			
		//Login with incorrect Email format and invalid Password
		@Test
		public void tc07() {
			LoginPage loginPage = new LoginPage(driver);

			loginPage.insertEmail("abc123");
			loginPage.insertPassword("abcabc");
			loginPage.clickOnLogin();
			
			assertTrue("Enter valid Email message not displayed!", loginPage.checkEmailError("Please, enter the valid Email address"));

		}
			
		//Login with invalid Email address and invalid Password	
		@Test
		public void tc08() {
			LoginPage loginPage = new LoginPage(driver);

			loginPage.insertEmail("example@mail123.com");
			loginPage.insertPassword("abcabc");
			loginPage.clickOnLogin();
				
			assertTrue("Credentials message not displayed!",loginPage.checkMessageError("These credentials do not match our records."));
		}
			
		//Login with valid Email address and invalid Password
		@Test
		public void tc09() {
			LoginPage loginPage = new LoginPage(driver);

			loginPage.insertEmail("kursqa@cubes.edu.rs");
			loginPage.insertPassword("abcabc");
			loginPage.clickOnLogin();
							
			assertTrue("Credentials message not displayed!",loginPage.checkMessageError("These credentials do not match our records."));

		}
		
		//Login with incorrect Email address and valid Password
		@Test
		public void tc10() {
			LoginPage loginPage = new LoginPage(driver);

			loginPage.insertEmail("abc123");
			loginPage.insertPassword("cubesqa");
			loginPage.clickOnLogin();
							
			assertTrue("Enter valid Email message not displayed!", loginPage.checkEmailError("Please, enter the valid Email address"));
		}
			
		//Login with invalid Email address and valid Password
		@Test
		public void tc11() {
			LoginPage loginPage = new LoginPage(driver);

			loginPage.insertEmail("example@mail123.com");
			loginPage.insertPassword("cubesqa");
			loginPage.clickOnLogin();
						
			assertTrue("Credentials message not displayed!",loginPage.checkMessageError("These credentials do not match our records."));
		}
			
		//Login with valid Email address and valid Password
		@Test
		public void tc12() {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.insertEmail("kursqa@cubes.edu.rs");
			loginPage.insertPassword("cubesqa");
			loginPage.clickOnLogin();
		}				
	}