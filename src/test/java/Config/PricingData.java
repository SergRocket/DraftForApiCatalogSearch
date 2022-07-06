package Config;

import RestApiSetup.EndPointsRegress;
import RestApiSetup.PricingResponceData;
import RestApiSetup.RestSpecRegressionPricing;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

import static Config.IsDouble.isDouble;
import static Config.IsInteger.isInt;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class PricingData extends RestSpecRegressionPricing {
   public void getPricingValidation(){
       List<PricingResponceData.PricingItem> pricingData = given().spec(REQUEST_SPECIFICATION).
               get(EndPointsRegress.GET_ITEMPRICING_SUMMARY).then().
               statusCode(200).extract().body().jsonPath().
               getList("pricingItem", PricingResponceData.PricingItem.class);
       Assert.assertTrue(pricingData.stream().anyMatch(x->x.getOrigTotalPrice().equals(19.99)));
       int size = pricingData.size()-1;
       for(int i=0; i<=size; i++){
           assertThat(pricingData.get(i).getOrigTotalPrice().toString(), isDouble());
       }
       Assert.assertTrue(pricingData.stream().anyMatch(x->x.getOrigUnitPrice().equals(19.99)));
       for(int i=0; i<=size; i++){
           assertThat(pricingData.get(i).getOrigUnitPrice().toString(), isDouble());
       }
       Assert.assertTrue(pricingData.stream().anyMatch(x->x.getSaleUnitPrice().equals(19.99)));
       for(int i=0; i<=size; i++){
           assertThat(pricingData.get(i).getSaleTotalPrice().toString(), isDouble());
       }
       Assert.assertTrue(pricingData.stream().anyMatch(x->x.getSaleTotalPrice().equals(19.99)));
       for(int i=0; i<=size; i++){
           assertThat(pricingData.get(i).getSaleTotalPrice().toString(), isDouble());
       }
       Assert.assertTrue(pricingData.stream().anyMatch(x->x.getSku().equals("PLATE01")));
   }

    public void getPricingSummaryValidation(HashMap<String,Object> mainParam){
        List<PricingResponceData.PricingItem> pricingItemData = given().spec(REQUEST_SPECIFICATION).
                params(mainParam).get(EndPointsRegress.GET_PRICING_SALE_AND_REGURAL).then().
                statusCode(200).extract().body().jsonPath().
                getList("pricingItem", PricingResponceData.PricingItem.class);

        Assert.assertTrue(pricingItemData.stream()
                .anyMatch(x->x.getOrigTotalPrice().equals(19.99)));
        int size = pricingItemData.size()-1;
        for(int i=0; i<=size; i++){
            assertThat(pricingItemData.get(i).getOrigTotalPrice().toString(), isDouble());
        }
        Assert.assertTrue(pricingItemData.stream()
                .anyMatch(x->x.getOrigUnitPrice().equals(19.99)));
        for(int i=0; i<=size; i++){
            assertThat(pricingItemData.get(i).getOrigUnitPrice().toString(), isDouble());
        }
        Assert.assertTrue(pricingItemData.stream()
                .anyMatch(x->x.getSaleUnitPrice().equals(19.99)));
        for(int i=0; i<=size; i++){
            assertThat(pricingItemData.get(i).getSaleUnitPrice().toString(), isDouble());
        }
        Assert.assertTrue(pricingItemData.stream()
                .anyMatch(x->x.getSaleTotalPrice().equals(19.99)));
        for(int i=0; i<=size; i++){
            assertThat(pricingItemData.get(i).getSaleTotalPrice().toString(), isDouble());
        }
        Assert.assertTrue(pricingItemData.stream()
                .anyMatch(x->x.getSku().equals("PLATE01")));
        Assert.assertTrue(pricingItemData.stream()
                .anyMatch(x->x.getOrigTotalPrice().equals(3.49)));
        Assert.assertTrue(pricingItemData.stream()
                .anyMatch(x->x.getOrigUnitPrice().equals(3.49)));
        Assert.assertTrue(pricingItemData.stream()
                .anyMatch(x->x.getSaleUnitPrice().equals(3.49)));
        Assert.assertTrue(pricingItemData.stream()
                .anyMatch(x->x.getSaleTotalPrice().equals(3.49)));
        Assert.assertTrue(pricingItemData.stream()
                .anyMatch(x->x.getSku().equals("SQUARE8X870")));

    }
}
