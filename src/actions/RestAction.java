package actions;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestAction {
	
	WebDriver driver;
	public RestAction(WebDriver driver){
		this.driver = driver;
	}

	public void launchApplication(String string) {
		driver.get(string);
		
		System.out.println("User launched URL: "+string);
	}
	public String session_id() {
		String token  = driver.findElement(By.id("session_id")).getText();
		token = token.replaceAll("Session ID: ", "");
		return token;
		
	}
	public String generate_token() throws Exception {
		
	String url = "http://10.0.1.86/tatoc/advanced/rest/service/token/" +session_id();

	HttpClient client = HttpClientBuilder.create().build();
	HttpGet request = new HttpGet(url);

	HttpResponse response = client.execute(request);

	BufferedReader rd = new BufferedReader(
                   new InputStreamReader(response.getEntity().getContent()));

	StringBuffer result = new StringBuffer();
	String line = "";
	while ((line = rd.readLine()) != null) {
		result.append(line);
	}
	
	JSONParser parser = new JSONParser();
	JSONObject json = null;
	try {
		json = (JSONObject) parser.parse(result.toString());
	} catch (ParseException e) {
		// TODO Auto-generated catch blocket
		e.printStackTrace();
	}
	return json.get("token").toString();

	
		
		
		
	}
	
	public void register_token() throws Exception {
		String url = "http://10.0.1.86/tatoc/advanced/rest/service/register";
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("id", session_id()));
		urlParameters.add(new BasicNameValuePair("signature", generate_token()));
		urlParameters.add(new BasicNameValuePair("allow_access", "1"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
				
	}
	public void click_proceed() {
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();;
	}
}
