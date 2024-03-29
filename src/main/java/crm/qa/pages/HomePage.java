package crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Hari Neeraj')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Deal')]")
	WebElement newDealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Task')]")
	WebElement newTasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTasksLink(){
		tasksLink.click();
		return new TaskPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	public void clickOnNewDealsLink(){
		Actions action = new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		newDealsLink.click();
		
	}
	
	public void clickOnNewTasksLink(){
		Actions action = new Actions(driver);
		action.moveToElement(tasksLink).build().perform();
		newTasksLink.click();
		
	}

}
