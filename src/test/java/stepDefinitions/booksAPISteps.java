package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageFiles.booksAPIPage;

import java.io.IOException;

public class booksAPISteps {
	
	private static final Logger logger = LoggerFactory.getLogger(booksAPISteps.class);
	booksAPIPage page = new booksAPIPage();
	@Given("Send a GET request to the books endpoint")
	public void send_request() {
		//sending the URL with details to hit the End-point
		page.hit_endpoint();
	}
	
	@Then("I should receive a valid response")
	public void receive_valid_response() {
		//Response is received
		page.receive_response();
	}
	
	@Given("The Response should contain the status code")
	public void validate_status_code() {
		//Verifying the status code is 200 - which is successful
		assertEquals(page.validate_status_code(), 200);
	}
	
	@And("Validate the status line")
	public void validate_status_line() {
		//Verifying the status line is "HTTP/1.1 200 OK
		assertEquals(page.validate_status_line(), "HTTP/1.1 200 OK");
	}
	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer statusCode) {
		assertEquals(statusCode.intValue(), page.get_Status_Code());
		System.out.println("Response Status Code ------>" +page.get_Status_Code());
	}

	@Then("the response time should be less than {int} seconds")
	public void the_response_time_should_be_less_than_seconds(Integer seconds) {
		long time = page.get_Response_Time();
		System.out.println("Response Time: " + time + " ms");
		assertTrue(time < seconds * 1000);
	}

	@Then("the response size should be below {int} KB")
	public void the_response_size_should_be_below_kb(Integer kb) {
		int size = page.get_Response_Size_In_Bytes();
		System.out.println("Response Size: " + size + " bytes");
		assertTrue(size < kb * 1024);
	}

	@Then("the response should contain exactly {int} books")
	public void the_response_should_contain_exactly_books(Integer expectedCount) {
		assertEquals(expectedCount.intValue(), page.getAllBooks().size());
		System.out.println("Printing all books :"+page.getAllBooks());
		System.out.println("Size of books: "+page.getAllBooks().size());
	}

	@Then("the book with id {int} should have name {string}")
	public void the_book_with_id_should_have_name(Integer id, String expectedName) {
		assertEquals("The book name with the given id does not match ",expectedName, page.getBookNameById(id));
	}

	@Then("all books should be of type fiction or non-fiction")
	public void all_books_should_be_of_valid_type() {
		for (String type : page.getBookTypes()) {
			assertTrue(type.equals("fiction") || type.equals("non-fiction"));
		}
	}

	@Then("at least one book should be unavailable")
	public void at_least_one_book_should_be_unavailable() {
		assertTrue("No books is in unavailable",page.getAvailabilityList().contains(false));
	}

	@Then("the book list should contain {string}")
	public void the_book_list_should_contain(String bookName) {
		assertTrue("The given name is not present in book list ",page.getAllBookNames().contains(bookName));
	}
}
