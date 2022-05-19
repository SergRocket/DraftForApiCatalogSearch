package Config;

public interface EndPoints {
    String GET_ALL = "/config/all";

    String GET_ALL_SCHEDULED = "/config/all/scheduled";

    String GET_BY_FEEDNAME = "GET /config/feedName/{feedName}";

    String PUT_CONFIG_INSERT = "/config/insert";

    String PUT_CONFIG_UPDATE = "/config/update";

    String GET_FEED_CONTROLLER = "/product/feed/create";

    String GET_FEED_BY_VENDOR = "/product/feed/create/{vendor}";

    String POST_CREATE_FEED = "/product/feed/createFeed";

    String GET_DEBUG_BY_ATTRIBUTE_NAME = "/debug/attributealias/{attributeName}";

    String GET_ATTRIBUTE_MAPPINGS = "/debug/attributemappings";

    String GET_ATTRIBUTE_BY_PRODUCT_CODE = "/debug/attributes/productCode/{productCode}";

    String GET_ATTRIBUTES_BY_PRODUCT_CODE_AND_SKU_CODE = "/debug/attributes/productCode/{productCode}/skuCode/{skuCode}";

    String POST_DEBUG_CREATE_FEED = "/debug/createFeed";

    String GET_DEBUG_FILE_HYSTORY_BY_FEEDNAME_AND_STORE_CODE = "/debug/fileHistory/lastComplete/{feedName}/{storeCode}";

    String GET_GOOGLE_ATTRIBUTES_BY_PRODUCT_CODE = "/debug/googleattributes/productCode/{productCode}";

    String GET_GOOGLE_ATTRIBUTES_BY_PRODUCT_CODE_AND_SKU_CODE = "/debug/googleattributes/productCode/{productCode}/skuCode/{skuCode}";

    String GET_DEBUG_MAPPINGS = "/debug/mappings";

    String GET_DEBUG_MOBILE_BY_SKU_CODE = "/debug/mobile/{skuCodes}/";

    String GET_DEBUG_PIM_TABLES = "/debug/pimtables";

    String GET_DEBUG_PIPI_DATA_BY_PRODUCT_CODE = "/debug/pipDataService/{productCode}";

    String GET_DEBUG_BY_PRODUCT_CODE = "/debug/productCode/{productCode}";

    String POST_DEBUG_RESET_REPO_IDS = "/debug/resetRepositoryIds/{password}";

    String GET_DEBUG_SKU_BY_PRODUCT_CODE_AND_SKU_CODE = "/debug/sflySkus/{productCode}/{skuCode}";

    String GET_DEBUG_SHIPPING_PRICE_BY_SKU_AND_QNT_DEFAULT_SHIPPING = "/debug/sflySkus/{productCode}/{skuCode}";

    String GET_DEBUG_TABLE_MAPPING = "/debug/tablemapping";

    String POST_DEBUG_TEST_AVALIABILITY = "/debug/testAvailability";

    String GET_DEBUG_TEST_FF = "/debug/testFF";

    String POST_DEBUG_TEST_PRICING_BY_PRODUCT_CODE_AND_MIN_QNT = "/debug/testPricingForProductVariation/{productCode}/{minQty}";

    String POST_DEBUG_RETRIEVE_PRODUCTS = "/debug/testRetrieveProducts";

    String GET_THUMBNAIL_URL_BY_PRODUCT_CODE_AND_SKU_CODE_AND_IMAGE_SIZE = "/debug/thumbnailUrl/{productCode}/{skuCode}/{imageSize}";

    String GET_DEBUG_THUBNAIL_URL_BY_PRODUCT_CODE_AND_IMAGE_SIZE = "/debug/thumbnailUrls/{productCode}/{imageSize}";

    String GET_DEBUG_V1_EPA_ATTRIBUTE_BY_KEY = "/debug/v1/epattribute/{key}";

    String GET_DEBUG_V1_PIM_ATTRIBUTE_BY_KEY = "/debug/v1/pimattribute/{key}";

    String GET_PRODUCTS_DOWNLOAD = "/product/feed/download";

    String GET_FILE_HISTORY_BY_NUMBER_OF_RECORDS = "/fileHistory/ALL/{numberOfRecords}";

    String GET_FILE_HISTORY_BY_FEED_STATUS_ID = "/fileHistory/vendor/feedId/{feedStatusId}";

    String GET_FILE_HISTORY_BY_NO_OF_DAYS = "/fileHistory/vendor/feedIds/{noOfDays}";

    String GET_FILE_HISTORY_BY_FEED_NAME = "/fileHistory/vendor/feedName/{feedName}";

    String GET_STATUS_FOR_ALL = "/status/ALL";

    String GET_STATUS_V1_BY_VENDOR = "GET /status/v1/{vendor}";

    String GET_STATUS_BY_VENDOR = "/status/{vendor}";

}
