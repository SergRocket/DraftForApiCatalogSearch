package Config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class BaseSevice extends ReportInitialization{

    //public int statusCode;
    //public int responseBody;
    public String testName;
    public org.slf4j.Logger logger;

    public void productFeedRequestConfigInsert(String feedName, boolean ftpFeed, boolean runNightly,
                                                        boolean saveFeed, int threshold, int responseBody, int statusCode){
    RequestBody requestBodyFeedController = new RequestBody(feedName,ftpFeed, runNightly, saveFeed,threshold);
    Map<String, RequestBody> configInsertMap = new HashMap<>();
    configInsertMap.put("bodyRequest", requestBodyFeedController);
    //ResponseBody responseBodyObj = new ResponseBody(responseBody, statusCode);
    //Map<String, List<String>> resultMap = getResponseData(responseBodyObj);

    }




        Map<String,List<String>> checksumMap = new HashMap<>();



    public static String getBaseUrl(String env) {
        String url = "https://product-feed."+env+".shutterfly.com";

        return url;
    }

    public ResponseBody postConfigFeedController(ParamatersForFeedCreation requestBody){
        return given().
                body(requestBody).
                put("insert").
                as(ResponseBody.class);
    }

    protected String getBasePath() {
        return "/config/";
    }

    public List<Deseralization> getAllFeeds(){
        return given().spec(requestSpecification).get().jsonPath().getList("feedName", Deseralization.class);
    }


}
