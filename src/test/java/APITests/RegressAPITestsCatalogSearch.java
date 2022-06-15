package APITests;

import Config.PipData;
import Config.PricingData;
import RestApiSetup.*;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RegressAPITestsCatalogSearch extends BaseSevice {
    public PipData pipData = new PipData();
    public PricingData pricingData = new PricingData();
    public VerifFeatureData verifFeatureData = new VerifFeatureData();
    public FeatureFlagOnOff featureFlagOnOff = new FeatureFlagOnOff();
    public VerifyBloomreachSizeIDData verifyBloomreachSizeIDData = new VerifyBloomreachSizeIDData();
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
        pipData.getsOptionsMap();
        pipData.getsProductOptionsBluePrintsValues();
        pipData.getProductDysplayNameColorValues();
        pipData.getProductDysplayNameCardSizeIdValues();
        pipData.getProductDysplayNameGreetingsValues();
        pipData.getProductDysplayNamePaperTypeValues();
        pipData.getProductDysplayNameTrimValues();
        pipData.getProductDysplayNameFinishValues();
    }

    @Test(description = "Verify the pricing of the products for automatically" +
            " generated feeds if C&S permutations is ENABLED")
    public void VerifyPricingForProducts(){
         pricingData.getPricingValidation();
    }

    @Test(description = "Verify the feature flag for C&S product variations")
    public void VerifyFeatureFlag() throws InterruptedException {//need to implement several tries, so
        //it won`t be needed to wait for 5 min
        HashMap<String, Object> mainBodyFalse = new HashMap<>();
        mainBodyFalse.put("forceRefresh",false);
        featureFlagOnOff.onOffFetureFlag(mainBodyFalse);
        System.out.println("dklf");
        Thread.sleep(305000);//pause for 5 min
        Assert.assertFalse(verifFeatureData.verifyFeatureIsOn());
        HashMap<String, Object> mainBodyTrue = new HashMap<>();
        mainBodyFalse.put("forceRefresh",true);
        featureFlagOnOff.onOffFetureFlag(mainBodyTrue);
        Assert.assertTrue(verifFeatureData.verifyFeatureIsOn());
    }

    @Test(description = "Verify presence of size ID in Bloomreach feed")
    public void VerifySizeIdPresentInBloomreach(){
        Assert.assertTrue(verifyBloomreachSizeIDData.getProductVerifySizeIdValue()
                .stream().anyMatch(x->x.equals(61)));
        Assert.assertTrue(verifyBloomreachSizeIDData.getProductVerifySizeIdType()
                .stream().anyMatch(x->x.equals("INTEGER")));
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
    public void VerifyOptionResourceUIDMD5Hash(){
        pipData.getOptionmapAndUID();
        Assert.assertTrue(pipData.getOptionmapAndUID().stream().findFirst().stream()
                .anyMatch(x->x.getOptionsMap().stream().allMatch(y->y.getpHOTO_BOOK_SIZE()
                        .equals("PHOTO_BOOK_SIZE_8X11"))));
        Assert.assertTrue(pipData.getOptionmapAndUID().stream().findFirst().stream()
                .anyMatch(x->x.getOptionsMap().stream().allMatch(y->y.getpHOTO_BOOK_COVER()
                        .equals("PHOTO_BOOK_COVER_PREMIUM_LEATHER"))));
        Assert.assertTrue(pipData.getOptionmapAndUID().stream().findFirst().stream()
                .anyMatch(x->x.getOptionsMap().stream().findFirst().stream()
                        .allMatch(y->y.getpHOTO_BOOK_PAGE_OPTIONS().equals("PHOTO_BOOK_PAGE_OPTIONS_DELUXE_LAYFLAT"))));
        Assert.assertTrue(pipData.getOptionmapAndUID().stream().findFirst().stream()
                .anyMatch(x->x.getOptionResourceUID().equals("34aa26a5231167787633ae510f211b57")));
        Assert.assertTrue(pipData.getOptionmapAndUID().stream()
                .filter(s->s.getOptionResourceUID().
                equals("a3a7278bdd85918531e947218bad314c")).anyMatch(y->y.getOptionsMap()
                        .stream().anyMatch(x->x.getpHOTO_BOOK_SIZE().equals("PHOTO_BOOK_SIZE_8X8"))));
        Assert.assertTrue(pipData.getOptionmapAndUID().stream()
                .filter(s->s.getOptionResourceUID().
                        equals("f699852ee75babbf1082a0fc69d9a67b")).anyMatch(y->y.getOptionsMap()
                        .stream().anyMatch(x->x.getpHOTO_BOOK_SIZE().equals("PHOTO_BOOK_SIZE_6X6"))));
        Assert.assertTrue(pipData.getOptionmapAndUID().stream()
                .filter(s->s.getOptionResourceUID().
                        equals("6fe0e3f77fa18674496a00c472f7627c")).anyMatch(y->y.getOptionsMap()
                        .stream().anyMatch(x->x.getpHOTO_BOOK_COVER().equals("PHOTO_BOOK_COVER_HARD"))));

    }

}
