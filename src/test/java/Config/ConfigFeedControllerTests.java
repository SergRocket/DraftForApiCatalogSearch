package Config;


import APITests.ResponseBody;
import RestApiSetup.*;
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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;


public class ConfigFeedControllerTests  extends BaseSevice {
    public ConfigFeedController controller = new ConfigFeedController();
    public CreateFeedController controllerCreate = new CreateFeedController();
    @BeforeTest
    private void beforeClass() {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).
                expectContentType(ContentType.JSON).log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

   @Test
   public void getConfigAll () {
       controller.getUsers().stream().sorted().findAny().equals("ADOBE");
   }

    @Test
    public void getConfigAllScheduled () {
        controller.getUsersScheduled().stream().sorted().findAny().equals("BLOOMREACH");;
    }

    @Test
    public void getConfigByName () {
        controller.getUsersByName().equals("GOOGLE");
    }


    @Test
    public void createNewFeeds () {
        HashMap<String, Object> mainBody = new HashMap<>();
        mainBody.put("feedName", "Test056355QA");
        mainBody.put("ftpFeed", true);
        mainBody.put("runNightly", true);
        mainBody.put("saveFeed", true);
        mainBody.put("threshold", 0);
        Assert.assertFalse(controller.createNewFeed(mainBody).isEmpty());
    }

    @Test
    public void updateNewFeeds () {
        HashMap<String, Object> mainBody = new HashMap<>();
        mainBody.put("feedName", "Test056355QA");
        mainBody.put("ftpFeed", true);
        mainBody.put("runNightly", true);
        mainBody.put("saveFeed", true);
        mainBody.put("threshold", 0);
        Assert.assertFalse(controller.updateNewFeed(mainBody).isEmpty());
    }

    @Test
    public void geCreatetFeedVendor () {
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("forceRefresh",true);
        mainParameters.put("uploadToFtp",true);
        mainParameters.put("uploadToDb",true);
        mainParameters.put("vendor", "BLOOMREACH");
        controllerCreate.getProductFeedVendor(mainParameters).contains("COMPLETE");
    }

    @Test
    public void getConfigFeedCreate () {//need to update basepath
        given().spec(requestSpecification).when().get("feed/create").then().statusCode(200);
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
    public void getDebugMobileSkuCode () {//need to update basepath+requestSpec
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("skuCodes", "PALENVELOPE_5X7GOLD");
        given().params(mainParameters).spec(requestSpecification).when().get("mobile/PALENVELOPE_5X7GOLD/").then().statusCode(200);
    }

    @Test
    public void getDebugPimtables () {//need to update basepath+requestSpec
        given().spec(requestSpecification).when().get("pimtables").then().statusCode(200);
    }

    @Test
    public void getDebugPipDataServiceProductCode () {//need to update basepath+requestSpec+find valid product Code
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("productCode", "PALENVELOPE_5X7GOLD");
        given().params(mainParameters).spec(requestSpecification).when().get("pipDataService/{productCode]/").then().statusCode(200);
    }

    @Test
    public void getDebugProductCode () {//need to update basepath+requestSpec+find valid product Code
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("productCode", "PALENVELOPE_5X7GOLD");
        given().params(mainParameters).spec(requestSpecification).when().get("productCode/{productCode]/").then().statusCode(200);
    }

    //do we need to cover with tests endpoint restRepoIds?

    @Test
    public void getDebugSflySkusProductCodeSkuCode () {//need to update basepath+requestSpec+find valid product Code
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("productCode", "PALENVELOPE_5X7GOLD");
        given().params(mainParameters).spec(requestSpecification).when().get("sflySkus/{productCode}/{skuCode}").then().statusCode(200);
    }

    @Test
    public void getDebugShippingPriceSflySkuMinQntUseDefShipping () {//need to update basepath+requestSpec+find valid product Code
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("sflySku","string");
        mainParameters.put("minQnt", "1");
        mainParameters.put("useDefaultShipping", true);
        given().params(mainParameters).spec(requestSpecification).when().get("shippingPrice/{sflySku}/{minQnt}/{useDefaultShipping}").then().statusCode(200);
    }

    @Test
    public void getDebugTableMapping () {//need to update basepath+requestSpec
        given().spec(requestSpecification).when().get("tablemapping").then().statusCode(200);
    }

    @Test
    public void postDebugTestAvaliability () {//edit request spec and get valid data instead of string in the body
        HashMap<String, Object> mainBody = new HashMap<String, Object>();
        mainBody.put("now", "2022-05-24T10:03:57.956Z");
        mainBody.put("productAvailable", true);
        mainBody.put("productCode", "string");
        mainBody.put("skuAvailable", true);
        mainBody.put("skuCode", "string");
        given().body(mainBody).when().put("testAvaliability").then().statusCode(200);
    }

    @Test
    public void getDebugTestFF () {//need to update basepath+requestSpec
        given().spec(requestSpecification).when().get("testFF").then().statusCode(200);
    }

    @Test
    public void postDebugTestPricingForProductValidation(){ //need to modify request spec + basePath+resovled issue with paramethers
        HashMap<String, Object> mainBody = new HashMap<>();
        mainBody.put("imageLink","string");
        mainBody.put("minimumQtyPrice",0);
        List<String> bodyParametersOptionPricingSkus = new ArrayList<>();
        bodyParametersOptionPricingSkus.add("string");
        mainBody.put("optionPricingSkus", bodyParametersOptionPricingSkus);
        mainBody.put("optionResourceUID","string");
        HashMap<String, Object> bodyParametersProductVariationOptions = new HashMap<>();
        bodyParametersProductVariationOptions.put("optionName","string");
        bodyParametersProductVariationOptions.put("optionParentDisplayName","string");
        bodyParametersProductVariationOptions.put("optionValueDisplayName","string");
        bodyParametersProductVariationOptions.put("resultKeyDisplayName","string");
        bodyParametersProductVariationOptions.put("resultValueDisplayName","string");
        mainBody.put("productVariationOptions", bodyParametersProductVariationOptions);
        mainBody.put("salePrice", 0);
        mainBody.put("size", "string");
        mainBody.put("skuCode", "string");
        mainBody.put("title", "string");
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("productCode","string");
        mainParameters.put("minQty","string");
        given().
                params(mainParameters).
                spec(requestSpecification).body(mainBody).
                when().
                post("testPricingForProductVariation/{productCode}/{minQnt}").then().statusCode(200);
    }

    @Test
    public void postDebugTestRetrieveProducts(){ //need to modify request spec + basePath
        HashMap<String, Object> mainBody = new HashMap<>();
        mainBody.put("includeThumbnails","string");
        List<String> bodyParametersProductCodes = new ArrayList<>();
        bodyParametersProductCodes.add("string");
        mainBody.put("productCodes", bodyParametersProductCodes);
        mainBody.put("storeCode","string");
        mainBody.put("testProductCount", 0);
        given().spec(requestSpecification).body(mainBody).
                when().
                post("testRetrieveProducts").then().statusCode(200);
    }

    @Test
    public void getDebugThumbnailUrlProductCodeSkuCodeImageSize(){ //need to modify request spec + basePath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("productCode","string");
        mainParameters.put("skuCode","string");
        mainParameters.put("imageSize","string");
        given().params(mainParameters).spec(requestSpecification).
                when().
                get("thumbnailUrl/{productCode}/{skuCode}/{imageSize}").then().statusCode(200);
    }

    @Test
    public void getDebugThumbnailUrlProductCodeImageSize(){ //need to modify request spec + basePath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("productCode","string");
        mainParameters.put("imageSize","string");
        given().params(mainParameters).spec(requestSpecification).
                when().
                get("thumbnailUrl/{productCode}/{imageSize}").then().statusCode(200);
    }

    @Test
    public void getDebugV1EpattributeKey(){ //need to modify request spec + basePath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("key","string");
        given().params(mainParameters).spec(requestSpecification).
                when().
                get("v1/epattribute/{key}").then().statusCode(200);
    }

    @Test
    public void getDebugV1PimattributeKey(){ //need to modify request spec + basePath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("key","string");
        given().params(mainParameters).spec(requestSpecification).
                when().
                get("v1/pimattribute/{key}").then().statusCode(200);
    }

    @Test
    public void getProductFeedDownloaded(){ //need to modify request spec + basePath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("zipFileName","string");
        given().params(mainParameters).spec(requestSpecification).
                when().
                get("feed/download").then().statusCode(200);
    }

    @Test
    public void getProductFeedHistoryNumberOfRecords(){ //need to modify request spec + basePath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("numberOfRecords","10");
        given().params(mainParameters).spec(requestSpecification).
                when().
                get("ALL/10").then().statusCode(200);
    }

    @Test
    public void getProductFeedHistoryFeedStatusId(){ //need to modify request spec + basePath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("feedStatusId","string");
        given().params(mainParameters).spec(requestSpecification).
                when().
                get("vendor/feedId/{feedStatus}").then().statusCode(200);
    }

    @Test
    public void getProductFeedHistoryFeedNoOfDays(){ //need to modify request spec + basePath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("noOfDays","5");
        given().params(mainParameters).spec(requestSpecification).
                when().
                get("vendor/feedIds/5").then().statusCode(200);
    }

    @Test
    public void getProductFeedHistoryFeedName(){ //need to modify request spec + basePath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("feedName","BLOOMREACH");
        given().params(mainParameters).spec(requestSpecification).
                when().
                get("vendor/feedName/BLOOMREACH").then().statusCode(200);
    }

    @Test
    public void getStatusV1Vendor(){ //need to modify request spec + basePath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("vendor","BLOOMREACH");
        mainParameters.put("days","14");
        given().params(mainParameters).spec(requestSpecification).when().get("v1/BLOOMREACH").then().statusCode(200);
    }

    @Test
    public void getStatusVendor(){ //need to modify request spec + basePath
        HashMap<String, Object> mainParameters = new HashMap<>();
        mainParameters.put("vendor","BLOOMREACH");
        given().params(mainParameters).spec(requestSpecification).when().get("BLOOMREACH").then().statusCode(200);
    }







        @Test
        public void createNewFeed () {
            ParamatersForFeedCreation paramaters = FeedGenarator.updateFeed();


            AssertionsForClassTypes.assertThat(paramaters).isNotNull().extracting(ParamatersForFeedCreation::getFeedName)
                    .isEqualTo("TestSergQAA");
        }



}

