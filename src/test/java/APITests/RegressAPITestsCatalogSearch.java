package APITests;

import Config.PipData;
import RestApiSetup.*;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class RegressAPITestsCatalogSearch extends BaseSevice {
    public PipData pipData = new PipData();
    @BeforeTest
    private void beforeClass() {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200)
                .log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test(description = "first and second tests")
    public void VerifyColNamesCSProductsInGoogleFeed(){
      //pipData.getsOptionsMap();
      //pipData.getsProductOptionsColor();
      //pipData.getsProductOptionsCartSizeId();
      //pipData.getsProductOptionsGREETING();
     // pipData.getsProductOptionsBluePrintsValues();
      pipData.getsProductOptionsBluePrintsTrim();
    }

    @Test(description = "5th test")
    public void VerifyColNamesForPricing(){
        pipData.getsProductOptionsPricingSku();
    }

    @Test(description = "Verify the feature flag for C&S product variations")
    public void VerifyFeatureFlag(){
        pipData.getsProductOptionsPricingSku();
    }







}
