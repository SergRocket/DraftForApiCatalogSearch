package RestApiSetup;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CreateFeedController extends RestSpec{
    @Override
    public String getBasePath() {

        return "/product/";
    }

    public String getProductFeedVendor(HashMap<String,Object> mainParam){
        return given().
                params(mainParam).
                spec(REQUEST_SPECIFICATION).
                get(EndPoints.GET_FEED_BY_VENDOR).then().statusCode(200).extract().asString();
    }



}
