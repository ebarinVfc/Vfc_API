@api
Feature: As an admin I'd like to manage inventory items


  Background:
    Given user has the right authorization
@post
  Scenario:  Adding a North Face fleece to the list

    When I send a POST request to the endpoint with the details of a New NF Fleece
    Then the North face fleece should be added to the inventory
    And I should get status code 201
@get
  Scenario: I should able to see the information about the NF fleece I added

    When I send a GET request to the endpoint with the itemId 40
    Then the details of item 40 should be returned
@put
  Scenario: Update an existing item
    When I send a PUT request to the endpoint with the updated details of item 40
    Then the item 40 should be updated in the inventory
    And the message "Product updated" should be returned
@delete
  Scenario: Delete an existing item id 41
    When I send a DELETE request to the endpoint with the itemId 41
    Then Item should be deleted

