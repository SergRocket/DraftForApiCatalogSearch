package RestApiSetup;

import java.util.List;

public class AttributeValuesMapItem{
	private String localizedAttributeKey;
	private Object dateValue;
	private String stringValue;
	private String attributeType;
	private Object decimalValue;
	private boolean multiLanguage;
	private Object integerValue;
	private Object booleanValue;
	private boolean multiValue;
	private Object stringValueList;

	public String getLocalizedAttributeKey(){
		return localizedAttributeKey;
	}

	public Object getDateValue(){
		return dateValue;
	}

	public String getStringValue(){
		return stringValue;
	}

	public String getAttributeType(){
		return attributeType;
	}

	public Object getDecimalValue(){
		return decimalValue;
	}

	public boolean isMultiLanguage(){
		return multiLanguage;
	}

	public Object getIntegerValue(){
		return integerValue;
	}

	public Object getBooleanValue(){
		return booleanValue;
	}

	public boolean isMultiValue(){
		return multiValue;
	}

	public Object getStringValueList(){
		return stringValueList;
	}
}