package com.vf.step_defi;

import com.vf.pojo.Product;
import com.vf.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiPost {

//public static int productId
    //unfortunately there is not body except the message

    Response response;

    @Given("user has the right authorization")
    public void user_has_the_right_authorization() {
        RestAssured.baseURI = ConfigurationReader.getProperty("getProductsEndPoint");

    }

    @When("I send a POST request to the endpoint with the details of a New NF Fleece")
    public void user_post_the_item_body_to_the_endpoint() {
       Product  product = new Product("North Face Polar Fleece", "The Men’s Denali Jacket is a true icon on both the street and the summit.", 179, 3);


        response = given().body(product).when().post("/create.php");

    }

    @Then("the North face fleece should be added to the inventory")
    public void verify_message_should_be_product_was_created() {
        response.then().body("message", is("Product was created."));

       // productId=response.jsonPath().getInt("id");

    }


    @And("I should get status code {int}")
    public void iShouldGetStatusCode(int expectedStatuscode) {
        response.then().log().body().statusCode(expectedStatuscode);



    }


    }

