package RestApiSetup;

import io.restassured.RestAssured;

import java.util.List;

public class VerifFeatureData extends RestSpecFeatureFlag{
    public boolean verifyFeatureIsOn(){
        return RestAssured.given().spec(REQUEST_SPECIFICATION).get(EndPointsRegress.GET_FEATURE_FLAG).
                then().statusCode(200).extract().body().as(Boolean.class);
    }


}
