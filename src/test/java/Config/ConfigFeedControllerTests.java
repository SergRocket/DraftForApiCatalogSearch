package Config;

import Config.BaseSevice;
import Config.FeedGenarator;
import Config.ParamatersForFeedCreation;
import Config.ResponseBody;
import groovy.transform.ASTTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.assertj.core.api.AssertionsForClassTypes;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;


public class ConfigFeedControllerTests  extends BaseSevice {

    @BeforeTest
    private void beforeClass() {
        RequestSpecBuilder builder = new RequestSpecBuilder().
                setBaseUri(BaseSevice.getBaseUrl(env)).
                setBasePath("/config/").
                addHeader("Content-Type", "application/json").
                addHeader("Accept", "application/json").log(LogDetail.ALL);
        requestSpecification = builder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).
                expectContentType(ContentType.JSON).log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

        @Test
        public void putConfigInsertController () {
          given().spec(requestSpecification).when().get().then().statusCode(200);
        }

        @Test
        public void createNewFeed () {
            ParamatersForFeedCreation paramaters = FeedGenarator.createFeed();
            ResponseBody createFeedTest = postConfigFeedController(paramaters);
            AssertionsForClassTypes.assertThat(createFeedTest).isNotNull().extracting(ResponseBody::getFeedname).
                    isEqualTo(paramaters.getFeedname());

            AssertionsForClassTypes.assertThat(paramaters).isNotNull().extracting(ParamatersForFeedCreation::getFeedname)
                    .isEqualTo(paramaters.getFeedname());
        }


    @Test
    public void createNewFeeds () {
        HashMap<String, String> mainBody = new HashMap<String, String>();
        mainBody.put("feedName", "Test22");
        mainBody.put("ftpFeed", "true");
        mainBody.put("runNightly", "true");
        mainBody.put("threshold", "0");
        given().body(mainBody).when().post("insert").then().statusCode(200);
    }

    }

