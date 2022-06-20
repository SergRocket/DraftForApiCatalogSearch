package RestApiSetup.HashResponce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata{
	private Object marketPlaceDesignerId;
	private Object storytellingSku;
	private boolean isGalleonProduct;
	private String categoryCode;
	private String title;
	private Object marketplaceDesignName;
	private Object marketplaceProvider;
	private String occasionName;
	private String productCategory;
	private boolean storytellingStyle;
	private MoreDetails moreDetails;
	private boolean isPersonalizable;
	private boolean pdtSupported;
	private String productTypeName;
	private Object marketplaceDesignerName;
	private String brand;

	public Object getMarketPlaceDesignerId(){
		return marketPlaceDesignerId;
	}

	public Object getStorytellingSku(){
		return storytellingSku;
	}

	public boolean isIsGalleonProduct(){
		return isGalleonProduct;
	}

	public String getCategoryCode(){
		return categoryCode;
	}

	public String getTitle(){
		return title;
	}

	public Object getMarketplaceDesignName(){
		return marketplaceDesignName;
	}

	public Object getMarketplaceProvider(){
		return marketplaceProvider;
	}

	public String getOccasionName(){
		return occasionName;
	}

	public String getProductCategory(){
		return productCategory;
	}

	public boolean isStorytellingStyle(){
		return storytellingStyle;
	}

	public MoreDetails getMoreDetails(){
		return moreDetails;
	}

	public boolean isIsPersonalizable(){
		return isPersonalizable;
	}

	public boolean isPdtSupported(){
		return pdtSupported;
	}

	public String getProductTypeName(){
		return productTypeName;
	}

	public Object getMarketplaceDesignerName(){
		return marketplaceDesignerName;
	}

	public String getBrand(){
		return brand;
	}
}
