package RestApiSetup;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BaseSevice extends ReportInitialization {



        public static String getBaseUrl(String env) {
        String url = "https://product-feed."+env+".shutterfly.com";

        return url;
    }



    protected String getBasePath() {
        return "/config/";
    }



}
