package Config;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import RestApiSetup.MapiPojo.MapeSearch.ResponseEmptyMapi;
import RestApiSetup.RestSpecMapi;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class MapiData extends RestSpecMapi {


    public ResponseEmptyMapi getMapiData(Map<String, String> mainBody) {
        Header brandHeader = new Header("SFLY-brand", "us-sfly");
        Header channelHeader = new Header("SFLY-channel", "web");
        Header secretHeader = new Header("SFLY-apikey", "G8z1COg2lGr0SqDO38yg7Lc9ImaKo45o");
        HashMap<String, String> params = new HashMap<>();
        params.put("q","enjoy%20cotton%20tote%26");
        params.put("fl","price,sale_price,title");
        params.put("fq","price:[10 TO 19.99]");
        Headers headers = new Headers(brandHeader, channelHeader,secretHeader);
        ResponseEmptyMapi productMapidata = given().spec(REQUEST_SPECIFICATION).
            headers(headers).params(params).formParams(mainBody).relaxedHTTPSValidation().when().
            post().then().
            statusCode(200).extract().body().as(ResponseEmptyMapi.class);
        return productMapidata;
    }

    public ResponseEmptyMapi getMapiData(Map<String, String> mainBody, String fqParam) {
        Header brandHeader = new Header("SFLY-brand", "us-sfly");
        Header channelHeader = new Header("SFLY-channel", "web");
        Header secretHeader = new Header("SFLY-apikey", "G8z1COg2lGr0SqDO38yg7Lc9ImaKo45o");
        HashMap<String, String> params = new HashMap<>();
        params.put("q","enjoy%20cotton%20tote%26");
        params.put("fl","price,sale_price,title");
        params.put("fq",fqParam);
        Headers headers = new Headers(brandHeader, channelHeader,secretHeader);
        ResponseEmptyMapi productMapidata = given().spec(REQUEST_SPECIFICATION).
            headers(headers).params(params).formParams(mainBody).relaxedHTTPSValidation().when().
            post().then().
            statusCode(200).extract().body().as(ResponseEmptyMapi.class);
        return productMapidata;
    }


}
