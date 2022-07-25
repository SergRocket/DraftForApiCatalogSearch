package RestApiSetup.MapiPojo.MapeSearch;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListOfResources {
    public Double sale_price;
    public Double price;
    public String productType;
    public String productCode;
    public Double productMinPrice;
    public String targetSubcategory;
    public String targetCategory;
    public Double productMinSalePrice;
    public String title;
    public String pid;
    public String sid;
    public ArrayList<Double> sale_price_range;
    public ArrayList<Double> price_range;
    public ArrayList<Variants> variants;

    public Object getPrice() {
        return price;
    }

    public Object getProductType() {
        return productType;
    }

    public Object getProductCode() {
        return productCode;
    }

    public Object getProductMinPrice() {
        return productMinPrice;
    }

    public Object getTargetSubcategory() {
        return targetSubcategory;
    }

    public Object getTargetCategory() {
        return targetCategory;
    }

    public Object getProductMinSalePrice() {
        return productMinSalePrice;
    }

    public Object getTitle() {
        return title;
    }

    public Object getPid() {
        return pid;
    }

    public Object getSid() {
        return sid;
    }

    public Object getSale_price_range() {
        return sale_price_range;
    }

    public Object getPrice_range() {
        return price_range;
    }

    public ArrayList<Variants> getVariants() {
        return variants;
    }

    public Object getSale_price() {
        return sale_price;
    }
}
