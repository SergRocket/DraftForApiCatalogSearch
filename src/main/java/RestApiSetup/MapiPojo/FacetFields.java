package RestApiSetup.MapiPojo;

import java.util.List;

public class FacetFields{
	private List<FeaturedItem> featured;
	private List<MinPriceItem> minPrice;
	private List<SalePriceItem> salePrice;
	private List<ColorShadeHexValueItem> colorShadeHexValue;
	private List<ThemeItem> theme;
	private List<ShapeNameItem> shapeName;
	private List<CategoryItem> category;
	private List<DesignerCodeItem> designerCode;
	private List<ProductTypeItem> productType;
	private List<DimensionsItem> dimensions;
	private List<DefaultNumberOfPhotosItem> defaultNumberOfPhotos;

	public List<FeaturedItem> getFeatured(){
		return featured;
	}

	public List<MinPriceItem> getMinPrice(){
		return minPrice;
	}

	public List<SalePriceItem> getSalePrice(){
		return salePrice;
	}

	public List<ColorShadeHexValueItem> getColorShadeHexValue(){
		return colorShadeHexValue;
	}

	public List<ThemeItem> getTheme(){
		return theme;
	}

	public List<ShapeNameItem> getShapeName(){
		return shapeName;
	}

	public List<CategoryItem> getCategory(){
		return category;
	}

	public List<DesignerCodeItem> getDesignerCode(){
		return designerCode;
	}

	public List<ProductTypeItem> getProductType(){
		return productType;
	}

	public List<DimensionsItem> getDimensions(){
		return dimensions;
	}

	public List<DefaultNumberOfPhotosItem> getDefaultNumberOfPhotos(){
		return defaultNumberOfPhotos;
	}
}