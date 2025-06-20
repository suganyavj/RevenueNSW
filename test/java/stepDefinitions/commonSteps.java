package stepDefinitions;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class commonSteps {
	
	
	public static Response getResponse() {
		
		//getting the response by hitting the URL below
		Response responseValue=null;
		
		try {

			RestAssured.baseURI = "http://simple-books-api.glitch.me";

			responseValue = given().log().all().when()

					.get("books");
		
		}
		catch(Exception e){
			System.out.println("Could not fetch the response"+e);
		}
		
		return responseValue;
	}
	
	public static JsonPath rawToJson(String response) {
		
		//converting String to JSON format
		JsonPath js = new JsonPath(response);
		return js;
	}
	
}
