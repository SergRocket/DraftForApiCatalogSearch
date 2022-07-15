package RestApiSetup;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class MapiResponseClass {

    public class Category{
        @JsonProperty("cat_id")
        public String catIid;
        @JsonProperty("cat_name")
        public String catName;
        public String crumb;
        @JsonProperty("tree_path")
        public String treePath;
        public int count;
        public String parent;

        public Category(String catIid, String catName, String crumb, String treePath, int count, String parent) {
            this.catIid = catIid;
            this.catName = catName;
            this.crumb = crumb;
            this.treePath = treePath;
            this.count = count;
            this.parent = parent;
        }

        public String getCatIid() {
            return catIid;
        }

        public String getCatName() {
            return catName;
        }

        public String getCrumb() {
            return crumb;
        }

        public String getTreePath() {
            return treePath;
        }

        public int getCount() {
            return count;
        }

        public String getParent() {
            return parent;
        }
    }

    public class ColorShadeHexValue{
        public String name;
        public int count;

        public ColorShadeHexValue(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }

    public class DefaultNumberOfPhoto{
        public String name;
        public int count;

        public DefaultNumberOfPhoto(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }

    public class DesignerCode{
        public String name;
        public int count;

        public DesignerCode(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }

    public class Dimension{
        public String name;
        public int count;

        public Dimension(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }

    public class FacetFields{
        public ArrayList<Category> category;
        @JsonProperty("Sale Price")
        public ArrayList<SalePrice> salePrice;
        public ArrayList<MinPrice> minPrice;
        public ArrayList<Dimension> dimensions;
        public ArrayList<ColorShadeHexValue> colorShadeHexValue;
        public ArrayList<DesignerCode> designerCode;
        public ArrayList<ProductType> productType;
        public ArrayList<ShapeName> shapeName;
        public ArrayList<DefaultNumberOfPhoto> defaultNumberOfPhotos;
        public ArrayList<Theme> theme;
        public ArrayList<Featured> featured;

        public FacetFields(ArrayList<Category> category, ArrayList<SalePrice> salePrice, ArrayList<MinPrice> minPrice,
                           ArrayList<Dimension> dimensions, ArrayList<ColorShadeHexValue> colorShadeHexValue,
                           ArrayList<DesignerCode> designerCode, ArrayList<ProductType> productType,
                           ArrayList<ShapeName> shapeName, ArrayList<DefaultNumberOfPhoto> defaultNumberOfPhotos,
                           ArrayList<Theme> theme, ArrayList<Featured> featured) {
            this.category = category;
            this.salePrice = salePrice;
            this.minPrice = minPrice;
            this.dimensions = dimensions;
            this.colorShadeHexValue = colorShadeHexValue;
            this.designerCode = designerCode;
            this.productType = productType;
            this.shapeName = shapeName;
            this.defaultNumberOfPhotos = defaultNumberOfPhotos;
            this.theme = theme;
            this.featured = featured;
        }

        public ArrayList<Category> getCategory() {
            return category;
        }

        public ArrayList<SalePrice> getSalePrice() {
            return salePrice;
        }

        public ArrayList<MinPrice> getMinPrice() {
            return minPrice;
        }

        public ArrayList<Dimension> getDimensions() {
            return dimensions;
        }

        public ArrayList<ColorShadeHexValue> getColorShadeHexValue() {
            return colorShadeHexValue;
        }

        public ArrayList<DesignerCode> getDesignerCode() {
            return designerCode;
        }

        public ArrayList<ProductType> getProductType() {
            return productType;
        }

        public ArrayList<ShapeName> getShapeName() {
            return shapeName;
        }

        public ArrayList<DefaultNumberOfPhoto> getDefaultNumberOfPhotos() {
            return defaultNumberOfPhotos;
        }

        public ArrayList<Theme> getTheme() {
            return theme;
        }

        public ArrayList<Featured> getFeatured() {
            return featured;
        }
    }

    public class Facets{
        @JsonProperty("facet_fields")
        public FacetFields facetFields;

        public Facets(FacetFields facetFields) {
            this.facetFields = facetFields;
        }

        public FacetFields getFacetFields() {
            return facetFields;
        }
    }

    public class Featured{
        public String name;
        public int count;

        public Featured(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }

    public class MinPrice{
        public String name;
        public int count;

        public MinPrice(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }

    public class Page{
        public int totalElements;
        public int number;
        public int size;
        public int totalPages;

        public Page(int totalElements, int number, int size, int totalPages) {
            this.totalElements = totalElements;
            this.number = number;
            this.size = size;
            this.totalPages = totalPages;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public int getNumber() {
            return number;
        }

        public int getSize() {
            return size;
        }

        public int getTotalPages() {
            return totalPages;
        }
    }

    public class ProductType{
        public String name;
        public int count;

        public ProductType(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class ResourceList{
        @JsonProperty("sale_price")
        public double salePrice;
        public double price;
        public String targetSubcategory;
        public String targetCategory;
        public double productMinPrice;
        public String productCode;
        public String featured;
        public double productMinSalePrice;
        public String productType;
        @JsonProperty("price_range")
        public ArrayList<Double> priceRange;
        public String url;
        @JsonProperty("sale_price_range")
        public ArrayList<Double> salePriceRange;
        public String title;
        public String pid;
        public String cid;
        public ArrayList<Variant> variants;
        public String description;

        public ResourceList(double salePrice, double price, String targetSubcategory, String targetCategory, double productMinPrice, String productCode,
                            String featured, double productMinSalePrice, String productType, ArrayList<Double> priceRange, String url,
                            ArrayList<Double> salePriceRange, String title, String pid, String cid,
                            ArrayList<Variant> variants, String description) {
            this.salePrice = salePrice;
            this.price = price;
            this.targetSubcategory = targetSubcategory;
            this.targetCategory = targetCategory;
            this.productMinPrice = productMinPrice;
            this.productCode = productCode;
            this.featured = featured;
            this.productMinSalePrice = productMinSalePrice;
            this.productType = productType;
            this.priceRange = priceRange;
            this.url = url;
            this.salePriceRange = salePriceRange;
            this.title = title;
            this.pid = pid;
            this.cid = cid;
            this.variants = variants;
            this.description = description;
        }

        public ResourceList(){
            super();
        }

        public double getSalePrice() {
            return salePrice;
        }

        public double getPrice() {
            return price;
        }

        public String getTargetSubcategory() {
            return targetSubcategory;
        }

        public String getTargetCategory() {
            return targetCategory;
        }

        public double getProductMinPrice() {
            return productMinPrice;
        }

        public String getProductCode() {
            return productCode;
        }

        public String getFeatured() {
            return featured;
        }

        public double getProductMinSalePrice() {
            return productMinSalePrice;
        }

        public String getProductType() {
            return productType;
        }

        public ArrayList<Double> getPriceRange() {
            return priceRange;
        }

        public String getUrl() {
            return url;
        }

        public ArrayList<Double> getSalePriceRange() {
            return salePriceRange;
        }

        public String getTitle() {
            return title;
        }

        public String getPid() {
            return pid;
        }

        public String getCid() {
            return cid;
        }

        public ArrayList<Variant> getVariants() {
            return variants;
        }

        public String getDescription() {
            return description;
        }
    }

    public class Pid{
        public String pid;

        Pid(){
            this.pid=pid;
        }
        public String getPid() {
            return pid;
        }
    }
    public class Root{
        public ArrayList<Pid> resourceList;
        public Facets facets;
        public Page page;

        public Root(ArrayList<ResourceList> resourceList, Facets facets, Page page) {
            //this.resourceList = resourceList;
            this.facets = facets;
            this.page = page;
        }

       // public ArrayList<ResourceList> getResourceList() {
       //    return resourceList;
       //}

        public Facets getFacets() {
            return facets;
        }

        public Page getPage() {
            return page;
        }
    }

    public class SalePrice{
        public String name;
        public int count;

        public SalePrice(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }

    public class ShapeName{
        public String name;
        public int count;

        public ShapeName(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }

    public class Theme{
        public String name;
        public int count;

        public Theme(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }

    public class Variant{
        public ArrayList<String> thumbnailUrl;
        @JsonProperty("sku_sale_price")
        public double skuSalePrice;
        public String skuid;
        @JsonProperty("sku_price")
        public double skuPrice;
        public ArrayList<String> sflySkuId;

        public Variant(ArrayList<String> thumbnailUrl, double skuSalePrice, String skuid, double skuPrice, ArrayList<String> sflySkuId) {
            this.thumbnailUrl = thumbnailUrl;
            this.skuSalePrice = skuSalePrice;
            this.skuid = skuid;
            this.skuPrice = skuPrice;
            this.sflySkuId = sflySkuId;
        }

        public ArrayList<String> getThumbnailUrl() {
            return thumbnailUrl;
        }

        public double getSkuSalePrice() {
            return skuSalePrice;
        }

        public String getSkuid() {
            return skuid;
        }

        public double getSkuPrice() {
            return skuPrice;
        }

        public ArrayList<String> getSflySkuId() {
            return sflySkuId;
        }
    }

}
