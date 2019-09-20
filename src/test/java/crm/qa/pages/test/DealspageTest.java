package crm.qa.pages.test;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.TestBase;
import crm.qa.pages.ContactsPage;
import crm.qa.pages.DealsPage;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.qa.util.TestUtil;

public class DealspageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage DealsPage;
	
	String sheetName = "Deals";
	
	public DealspageTest(){
		super();
		
}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		DealsPage = new DealsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//TestUtil.runTimeInfo("error", "login successful");
		testUtil.switchToFrame();
		DealsPage = homePage.clickOnDealsLink();
	}
	
	
	@Test(priority=1)
	public void verifyDealsPageLabel(){
		Assert.assertTrue(DealsPage.verifyDealsLabel(), "contacts label is missing on the page");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getCRMTestData")
	//@Test(priority=4)
	public void validatecreateNewDeal(String type, String titl, String comp){
	//public void validateCreateNewContact() {
		homePage.clickOnNewDealsLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		DealsPage.createNewDeal(type, titl, comp);
		
	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
