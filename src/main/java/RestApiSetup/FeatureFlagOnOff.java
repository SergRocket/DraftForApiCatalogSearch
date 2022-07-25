package RestApiSetup;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.apache.commons.codec.Charsets;
import org.json.JSONObject;

import java.util.HashMap;
import static io.restassured.RestAssured.config;
import static io.restassured.config.DecoderConfig.decoderConfig;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class FeatureFlagOnOff extends RestSpecFeatureOnOff{

    public void onOffFetureFlag(String  mainBody){
        Header secretHeader = new Header("sfly-ccs-api-key", "a444a22f-ba41-4285-8816-4d2da295e4be");
        RestAssured.given().header("Content-Type", "application/json").spec(REQUEST_SPECIFICATION).when().log().all().header(secretHeader).body(mainBody)
             .when().post(EndPointsRegress.POST_ONOFF_FESTURE_FLAG).
             then().statusCode(200);
    }

    public void inOffGeature(String mainbody){
        Header secretHeader = new Header("sfly-ccs-api-key","a444a22f-ba41-4285-8816-4d2da295e4be");
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig().defaultContentCharset("ISO-8859-1"));
        RestAssured.given().config(config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(true)))
            .contentType(ContentType.TEXT).log().all().body(mainbody).when().log().all().header(secretHeader).when().post(EndPointsRegress.POST_ONOFF_FESTURE_FLAG).
            then().statusCode(200);
    }

}
