package Config;

import RestApiSetup.EndPointsRegress;
import RestApiSetup.PricingResponceData;
import RestApiSetup.RestSpecRegressionPricing;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PricingData extends RestSpecRegressionPricing {
   public void getPricingValidation(){
       List<PricingResponceData.PricingItem> pricingData = given().spec(REQUEST_SPECIFICATION).
               get(EndPointsRegress.GET_ITEMPRICING_SUMMARY).then().
               statusCode(200).extract().body().jsonPath().
               getList("pricingItem", PricingResponceData.PricingItem.class);
       Assert.assertTrue(pricingData.stream().anyMatch(x->x.getOrigTotalPrice().equals(19.99)));
       Assert.assertTrue(pricingData.stream().anyMatch(x->x.getOrigUnitPrice().equals(19.99)));
       Assert.assertTrue(pricingData.stream().anyMatch(x->x.getSaleUnitPrice().equals(19.99)));
       Assert.assertTrue(pricingData.stream().anyMatch(x->x.getSaleTotalPrice().equals(19.99)));
       Assert.assertTrue(pricingData.stream().anyMatch(x->x.getSku().equals("PLATE01")));
   }

    public List<PricingResponceData.PricingItem> getPricingSummaryValidation(HashMap<String,Object> mainParam){
        List<PricingResponceData.PricingItem> pricingData = given().spec(REQUEST_SPECIFICATION).
                params(mainParam).get(EndPointsRegress.GET_PRICING_SALE_AND_REGURAL).then().
                statusCode(200).extract().body().jsonPath().
                getList("pricingItem", PricingResponceData.PricingItem.class);

        /*Assert.assertTrue(pricingData.stream().anyMatch(x->x.getOrigTotalPrice().equals(19.99)));
        Assert.assertTrue(pricingData.stream().anyMatch(x->x.getOrigUnitPrice().equals(19.99)));
        Assert.assertTrue(pricingData.stream().anyMatch(x->x.getSaleUnitPrice().equals(19.99)));
        Assert.assertTrue(pricingData.stream().anyMatch(x->x.getSaleTotalPrice().equals(19.99)));
        Assert.assertTrue(pricingData.stream().anyMatch(x->x.getSku().equals("PLATE01")));*/
        return pricingData;
    }
}
