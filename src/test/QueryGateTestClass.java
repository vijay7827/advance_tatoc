package test;

import java.sql.SQLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.QueryGatePageAction;

public class QueryGateTestClass extends WebDriverCommon {
	QueryGatePageAction querypage;
	@BeforeClass
	public void initVars3() {
		
		querypage = new QueryGatePageAction(driver);
		
	}
	@Test
	public void connect_database_test() throws ClassNotFoundException, SQLException {
		querypage.connect_database();
	}

}
