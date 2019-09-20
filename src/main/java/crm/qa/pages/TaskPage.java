package crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TestBase.TestBase;

public class TaskPage extends TestBase{
	

	
	@FindBy(xpath = "//td[contains(text(),'Tasks')]")
	WebElement TasksLabel;
	
	@FindBy(id="title")
	WebElement title;
	
	@FindBy(name="completion")
	WebElement completionfield;
	
	@FindBy(name="prospect_lookup")
	WebElement prospect;
	
	
	@FindBy(name="description")
	WebElement descriptionfield;
	
	@FindBy(xpath = "//input[@type='text' and @name='deadline']")
	WebElement Datepickerfield;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public TaskPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTasksLabel(){
		return TasksLabel.isDisplayed();
	}
	

	
	
	public void createNewTask(String type, String titl, String completion, String prospect_lookup, String description,String priority,String Datepicker){
		Select select = new Select(driver.findElement(By.name("task_type")));
		select.selectByVisibleText(type);
		Select select1 = new Select(driver.findElement(By.name("priority")));
		select1.selectByVisibleText(priority);
		
		
		title.sendKeys(titl);
		completionfield.sendKeys(completion);
		prospect.sendKeys(prospect_lookup);
		descriptionfield.sendKeys(description);
		Datepickerfield.sendKeys(Datepicker);
		saveBtn.click();
		
	}

	
	
	
	
	

}
