package RestApiSetup;

import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import RestApiSetup.MapiPojo.AutoCorrectQuery;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class SuggestionData extends RestSpecSuggestionTest {

    public AutoCorrectQuery getSuggestions(Map<String, String> mainBody){
        Header brandHeader = new Header("SFLY-brand", "us-sfly");
        Header channelHeader = new Header("SFLY-channel", "web");
        Headers headers = new Headers(brandHeader, channelHeader);
       AutoCorrectQuery pipOptdata = given().spec(REQUEST_SPECIFICATION_SUGGESTIONS).headers(headers).formParams(mainBody).relaxedHTTPSValidation().when().
           post().then().statusCode(200).extract().body().as(AutoCorrectQuery.class);
       return pipOptdata;
    }
}
