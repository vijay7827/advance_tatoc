package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import actions.HomePageActions;



public class HomeTestClass extends WebDriverCommon {
	HomePageActions homepage;

	@BeforeClass
	public void initVars() {
		/*String exePath = "C:\\Users\\Shivamjaiswal\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();*/
		 homepage = new HomePageActions(driver);
	}
	
	@Test
	public void Step01_Launch_Homepage(){
		homepage.launchApplication("http://10.0.1.86/tatoc");
		homepage.verifyHomePageLaunched();
	}
	
	@Test (dependsOnMethods={"Step01_Launch_Homepage"})
	public void STEP02_Click_Link(){
		homepage.find_click_link();
		homepage.verify_link_clicked();
		
	}

	
	
	@AfterClass
	public void closeBrowser(){
		//driver.close();
	}
	

}
