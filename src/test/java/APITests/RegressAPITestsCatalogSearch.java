package APITests;

import Config.MapiData;
import Config.PipData;
import Config.PricingData;
import RestApiSetup.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Header;
import org.awaitility.Awaitility;
import org.awaitility.Duration;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static Config.IsInteger.isInt;
import static Config.IsString.isString;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegressAPITestsCatalogSearch extends BaseSevice {
    public PipData pipData = new PipData();
    public SuggestionData suggestionData = new SuggestionData();
    public PricingData pricingData = new PricingData();
    public VerifFeatureData verifFeatureData = new VerifFeatureData();
    public FeatureFlagOnOff featureFlagOnOff = new FeatureFlagOnOff();
    public VerifyBloomreachSizeIDData verifyBloomreachSizeIDData = new VerifyBloomreachSizeIDData();
    public MapiData mapiData = new MapiData();
    public MapiDataApi2Stage mapiDataApi2Stage = new MapiDataApi2Stage();
    @BeforeTest
    private void beforeClass() {
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
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
    public void VerifyPricingForProducts(){pricingData.getPricingValidation();
    }

    @Test(description = "Verify the feature flag for C&S product variations")
    public void VerifyFeatureFlag() throws InterruptedException {
        HashMap<String, Object> mainBodyFalse = new HashMap<>();
        String mainBody =  "{ \"google.extendedProductTypes.enableProductVariations\": \"true\" }";
        mainBodyFalse.put("google.extendedProductTypes.enableProductVariations",true);
        JSONObject requestParams = new JSONObject();
        requestParams.put("google.extendedProductTypes.enableProductVariations", "true");
        Assert.assertTrue(verifFeatureData.verifyFeatureIsOn());
        featureFlagOnOff.onOffFetureFlag(requestParams.toString());
        Awaitility.await().atMost(60, TimeUnit.SECONDS).pollInterval(Duration.FIVE_SECONDS)
                .until(()->verifFeatureData.verifyFeatureIsOn()==false);
        Assert.assertFalse(verifFeatureData.verifyFeatureIsOn());
        HashMap<String, Object> mainBodyTrue = new HashMap<>();
        mainBodyFalse.put("google.extendedProductTypes.enableProductVariations",false);
        featureFlagOnOff.onOffFetureFlag(mainBody);
        Assert.assertTrue(verifFeatureData.verifyFeatureIsOn());
    }

    @Test
    public void getFeature(){
        HashMap<String, Object> mainBodyFalse = new HashMap<>();
        mainBodyFalse.put("google.extendedProductTypes.enableProductVariations",true);
        RestAssured.given().baseUri("https://configserver-cloud-int.beta.shutterfly.com")
            .basePath("/_internal/properties/services_product_feed/")
            .body(mainBodyFalse).post(EndPointsRegress.POST_ONOFF_FESTURE_FLAG).
            then().statusCode(200);
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
                .stream().anyMatch(x->x.getImageUrl().equals("https://c1-beta.staticsfly.com/asset/fetch"
                + "/cs/STATIONERYCARD_6x8-89017-22504-MERCHLARGE_FRONT-ROUNDED/thumbnail.preview/v7")));
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
                .anyMatch(x->x.equals("PHOTO_BOOK_PAGE_OPTIONS_DELUXE_LAYFLAT")));
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

    @Test(description = "MAPI API2 search stage test")
    public void verifyMAPIApi2ResponseBodyApi2Stage() {
        Map<String,String> mainParameters = new HashMap<>();
        mainParameters.put("url","https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParameters.put("refurl","https://shutterfly.com%");
        mainParameters.put("sid","_br_uid_2");
        mainParameters.put("fl","title");
        mainParameters.put("q", "mug");
        Assert.assertTrue(mapiData.getMapiData(mainParameters).getPage().getSize()>=50);
        Assert.assertTrue(mapiData.getMapiData(mainParameters).getFacets().getFacetFields().getMedium().stream().anyMatch(x->x.getName().equals("Art")));
        Assert.assertTrue(mapiData.getMapiData(mainParameters).getFacets().getFacetFields().getTopic().stream().anyMatch(x->x.getName().equals("Typography")));

    }

    @Test(description = "MAPI API2 search stage test with filter for prices")
    public void verifyMAPIApi2ResponseBodyApi2StageWithPriceFilter() {
        Map<String,String> mainParameters = new HashMap<>();
        mainParameters.put("url","https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParameters.put("refurl","https://shutterfly.com%");
        mainParameters.put("sid","_br_uid_2");
        mainParameters.put("fl","price,sale_price,title");
        mainParameters.put("q", "mug");
        Assert.assertTrue(mapiData.getMapiData(mainParameters).getFacets().getFacetRanges().getPrice().stream().anyMatch(x->x.getCount()==9));
        Assert.assertTrue(mapiData.getMapiData(mainParameters).getResourceList().size()==mapiData.getMapiData(mainParameters)
            .getFacets().getFacetRanges().getPrice().get(2).getCount());
    }

    @Test(description = "MAPI API2 search stage test with filter for sale_prices and validate resoyrseList fields")
    public void verifyResourceListMAPIApi2StageWithSalePriceFilter() {
        Map<String,String> mainParameters = new HashMap<>();
        mainParameters.put("url","https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParameters.put("refurl","https://shutterfly.com%");
        mainParameters.put("sid","_br_uid_2");
        mainParameters.put("fl","cid,description,featured,keywords,pid,price,price_range,productCode,"
            +"productMinPrice,productMinSalePrice,productType,sale_price,sale_price_range,sku_color,"
            +"skuid,sflySkuId,sku_price,sku_sale_price,sku_swatch_images,sku_thumb_images,targetCategory,"
            +"targetSubcategory,thumb_image,thumbnailUrl,title,url");
        mainParameters.put("q", "mug");
        Assert.assertFalse(mapiData.getMapiData(mainParameters, "sale_price:[10 TO 19.99]").getResourceList().isEmpty());
        Assert.assertTrue(mapiData.getMapiData(mainParameters, "sale_price:[20 TO 29.99]").getResourceList().size()>1);
    }

    @Test(description = "MAPI API2 search stage test with filter for sale_prices and validate variants fields")
    public void verifyVariantsMAPIApi2StageWithPriceFilter() {
        Map<String,String> mainParameters = new HashMap<>();
        mainParameters.put("url","https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParameters.put("refurl","https://shutterfly.com%");
        mainParameters.put("sid","_br_uid_2");
        mainParameters.put("fl","cid,description,featured,keywords,pid,price,price_range,productCode,"
            +"productMinPrice,productMinSalePrice,productType,sale_price,sale_price_range,sku_color,"
            +"skuid,sflySkuId,sku_price,sku_sale_price,sku_swatch_images,sku_thumb_images,targetCategory,"
            +"targetSubcategory,thumb_image,thumbnailUrl,title,url");
        mainParameters.put("q", "mug");
        Assert.assertTrue(mapiData.getMapiData(mainParameters, "price:[10 TO 19.99]").getResourceList().stream().anyMatch(x->x.getVariants()
            .stream().anyMatch(y->y.getSku_price()<=19.99)));
        Assert.assertTrue(mapiData.getMapiData(mainParameters, "price:[10 TO 19.99]").getResourceList().stream().allMatch(x->x.getVariants()
            .get(0).getSku_price()<=19.99));
    }


    @Test(description = "MAPI API2 search stage test with filter for sale_prices")
    public void verifyMAPIApi2ResponseBodyVariantsBetaWithSalePriceFilter() {
        Map<String,String> mainParameters = new HashMap<>();
        mainParameters.put("url","https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParameters.put("refurl","https://shutterfly.com%");
        mainParameters.put("sid","_br_uid_2");
        mainParameters.put("fl","price,sale_price,title");
        mainParameters.put("q", "mug");
        Assert.assertTrue(mapiData.getMapiData(mainParameters, "sale_price:[10 TO 19.99]").getFacets().getFacetRanges().getSalePrices().stream().anyMatch(x->x.getCount()==9));
        Assert.assertTrue(mapiData.getMapiData(mainParameters, "sale_price:[10 TO 19.99]").getResourceList().size()==mapiData.getMapiData(mainParameters)
            .getFacets().getFacetRanges().getSalePrices().get(1).getCount());
    }

    @Test(description = "MAPI API2 search stage test with filter for sale_prices and validate facets")
    public void verifyMAPIApi2ResponseBodyFacetsBetaWithSalePriceFilter() {
        Map<String, String> mainParameters = new HashMap<>();
        mainParameters.put("url", "https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParameters.put("refurl", "https://shutterfly.com%");
        mainParameters.put("sid", "_br_uid_2");
        mainParameters.put("fl", "price,sale_price,title");
        mainParameters.put("q", "mug");
        Assert.assertFalse(mapiData.getMapiData(mainParameters, "sale_price:[10 TO 19.99]").getFacets().getFacetFields().getCategory().isEmpty());
        Assert.assertFalse(mapiData.getMapiData(mainParameters, "sale_price:[10 TO 19.99]").getFacets().getFacetFields().toString().isEmpty());
    }

    @Test(description = "MAPI API2 search stage test with filter for sale_prices and validate facetsRanges")
    public void verifyMAPIApi2ResponseBodyFacetsRangesBetaWithSalePriceFilter() {
        Map<String, String> mainParameters = new HashMap<>();
        mainParameters.put("url", "https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParameters.put("refurl", "https://shutterfly.com%");
        mainParameters.put("sid", "_br_uid_2");
        mainParameters.put("fl", "price,sale_price,title");
        mainParameters.put("q", "mug");
        Assert.assertFalse(mapiData.getMapiData(mainParameters, "sale_price:[9 TO 9.99]").getFacets().getFacetRanges().getPrice().isEmpty());
        Assert.assertFalse(mapiData.getMapiData(mainParameters, "sale_price:[9 TO 9.99]").getFacets().getFacetRanges().getSalePrices().isEmpty());
        Assert.assertFalse(mapiData.getMapiData(mainParameters, "sale_price:[9 TO 9.99]").getFacets().getFacetRanges().toString().isEmpty());
    }

    @Test(description = "Verify suggestion is in the response with muge query")
    public void verifySuggestionIfInvalidQueryMugeIsApplied() {
        HashMap<String, String> mainParam = new HashMap<>();
        mainParam.put("size","100");
        mainParam.put("q","muge");
        mainParam.put("sid","1234");
        mainParam.put("url","https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParam.put("fl","availability,title,description,price");
        mainParam.put("refurl","https://www.shutterfly.com%26");
        suggestionData.getSuggestions(mainParam);
        Assert.assertTrue(suggestionData.getSuggestions(mainParam).getAutoCorrectQuery().contains("mugs"));
        Assert.assertTrue(suggestionData.getSuggestions(mainParam).getCategoryMap().getItem3().equals("Mugs"));
        Assert.assertTrue(suggestionData.getSuggestions(mainParam).getDidYouMean().size()>1);
        Assert.assertTrue(suggestionData.getSuggestions(mainParam).getDidYouMean().stream().anyMatch(i->i.contains("mug")));
    }

    @Test(description = "Verify suggestion is in the response with help query")
    public void verifySuggestionIfQueryHelpIsApplied() {
        HashMap<String, String> mainParam = new HashMap<>();
        mainParam.put("size","100");
        mainParam.put("q","help");
        mainParam.put("sid","1234");
        mainParam.put("url","https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParam.put("fl","availability,title,description,price");
        mainParam.put("refurl","https://www.shutterfly.com%26");
        suggestionData.getSuggestions(mainParam);
        Assert.assertTrue(suggestionData.getSuggestions(mainParam).getKeywordRedirect().getRedirectedQuery().equals(mainParam.get("q")));
        Assert.assertTrue(suggestionData.getSuggestions(mainParam).getKeywordRedirect().getOriginalQuery().equals(mainParam.get("q")));
        Assert.assertTrue(suggestionData.getSuggestions(mainParam).getKeywordRedirect().getRedirectedUrl().equals("support.shutterfly.com/"));
    }

    @Test(description = "Verify suggestion is in the response with help query")
    public void verifySuggestionIfQueryJunkStyleIsApplied() {
        HashMap<String, String> mainParam = new HashMap<>();
        mainParam.put("size", "100");
        mainParam.put("q", "tffdf");
        mainParam.put("sid", "1234");
        mainParam.put("url", "https://www.shutterfly.com/sitesearch/enjoy+cotton+tote");
        mainParam.put("fl", "availability,title,description,price");
        mainParam.put("refurl", "https://www.shutterfly.com%26");
        suggestionData.getSuggestions(mainParam);
        Assert.assertTrue(Stream.of(suggestionData.getSuggestions(mainParam).getCategoryMap().getItemOne()).allMatch(Objects::isNull));
        Assert.assertTrue(Stream.of(suggestionData.getSuggestions(mainParam).getCategoryMap().getItemOTwo()).allMatch(Objects::isNull));
        Assert.assertTrue(Stream.of(suggestionData.getSuggestions(mainParam).getCategoryMap().getItem3()).allMatch(Objects::isNull));
        Assert.assertTrue(Stream.of(suggestionData.getSuggestions(mainParam).getDidYouMean()).allMatch(Objects::isNull));
    }

}


