package RestApiSetup.HashResponce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreationPath{
	private String baseUrl;
	private Params params;

	public String getBaseUrl(){
		return baseUrl;
	}

	public Params getParams(){
		return params;
	}
}
