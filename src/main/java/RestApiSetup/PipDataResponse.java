package RestApiSetup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class PipDataResponse {

    public class _6X8FLATCARD06{
        public ArrayList<Integer> quantities;
        public Integer defaultQuantity;
    }

    public class AltView{
        public String label;
        public String imageUrl;
    }

    public class BlueprintOption{
        public OptionsMap optionsMap;
        public String skuCode;
        public String sizeId;
        public String styleId;
        public String occasionId;
        public Object bundleId;
        public String pricingSku;
        public String premiumSku;
        public String premiumSizeId;
        public ArrayList<Option> options;

    }

    public static class BluePrintOptions{
        @JsonIgnore
        public String displayName;
        public String value;
        public String sizeId;
        public Boolean isBaseSku;
        public ArrayList<ChildOptions> childOptions;
        public String detailedDescription;
        public String description;
        public Boolean isPromoted;
        public Integer dysplayOrder;
        public String avaliability;
        public String pricingSku;

        public BluePrintOptions()
        {
            super();
        }

        public BluePrintOptions(String displayName, String value, String sizeId, Boolean isBaseSku, ArrayList<ChildOptions> childOptions, String detailedDescription, String description, Boolean isPromoted, Integer dysplayOrder, String avaliability, String pricingSku) {
            this.displayName = displayName;
            this.value = value;
            this.sizeId = sizeId;
            this.isBaseSku = isBaseSku;
            this.childOptions = childOptions;
            this.detailedDescription = detailedDescription;
            this.description = description;
            this.isPromoted = isPromoted;
            this.dysplayOrder = dysplayOrder;
            this.avaliability = avaliability;
            this.pricingSku = pricingSku;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getValue() {
            return value;
        }

        public String getSizeId() {
            return sizeId;
        }

        public String getAvaliability() {
            return avaliability;
        }
    }

    public static class BluePrintOptinsMap {
        public String color;
        public String CARD_SIZE_ID;
        public String GREETING;

        public BluePrintOptinsMap()
        {
            super();
        }

        public BluePrintOptinsMap(String color, String CARD_SIZE_ID, String GREETING) {
            this.color = color;
            this.CARD_SIZE_ID = CARD_SIZE_ID;
            this.GREETING = GREETING;
        }

        public String getColor() {
            return color;
        }

        public String getCARD_SIZE_ID() {
            return CARD_SIZE_ID;
        }

        public String getGREETING() {
            return GREETING;
        }
    }

    public static class OptionsFromBluePrint{
        public String key;
        public String defaultValue;
        public ArrayList<Values> values;

        public OptionsFromBluePrint()
        {
            super();
        }

        public OptionsFromBluePrint(String key, String defaultValue, ArrayList<Values> values) {//!!!!!!!
            this.key = key;
            this.defaultValue = defaultValue;
            this.values = values;
        }

        public String getKey() {
            return key;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        public ArrayList<Values> getValues() {
            return values;
        }
    }

    public static class Values{
        public String displayName;
        public String value;
        public String sizeId;
        public Boolean isBaseSku;
        public ArrayList<ChildOptions> options;

        public Values()
        {
            super();
        }

        public Values(String displayName, String value, String sizeId, Boolean isBaseSku, ArrayList<ChildOptions> options) {
            this.displayName = displayName;
            this.value = value;
            this.sizeId = sizeId;
            this.isBaseSku = isBaseSku;
            this.options = options;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getValue() {
            return value;
        }

        public String getSizeId() {
            return sizeId;
        }

        public Boolean getBaseSku() {
            return isBaseSku;
        }

        public ArrayList<ChildOptions> getOptions() {
            return options;
        }
    }

    public static class ChildOptions{
        public String key;
        public String defaultValue;

        public ChildOptions()
        {
            super();
        }

        public ChildOptions(String key, String defaultValue) {
            this.key = key;
            this.defaultValue = defaultValue;
        }

        public String getKey() {
            return key;
        }

        public String getDefaultValue() {
            return defaultValue;
        }
    }

    public class ChildOption{
        public String key;
        public String defaultValue;
        public ArrayList<Value> values;
        public String displayName;
    }

    public class CreationPath{
        public String baseUrl;
        public Params params;
    }

    public class Data{
        public String label;
        public String url;
    }

    public static class ImageURL {
        public String label;
        public String imageUrl;

        public ImageURL()
        {
            super();
        }

        public ImageURL(String label, String imageUrl) {
            this.label = label;
            this.imageUrl = imageUrl;
        }

        public String getLabel() {
            return label;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }

    public class DESIGNERCARD06{
        public ArrayList<Integer> quantities;
        public Integer defaultQuantity;
    }

    public class DesignerDetails{
        public int statusCode;
        public Data data;
    }

    public class PhotoBooksCategoryes{
        public String value;
        public String displayOrder;
        public String dysplayName;
        public ArrayList<String> childOptions;
        public String iconClass;
        public String avaliability;

        public PhotoBooksCategoryes(String value, String dysplayName) {
            this.value = value;
            this.dysplayName = dysplayName;
        }
        public PhotoBooksCategoryes()
        {
            super();
        }

        public String getValue() {
            return value;
        }

        public String getDysplayName() {
            return dysplayName;
        }
    }

    public class FormatOptions{
    }

    public class ImageUrl{
        public String label;
        public String imageUrl;
    }

    public class Metadata{
        public String title;
        public String categoryCode;
        public String productCategory;
        public String brand;
        public MoreDetails moreDetails;
        public Boolean isGalleonProduct;
        public String productTypeName;
        public String occasionName;
        public Object marketplaceDesignerName;
        public Object marketPlaceDesignerId;
        public Object marketplaceDesignName;
        public Object marketplaceProvider;
        public Boolean isPersonalizable;
        public DesignerDetails designerDetails;
        public Boolean pdtSupported;
    }

    public class MoreDetails{
        @JsonProperty("Mail Options")
        public ArrayList<String> mailOptions;
        public String styleName;
        public String abnTheme;
        public String abnFeatured;
        @JsonProperty("Type")
        public String type;
        @JsonProperty("Orientation")
        public String orientation;
        @JsonProperty("Photos")
        public String photos;
        public String size;
    }

    public class Option{
        public String key;
        public String defaultValue;
        public ArrayList<Value> values;
        public String displayName;
    }

    public static class OptionMap{
        public String color;
        public String CARD_SIZE_ID;
        public String GREETING;

        public OptionMap()
        {
            super();
        }

        public OptionMap(String color, String CARD_SIZE_ID, String GREETINGS) {
            this.color = color;
            this.CARD_SIZE_ID = CARD_SIZE_ID;
            this.GREETING = GREETINGS;
        }

        public String getColor() {
            return color;
        }

        public String getCARD_SIZE_ID() {
            return CARD_SIZE_ID;
        }

        public String getGREETING() {
            return GREETING;
        }
    }

    public class OptionResourceMap{
        public OptionsMap optionsMap;
        public String skuCode;
        public String creationPathUrl;
        public CreationPath creationPath;
        public String optionResourceUID;
        public String shortDescription;
        public ArrayList<ImageUrl> imageUrls;
        public ArrayList<AltView> altViews;
        public Boolean isEPDefault;
        public ArrayList<String> details;
        public MoreDetails moreDetails;
        public Object bookAdditionalPageSku;
        public String formFactorId;
        public Object marketplaceBackgroundName;
        public String availability;
    }

    public class OptionsMap{
        public String color;
        @JsonProperty("CARD_SIZE_ID")
        public String cARD_SIZE_ID;
        @JsonProperty("GREETING")
        public String gREETING;
        @JsonProperty("PAPER_TYPE")
        public String pAPER_TYPE;
        @JsonProperty("TRIM")
        public String tRIM;
        @JsonProperty("PAPER_FINISH")
        public String pAPER_FINISH;

        public OptionsMap()
        {
            super();
        }

        public OptionsMap(String color, String cARD_SIZE_ID, String gREETING, String pAPER_TYPE, String tRIM, String pAPER_FINISH) {
            this.color = color;
            this.cARD_SIZE_ID = cARD_SIZE_ID;
            this.gREETING = gREETING;
            this.pAPER_TYPE = pAPER_TYPE;
            this.tRIM = tRIM;
            this.pAPER_FINISH = pAPER_FINISH;
        }

        public String getColor() {
            return color;
        }

        public String getcARD_SIZE_ID() {
            return cARD_SIZE_ID;
        }

        public String getgREETING() {
            return gREETING;
        }

        public String getpAPER_TYPE() {
            return pAPER_TYPE;
        }

        public String gettRIM() {
            return tRIM;
        }

        public String getpAPER_FINISH() {
            return pAPER_FINISH;
        }
    }

    public class Params{
        public String brand;
        public String skuCode;
        public String productCode;
        public String categoryCode;
        public String bundleId;
        public String sizeIds;
        public String occasionIds;
        public String styleIds;
    }

    public class ProductOption{
        public String key;
        public String displayName;
        public ArrayList<Value> values;
        public ProductOption()
        {
            super();
        }

        public ProductOption(String key, String displayName, ArrayList<Value> values) {
            this.key = key;
            this.displayName = displayName;
            this.values = values;
        }

        public String getKey() {
            return key;
        }

        public String getDisplayName() {
            return displayName;
        }

        public ArrayList<Value> getValues() {
            return values;
        }
    }

    public class QuantityOptions{
        @JsonProperty("DESIGNERCARD06")
        public DESIGNERCARD06 dESIGNERCARD06;
        @JsonProperty("6X8FLATCARD06")
        public _6X8FLATCARD06 _6X8FLATCARD06;
    }

    public class Root{
        public String productCode;
        public Metadata metadata;
        public ArrayList<ProductOption> productOptions;
        public ArrayList<BlueprintOption> blueprintOptions;
        public FormatOptions formatOptions;
        public QuantityOptions quantityOptions;
        public ArrayList<OptionResourceMap> optionResourceMap;

        public Root(String productCode, ArrayList<OptionResourceMap> optionResourceMap) {
            this.productCode = productCode;
            this.optionResourceMap = optionResourceMap;
        }

        public ArrayList<OptionResourceMap> getOptionResourceMap() {
            return optionResourceMap;
        }
    }

    public static class Value{
        public String value;
        public Integer displayOrder;
        public String displayName;
        public String uniqueKey;
        public String availability;
        public String iconClass;
        public String sizeId;
        public Boolean isBaseSku;
        public ArrayList<ChildOption> childOptions;
        public String detailedDescription;
        public String description;
        public Boolean isPromoted;
        public String pricingSku;
        public String key;

        public Value()
        {
            super();
        }

        public Value(String key, String value, Integer displayOrder, String displayName,  String uniqueKey,String availability) {
            //this.key = key;
            this.value = value;
            this.displayOrder = displayOrder;
            this.displayName = displayName;
            this.uniqueKey = uniqueKey;
            this.availability = availability;

        }

        public String getValue() {
            return value;
        }

        public Integer getDisplayOrder() {
            return displayOrder;
        }

        public String getDisplayName() {
            return displayName;
        }

        public String getAvailability() {
            return availability;
        }
    }


}
