package RestApiSetup;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.groovy.util.StringUtil;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static io.restassured.RestAssured.given;

public class VerifFeatureData extends RestSpecFeatureFlag{
    public Boolean verifyFeatureIsOn(){
        Header secretHeader = new Header("sfly-ccs-api-key", "a444a22f-ba41-4285-8816-4d2da295e4be");
        String response = given().spec(REQUEST_SPECIFICATION).when().log().all().header(secretHeader).get().
                then().statusCode(200).extract().body().asString();
         if(StringUtils.contains(response, "google.extendedProductTypes.enableProductVariations: true")){
            return true;
        }
        return false;
    }

}
