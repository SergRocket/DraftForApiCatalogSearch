package Config;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.testng.Assert;

public class GetRequestExample {
  /*  RestAssured.baseURI = "http://kdfldfd";
    RequestSpecification httpRequest = RestAssured.given();
    Response response = httpRequest.request(Method.GET, "/books/v1/book");
    int statusCode = response.statusCode();
    Assertions.asertEqueals(200, statusCode);
    Headers headers = response.getHeaders();
    int countOfHeaders = headers.asList().size();
    Assertions.assertEquals(5,countOfHeaders);
    String headerValue = response.getHeader("Content-Type");
    Assertions.asserEquels("applacation/json", headerValue);
    String responseBodyAsString = response.getBody().asString();
    Assertions.asserTrue(responceBodyAsString.contains("ldfkdlf"));*/
}
