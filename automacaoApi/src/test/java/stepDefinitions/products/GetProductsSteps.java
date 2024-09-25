package stepDefinitions.products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ApiUtils;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class GetProductsSteps {

    private Response response;

    @Given("I perform a GET request to the products API")
    public void i_perform_a_get_request_to_the_products_api() {

        response = ApiUtils.getRequest("/productsList");
    }

    @Then("I should receive a response with status code {int}")
    public void i_should_receive_a_response_with_status_code(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response should contain at most {int} products")
    public void the_response_should_contain_at_most_products(int maxProducts) {

        int totalProducts = response.jsonPath().getList("products").size();

        assertTrue("O número de produtos excede o limite: " + totalProducts, totalProducts <= maxProducts);
    }

    @Then("each product should have id, name, price, brand, usertype, and category")
    public void each_product_should_have_id_name_price_brand_usertype_and_category() {
        response.then().body("products.id", everyItem(notNullValue()))
                .body("products.name", everyItem(notNullValue()))
                .body("products.price", everyItem(notNullValue()))
                .body("products.brand", everyItem(notNullValue()))
                .body("products.category.usertype.usertype", everyItem(notNullValue()))
                .body("products.category.category", everyItem(notNullValue()));
    }

}
