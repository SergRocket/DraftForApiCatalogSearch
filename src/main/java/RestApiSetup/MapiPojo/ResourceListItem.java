package RestApiSetup.MapiPojo;

import java.util.List;

public class ResourceListItem{
	private double productMinPrice;
	private List<Double> salePriceRange;
	private List<Double> priceRange;
	private String pid;
	private List<VariantsItem> variants;
	private String title;
	private double salePrice;
	private double productMinSalePrice;
	private String url;
	private String productCode;
	private double price;
	private String productType;
	private String cid;
	private String description;
	private String targetSubcategory;
	private String targetCategory;
	private String featured;

	public double getProductMinPrice(){
		return productMinPrice;
	}

	public List<Double> getSalePriceRange(){
		return salePriceRange;
	}

	public List<Double> getPriceRange(){
		return priceRange;
	}

	public String getPid(){
		return pid;
	}

	public List<VariantsItem> getVariants(){
		return variants;
	}

	public String getTitle(){
		return title;
	}

	public double getSalePrice(){
		return salePrice;
	}

	public double getProductMinSalePrice(){
		return productMinSalePrice;
	}

	public String getUrl(){
		return url;
	}

	public String getProductCode(){
		return productCode;
	}

	public double getPrice(){
		return price;
	}

	public String getProductType(){
		return productType;
	}

	public String getCid(){
		return cid;
	}

	public String getDescription(){
		return description;
	}

	public String getTargetSubcategory(){
		return targetSubcategory;
	}

	public String getTargetCategory(){
		return targetCategory;
	}

	public String getFeatured(){
		return featured;
	}
}