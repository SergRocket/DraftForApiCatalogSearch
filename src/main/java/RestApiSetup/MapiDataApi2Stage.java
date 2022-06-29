package RestApiSetup;

import java.util.Map;
import static io.restassured.RestAssured.given;

public class MapiDataApi2Stage extends RestSpecMapiApi2Stage{

    public MapiDataResponce getMapiData(Map<String, String> mainBody) {
        MapiDataResponce productMapidata = given().spec(REQUEST_SPECIFICATION)
            .formParams(mainBody).relaxedHTTPSValidation().when().post().then().
            statusCode(200).extract().body().as(MapiDataResponce.class);
        return productMapidata;
    }
}
