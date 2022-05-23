package Config;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PostRequestExapmle {

   // RestAssured.baseURI = "http://kdfldfd";
    RequestSpecification httpRequest = RestAssured.given();

    String body = "{\n" +
            "  \"feedName\": \"TestSerg\",\n" +
            "  \"ftpFeed\": true,\n" +
            "  \"runNightly\": true,\n" +
            "  \"saveFeed\": true,\n" +
            "  \"threshold\": 0\n" +
            "}";
    Response response = httpRequest.body(body).request(Method.POST, "/books/v1/book");
    int statusCode = response.statusCode();
  //  Assertions.asertEqueals(200, statusCode);

    public void postExapmle(){
    /*    {
            "firstname" : "Jim",
                "lastname" : "Brown",
                "totalprice" : 111,
                "depositpaid" : true,
                "bookingdates" : {
            "checkin" : "2018-01-01",
                    "checkout" : "2019-01-01"
        },
            "additionalneeds" : "Breakfast"
        }
*/
        Map<String,Object> jsonBodyUsingMap = new HashMap<String,Object>();
        jsonBodyUsingMap.put("firstname", "Jim");
        jsonBodyUsingMap.put("lastname", "Brown");
        jsonBodyUsingMap.put("totalprice", 111);
        jsonBodyUsingMap.put("depositpaid", true);

        Map<String,String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2021-07-01");
        bookingDatesMap.put("checkout", "2021-07-01");

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");
    }

    @Test
    public void CreatingNestedJsonObjectTest()
    {
        Map<String,Object> jsonBodyUsingMap = new HashMap<String,Object>();
        jsonBodyUsingMap.put("firstname", "Jim");
        jsonBodyUsingMap.put("lastname", "Brown");
        jsonBodyUsingMap.put("totalprice", 111);
        jsonBodyUsingMap.put("depositpaid", true);

        Map<String,String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2021-07-01");
        bookingDatesMap.put("checkout", "2021-07-01");

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");


        //GIVEN
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType(ContentType.JSON)
                .body(jsonBodyUsingMap)
                .log()
                .all()
                // WHEN
                .when()
                .post()
                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .log()
                .all();
    }


}
