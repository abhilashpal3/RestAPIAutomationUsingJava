import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_PostApi {

	@Test
	public void performPostApi() {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "test"); // Cast
		requestParams.put("salary", "123");
		requestParams.put("age", "15");
		requestParams.put("id", "25");

		request.body(requestParams.toJSONString());
		Response response = request.post("/create");

		int statusCode = response.getStatusCode();

		String body = response.getBody().asString();

		System.out.println("Body is -" + body);

		/*
		 * Assert.assertEquals(statusCode, "200"); String successCode =
		 * response.jsonPath().get("SuccessCode");
		 * Assert.assertEquals("Correct Success code was returned", successCode,
		 * "OPERATION_SUCCESS");
		 */

		System.out.println("Status code is - " + statusCode);
	}
}
