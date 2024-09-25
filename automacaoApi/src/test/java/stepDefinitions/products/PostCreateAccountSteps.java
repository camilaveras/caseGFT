package stepDefinitions.products;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PostCreateAccountSteps {

    private Response response;

    @Given("I send a POST request to create a new account")
    public void i_send_a_post_request_to_create_a_new_account() throws IOException {

        RestAssured.baseURI = "https://automationexercise.com/api";

        // Carrega os dados do arquivo userData.json
        ObjectMapper objectMapper = new ObjectMapper();
        File userDataFile = new File("src/test/resources/fixtures/userData.json");
        Map<String, Object> requestBody = objectMapper.readValue(userDataFile, Map.class);

        // Cria a requisição usando form-data
        RequestSpecification request = RestAssured.given();
        for (Map.Entry<String, Object> entry : requestBody.entrySet()) {
            request.multiPart(entry.getKey(), entry.getValue().toString());
        }

        // Envia a requisição POST
        response = request.post("/createAccount");

        // Log da resposta
        System.out.println("Resposta da API: " + response.getBody().asString());
    }


    @Then("I should receive a response with status code {int} for account creation")
    public void i_should_receive_a_response_with_status_code_for_account_creation(int statusCode) {

        int actualStatusCode = response.getStatusCode();

        assertTrue("Código de status incorreto! Esperado: 201 ou 200, Recebido: " + actualStatusCode,
                actualStatusCode == 200 || actualStatusCode == 201);
    }


    @Then("the response should contain success message")
    public void the_response_should_contain_success_message() {
        // Imprimir o corpo da resposta para inspeção
        System.out.println("Corpo da resposta: " + response.getBody().asString());

        // Extração dos valores diretamente do JSON
        String message = response.jsonPath().getString("message");
        int responseCode = response.jsonPath().getInt("responseCode");

        // Validação dos valores extraídos
        assertEquals("A mensagem não corresponde!", "User created!", message);
        assertEquals("O código de resposta não corresponde!", 201, responseCode);
    }

}
