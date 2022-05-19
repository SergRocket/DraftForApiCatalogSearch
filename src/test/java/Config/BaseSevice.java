package Config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseSevice extends ReportInitialization{

    //public int statusCode;
    //public int responseBody;
    public String testName;
    public org.slf4j.Logger logger;

    public Map<String, List<String>> productFeedRequestConfigInsert(String feedName, boolean ftpFeed, boolean runNightly,
                                                        boolean saveFeed, int threshold, int responseBody, int statusCode){
    RequestBody requestBodyFeedController = new RequestBody(feedName,ftpFeed, runNightly, saveFeed,threshold);
    Map<String, RequestBody> configInsertMap = new HashMap<>();
    configInsertMap.put("bodyRequest", requestBodyFeedController);
    ResponseBody responseBodyObj = new ResponseBody(responseBody, statusCode);
    Map<String, List<String>> resultMap = getResponseData(responseBodyObj);
        return resultMap;
    }

    private Map<String, List<String>> getResponseData(ResponseBody responseObj){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(getBaseUrl(env));
        builder.setBasePath("/config/insert");
        builder.addHeader("Content-Type","application/json");
        builder.addHeader("Accept","application/json");
        RequestSpecification requestSpecification = builder.build();

        return null;
    }

    private String getBaseUrl(String env) {
        String url = "https://product-feed."+env+".shutterfly.com";

        return url;
    }


}
