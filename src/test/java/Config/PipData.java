package Config;

import RestApiSetup.*;
import RestApiSetup.HashResponce.Metadata;
import RestApiSetup.HashResponce.OptionResourceMapItem;
import RestApiSetup.HashResponce.ResponseItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.config.HttpClientConfig;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.assertj.core.internal.Predicates;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.collections.Lists;
import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static groovyjarjarantlr4.v4.runtime.misc.Utils.readFile;
import static io.restassured.RestAssured.given;
import static java.util.stream.Collectors.toMap;
import static org.apache.groovy.json.internal.Chr.chars;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.codehaus.groovy.reflection.ClassInfo.size;

public class PipData extends RestSpecRegression {
    //public PipData pipData;
    ObjectMapper mapper = new ObjectMapper();
   // List<OptionsMap> pipOptdata;
    public void getsOptionsMap(){
      List<OptionsMaps> pipOptdata = given().spec(REQUEST_SPECIFICATION).
              get(EndPointsRegress.GET_PRODUCT).then().
              statusCode(200).extract().body().jsonPath().getList("optionResourceMap.optionsMap", OptionsMaps.class);
      Assert.assertTrue(pipOptdata.stream().allMatch(x->x.getColor().equals("#2C1E16")));
      Assert.assertTrue(pipOptdata.stream().anyMatch(x->x.getcARD_SIZE_ID().equals("23")));
      Assert.assertTrue(pipOptdata.stream().anyMatch(x->x.getgREETING().equals("CHRISTMAS")));
      Assert.assertTrue(pipOptdata.stream().anyMatch(x->x.getpAPER_TYPE().contains("Regular")));
      Assert.assertTrue(pipOptdata.stream().anyMatch(x->x.gettRIM().equals("Regular")));
        List<String> pipOptdataPaperFinish = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].values[0].childOptions[0].values[0].findAll{it.value == 'Matte'}.value");
        Assert.assertTrue(pipOptdataPaperFinish.stream().anyMatch(x->x.contains("Matte")));
        }

    public void getProductDysplayNameColor(){
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("productOptions.findAll{it.key == 'color'}.displayName");
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.contains("DESIGN COLOR")));
    }

    public void getProductDisplayNameCartSizeId(){
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("productOptions.findAll{it.key == 'CARD_SIZE_ID'}.displayName");
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.contains("FORMAT")));
    }

    public void getProductDisplayNameGreeting(){
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("productOptions.findAll{it.key == 'GREETING'}.displayName");
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.contains("GREETING")));
    }

    public void getProductDisplayNamePaperType(){
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].findAll{it.key == 'PAPER_TYPE'}.defaultValue");
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.contains("Regular")));
    }

    public void getProductDisplayNameTrim(){
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].values[0].childOptions[0].findAll{it.key == 'TRIM'}.displayName");
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.contains("TRIM")));
    }

    public void getProductDisplayNamePaperFinish(){
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].values[0].childOptions[0].findAll{it.key == 'PAPER_FINISH'}.displayName");
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.contains("FINISH")));
    }

    public void getProductDysplayNameColorValues(){
       ArrayList<List<String>> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getJsonObject("productOptions.findAll{it.key == 'color'}.values.value");
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.contains("#2C1E16")));
        ArrayList<List<String>> productOptdataColor = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getJsonObject("productOptions.findAll{it.key == 'color'}.values.displayName");
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.contains("#2C1E16")));
        Assert.assertTrue(productOptdataColor.stream().anyMatch(x->x.contains("Brown")));
    }

    public void getProductDysplayNameCardSizeIdValues(){
        ArrayList<List<String>> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getJsonObject("productOptions.findAll{it.key == 'CARD_SIZE_ID'}.values.value");
        ArrayList<List<String>> productOptdataSizeId = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getJsonObject("productOptions.findAll{it.key == 'CARD_SIZE_ID'}.values.displayName");
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.contains("23")));
        Assert.assertTrue(productOptdataSizeId.stream().anyMatch(x->x.contains("5x7")));
    }

    public void getProductDysplayNameGreetingsValues(){
        ArrayList<List<String>> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getJsonObject("productOptions.findAll{it.key == 'GREETING'}.values.value");
        ArrayList<List<String>> productOptdataGreet = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getJsonObject("productOptions.findAll{it.key == 'GREETING'}.values.displayName");
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.contains("CHRISTMAS")));
        Assert.assertTrue(productOptdataGreet.stream().anyMatch(x->x.contains("Christmas")));
    }
    public void getProductDysplayNamePaperTypeValues(){
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].findAll{it.key == 'PAPER_TYPE'}.defaultValue");
        ArrayList<List<String>> productOptdataPaperType = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getJsonObject("blueprintOptions.options[0].findAll{it.key == 'PAPER_TYPE'}.values.value");
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.contains("Regular")));
        Assert.assertTrue(productOptdataPaperType.stream().allMatch(x->x.contains("Regular")));
    }

    public void getProductDysplayNameTrimValues(){
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].values[0].childOptions[0].findAll{it.key == 'TRIM'}.displayName");
        List<String> productOptdataTrim = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].values[0].childOptions[0].findAll{it.key == 'TRIM'}.values[0].value");
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.equals("TRIM")));
        Assert.assertTrue(productOptdataTrim.stream().anyMatch(x->x.equals("Rounded")));
    }

    public void getProductDysplayNameFinishValues(){
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].values[0].childOptions[0].findAll{it.key == 'PAPER_FINISH'}.values[0].displayName");
        List<String> productOptdataFin = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].values[0].childOptions[0].findAll{it.key == 'PAPER_FINISH'}.values[0].value");
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.equals("Matte")));
        Assert.assertTrue(productOptdataFin.stream().anyMatch(x->x.equals("Matte")));
    }

    public List<ImageURLs.ImageURL> getProductVerifyImageLink() {
        List<ImageURLs.ImageURL> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("optionResourceMap.imageUrls[26]", ImageURLs.ImageURL.class);

        return productOptdata;
    }

    public List<String> getPhotoBooksColumnPhotoBookSize() {
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT_PHOTO_BOOKS_VERIF_COLUMNS).then().
                statusCode(200).extract().body().jsonPath().get("productOptions.findAll{it.key=='PHOTO_BOOK_SIZE'}.values.value[0]");
        return productOptdata;
    }

    public List<String> getPhotoBooksColumnPhotoBookCover() {
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT_PHOTO_BOOKS_VERIF_COLUMNS).then().
                statusCode(200).extract().body().jsonPath()
                .getList("productOptions.values[0].childOptions[0].find{it.key=='PHOTO_BOOK_COVER'}.values.value");
        return productOptdata;
    }

    public List<String> getPhotoBooksColumnPageOptions() {
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT_PHOTO_BOOKS_VERIF_COLUMNS).then().
                statusCode(200).extract().body().jsonPath().getList("productOptions.values[0].childOptions[0].values[0].childOptions[0].find{it.key=='PHOTO_BOOK_PAGE_OPTIONS'}.values.value");
        return productOptdata;
    }

    public List<String> getHashMap() throws NoSuchAlgorithmException, UnsupportedEncodingException, JsonProcessingException {
        ArrayList<Map<String,String>> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT_PHOTO_BOOKS_VERIF_COLUMNS).then().
                statusCode(200).extract().body().jsonPath().get("optionResourceMap.optionsMap");
        Map<String, String> map = new HashMap<>();
        for (Map<String, String> str : productOptdata)
        { map.put(String.valueOf(str), String.valueOf(str.size())); }
        List<String> filteredHashList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> keyListForHasing = new ArrayList<>();
        for( Map<String, String> as : productOptdata )
        {
            keyListForHasing.add(objectMapper.writeValueAsString(as));
        }
        for( String s : keyListForHasing )
        {
            filteredHashList.add(DatatypeConverter.printHexBinary(
                    MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"))).toLowerCase());
        }
        System.out.println(filteredHashList);
        System.out.println(keyListForHasing);
        return filteredHashList;
    }


    public List<OptionResourceMapItem> getOptionmapAndUID(){
        List<OptionResourceMapItem> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT_PHOTO_BOOKS_VERIF_COLUMNS).then().
                statusCode(200).extract().body().jsonPath().getList("optionResourceMap.findAll{it.optionsMap}", OptionResourceMapItem.class);
        Assert.assertTrue(productOptdata.stream()
                .filter(s->s.getOptionResourceUID().
                        equals("a3a7278bdd85918531e947218bad314c")).anyMatch(y->y.getOptionsMap()
                        .stream().anyMatch(x->x.getpHOTO_BOOK_SIZE().equals("PHOTO_BOOK_SIZE_8X8"))));
        Assert.assertTrue(productOptdata.stream()
                .anyMatch(x->x.getOptionsMap().stream().allMatch(y->y.getpHOTO_BOOK_SIZE()
                        .equals("PHOTO_BOOK_SIZE_8X11"))));
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getOptionsMap().stream().allMatch(y->y.getpHOTO_BOOK_COVER()
                .equals("PHOTO_BOOK_COVER_PREMIUM_LEATHER"))));
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.getOptionsMap().stream()
                .allMatch(y->y.getpHOTO_BOOK_PAGE_OPTIONS().equals("PHOTO_BOOK_PAGE_OPTIONS_DELUXE_LAYFLAT"))));
        Assert.assertTrue(productOptdata.stream()
                .filter(s->s.getOptionResourceUID().
                        equals("a3a7278bdd85918531e947218bad314c")).anyMatch(y->y.getOptionsMap()
                        .stream().anyMatch(x->x.getpHOTO_BOOK_SIZE().equals("PHOTO_BOOK_SIZE_8X8"))));
        Assert.assertTrue(productOptdata.stream()
                .filter(s->s.getOptionResourceUID().
                        equals("f699852ee75babbf1082a0fc69d9a67b")).anyMatch(y->y.getOptionsMap()
                        .stream().anyMatch(x->x.getpHOTO_BOOK_SIZE().equals("PHOTO_BOOK_SIZE_6X6"))));
        Assert.assertTrue(productOptdata.stream()
                .filter(s->s.getOptionResourceUID().
                        equals("6fe0e3f77fa18674496a00c472f7627c")).anyMatch(y->y.getOptionsMap()
                        .stream().anyMatch(x->x.getpHOTO_BOOK_COVER().equals("PHOTO_BOOK_COVER_HARD"))));
        return productOptdata;
    }

    public List<ResponseItem> getFeedsUniquenessForTitles() throws IOException {
        List<ResponseItem> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT_VALIDATE_TILTES_VALUES).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[1].values[0].findAll{it.value=='black_mug'}", ResponseItem.class);
        return productOptdata;
    }

    public Metadata getTitleFromMetadata() {
        Metadata productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT_VALIDATE_TILTES_VALUES).then().
                statusCode(200).extract().body().jsonPath().getObject("metadata", Metadata.class);
        return productOptdata;
    }

    public List<OptionsMaps> getOptionsMapForTestCaseWithSplunckCheck(){
        List<OptionsMaps> pipOptdata = given().spec(REQUEST_SPECIFICATION).
            get(EndPointsRegress.GET_PRODUCT).then().
            statusCode(200).extract().body().jsonPath().getList("optionResourceMap.optionsMap", OptionsMaps.class);
        return pipOptdata;
    }

    public Metadata getOptionsMapForTestCaseWithSplunckCheckAdditional(){
        Metadata pipOptdata = given().spec(REQUEST_SPECIFICATION).
            get(EndPointsRegress.GET_PRODUCT).then().
            statusCode(200).extract().body().jsonPath().getObject("metadata", Metadata.class);
        return pipOptdata;
    }

    public List<String> getOptionsMapForTestCaseWithSplunckCheckGetSignature(){
        List<String> pipOptdata = given().spec(REQUEST_SPECIFICATION).
            get(EndPointsRegress.GET_PRODUCT).then().
            statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].values[0].displayName");
        return pipOptdata;
    }

    public List<String> getOptionsMapForTestCaseWithSplunckCheckgetSquare(){
        List<String> pipOptdata = given().spec(REQUEST_SPECIFICATION).
            get(EndPointsRegress.GET_PRODUCT).then().
            statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].values[0].childOptions[0].values[1].findAll{it.displayName=='Square'}.displayName");
        return pipOptdata;
    }

    public static ArrayList<String[]> tsvReader(File fileFortesting) {
        ArrayList<String[]> Data = new ArrayList<>(); //initializing a new ArrayList out of String[]'s
        try (BufferedReader TSVReader = new BufferedReader(new FileReader(fileFortesting))) {
            String line = null;
            while ((line = TSVReader.readLine()) != null) {
                String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
                Data.add(lineItems); //adding the splitted line array to the ArrayList
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return Data;
    }

    RequestConfig requestConfig = RequestConfig.custom()
        .setConnectTimeout(5000)
        .setConnectionRequestTimeout(5000)
        .build();

    HttpClientConfig httpClientFactory = HttpClientConfig.httpClientConfig()
        .httpClientFactory(() -> HttpClientBuilder.create()
            .setDefaultRequestConfig(requestConfig)
            .build());




    public void getProductPricingValues(){
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].values[0].childOptions[0].findAll{it.key == 'PAPER_FINISH'}.values[0].displayName");
        List<String> productOptdataFin = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath().getList("blueprintOptions.options[0].values[0].childOptions[0].findAll{it.key == 'PAPER_FINISH'}.values[0].value");
        Assert.assertTrue(productOptdata.stream().allMatch(x->x.equals("Matte")));
        Assert.assertTrue(productOptdataFin.stream().anyMatch(x->x.equals("Matte")));
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
    }


    public void getsProductOptionsBluePrintsTrim(){
        List<String> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath()
                .getJsonObject("optionResourceMap.optionsMap.TRIM");
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.equals("Rounded")));
        List<ArrayList<String>> productOptdataBluePrints = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath()
                .getJsonObject("blueprintOptions.options[0].values.childOptions.displayName[0]");
        Assert.assertTrue(productOptdataBluePrints.stream().anyMatch(x->x.contains("TRIM")));
    }

    public void getsProductOptionsPricingSku(){
        List<ArrayList<String>> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath()
                .getJsonObject("blueprintOptions.options[0].values.childOptions.values[0].pricingSku[0]");
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.contains("ROUNDED_TRIM_5X7_FLAT")));

    }

    public void getsProducftOptionsPricingSku(){
        List<ArrayList<String>> productOptdata = given().spec(REQUEST_SPECIFICATION).
                get(EndPointsRegress.GET_PRODUCT).then().
                statusCode(200).extract().body().jsonPath()
                .getJsonObject("blueprintOptions.options[0].values.childOptions.values[0].pricingSku[0]");
        Assert.assertTrue(productOptdata.stream().anyMatch(x->x.contains("ROUNDED_TRIM_5X7_FLAT")));

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
       List<ArrayList<String>> listF = productOptdataBluePrints.stream().filter(x->x.equals("TRIM")).collect(Collectors.toList());
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

//  ArrayList<Map<PipDataResponse.BluePrintOptions,?>>;