package crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TestBase.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'Deals')]")
	WebElement DealsLabel;
	
	@FindBy(id="title")
	WebElement title;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDealsLabel(){
		return DealsLabel.isDisplayed();
	}
	
	public void createNewDeal(String type, String titl, String comp){
		Select select = new Select(driver.findElement(By.name("type")));
		select.selectByVisibleText(type);
		
		title.sendKeys(titl);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
	
	
	
	
	
}
