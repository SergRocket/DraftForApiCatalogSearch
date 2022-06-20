package RestApiSetup.HashResponce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseItem{
	private String sizeId;
	private String displayName;
	private String availability;
	private List<Object> childOptions;
	private String value;
	private String pricingSku;
	private String iconClass;
	private Boolean isBaseSku;

	public ResponseItem(String sizeId, String displayName, String availability, List<Object> childOptions,
						String value, String pricingSku, String iconClass, boolean isBaseSku) {
		this.sizeId = sizeId;
		this.displayName = displayName;
		this.availability = availability;
		this.childOptions = childOptions;
		this.value = value;
		this.pricingSku = pricingSku;
		this.iconClass = iconClass;
		this.isBaseSku = isBaseSku;
	}
	public ResponseItem(){
		super();
	}


	public String getSizeId(){
		return sizeId;
	}

	public String getDisplayName(){
		return displayName;
	}

	public String getAvailability(){
		return availability;
	}

	public List<Object> getChildOptions(){
		return childOptions;
	}

	public String getValue(){
		return value;
	}

	public String getPricingSku(){
		return pricingSku;
	}

	public String getIconClass(){
		return iconClass;
	}

	public boolean isIsBaseSku(){
		return isBaseSku;
	}
}