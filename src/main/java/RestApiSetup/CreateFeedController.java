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

    public String postProductFeedCreateFeed(HashMap<String,Object> mainParam){
        return given().
                spec(REQUEST_SPECIFICATION).body(mainParam).
                post(EndPoints.POST_CREATE_FEED).then().statusCode(200).extract().asString();
    }





}
