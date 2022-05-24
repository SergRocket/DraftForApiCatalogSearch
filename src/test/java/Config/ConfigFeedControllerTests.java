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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;


public class ConfigFeedControllerTests  extends BaseSevice {

    @BeforeTest
    private void beforeClass() {
        RequestSpecBuilder builder = new RequestSpecBuilder().
                setBaseUri(BaseSevice.getBaseUrl(env)).
                setBasePath(getBasePath()).

                addHeader("Accept", "application/json")
                .log(LogDetail.ALL);
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
    public void getConfigFeedCreateVendor () {//need to update basepath+configureVendor
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("adHocBuild",true);
        mainParameters.put("feedType","PARTIAL");
        mainParameters.put("forceRefresh",true);
        mainParameters.put("sampleFeedSize", "0");
        HashMap<String, String> parametersSampleProductCodes = new HashMap<>();
        parametersSampleProductCodes.put("","string");
        mainParameters.put("sampleProductCodes", parametersSampleProductCodes);
        HashMap<String, String> parametersSkipSpecificCollection = new HashMap<>();
        parametersSkipSpecificCollection.put("","string");
        mainParameters.put("skipSpecificCollection",parametersSkipSpecificCollection);
        mainParameters.put("startTime", "0");
        mainParameters.put("sampleFeedSize", "2022-05-24T10:03:57.888Z");
        mainParameters.put("storeCode", "string");
        given().
                params(mainParameters).
                spec(requestSpecification).when().get("feed/create/{vendor}").then().statusCode(200);
    }

    @Test
    public void postConfigFeedCreateVendor () {//need to update basepath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("catalog","string");
        mainParameters.put("feedName","TestQA244");
        mainParameters.put("feedType","PARTIAL");
        mainParameters.put("ftp", true);
        List<String> parametersSampleProductCodes = new ArrayList<>();
        parametersSampleProductCodes.add("string");
        mainParameters.put("sampleProductCodes", parametersSampleProductCodes);
        List<String> parametersSampleProductTypes = new ArrayList<>();
        parametersSampleProductTypes.add("string");
        mainParameters.put("sampleProductCodes", parametersSampleProductCodes);
        mainParameters.put("sampleProductTypes", parametersSampleProductTypes);
        mainParameters.put("sampleSize", 0);
        mainParameters.put("saveToDb", true);
        List<String> parametersSkipSpecificCollection = new ArrayList<>();
        parametersSkipSpecificCollection.add("string");
        mainParameters.put("skipSpecificCollection",parametersSkipSpecificCollection);
        given().spec(requestSpecification).body(mainParameters).when().
                post("feed/createFeed").then().statusCode(200);
    }

    @Test
    public void getDebugControllerByAttributeName () {//need to update basepath+requestSpec
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("attributeName", "forceRefresh");
        given().params(mainParameters).spec(requestSpecification).when().get("attributealias/forceRefresh").then().statusCode(200);
    }

    @Test
    public void getDebugAttributemappings () {//need to update basepath+resuestSpec
        given().spec(requestSpecification).when().get("attributemappings").then().statusCode(200);
    }

    //needToImplementDebugAttributesProductCode{productCode}skuCode{skuCode}


    @Test
    public void postDebugCreateFeed(){ //need to modify request spec + basePath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("catalog","string");
        mainParameters.put("feedName","TestQA944");
        mainParameters.put("feedType","PARTIAL");
        mainParameters.put("ftp", true);
        List<String> parametersSampleProductCodes = new ArrayList<>();
        parametersSampleProductCodes.add("string");
        mainParameters.put("sampleProductCodes", parametersSampleProductCodes);
        List<String> parametersSampleProductTypes = new ArrayList<>();
        parametersSampleProductTypes.add("string");
        mainParameters.put("sampleProductCodes", parametersSampleProductCodes);
        mainParameters.put("sampleProductTypes", parametersSampleProductTypes);
        mainParameters.put("sampleSize", 0);
        mainParameters.put("saveToDb", true);
        List<String> parametersSkipSpecificCollection = new ArrayList<>();
        parametersSkipSpecificCollection.add("string");
        mainParameters.put("skipSpecificCollection",parametersSkipSpecificCollection);
        given().spec(requestSpecification).body(mainParameters).when().
                post("feed/createFeed").then().statusCode(200);
    }


    @Test
    public void getDebugFileHystoryLastCompleteFeedNameStoreCode () {//need to update basepath+requestSpec
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("feedName", "QATest7");
        mainParameters.put("storeCode", "string");
        given().params(mainParameters).spec(requestSpecification).when().get("fileHistory/lastComplete/QATest7/string").then().statusCode(200);
    }

    @Test
    public void getDebugGoogleAttributesProductCode () {//need to update basepath+requestSpec+found valid product code
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("productCode", "???");
        given().params(mainParameters).spec(requestSpecification).when().get("googleattributes/productCode/{productCode}").then().statusCode(200);
    }

    @Test
    public void getDebugGoogleAttributesProductCodeAndSkuCode () {//need to update basepath+requestSpec+found valid product code+skucode
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("productCode", "???");
        mainParameters.put("skuCode", "???");
        given().params(mainParameters).spec(requestSpecification).when().get("googleattributes/productCode/{productCode}/skuCode/{skuCode}").then().statusCode(200);
    }

    @Test
    public void getDebugMappings () {//need to update basepath+requestSpec+writeCheckFor response body
        given().spec(requestSpecification).when().get("mappings").then().statusCode(200);
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

