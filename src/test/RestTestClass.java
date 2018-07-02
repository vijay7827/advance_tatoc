package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.RestAction;

public class RestTestClass extends WebDriverCommon {
	RestAction RestPage;

	@BeforeClass
	public void initVars() {
		RestPage = new RestAction(driver);
	}
	
	@Test
	public void Step01_Launch(){
		RestPage.launchApplication("http://10.0.1.86/tatoc/advanced/rest/#");
		
	}
	@Test
	public void generatetoken() throws Exception {
		RestPage.generate_token();
		RestPage.register_token();
		RestPage.click_proceed();
	}
	
	
	

}
