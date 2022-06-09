package RestApiSetup;

import io.restassured.RestAssured;

import java.util.HashMap;

public class FeatureFlagOnOff extends RestSpecFeatureOnOff{
    public void onOffFetureFlag(HashMap<String,Object> mainBody){
         RestAssured.given().spec(REQUEST_SPECIFICATION).body(mainBody).post(EndPointsRegress.POST_ONOFF_FESTURE_FLAG).
                then().statusCode(200);
    }
}
