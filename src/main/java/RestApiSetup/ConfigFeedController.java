package RestApiSetup;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ConfigFeedController  extends RestSpec{

    @Override
    public String getBasePath() {
        return "/config/";
    }

    public List<String> getUsers(){
       return given().spec(REQUEST_SPECIFICATION).get(EndPoints.GET_ALL).jsonPath().getList("feedName");
    }

    public List<String> getUsersScheduled(){
        return given().spec(REQUEST_SPECIFICATION).get(EndPoints.GET_ALL_SCHEDULED).jsonPath().getList("feedName");
    }

    public String getUsersByName(){
        return  given().spec(REQUEST_SPECIFICATION).get(EndPoints.GET_BY_FEEDNAME).jsonPath().getString("feedName");
    }

    public String createNewFeed(HashMap<String, Object> mainBody){
       return   given().spec(REQUEST_SPECIFICATION).body(mainBody)
                .put(EndPoints.PUT_CONFIG_INSERT).toString();
    }

    public String updateNewFeed(HashMap<String, Object> mainBody){
        return   given().spec(REQUEST_SPECIFICATION).body(mainBody)
                .put(EndPoints.PUT_CONFIG_UPDATE).toString();
    }


}
