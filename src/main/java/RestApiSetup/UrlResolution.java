package RestApiSetup;

public class UrlResolution{
	private String productCode;
	private String createdDate;
	private String destinationUri;
	private Object linkedUrlResolution;
	private String categoryCode;
	private Object updatedDate;
	private int httpStatusCode;
	private String storeCode;

	public String getProductCode(){
		return productCode;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public String getDestinationUri(){
		return destinationUri;
	}

	public Object getLinkedUrlResolution(){
		return linkedUrlResolution;
	}

	public String getCategoryCode(){
		return categoryCode;
	}

	public Object getUpdatedDate(){
		return updatedDate;
	}

	public int getHttpStatusCode(){
		return httpStatusCode;
	}

	public String getStoreCode(){
		return storeCode;
	}
}
