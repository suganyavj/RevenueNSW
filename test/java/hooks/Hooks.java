package hooks;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.cucumber.java.Before;

import static io.restassured.RestAssured.given;

public class Hooks {

    @Before
    public void run_before_all(){

        try {
//            RestAssured.baseURI = "https://www.woolworths.com.au";
//            Response responseValue = given().queryParam("searchTerm", "deli").log().all().when()
//
//                    .get("apis/ui/v2/Search/count");
//            ResponseBody body = responseValue.body();
//            String bodyObject = body.asString();
//            System.out.println("Response Value---->:"+responseValue.asPrettyString());

            RestAssured.baseURI = "http://simple-books-api.glitch.me";
            Response responseValue = given().log().all().when()

                    .get("books");
            ResponseBody body = responseValue.body();
            String bodyObject = body.asString();
            System.out.println("Response Value---->:"+responseValue.asPrettyString());
        }
        catch(Exception e){
            System.out.println("Could not fetch the response"+e);
        }
    }
}
