package APITests;

import Config.MapiData;
import Config.PipData;
import Config.PricingData;
import RestApiSetup.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static Config.IsInteger.isInt;
import static Config.IsString.isString;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegressAPITestsCatalogSearch extends BaseSevice {
    public PipData pipData = new PipData();
    public PricingData pricingData = new PricingData();
    public VerifFeatureData verifFeatureData = new VerifFeatureData();
    public FeatureFlagOnOff featureFlagOnOff = new FeatureFlagOnOff();
    public VerifyBloomreachSizeIDData verifyBloomreachSizeIDData = new VerifyBloomreachSizeIDData();
    public MapiData mapiData = new MapiData();
    public MapiDataApi2Stage mapiDataApi2Stage = new MapiDataApi2Stage();
    @BeforeTest
    private void beforeClass() {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200)
                .log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test(description = "Verify the column names of the Cards & Stationery " +
            "products permutations in the Google feed")
    public void VerifyColNamesCSProductsInGoogleFeed(){
      pipData.getsOptionsMap();
      pipData.getProductDysplayNameColor();
      pipData.getProductDisplayNameCartSizeId();
      pipData.getProductDisplayNameGreeting();
      pipData.getProductDisplayNamePaperType();
      pipData.getProductDisplayNameTrim();
      pipData.getProductDisplayNamePaperFinish();
    }

    @Test(description = "Verify the product options values of the C&S " +
            "products permutations in the Google feed")
    public void VerifyProductOptValuesIngoogleFeed(){
      // pipData.getsOptionsMap();
      // pipData.getsProductOptionsBluePrintsValues();
       pipData.getProductDysplayNameColorValues();
       pipData.getProductDysplayNameCardSizeIdValues();
       pipData.getProductDysplayNameGreetingsValues();
       pipData.getProductDysplayNamePaperTypeValues();
       pipData.getProductDysplayNameTrimValues();
       pipData.getProductDysplayNameFinishValues();
    }

    @Test(description = "Verify the pricing of the products for automatically" +
            " generated feeds if C&S permutations is ENABLED")
    public void VerifyPricingForProducts(){pricingData.getPricingValidation();
    }

    @Test(description = "Verify the feature flag for C&S product variations")
    public void VerifyFeatureFlag() throws InterruptedException {//need to implement several tries, so
        //it won`t be needed to wait for 5 min
        HashMap<String, Object> mainBodyFalse = new HashMap<>();
        mainBodyFalse.put("google.extendedProductTypes.includeCardsAndStationery",false);
        featureFlagOnOff.onOffFetureFlag(mainBodyFalse);
        Thread.sleep(305000);//pause for 5 min
        Assert.assertFalse(verifFeatureData.verifyFeatureIsOn());
        HashMap<String, Object> mainBodyTrue = new HashMap<>();
        mainBodyFalse.put("google.extendedProductTypes.includeCardsAndStationery",true);
        featureFlagOnOff.onOffFetureFlag(mainBodyTrue);
        Assert.assertTrue(verifFeatureData.verifyFeatureIsOn());
    }

    @Test(description = "Verify presence of size ID in Bloomreach feed")
    public void VerifySizeIdPresentInBloomreach(){
        Assert.assertTrue(verifyBloomreachSizeIDData.getProductVerifySizeIdValue()
                .stream().anyMatch(x->x.equals(61)));
        int size = verifyBloomreachSizeIDData.getProductVerifySizeIdValue().size()-1;
        for(int i=0; i<=size; i++){
            assertThat(verifyBloomreachSizeIDData.getProductVerifySizeIdValue().get(i).toString(), isInt());
        }
        Assert.assertTrue(verifyBloomreachSizeIDData.getProductVerifySizeIdType()
                .stream().anyMatch(x->x.equals("INTEGER")));
        for(int i=0; i<=size; i++){
            assertThat(verifyBloomreachSizeIDData.getProductVerifySizeIdType().get(i), isString());
        }
    }

    @Test(description = "Verify image Links of pipdata enabled Categories")
    public void VerifyImageLink(){
        Assert.assertTrue(pipData.getProductVerifyImageLink()
                .stream().anyMatch(x->x.getLabel().equals("FRONT")));
        Assert.assertTrue(pipData.getProductVerifyImageLink()
                .stream().anyMatch(x->x.getImageUrl().equals("https://c2-beta.staticsfly.com/" +
       "asset/fetch/cs/STATIONERYCARD_6x8-89017-22504-MERCHLARGE_FRONT-REGULAR/thumbnail.preview/v7")));
    }

    @Test(description = "Verify sale price of different product types / categories")
    public void VerifySalePricingForDiffrntProducts(){
        HashMap<String, Object> mainParam = new HashMap<>();
        mainParam.put("productCode", "2037481");
        mainParam.put("skuCode","1084038");
        String[] skus = {"PLATE01","SQUARE8X870"};
        mainParam.put("sku", Arrays.asList(skus));
        pricingData.getPricingSummaryValidation(mainParam);
    }

    @Test(description = "Verify Photo Books category additional columns for variations")
    public void VerifyPhotoBooksCategoryAdditionalColumns(){
        Assert.assertTrue(pipData.getPhotoBooksColumnPhotoBookSize().stream()
                .anyMatch(x->x.equals("PHOTO_BOOK_SIZE_10X10")));
        Assert.assertTrue(pipData.getPhotoBooksColumnPhotoBookCover().stream()
                .anyMatch(x->x.equals("PHOTO_BOOK_COVER_HARD")));
        Assert.assertTrue(pipData.getPhotoBooksColumnPageOptions().stream()
                .allMatch(x->x.equals("PHOTO_BOOK_PAGE_OPTIONS_DELUXE_LAYFLAT")));
    }

    @Test(description = "Google feeds optionResourceUID MD5 hash id column for C&S and PB")
    public void VerifyOptionResourceUIDMD5Hash() throws UnsupportedEncodingException, NoSuchAlgorithmException, JsonProcessingException {
        Assert.assertTrue(pipData.getOptionmapAndUID().size() == pipData.getHashMap().size());
        Assert.assertTrue(pipData.getHashMap().stream().
        anyMatch(element ->pipData.getOptionmapAndUID().stream().anyMatch(s->s.getOptionResourceUID().equals(element))));
    }

    @Test(description = "Google feeds uniqueness of Titles for permutations")
    public void VerifyUniquenessOfTitles() throws IOException {
        Assert.assertTrue(pipData.getFeedsUniquenessForTitles().stream().anyMatch(x->x.getDisplayName().equals("Ceramic Mug (15oz) - Black")));
        Assert.assertTrue(pipData.getFeedsUniquenessForTitles().stream().anyMatch(x->x.getValue().equals("black_mug")));
        Assert.assertTrue(pipData.getFeedsUniquenessForTitles().stream().anyMatch(x->x.getPricingSku().equals("MUG_15_BLACK")));
        Assert.assertTrue(pipData.getTitleFromMetadata().getTitle().equals("Classic Trio Mug"));
        Assert.assertTrue(pipData.getTitleFromMetadata().getMoreDetails().getStyleName().equals("Classic Trio"));
        Assert.assertTrue(pipData.getTitleFromMetadata().getProductTypeName().equals("Ceramic Mug"));
        }

    @Test(description = "Google feeds uniqueness of Titles for permutations")
    public void verifyManuallyGeneratedFeed() {
        Assert.assertTrue(pipData.getOptionsMapForTestCaseWithSplunckCheck().size()>=30);
        pipData.getOptionsMapForTestCaseWithSplunckCheck().stream().anyMatch(x->x.getcARD_SIZE_ID().equals("89"));
        int size = pipData.getOptionsMapForTestCaseWithSplunckCheck().size()-1;
        for(int i=0; i<=size; i++){
            assertThat(pipData.getOptionsMapForTestCaseWithSplunckCheck().get(i).getcARD_SIZE_ID(), isInt());
        }
        Assert.assertTrue(pipData.getOptionsMapForTestCaseWithSplunckCheck().stream().anyMatch(x->x.getpAPER_TYPE().equals("Pearl")));
        for(int i=0; i<=size; i++){
            assertThat(pipData.getOptionsMapForTestCaseWithSplunckCheck().get(i).getpAPER_TYPE(), isString());
        }
        Assert.assertTrue(pipData.getOptionsMapForTestCaseWithSplunckCheck().stream().anyMatch(x->x.getpAPER_TYPE().equals("Luxe")));

        Assert.assertTrue(pipData.getOptionsMapForTestCaseWithSplunckCheck().stream().anyMatch(x->x.gettRIM().equals("Rounded")));
        for(int i=0; i<=size; i++){
            assertThat(pipData.getOptionsMapForTestCaseWithSplunckCheck().get(i).gettRIM(), isString());
        }
        Assert.assertTrue(pipData.getOptionsMapForTestCaseWithSplunckCheck().stream().anyMatch(x->x.gettRIM().equals("Scallop")));
        for(int i=0; i<=size; i++){
            assertThat(pipData.getOptionsMapForTestCaseWithSplunckCheck().get(i).getgREETING(), isString());
        }
        Assert.assertTrue(pipData.getOptionsMapForTestCaseWithSplunckCheck().stream().anyMatch(x->x.getgREETING().equals("HOLIDAY")));
    }

    @Test(description = "Google feeds uniqueness of Titles for permutations, additional validations")
    public void verifyFeedUniquenessForTitles() {
       Assert.assertTrue(pipData.getOptionsMapForTestCaseWithSplunckCheckAdditional().getTitle().equals("Wreathed in Joy Holiday Card"));
       Assert.assertTrue(pipData.getOptionsMapForTestCaseWithSplunckCheckGetSignature().stream().anyMatch(x->x.contains("Signature Smooth Cardstock")));
       Assert.assertTrue(pipData.getOptionsMapForTestCaseWithSplunckCheckgetSquare().stream().anyMatch(x->x.equals("Square")));
       assertThat(pipData.getOptionsMapForTestCaseWithSplunckCheckAdditional().getTitle(), isString());
    }

    @Test(description = "MAPI test")
    public void verifyMAPIResponseBody () {
        Map<String,String> mainParameters = new HashMap<>();
        mainParameters.put("SFLY-brand","us-sfly");
        mainParameters.put("SFLY-channel","web");
        mainParameters.put("q","enjoy%20cotton%20tote%26");
        mainParameters.put("sid","_br_uid_2");
        mainParameters.put("fl","avaliability%26");
        mainParameters.put("url","https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParameters.put("refurl","https://shutterfly.com%26");
        mainParameters.put("size","100");
        Assert.assertTrue(mapiData.getMapiData(mainParameters).getPage().getSize().equals(Integer.valueOf(100)));
        assertThat(mapiData.getMapiData(mainParameters).getPage().
            getSize(), isInt());
    }

    @Test
    public void givenAString_whenIsOnlyDigits_thenCorrect() {
        String digits = "12";
        assertThat(digits, isInt());
    }

    @Test(description = "MAPI test")
    public void verifyMAPIResponseBodyApi2Stage () {
        Map<String,String> mainParameters = new HashMap<>();
        mainParameters.put("fl","avaliability%26");
        mainParameters.put("url","https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParameters.put("refurl","https://shutterfly.com%26");
        mainParameters.put("size","100");
        Assert.assertTrue(mapiData.getMapiData(mainParameters).getPage().getSize().equals(Integer.valueOf(100)));
    }


    @Test(description = "MAPI API2 stage test")
    public void verifyMAPIApi2ResponseBodyApi2Stage () {
        Map<String,String> mainParameters = new HashMap<>();
        mainParameters.put("fl","skuid");
        mainParameters.put("url","https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParameters.put("refurl","https://shutterfly.com%26");
        //mainParameters.put("sfly-apikey","vHAx0uG8Ndr6WJf2vu697D4HnPHu5WfG");
        //Assert.assertTrue(mapiData.getMapiData(mainParameters).getPage().getSize().equals(Integer.valueOf(120)));
        Assert.assertFalse(mapiData.getMapiDataNegat(mainParameters).isEmpty());
    }


}


