package RestApiSetup.HashResponce;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionResourceMapItem {
	private List<Object> backgroundViews;
	private String nautilusCreationPathUrl;
	private ArrayList<CreationPath> creationPath;
	private List<String> pricingSkus;
	private List<Object> ideaPageViews;
	private List<Object> embellishmentViews;
	private String shortDescription;
	private boolean isEPDefault;
	private String availability;
	private String optionResourceUID;
	private String bookAdditionalPageSku;
	private String formFactorId;
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<OptionsMap> optionsMap;
	private String creationPathUrl;
	private Object marketplaceBackgroundName;
	private List<MoreDetails> moreDetails;
	private List<ImageUrlsItem> imageUrls;
	private List<AltViewsItem> altViews;
	private List<Object> details;
	private String skuCode;

	public List<OptionsMap> getOptionsMap() {
		return optionsMap;
	}

	public List<Object> getBackgroundViews() {
		return backgroundViews;
	}

	public String getNautilusCreationPathUrl() {
		return nautilusCreationPathUrl;
	}

	/*public CreationPath getCreationPath(){
		return creationPath;
	}*/

	public List<String> getPricingSkus() {
		return pricingSkus;
	}

	public List<Object> getIdeaPageViews() {
		return ideaPageViews;
	}

	public List<Object> getEmbellishmentViews() {
		return embellishmentViews;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public boolean isIsEPDefault() {
		return isEPDefault;
	}

	public String getAvailability() {
		return availability;
	}

	public String getOptionResourceUID() {
		return optionResourceUID;
	}

	public String getBookAdditionalPageSku() {
		return bookAdditionalPageSku;
	}

	public String getFormFactorId() {
		return formFactorId;
	}

	public String getCreationPathUrl() {
		return creationPathUrl;
	}

	public Object getMarketplaceBackgroundName() {
		return marketplaceBackgroundName;
	}


/*	public MoreDetails getMoreDetails(){
		return moreDetails;
	}*/

	public List<ImageUrlsItem> getImageUrls(){
		return imageUrls;
	}

	/*public List<OptionsMap> getOptionsMap(){
		return optionsMap;
	}*/

	public List<AltViewsItem> getAltViews(){
		return altViews;
	}

	public List<Object> getDetails(){
		return details;
	}

	public String getSkuCode(){
		return skuCode;
	}
}