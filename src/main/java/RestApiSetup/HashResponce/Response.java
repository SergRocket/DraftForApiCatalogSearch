package RestApiSetup.HashResponce;

import java.util.List;

public class Response{
	private Metadata metadata;
	private QuantityOptions quantityOptions;
	private String productCode;
	private List<ProductOptionsItem> productOptions;
	private List<OptionResourceMapItem> optionResourceMap;
	private FormatOptions formatOptions;
	private List<Object> blueprintOptions;

	public Metadata getMetadata(){
		return metadata;
	}

	public QuantityOptions getQuantityOptions(){
		return quantityOptions;
	}

	public String getProductCode(){
		return productCode;
	}

	public List<ProductOptionsItem> getProductOptions(){
		return productOptions;
	}

	public List<OptionResourceMapItem> getOptionResourceMap(){
		return optionResourceMap;
	}

	public FormatOptions getFormatOptions(){
		return formatOptions;
	}

	public List<Object> getBlueprintOptions(){
		return blueprintOptions;
	}
}