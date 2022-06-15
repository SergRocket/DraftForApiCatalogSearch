package RestApiSetup.HashResponce;

import java.util.List;

public class ValuesItem{
	private String displayName;
	private int displayOrder;
	private String availability;
	private List<ChildOptionsItem> childOptions;
	private String value;
	private String iconClass;

	public String getDisplayName(){
		return displayName;
	}

	public int getDisplayOrder(){
		return displayOrder;
	}

	public String getAvailability(){
		return availability;
	}

	public List<ChildOptionsItem> getChildOptions(){
		return childOptions;
	}

	public String getValue(){
		return value;
	}

	public String getIconClass(){
		return iconClass;
	}
}