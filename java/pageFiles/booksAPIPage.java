package pageFiles;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import stepDefinitions.commonSteps;
import stepDefinitions.booksAPISteps;

import java.util.List;

public class booksAPIPage {
	
	//defined the logger here
	private static final Logger logger = LoggerFactory.getLogger(booksAPISteps.class);
	
	Response responseValue;
	Response response;
	ResponseBody body;
	String bodyObject;
	JsonPath js;
	
	int search;
	int totalSearch=0;
	
	public void hit_endpoint() {
		
		//passing this from commonSteps file
		responseValue = commonSteps.getResponse();
		
		// Get all the body from json response
		body = responseValue.body();
		bodyObject = body.asString();
		
		
    }
	public void receive_response() {
		
		logger.info("<-------------------Response-------------->");
		System.out.println("Response Value---->:"+responseValue.asPrettyString());
		
	}
	
	public int validate_status_code() {
		
		int statusCode = responseValue.getStatusCode();
		logger.info(",-----Status code:------>"+statusCode);
		return statusCode;
		
	}
	
	public String validate_status_line() {
		String statusLine = responseValue.getStatusLine();
		logger.info(",-----Status Line:------>"+statusLine);
		return statusLine;
	}
	public int get_Status_Code() {
		return responseValue.getStatusCode();
	}

	public long get_Response_Time() {
		logger.info(",-----Response Time:------>"+responseValue.getTime());
		return responseValue.getTime();
	}

	public int get_Response_Size_In_Bytes() {
		logger.info(",-----Response Size:------>"+responseValue.getBody().asByteArray().length);
		return responseValue.getBody().asByteArray().length;
	}

	public List<Object> getAllBooks() {
		logger.info(",-----All Books:------>"+responseValue.jsonPath().getList("$"));
		return responseValue.jsonPath().getList("$");
	}

	public String getBookNameById(int id) {
		logger.info(",-----Book Name by id:------>"+responseValue.jsonPath().getString("find { it.id == " + id + " }.name"));
		return responseValue.jsonPath().getString("find { it.id == " + id + " }.name");
	}

	public List<String> getBookTypes() {
		logger.info(",-----Book Type:------>"+responseValue.jsonPath().getList("type"));
		return responseValue.jsonPath().getList("type");
	}

	public List<Boolean> getAvailabilityList() {
		logger.info(",-----Book Availability List:------>"+responseValue.jsonPath().getList("available"));
		return responseValue.jsonPath().getList("available");
	}

	public List<String> getAllBookNames() {
		logger.info(",-----All Books:------>"+responseValue.jsonPath().getList("$"));
		return responseValue.jsonPath().getList("name");
	}


}
