package RestApiSetup.MapiPojo;

import java.util.List;

public class VariantsItem{
	private double skuSalePrice;
	private double skuPrice;
	private List<String> sflySkuId;
	private String skuid;
	private List<String> thumbnailUrl;

	public double getSkuSalePrice(){
		return skuSalePrice;
	}

	public double getSkuPrice(){
		return skuPrice;
	}

	public List<String> getSflySkuId(){
		return sflySkuId;
	}

	public String getSkuid(){
		return skuid;
	}

	public List<String> getThumbnailUrl(){
		return thumbnailUrl;
	}
}