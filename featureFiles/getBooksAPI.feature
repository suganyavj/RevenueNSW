Feature: Validate simple books API

Background: Hitting the endpoint and getting the response
  Given Send a GET request to the books endpoint
  Then I should receive a valid response

  @API_tc_001
  Scenario: Validate the Books Response Elements
    Given The Response should contain the status code
    And Validate the status line
    Then the response status code should be 200
    Then the response time should be less than 2 seconds
    Then the response size should be below 10 KB
    Then the response should contain exactly 6 books
    Then the book with id 3 should have name "The Vanishing Half"
    Then all books should be of type fiction or non-fiction
    Then at least one book should be unavailable
    Then the book list should contain "The Midnight Library"