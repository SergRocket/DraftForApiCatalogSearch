package RestApiSetup.HashResponce;

import java.util.List;

public class ChildOptionsItem{
	private String displayName;
	private List<ValuesItem> values;
	private String key;

	public String getDisplayName(){
		return displayName;
	}

	public List<ValuesItem> getValues(){
		return values;
	}

	public String getKey(){
		return key;
	}
}