package RestApiSetup.MapiPojo.MapeSearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Facets{

	public FacetField facetFields;
	public FacetFields facet_fields;
	public FacetRanges facetRanges;

	public Facets(FacetField facetFields, FacetFields facet_fields, FacetRanges facetRanges) {
		this.facetFields = facetFields;
		this.facet_fields = facet_fields;
		this.facetRanges = facetRanges;
	}

	public Facets() {
		super();
	}

	public FacetFields getFacetFields(){
		return facet_fields;
	}

	public FacetRanges getFacetRanges() {
		return facetRanges;
	}
}
