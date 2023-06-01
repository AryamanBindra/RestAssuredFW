package tekarch.tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import tekarch.utilities.DataUtils;

public class LoginTest extends BaseTest{

	String token = null;
	
	@Test(priority = 1)
	public void TC01_loginReq() throws IOException {
		String env = System.getProperty("user.dir") + "//src//main//java//testData//env.json";
		String prodEnv = DataUtils.readJsonFileAsString(env);
		RestAssured.baseURI = JsonPath.read(prodEnv, "$.prod.uri");
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("content-type", "application/json");
		
		String body = "{\"username\": \"mithun@ta.com\", \"password\": \"mithun\"}";
		
		Response response = lu.taPost("/login", headers, body);
		
		System.out.println(response.asString());
		if (response.statusCode() == 201) {
			token = response.jsonPath().get("token").toString().replaceAll("\\[", "").replaceAll("]", "");
			System.out.println(token);
		}
	}
	
	@Test(dependsOnMethods = "TC01_loginReq")
	public void TC2_GetData() throws IOException {
		String env = System.getProperty("user.dir") + "//src//main//java//testData//env.json";
		String prodEnv = DataUtils.readJsonFileAsString(env);
		RestAssured.baseURI = JsonPath.read(prodEnv, "$.prod.uri");
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("token", token);
		headers.put("content-type", "application/json");
		
		Response response = lu.taGet("/getData", headers);
		
		if (response.statusCode() == 401) {
			System.out.println(response.jsonPath().get("status").toString());
		} else
			System.out.println("---");
	}
			

	@Test(dependsOnMethods = "TC01_loginReq")
	public void TC03_addData() throws IOException {
		String env = System.getProperty("user.dir") + "//src//main//java//testData//env.json";
		String prodEnv = DataUtils.readJsonFileAsString(env);
		RestAssured.baseURI = JsonPath.read(prodEnv, "$.prod.uri");

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("token", token);
		headers.put("content-type", "application/json");
		

		String dataPath = System.getProperty("user.dir") + "//src//main//java//testData//addData.json";
		String body = DataUtils.readJsonFileAsString(dataPath);
	
		Response response = lu.taPost("/addData", headers, body);

		if (response.statusCode() == 201) {
			System.out.println(response.jsonPath().get("status").toString());
		} else
			System.out.println("--Failed--");
	}


}
