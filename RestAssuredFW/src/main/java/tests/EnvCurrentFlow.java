package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class EnvCurrentFlow extends BaseTest {

	public static String data;
	

	@Test(priority = 1)
	public void climateData() {
		test = extent.createTest("climateData");

		Response response = lu.taGet(
				"https://api.openweathermap.org/data/2.5/weather?q=davis &appid=08879b09b61cbc80bb47626adcbd5331&");

		data = response.asString();

		Assert.assertEquals(response.getStatusCode(), 200);
		
		test.log(Status.DEBUG, "success");
		test.log(Status.INFO, "data is retrived");

	}

	@Test(dependsOnMethods = "climateData")
	public void dataDetails() {
		JsonPath jp = new JsonPath(data);
        List<String> detail = jp.get("weather.main");
		System.out.println(detail);
		test.log(Status.DEBUG, "success" + detail);
		
		List<String> weatherdata = jp.get("weather.description");
		test.log(Status.DEBUG,"success" + weatherdata);
		
		int weatherid = jp.get("weather[0].id");
		test.log(Status.DEBUG,"success" + weatherid);
		
		int weatherpress = jp.get("main.pressure");
		test.log(Status.DEBUG,"success" + weatherpress);

	}

}
