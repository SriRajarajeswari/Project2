package crm.qa.pages.test;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestBase.TestBase;
import crm.qa.pages.DealsPage;
import crm.qa.pages.HomePage;
import crm.qa.pages.LoginPage;
import crm.qa.pages.TaskPage;
import crm.qa.util.TestUtil;

public class TasksPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	TaskPage TaskPage;
	
	String sheetName = "Tasks";
	
	
	public TasksPageTest(){
		super();	
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		TaskPage = new TaskPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//TestUtil.runTimeInfo("error", "login successful");
		testUtil.switchToFrame();
		TaskPage = homePage.clickOnTasksLink();
	}
	
	
	@Test(priority=1)
	public void verifyDealsPageLabel(){
		Assert.assertTrue(TaskPage.verifyTasksLabel(), "contacts label is missing on the page");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getCRMTestData")
	//@Test(priority=4)
	public void validatecreateNewTask(String type, String titl, String completion, String prospect_lookup, String description,String priority,String Datepicker){
	//public void validateCreateNewContact() {
		homePage.clickOnNewTasksLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		TaskPage.createNewTask(type, titl, completion,prospect_lookup,description,priority,Datepicker);
		
	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}

