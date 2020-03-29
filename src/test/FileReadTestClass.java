package test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.FileReadAction;;

public class FileReadTestClass extends WebDriverCommon {
	FileReadAction FilePage;

	@BeforeClass
	public void initVars() throws InterruptedException {
		Thread.sleep(100);
		System.out.println("888888899" + driver.getCurrentUrl());
		FilePage = new FileReadAction(driver);
	}
	@Test
	public void read() throws InterruptedException, IOException {
		FilePage.downloadfile();
		FilePage.read_file();
		
	}
	
}
