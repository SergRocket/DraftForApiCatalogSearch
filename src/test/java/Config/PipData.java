package Config;

import RestApiSetup.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class PipData extends RestSpecRegression {
    //public PipData pipData;
    ObjectMapper mapper = new ObjectMapper();
   // List<OptionsMap> pipOptdata;
    public void getsOptionsMap(){
      List<OptionsMap> pipOptdata = given().spec(REQUEST_SPECIFICATION).
              get(EndPointsRegress.GET_PRODUCT).then().
              statusCode(200).extract().body().jsonPath().getList("optionResourceMap.optionsMap", OptionsMap.class);
      Assert.assertTrue(pipOptdata.stream().allMatch(x->x.getColor().equals("#2C1E16")));
      Assert.assertTrue(pipOptdata.stream().anyMatch(x->x.getcARD_SIZE_ID().equals("23")));
      Assert.assertTrue(pipOptdata.stream().anyMatch(x->x.getgREETING().equals("CHRISTMAS")));
      Assert.assertTrue(pipOptdata.stream().anyMatch(x->x.getpAPER_TYPE().contains("Regular")));
      Assert.assertTrue(pipOptdata.stream().anyMatch(x->x.gettRIM().equals("Regular")));
      Assert.assertTrue(pipOptdata.stream().anyMatch(x->x.getpAPER_FINISH().contains("Matte")));

     // Assert.assertTrue(pipOptdata.stream().allMatch(x->x.getpAPER_FINISH().equals(x.pAPER_FINISH)));

      /*pipOptdata.forEach(x->Assert.assertTrue(x.getColor().contains(x.color)));
      pipOptdata.forEach(x->Assert.assertTrue(x.getcARD_SIZE_ID().contains(x.cARD_SIZE_ID)));
      pipOptdata.forEach(x->Assert.assertTrue(x.getgREETING().contains(x.gREETING)));
      pipOptdata.forEach(x->Assert.assertTrue(x.getpAPER_FINISH().contains(x.pAPER_FINISH)));
      pipOptdata.forEach(x->Assert.assertTrue(x.getpAPER_TYPE().contains(x.pAPER_TYPE)));
      pipOptdata.forEach(x->Assert.assertTrue(x.gettRIM().contains(x.tRIM)));*/

    }

    public void getsProductOptionsColor(){
        List<PipDataResponse.Value> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("productOptions.values[0]",  PipDataResponse.Value.class);
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.getAvailability().contains("AVAILABLE")));
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.getDisplayName().contains("Brown")));
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.getValue().contains("#2C1E16")));
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.getDisplayOrder().equals(0)));
    }

    public void getsProductOptionsCartSizeId(){
        List<PipDataResponse.Value> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("productOptions.values[1]",  PipDataResponse.Value.class);
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.getAvailability().contains("AVAILABLE")));
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getDisplayName().contains("6x8")));
    }

    public void getsProductOptionsGREETING(){
        List<PipDataResponse.Value> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("productOptions.values[2]",  PipDataResponse.Value.class);
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getAvailability().contains("AVAILABLE")));
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getDisplayName().contains("Holiday")));
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getValue().contains("HOLIDAY")));
    }

    public void getsProductOptionsBluePrints(){

        ArrayList<PipDataResponse.OptionsFromBluePrint> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath()
                .getJsonObject("blueprintOptions.options");
        System.out.println("kf");
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getDefaultValue().equals("Regular")));
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getKey().contains("PAPER_TYPE")));
    }

    /*public void getsProductOptionsBluePrintsValues(){
        List<PipDataResponse.Values> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions[0].options.values",  PipDataResponse.Values.class);
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getDisplayName().contains("Signature Smooth Cardstock")));
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getValue().contains("Regular")));
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getSizeId().equals("23")));
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.isBaseSku.equals(false)));
    }*/

    public void getsProductOptionsBluePrintsValues(){
        List<PipDataResponse.BluePrintOptinsMap> productOptDataMap = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().statusCode(200).extract().body().jsonPath()
                .getList("blueprintOptions.optionsMap",PipDataResponse.BluePrintOptinsMap.class);
        Assert.assertFalse(productOptDataMap.isEmpty());
        Assert.assertTrue(productOptDataMap.stream().allMatch(x->x.getColor().equals("#2C1E16")));
        Assert.assertTrue(productOptDataMap.stream().anyMatch(x->x.getGREETING().equals("CHRISTMAS")));
        Assert.assertTrue(productOptDataMap.stream().anyMatch(x->x.getCARD_SIZE_ID().equals("23")));
        List<String> productColorOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().statusCode(200).extract().body().jsonPath().getList("blueprintOptions.optionsMap.findAll{ it.CARD_SIZE_ID == '23' }.GREETING");
        Assert.assertTrue(productColorOptdata.stream().anyMatch(x->x.equals("HOLIDAY")));
        List<ArrayList<String>> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options.findAll{ it.key }.key");
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.contains("PAPER_TYPE")));

       // Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getDisplayName().contains("Signature Smooth Cardstock")));
       // Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getValue().contains("Regular")));
       // Assert.assertTrue(productOptdata.stream().allMatch(x->x.getSizeId().contains("23")));
       /* List<List> productOptdataparent = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).jsonPath().getList("blueprintOptions[0].options");*/


        //Assert.assertFalse(productOptdata.isEmpty());
        //Assert.assertFalse(productOptdataparent.isEmpty());
      //  ArrayList<Map<PipDataResponse.BluePrintOptions,?>>;

    }





    public List<String> getProductPipData(){
       JsonNode accounts = given().spec(REQUEST_SPECIFICATION).get(EndPointsRegress.GET_PRODUCT).as(JsonNode.class);
       List<String> accountList = mapper.
               enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY).
               convertValue(accounts, new TypeReference<>() {
       });
       //accountList.stream().collect(Collectors.toList();
       return accountList;
    }


   // given().spec(REQUEST_SPECIFICATION).get(EndPointsRegress.GET_PRODUCT).then().statusCode(200).body("optionResourceMap.optionsMap[0].color", Matchers.equalTo("#2C1E16"));
}

   /* public void getsProductPipData(){
        List<OptionsMap> pipOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("optionResourceMap.optionsMap", OptionsMap.class);
        pipOptdata.forEach(x-> Assert.assertTrue(x.getColor().contains(x.color)));
        pipOptdata.forEach(x->Assert.assertTrue(x.getColor().contains(x.color)));
        pipOptdata.forEach(x->Assert.assertTrue(x.getcARD_SIZE_ID().contains(x.cARD_SIZE_ID)));
        pipOptdata.forEach(x->Assert.assertTrue(x.getgREETING().contains(x.gREETING)));
        pipOptdata.forEach(x->Assert.assertTrue(x.getpAPER_FINISH().contains(x.pAPER_FINISH)));
        pipOptdata.forEach(x->Assert.assertTrue(x.getpAPER_TYPE().contains(x.pAPER_TYPE)));
        pipOptdata.forEach(x->Assert.assertTrue(x.gettRIM().contains(x.tRIM)));

    }*/


    /*ArrayList<String> filtered = productOptdata.stream().filter(x->"key".equals(x.equals("PAPER_TYPE")).collect(Collectors.toList()));
        System.out.println(filtered);
                Assert.assertFalse(productOptdata.isEmpty());
                Map<String, String> filteredMap = productOptdata
        .stream().filter(x->"key".equals(x.equals("PAPER_TYPE")))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));*/