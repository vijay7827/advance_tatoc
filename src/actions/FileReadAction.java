package actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileReadAction {

	WebDriver driver;
	public FileReadAction(WebDriver driver){
		this.driver = driver;
		System.out.println(driver.getCurrentUrl());
	}
	
	public void downloadfile() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
		Thread.sleep(500);
		
	}
	public void read_file() throws IOException {
		File file = new File("C:\\Users\\Shivamjaiswal\\Downloads\\file_handle_test.dat");
		BufferedReader br = new BufferedReader(new FileReader(file));
		// System.out.println(file.getAbsolutePath());
	
		String st;
		while ((st = br.readLine()) != null) {
		 if(st.contains("Signature")) {
				 st = st.replace("Signature: ", "");
				 br.close();
				 file.delete();
				 driver.findElement(By.xpath("//*[@id=\"signature\"]")).sendKeys(st);
				 driver.findElement(By.xpath("/html/body/div/div[2]/form/input[2]")).click();
				 break;
			 }
		  System.out.println(st);
		}
		
		  
	}
}
