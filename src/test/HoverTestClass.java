package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import actions.HomePageActions;
import actions.HoverMenuPageAction;

public class HoverTestClass extends WebDriverCommon  {
	HoverMenuPageAction hoverpage;
	
	@BeforeClass
	public void initVars1() {
		 hoverpage = new HoverMenuPageAction(driver);
	}
	
	
	@Test
	public void hover_element() {
		hoverpage.find_hover_menu_element();
		hoverpage.list_appeared_verify();
	}
	@Test(dependsOnMethods = {"hover_element"})
	public void click_gonext() {
		hoverpage.click_go_menu();
		hoverpage.very_clicked();
	}
	

}
