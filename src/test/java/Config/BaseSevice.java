package Config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseSevice extends ReportInitialization{

    public int statusCode;
    public int statusCode1;
    public int StatusCode2;
    public String testName;
    public org.slf4j.Logger logger;

    public Map<String, List<String>> productFeedRequestConfigInsert(String feedName, boolean ftpFeed, boolean runNightly,
                                                        boolean saveFeed, int threshold){
    RequestBody requestBodyFeedController = new RequestBody(feedName,ftpFeed, runNightly, saveFeed,threshold);
    Map<String, RequestBody> configInsertMap = new HashMap<>();
    configInsertMap.put("bodyRequest", requestBodyFeedController);
    Map<String, List<String>> resultMap =
        return ;
    }

    private Map<String, List<String>> getResponseData(ResponseBody responseBody, int statusCode){
        ResponseBody responseBody = new ResponseBody(responceBody);
    }
}
