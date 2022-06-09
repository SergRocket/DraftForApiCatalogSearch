package RestApiSetup;

public class Availability{
	private String enableDate;
	private boolean hidden;
	private Object disableDate;
	private Object available;
	private Object displayable;

	public String getEnableDate(){
		return enableDate;
	}

	public boolean isHidden(){
		return hidden;
	}

	public Object getDisableDate(){
		return disableDate;
	}

	public Object getAvailable(){
		return available;
	}

	public Object getDisplayable(){
		return displayable;
	}
}
