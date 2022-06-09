package RestApiSetup;

import java.util.List;

import static io.restassured.RestAssured.given;

public class VerifyBloomreachSizeIDData extends RestSpecRegressionVerifySizeId{
    public List<Integer> getProductVerifySizeIdValue(){
        List<Integer> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT_BLOOMREACH_VERIF_SIZE_ID).then().
                statusCode(200).extract().body().jsonPath().getList("skus.attributeValuesMap[0]" +
                        ".findAll{it.localizedAttributeKey == 'content_product_sku_type'}.integerValue");
        return  productOptdata;
    }

    public List<String> getProductVerifySizeIdType(){
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT_BLOOMREACH_VERIF_SIZE_ID).then().
                statusCode(200).extract().body().jsonPath().getList("skus.attributeValuesMap[0]" +
                        ".findAll{it.localizedAttributeKey == 'content_product_sku_type'}.attributeType");
        return  productOptdata;
     }
 }
