package Config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import RestApiSetup.EndPointsRegress;
import RestApiSetup.ImageURLs;
import RestApiSetup.MapiDataResponce;
import RestApiSetup.RestSpecMapi;
import org.testng.Assert;

public class MapiData extends RestSpecMapi {

    public MapiDataResponce getMapiData(Map<String, String> mainBody) {
        MapiDataResponce productMapidata = given().spec(REQUEST_SPECIFICATION)
            .formParams(mainBody).relaxedHTTPSValidation().when().post().then().
            statusCode(200).extract().body().as(MapiDataResponce.class);
        return productMapidata;
    }


}
