package api.com;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Api {
	@Test
    public void verifyWeatherDetails() {

        String apiKey = "28557dd8e2a645ef1c41df1be7ac9f02"; // Replace with your key
        String city = "Chennai";

        RestAssured.baseURI = "https://api.openweathermap.org/data/2.5";
        
        given()
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")

        .when()
                .get("/weather")

        .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo(city))
                .body("main.temp", notNullValue())
                .log().all();
	
		}
}

