package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePageActions {
	WebDriver driver;
	public HomePageActions(WebDriver driver){
		this.driver = driver;
	}

	public void launchApplication(String string) {
		driver.get(string);
		System.out.println("User launched URL: "+string);
	}

	public void verifyHomePageLaunched() {
		WebElement logo = driver.findElement(By.className("title"));
		Assert.assertTrue(logo.isDisplayed());
		System.out.println("User is on homepage");
	}
	
	public void find_click_link() {
		WebElement advance_link = driver.findElement(By.linkText("Advanced Course"));
		System.out.println("Advanced Course link found");
		advance_link.click();
	}
	public void verify_link_clicked() {
		String Text =  driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(Text, "Hover Menu");
		System.out.println("Advance Link clicked");
		
		
	}
}
