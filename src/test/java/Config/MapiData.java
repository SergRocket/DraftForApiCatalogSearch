package Config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import RestApiSetup.EndPointsRegress;
import RestApiSetup.ImageURLs;
import RestApiSetup.MapiDataResponce;
import RestApiSetup.RestSpecMapi;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.Assert;

public class MapiData extends RestSpecMapi {

    public MapiDataResponce getMapiData(Map<String, String> mainBody) {
        Header secretHeader = new Header("sfly-apikey", "G8z1COg2lGr0SqDO38yg7Lc9ImaKo45o");
        Headers headers = new Headers(secretHeader);
        MapiDataResponce productMapidata = given().spec(REQUEST_SPECIFICATION)
            .headers(headers).formParams(mainBody).relaxedHTTPSValidation()
            .when().post().then().
            statusCode(200).extract().body().as(MapiDataResponce.class);
        return productMapidata;
    }


}
