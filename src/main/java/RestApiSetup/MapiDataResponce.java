package RestApiSetup;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MapiDataResponce{
	private Page page;
	private List<Object> resourceList;
	private Facets facets;

	public  MapiDataResponce(){
		super();
	}

	public Page getPage(){
		return page;
	}

	public List<Object> getResourceList(){
		return resourceList;
	}

	public Facets getFacets(){
		return facets;
	}
}