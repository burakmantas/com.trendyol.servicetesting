package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


public class StepDefinitions {
    public Response response;
    public RequestSpecification requestSpecification = RestAssured.given();

    private static JsonPath jsonPathEvaluater;

    @When("get {string}")
    public void get(String path) {
        response = requestSpecification
                .header("Content-Type", "application/json")
                .when().get(path);

        jsonPathEvaluater = response.jsonPath();
    }

    @Then("status code should be return {int} ok")
    public void status_code_should_be_return_ok(Integer value) {
        response.then().assertThat().statusCode(200);
    }

    @Then("response body total field should be {int}")
    public void response_body_total_field_should_be(Integer value) {
        Integer total = jsonPathEvaluater.getInt("total");
        Assert.assertEquals(value, total);
    }

    @Then("response body data field list size should be {int}")
    public void response_body_data_field_list_size_should_be(Integer value) {
        Integer dataFieldSize = jsonPathEvaluater.getList("data").size();
        Assert.assertEquals(value, dataFieldSize);
    }

    @Then("title field is not null")
    public void title_field_is_not_null() {
        String title = jsonPathEvaluater.getString("title");
        Assert.assertNotEquals("",title);
    }
    @Then("author field is not null")
    public void author_field_is_not_null() {
        String author = jsonPathEvaluater.getString("author");
        Assert.assertNotEquals("",author);
    }

    @Then("genre field is not null")
    public void genre_field_is_not_null() {
        String genre = jsonPathEvaluater.getString("genre");
        Assert.assertNotEquals("",genre);
    }
    @Then("content field is not null")
    public void content_field_is_not_null() {
        String content = jsonPathEvaluater.getString("content");
        Assert.assertNotEquals("",content);
    }

    @Then("content field should be contains {int} character")
    public void content_field_should_be_contains_character(long value) {
        String content = jsonPathEvaluater.getString("data.content");
        long contentCharacterCount = content.chars().count();
        Assert.assertEquals(value,contentCharacterCount);
    }

    @Then("custom fields should not be null")
    public void custom_fields_should_not_be_null() {
        String name = jsonPathEvaluater.getString("data.name");
        Assert.assertNotEquals("",name);

        String lmd = jsonPathEvaluater.getString("data.lmd");
        Assert.assertNotEquals("", lmd);

        String phone = jsonPathEvaluater.getString("data.phone");
        Assert.assertNotEquals("",phone);

        String description = jsonPathEvaluater.getString("data.description");
        Assert.assertNotEquals("",description);
    }
}
