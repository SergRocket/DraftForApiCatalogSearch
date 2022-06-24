package RestApiSetup;

import java.util.ArrayList;

public class MetaData {
    public String title;
    public String categoryCode;
    public String productCategory;
    public String brand;
    public ArrayList<Object> moreDetails;

    public MetaData(String title, String categoryCode, String productCategory, String brand, ArrayList<Object> moreDetails) {
        this.title = title;
        this.categoryCode = categoryCode;
        this.productCategory = productCategory;
        this.brand = brand;
        this.moreDetails = moreDetails;
    }
    public MetaData(){
        super();
    }

    public String getTitle() {
        return title;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getBrand() {
        return brand;
    }
}
