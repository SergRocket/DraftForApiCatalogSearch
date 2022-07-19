package RestApiSetup.MapiPojo.MapeSearch;

import java.util.ArrayList;
import java.util.List;
import RestApiSetup.MapiPojo.CategoryItem;
import RestApiSetup.MapiPojo.ColorShadeHexValueItem;
import RestApiSetup.MapiPojo.DefaultNumberOfPhotosItem;
import RestApiSetup.MapiPojo.DesignerCodeItem;
import RestApiSetup.MapiPojo.DimensionsItem;
import RestApiSetup.MapiPojo.FeaturedItem;
import RestApiSetup.MapiPojo.Mediums;
import RestApiSetup.MapiPojo.MinPriceItem;
import RestApiSetup.MapiPojo.ProductTypeItem;
import RestApiSetup.MapiPojo.SalePriceItem;
import RestApiSetup.MapiPojo.ShapeNameItem;
import RestApiSetup.MapiPojo.ThemeItem;
import RestApiSetup.MapiPojo.Topics;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
	private ArrayList<Mediums> medium;
	private ArrayList<Topics> topic;



	public ArrayList<Mediums> getMedium() {
		return medium;
	}

	public ArrayList<Topics> getTopic() {
		return topic;
	}

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