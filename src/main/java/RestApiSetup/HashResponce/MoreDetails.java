package RestApiSetup.HashResponce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoreDetails{
	private String abnTheme;
	private String styleName;

	public String getAbnTheme(){
		return abnTheme;
	}

	public String getStyleName(){
		return styleName;
	}
}
