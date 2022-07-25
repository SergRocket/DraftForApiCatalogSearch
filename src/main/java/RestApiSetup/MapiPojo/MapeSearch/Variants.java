package RestApiSetup.MapiPojo.MapeSearch;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Variants {
    public Double sku_sale_price;
    public List<String> sflySkuId;
    public Double sku_price;
    public String skuid;
    public List<String> thumbnailUrl;

    public Double getSku_sale_price() {
        return sku_sale_price;
    }

    public List<String> getSflySkuId() {
        return sflySkuId;
    }

    public Double getSku_price() {
        return sku_price;
    }

    public String getSkuid() {
        return skuid;
    }

    public List<String> getThumbnailUrl() {
        return thumbnailUrl;
    }
}
