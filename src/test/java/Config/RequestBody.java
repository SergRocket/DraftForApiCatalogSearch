package Config;

import java.util.Map;

public class RequestBody {

    public String feedName;
    public boolean ftpFeed;
    public boolean runNightly;
    public boolean saveFeed;
    public int threshold;

    public boolean adHocBuild;
    String feedType;
    boolean forceRefresh;
    int sampleFeedSize;
    public Map<String, Object> sampleProductCodes; //check the containment
    public Map<String, Object> skipSpecificCollection;//check the containment
    public String startTime;
    public String storeCode;

    public String epAttribute;
    public String pimAttribute;
    public String repository;

    public String endTime;
    public String feedFileId;
    public String feedFormat;
    public int feedStatusId;
    public String fileUrl;
    public int numberOfRows;

    public String ageGroup;
    public String color;
    public String gender;
    public String size;
    public Map<String, Object> attributeMappingEntries;//check the containment

    public String imageLink;
    public int minimumQtyPrice;
    public Map<String, Object> optionPricingSkus;
    public String optionResourceUID;
    public Map<String, Object> productVariationOptions;//check the containment
    public int salePrice;
    public String skuCode;
    public String title;

    public Map<String, Object> attributeValuesMap;
    public Map<Boolean, String> availability;//may be wrong implementation
    public String brandCode;
    public boolean bundle;
    public Map<String, Object> catalogDefaultLocale;//check the containment
    public Map<String, Object> unicodeLocaleAttributes;
    public Map<String, Object> unicodeLocaleKeys;
    public String variant;
    public Map<Object, Object> categoryCodes;
    public String code;
    public String continueUrlTemplate;
    public Map<Object, Object> defaultCategoryCodes;
    public String image;
    public String lastModifiedDate;
    public Map<Object, Object> localeDependentFields;
    public String productTypeName;
    public int skuHash;
    public Map<Object, Object> skus;
    public String startNewUrlTemplate;
    public String startedUrlTemplate;
    public Map<String, Object> storeSetStoreValue;//check the containment
    public boolean supportedOnMobile;
    public String taxCode;
    public int urlMappingHash;
    public Map<String, Integer> urlResolution;
    public Map<String, Object> linkedUrlResolution;
    public String version;
    public Map<String, Object> baseSkus;
    public String productCode;
    public Map<String, Object> sflySkus;

    public String first;
    public String second;

    public String now;
    public boolean productAvailable;
    public boolean skuAvailable;

    public int origTotalPrice;
    public Map<String, Integer> pricingItem;//check the containment
    public int saleTotalPrice;

    public boolean fetchingThumbnails;
    public int linkedCategoryCounts;
    public int nonAvailableProductCounts;
    public int nonAvailableSkuCounts;
    public int totalCategoryCounts;
    public int totalLinkedCatProcessTimeSeconds;
    public int totalProductCounts;
    public int totalSkuCounts;
    public int totalTimeProcessSeconds;

    public String key;
    public String productType;

    public String description;
    public Map<String, Object> inputStream;
    public boolean open;
    public boolean readable;
   // public Map<String, Integer, Boolean> uri;//refactor so it can contain boolean, string, int
   // public Map<String, Integer, Boolean> url;//refactor so it can contain  string, int

    public String feedClobReferenceId;
    public String feedComponentName;
    public String feedDate;
    public String insertTime;
    public String logMsg;
    public Map<String, Integer> stateStatuses;//check the containment
    public String updateTime;





    public RequestBody(String feedName, boolean ftpFeed, boolean runNightly, boolean saveFeed, int threshold){
        this.feedName = feedName;
        this.ftpFeed = ftpFeed;
        this.runNightly = runNightly;
        this.saveFeed = saveFeed;
        this.threshold = threshold;
    }

    public RequestBody(boolean adHocBuild, String feedType, boolean forceRefresh, int sampleFeedSize, Map<String,
            Object> sampleProductCodes, Map<String, Object> skipSpecificCollection, String startTime, String storeCode){
        this.adHocBuild = adHocBuild;
        this.feedType = feedType;
        this.forceRefresh = forceRefresh;
        this.sampleFeedSize = sampleFeedSize;
        this.sampleProductCodes = sampleProductCodes;
        this.skipSpecificCollection = skipSpecificCollection;
        this.startTime = startTime;
        this.storeCode = storeCode;
    }
}
