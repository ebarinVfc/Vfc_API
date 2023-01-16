package com.vf.step_defi;

import com.vf.pojo.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiDelete {
    Response response;

    @When("I send a DELETE request to the endpoint with the itemId {int}")
    public void iSendADELETERequestToTheEndpointWithTheItemId(int itemId) {
    Product product= new Product(itemId);
        response = given().body(product).when().delete("/delete.php");
    }

    @Then("Item should be deleted")
    public void itemShouldBeDeleted() {
        response.then().log().body();
    }


    }

