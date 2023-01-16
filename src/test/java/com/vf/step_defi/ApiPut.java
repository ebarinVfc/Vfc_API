package com.vf.step_defi;

import com.vf.pojo.Product;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiPut {
    Response response;
    @When("I send a PUT request to the endpoint with the updated details of item {int}")
    public void iSendAPUTRequestToTheEndpointWithTheUpdatedDetailsOfItem(int itemId) {


        Product product= new Product(itemId,"North Face Polar Fleece","The Men's Denali Jacket is a true icon on both the street and the summit.",159,3);

       response = given().body(product).when().put("/update.php");

    }
    @Then("the item {int} should be updated in the inventory")
    public void theItemShouldBeUpdatedInTheInventory(int id) {

        response.then().body("message",is("Product updated"));

    }

    @And("the message {string} should be returned")
    public void theMessageShouldBeReturned(String id) {
        response.then().log().body();

    }

    }
