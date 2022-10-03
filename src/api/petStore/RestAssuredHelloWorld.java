package api.petStore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class RestAssuredHelloWorld {

    private final String requestBody = "{\\n\" +\n" +
            "            \"    \\\"id\\\" : \\\"1\\\",\\n\" +\n" +
            "            \"    \\\"name\\\" : \\\"kuca\\\",\\n\" +\n" +
            "            \"    \\\"status\\\" : \\\"available\\\",\\n\" +\n" +
            "            \"    \\\"photoUrls\\\" : [\\\"https://www.mydog.com/\\\", \\\"https://www.mydog2.com/\\\"],\\n\" +\n" +
            "            \"    \\\"tags\\\" : [\\n\" +\n" +
            "            \"        {\\\"id\\\" : \\\"1\\\", \\\"name\\\" : \\\"myTag1\\\"},\\n\" +\n" +
            "            \"        {\\\"id\\\" : \\\"2\\\", \\\"name\\\" : \\\"myTag2\\\"}\\n\" +\n" +
            "            \"    ]\\n\" +\n" +
            "            \"}";

    private final String storeRequestBody = "{\n" +
            "  \"id\": 0,\n" +
            "  \"petId\": 1,\n" +
            "  \"quantity\": 3,\n" +
            "  \"shipDate\": \"2022-09-30T17:24:25.251Z\",\n" +
            "  \"status\": \"placed\",\n" +
            "  \"complete\": true\n" +
            "}";

    @Test
    public void simpleApiCallTest() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200, "status code should be 200");
        Assert.assertEquals(response.jsonPath().getString("id"), "1", "id should be 1");
        Assert.assertEquals(response.jsonPath().getString("name"), "kuca", "name should be kuca");
        Assert.assertEquals(response.jsonPath().getString("status"), "available", "status should be available");
        Assert.assertEquals(response.jsonPath().getString("photoUrls"),
                Arrays.toString(new String[]{"https://www.mydog.com/", "https://www.mydog2.com/"}), "photos urls should match");
        Assert.assertEquals(response.jsonPath().getString("tags"),
                Arrays.deepToString(new String[][]{
                        new String[]{"id:1", "name:myTag1"},
                        new String[]{"id:2", "name:myTag2"}
                }),
                "tags objects array should match");
    }

    @Test
    public void getPetTestHappyPath() {

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/pet/1")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200, "status code should be 200");
    }

    @Test
    public void postOrderHappyPath() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/store/order/";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(storeRequestBody)
                .when()
                .post("/")
                .then()
                .extract().response();

        Assert.assertEquals(response.statusCode(), 200, "status code should be 200");
        System.out.println(response.jsonPath().getString("id"));
        System.out.println(response.jsonPath().getString("petId"));
        System.out.println(response.jsonPath().getString("quantity"));
        System.out.println(response.jsonPath().getString("shipDate"));
        System.out.println(response.jsonPath().getString("status"));
        System.out.println(response.jsonPath().getString("complete"));

    }
//    "id": 9223372036854255024,
//            "petId": 1,
//            "quantity": 3,
//            "shipDate": "2022-09-30T17:24:25.251+0000",
//            "status": "placed",
//            "complete": true

}
