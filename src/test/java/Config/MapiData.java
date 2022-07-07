package Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static io.restassured.authentication.FormAuthConfig.formAuthConfig;
import static io.restassured.authentication.FormAuthConfig.springSecurity;
import RestApiSetup.EndPointsRegress;
import RestApiSetup.ImageURLs;
import RestApiSetup.MapiDataResponce;
import RestApiSetup.RestSpecMapi;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.Assert;

public class MapiData extends RestSpecMapi {

    public MapiDataResponce getMapiData(Map<String, String> mainBody) {
        Map<String, String> bodyParams = new HashMap<>();
        Map<String, String> headerParams = new HashMap<>();
        bodyParams.put("fl","skuid");
        bodyParams.put("url","https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        bodyParams.put("refurl","https://shutterfly.com%26");
        //bodyParams.put("sfly-apikey","G8z1COg2lGr0SqDO38yg7Lc9ImaKo45o");
        MapiDataResponce productMapidata = given().header("APIKey","G8z1COg2lGr0SqDO38yg7Lc9ImaKo45o").given().header("Accept", "application/json;odata=verbose").spec(REQUEST_SPECIFICATION)
            .when().body(bodyParams).
            post().then().
            statusCode(401).extract().body().as(MapiDataResponce.class);
        return productMapidata;
    }

    public Map<String ,String > getMapiDataNegat(Map<String, String> mainBody) {
        Header secretHeader = new Header("sfly-apikey", "vHAx0uG8Ndr6WJf2vu697D4HnPHu5WfG");
        Headers headers = new Headers(secretHeader);
        Map<String ,String > productMapidata = given().spec(REQUEST_SPECIFICATION).headers(headers).when().body(mainBody).
            post().then().
            statusCode(401).extract().body().jsonPath().getMap("fault");
        return productMapidata;
    }


}
