package tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RapidStock extends BaseTest{
	
	@Test
	public void stockTime_InterDay() {
		test = extent.createTest("stockTime_InterDay");
		
		RestAssured.baseURI = "https://alpha-vantage.p.rapidapi.com";
		
		HashMap<String, String> query = new HashMap<String, String>();
		query.put("interval", "5min");
		query.put("function", "TIME_SERIES_INTRADAY");
		query.put("symbol", "MSFT");
		query.put("datatype", "json");
		query.put("output_size", "compact");
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("X-RapidAPI-Key", "52942249cemshc46118935f70976p1c3ccbjsnf9085d0eab24");
		headers.put("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com");
		
		Response res = lu.taGet("/query", headers, query);
		
		System.out.println(res.getStatusCode());
		
		if(res.getStatusCode() == 200) {
			System.out.println("Inter Day Stock data recieved");
			test.log(Status.PASS, "Inter Day Stock data recieved");
		}
		
		else
			test.log(Status.FAIL, "Failed");
		
	}
	
	@Test
	public void forex_Daily() {
		test = extent.createTest("forex_Daily");
		
		RestAssured.baseURI = "https://alpha-vantage.p.rapidapi.com";
		HashMap<String, String> query = new HashMap<String, String>();
		query.put("rom_symbol", "EUR");
		query.put("function", "FX_DAILY");
		query.put("to_symbol", "USD");
		query.put("outputsize", "compact");
		query.put("datatype", "json");
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("X-RapidAPI-Key", "52942249cemshc46118935f70976p1c3ccbjsnf9085d0eab24");
		headers.put("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com");
		
//		Response res = RestAssured.given().queryParams(map).headers(headers).get("/query").andReturn();
		Response res = lu.taGet("/query", headers, query);
		System.out.println(res.getStatusCode());
		
		if(res.getStatusCode() == 200) {
			System.out.println("Forex Daily Stock data recieved");
			test.log(Status.PASS, "Forex Daily Stock data recieved");
		}
		else
			test.log(Status.FAIL, "Failed");
		
	}
	
	@Test
	public void bitCoin_ExchgRate() {
		test = extent.createTest("bitCoin_ExchgRate");
		
		RestAssured.baseURI = "https://alpha-vantage.p.rapidapi.com";
		HashMap<String, String> query = new HashMap<String, String>();
		query.put("from_currency", "BTC");
		query.put("function", "CURRENCY_EXCHANGE_RATE");
		query.put("to_currency", "USD");
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("X-RapidAPI-Key", "52942249cemshc46118935f70976p1c3ccbjsnf9085d0eab24");
		headers.put("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com");
		
//		Response res = RestAssured.given().queryParams(map).headers(headers).get("/query").andReturn();
		Response res = lu.taGet("/query", headers, query);
		System.out.println(res.asPrettyString());
		
		if(res.getStatusCode() == 200) {
			System.out.println("Bitcoin to USD Stock Exchange rate recieved");
			test.log(Status.PASS, "Bitcoin to USD Stock Exchange rate recieved"+res.asPrettyString());
		}
		else
			test.log(Status.FAIL, "Failed");
		
	}
	
	@Test
	public void DIGITAL_CURRENCY_WEEKLY() {
		test = extent.createTest("DIGITAL_CURRENCY_WEEKLY");
		
		RestAssured.baseURI = "https://alpha-vantage.p.rapidapi.com";
		HashMap<String, String> query = new HashMap<String, String>();
		query.put("market", "CNY");
		query.put("function", "DIGITAL_CURRENCY_WEEKLY");
		query.put("symbol", "BTC");
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("X-RapidAPI-Key", "52942249cemshc46118935f70976p1c3ccbjsnf9085d0eab24");
		headers.put("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com");
		
//		Response res = RestAssured.given().queryParams(map).headers(headers).get("/query").andReturn();
		Response res = lu.taGet("/query", headers, query);
		System.out.println(res.asPrettyString());
		
		if(res.getStatusCode() == 200) {
			System.out.println("Digital Weekly Exchange rate recieved");
			test.log(Status.PASS, "Digital Weekly Exchange rate recieved"+res.asPrettyString());
		}
		else
			test.log(Status.FAIL, "Failed");
		
	}
	
	@Test
	public void DIGITAL_CURRENCY_MONTHLY() {
		test = extent.createTest("DIGITAL_CURRENCY_MONTHLY");
		
		RestAssured.baseURI = "https://alpha-vantage.p.rapidapi.com";
		HashMap<String, String> query = new HashMap<String, String>();
		query.put("market", "CNY");
		query.put("function", "DIGITAL_CURRENCY_MONTHLY");
		query.put("symbol", "BTC");
		
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("X-RapidAPI-Key", "52942249cemshc46118935f70976p1c3ccbjsnf9085d0eab24");
		headers.put("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com");
		
//		Response res = RestAssured.given().queryParams(query).headers(headers).get("/query").andReturn();
		Response res = lu.taGet("/query", headers, query);
		System.out.println(res.asPrettyString());
		
		if(res.getStatusCode() == 200) {
			System.out.println("Digital monthly Exchange rate recieved");
			test.log(Status.PASS, "Digital monthly Exchange rate recieved"+res.asPrettyString());
		}
		else
			test.log(Status.FAIL, "Failed");
		
	}
	
	

}
