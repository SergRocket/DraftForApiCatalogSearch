package RestApiSetup.MapiPojo.MapeSearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Facets{

	public FacetField facetField;
	public FacetFields facetFields;
	public FacetRanges facetRanges;

	public Facets(FacetField facetField, FacetFields facetFields, FacetRanges facetRanges) {
		this.facetField = facetField;
		this.facetFields = facetFields;
		this.facetRanges = facetRanges;
	}

	public Facets() {
		super();
	}

	public FacetFields getFacetFields(){
		return facetFields;
	}

	public FacetRanges getFacetRanges() {
		return facetRanges;
	}
}
