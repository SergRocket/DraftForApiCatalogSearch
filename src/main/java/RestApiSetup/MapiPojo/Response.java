package RestApiSetup.MapiPojo;

import java.util.List;
import RestApiSetup.MapiPojo.MapeSearch.Facets;
import RestApiSetup.MapiPojo.MapeSearch.Page;

public class Response{
	private Page page;
	private List<ResourceListItem> resourceList;
	private Facets facets;

	public Page getPage(){
		return page;
	}

	public List<ResourceListItem> getResourceList(){
		return resourceList;
	}

	public Facets getFacets(){
		return facets;
	}
}