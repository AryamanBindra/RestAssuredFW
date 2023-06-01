package tekarch.reusables;

import java.util.HashMap;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginUtils {
	
	public Response taPost(String endPoint, HashMap<String, String> headers, String body) {
		Response response = RestAssured.given().headers(headers).when().body(body).post(endPoint).andReturn();
		return response;
	}
	
	public Response taPost(String endPoint, HashMap<String, String> headers, JsonObject body) {
		Response response = RestAssured.given().headers(headers).when().body(body).post(endPoint).andReturn();
		return response;
	}
	
	public Response taGet(String endPoint, HashMap<String, String> headers) {
		Response response = RestAssured.given().headers(headers).when().get(endPoint).andReturn();
		return response;
	}
	
	public Response taPut(String endPoint, HashMap<String, String> headers, String body) {
		Response response = RestAssured.given().headers(headers).when().body(body).put(endPoint).andReturn();
		return response;
	}
	
	public Response taDelete(String endPoint, HashMap<String, String> headers, String body) {
		Response response = RestAssured.given().headers(headers).when().body(body).delete(endPoint).andReturn();
		return response;
	}

}
