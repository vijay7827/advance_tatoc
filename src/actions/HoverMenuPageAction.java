package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HoverMenuPageAction  {

	WebDriver driver;
	public HoverMenuPageAction(WebDriver driver) {
		this.driver = driver;
		System.out.println(driver.getCurrentUrl() + " @@@@@@@@@@@@");
		
		// TODO Auto-generated constructor stub
	}

	public void find_hover_menu_element() {
		System.out.println(driver.getCurrentUrl() + " &&&&&&&&&&&&&&&&&");
	WebElement hoverElement = driver.findElement(By.xpath("//div[@class='menutop m2']"));
	Actions builder = new Actions(driver);
	builder.moveToElement(hoverElement).perform();
	
	
	}
	public void list_appeared_verify() {
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Go Next']")).isDisplayed());
	}
	
	public void click_go_menu() {
		 driver.findElement(By.xpath("//span[text()='Go Next']")).click();
		
	}
	public void very_clicked() {
		String newurl = driver.getCurrentUrl();
		Assert.assertEquals(newurl, "http://10.0.1.86/tatoc/advanced/query/gate");
		
	}

}
