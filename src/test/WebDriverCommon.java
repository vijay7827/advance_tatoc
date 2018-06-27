package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class WebDriverCommon {

	  static  public WebDriver driver;
	  //  String baseurl = "http://10.0.1.86/tatoc";     

	    @BeforeTest
	    public void openBrowser(){
	    	String exePath = "C:\\Users\\Shivamjaiswal\\Downloads\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
	      //  driver.manage().window().maximize();
	    }
}
