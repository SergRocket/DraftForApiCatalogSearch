package RestApiSetup;

import java.util.*;

import static io.restassured.RestAssured.given;

public class DebugController extends RestSpec{

    @Override
    public  String getBasePath() {
        return "/debug/";
    }

    public String getDebugController(HashMap<String,Object> mainParam){
        return given().params(mainParam).
                spec(REQUEST_SPECIFICATION).
                get(EndPoints.GET_DEBUG_BY_ATTRIBUTE_NAME).then().statusCode(200).extract().asString();
    }

    public List<String> getDebugAttributeMappings(){
        return given().spec(REQUEST_SPECIFICATION).get(EndPoints.GET_ATTRIBUTE_MAPPINGS).jsonPath().getList("epAttribute");
    }

    public String getDebugByProductCode(HashMap<String,Object> mainParam){
        return given().params(mainParam).
                spec(REQUEST_SPECIFICATION).
                get(EndPoints.GET_DEBUG_BY_PRODUCT_CODE).then().statusCode(200).extract().asString();
    }

    public String getDebugByProductCodeSkuCode(HashMap<String,Object> mainParam){
        return given().params(mainParam).
                spec(REQUEST_SPECIFICATION).
                get(EndPoints.GET_DEBUG_SKU_BY_PRODUCT_CODE_AND_SKU_CODE).then().statusCode(200).extract().asString();
    }

    public String getDebugByFeedNameStoreCode(HashMap<String,Object> mainParam){
        return given().params(mainParam).
                spec(REQUEST_SPECIFICATION).
                get(EndPoints.GET_DEBUG_FILE_HYSTORY_BY_FEEDNAME_AND_STORE_CODE).then().statusCode(200).extract().asString();
    }

    public boolean generateFullFeed(){
        return   given().spec(REQUEST_SPECIFICATION)
                .get(EndPoints.GET_DEBUG_GENERATE_FULL_FEED).toString().isEmpty();
    }

    public List<String> getDebugAttributeByProductCode(HashMap<String,Object> mainParam){
        return given().params(mainParam).spec(REQUEST_SPECIFICATION).get(EndPoints.GET_ATTRIBUTE_MAPPINGS).jsonPath().getList("color");
    }

    public String getDebugGoogleAttrbProductCodeSkuCode(HashMap<String,Object> mainParam){
        return given().params(mainParam).
                spec(REQUEST_SPECIFICATION).
                get(EndPoints.GET_DEBUG_SKU_BY_PRODUCT_CODE_AND_SKU_CODE).then().statusCode(200).extract().asString();
    }

    public String getDebugMappings(){
        return given().spec(REQUEST_SPECIFICATION).get(EndPoints.GET_DEBUG_MAPPINGS).
                jsonPath().
                get("attributeMappingEntries[0].pimRepository");
    }

    public String getDebugMobileSkuCode(HashMap<String,Object> mainParam){
        return given().params(mainParam).
                spec(REQUEST_SPECIFICATION).
                get(EndPoints.GET_DEBUG_MOBILE_BY_SKU_CODE).then().statusCode(200).extract().asString();
    }

    public List<String> getDebugPimTables(){
        return given().spec(REQUEST_SPECIFICATION).get(EndPoints.GET_DEBUG_PIM_TABLES).jsonPath().getList("");
    }

    public List<String> getDebugPimDataProductCode(HashMap<String,Object> mainParam){
        return given().params(mainParam).spec(REQUEST_SPECIFICATION).get(EndPoints.GET_DEBUG_PIPI_DATA_BY_PRODUCT_CODE).jsonPath().getList("skuCode");
    }

    public String getDebugProductCode(HashMap<String,Object> mainParam){
        return given().params(mainParam).spec(REQUEST_SPECIFICATION).get(EndPoints.GET_DEBUG_BY_PRODUCT_CODE).jsonPath().get("localeDependentFields[0].displayName");
    }

    public String getDebugProductCodeSkuCode(HashMap<String,Object> mainParam){
        return  given().params(mainParam).spec(REQUEST_SPECIFICATION).get(EndPoints.GET_DEBUG_SKU_BY_PRODUCT_CODE_AND_SKU_CODE).jsonPath().get("baseSkus[0]");
    }

    public Float getDebugShippingPrice(HashMap<String,Object> mainParam){
        return  given().params(mainParam).spec(REQUEST_SPECIFICATION).get(EndPoints.GET_DEBUG_SHIPPING_PRICE_BY_SKU_AND_QNT_DEFAULT_SHIPPING).jsonPath().get("first");
    }

    public boolean getDebugTableMapping(){
        return given().spec(REQUEST_SPECIFICATION).get(EndPoints.GET_DEBUG_TABLE_MAPPING).toString().isEmpty();
    }

    public boolean getDebugTestFF(){
        return  given().spec(REQUEST_SPECIFICATION).get(EndPoints.GET_DEBUG_TEST_FF).then().statusCode(200).extract().response().as(Boolean.class);
    }



}
