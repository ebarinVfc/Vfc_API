package com.vf.step_defi;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiGet {
    Response response;

    @When("I send a GET request to the endpoint with the itemId {int}")
    public void iSendAGETRequestToTheEndpointWithTheItemId(int itemId) {


        response = given().queryParams("id",itemId).when().get("/read_one.php");


    }

    @Then("the details of item {int} should be returned")
    public void theDetailsOfItemShouldBeReturned(int itemId) {
        response.then().log().body();

    }
}


