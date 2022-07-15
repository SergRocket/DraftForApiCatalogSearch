package RestApiSetup.MapiPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Facets{

	private FacetFields facet_fields;

	public FacetFields getFacetFields(){
		return facet_fields;
	}
}
