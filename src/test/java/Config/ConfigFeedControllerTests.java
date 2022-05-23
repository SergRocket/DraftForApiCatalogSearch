package Config;

import Config.BaseSevice;
import Config.FeedGenarator;
import Config.ParamatersForFeedCreation;
import Config.ResponseBody;
import com.fasterxml.jackson.databind.util.JSONPObject;
import groovy.transform.ASTTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.assertj.core.api.AssertionsForClassTypes;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;


public class ConfigFeedControllerTests  extends BaseSevice {

    @BeforeTest
    private void beforeClass() {
        RequestSpecBuilder builder = new RequestSpecBuilder().
                setBaseUri(BaseSevice.getBaseUrl(env)).
                setBasePath(getBasePath()).
                addHeader("Content-Type", "application/json").
                addHeader("Accept", "application/json").log(LogDetail.ALL);
        requestSpecification = builder.build();



        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).
                expectContentType(ContentType.JSON).log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

   @Test
   public void getConfigAll () {
    given().spec(requestSpecification).when().get("all").then().statusCode(200);
   }

    @Test
    public void getConfigAllScheduled () {
        given().spec(requestSpecification).when().get("all/scheduled").then().statusCode(200);
    }

    @Test
    public void getConfigFeedNameByName () {
        given().spec(requestSpecification).when().get("feedName/{feedName}").then().statusCode(200);
    }

    @Test
    public void createNewFeeds () {
        HashMap<String, Object> mainBody = new HashMap<String, Object>();
        mainBody.put("feedName", "Test22QA");
        mainBody.put("ftpFeed", true);
        mainBody.put("runNightly", true);
        mainBody.put("saveFeed", true);
        mainBody.put("threshold", 0);
        given().body(mainBody).when().put("insert").then().statusCode(200);
    }

    @Test
    public void updateNewFeeds () {
        HashMap<String, Object> mainBody = new HashMap<String, Object>();
        mainBody.put("feedName", "Test22QA");
        mainBody.put("ftpFeed", true);
        mainBody.put("runNightly", true);
        mainBody.put("saveFeed", true);
        mainBody.put("threshold", 0);
        given().body(mainBody).when().put("update").then().statusCode(200);
    }

    @Test
    public void geCreatetFeedForceRefresh () {
        given().spec(requestSpecification).when().get("feedName/{feedName}").then().statusCode(200);
    }

    @Test
    public void getConfigFeedCreate () {//need to update basepath
        given().spec(requestSpecification).when().get("feed/create").then().statusCode(200);
    }

    @Test
    public void getConfigFeedCreateVendor () {//need to update basepath
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("forceRefresh",true);
        parameters.put("uploadToFtp",true);
        parameters.put("uploadToDb",true);
        parameters.put("vendor", "google");
        given().params(parameters).spec(requestSpecification).when().get("feed/create").then().statusCode(200);
    }




        @Test
        public void createNewFeed () {
            ParamatersForFeedCreation paramaters = FeedGenarator.updateFeed();
            ResponseBody createFeedTest = postConfigFeedController(paramaters);
            AssertionsForClassTypes.assertThat(createFeedTest).isNotNull();

            AssertionsForClassTypes.assertThat(paramaters).isNotNull().extracting(ParamatersForFeedCreation::getFeedName)
                    .isEqualTo("TestSergQAA");
        }




    }

