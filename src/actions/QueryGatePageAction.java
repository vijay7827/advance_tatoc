package actions;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class QueryGatePageAction {
	WebDriver driver;
	public QueryGatePageAction(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getSymbol() {
		System.out.println(driver.getCurrentUrl());
		WebElement symbol = driver.findElement(By.xpath("//div[@id='symboldisplay']"));
		System.out.println(symbol.getText());
		return symbol.getText();
	}
	
	public void connect_database() throws ClassNotFoundException, SQLException {
		
		
		String dbUrl = "jdbc:mysql://10.0.1.86/tatoc";
		String username = "tatocuser";
		String password = "tatoc01";
		String query = "select *  from identity where symbol =" +"'"+getSymbol()+"'" +";";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =  DriverManager.getConnection(dbUrl,username,password);
	 Statement stmt =  con.createStatement();					
	 ResultSet rs= stmt.executeQuery(query);
	
	Long id = (long) 0;
	while(rs.next()) {
		id = rs.getLong("id");
		System.out.println("___________" + rs.getString("symbol"));
		
	}
	String query2 =  "select *  from credentials where id = " + "'" + id + "'"+";";
	rs = stmt.executeQuery(query2);
	while(rs.next()) {
		driver.findElement(By.id("name")).sendKeys(rs.getString("name"));
		driver.findElement(By.id("passkey")).sendKeys(rs.getString("passkey"));
	}
	driver.findElement(By.id("submit")).click();
	
	
	}

}
