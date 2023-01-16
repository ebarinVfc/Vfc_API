package com.vf.step_defi;

import com.vf.pojo.Product;
import com.vf.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ApiCreate {


    @Given("user has the right authorization")
    public void user_has_the_right_authorization() {
        RestAssured.baseURI = ConfigurationReader.getProperty("getProductsEndPoint");

    }

    @When("the user sends a POST request to the endpoint with the product details")
    public void user_post_the_item_body_to_the_endpoint() {
        Product product= new Product("North Face Polar Fleece","The Men’s Denali Jacket is a true icon on both the street and the summit.",179,3);


        response = given().body(product).when().post("/create.php");


    }

    @Then("the product should be added to the list")
    public void verify_message_should_be_product_was_created() {
        response.then().body("message", is("Product was created."));
    }


    @And("a {string} message should be returned")
    public void aMessageShouldBeReturned(String str) {

        response.then().log().body();
    }
}