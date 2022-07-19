package RestApiSetup.MapiPojo.MapeSearch;

import java.util.ArrayList;
import RestApiSetup.MapiPojo.Brand;
import RestApiSetup.MapiPojo.CategoryMaps;
import RestApiSetup.MapiPojo.Colors;
import RestApiSetup.MapiPojo.DesingerCode;
import RestApiSetup.MapiPojo.FacetCategory;
import RestApiSetup.MapiPojo.MapeSearch.MinPrices;
import RestApiSetup.MapiPojo.Mediums;
import RestApiSetup.MapiPojo.ProductTypes;
import RestApiSetup.MapiPojo.SalePrices;
import RestApiSetup.MapiPojo.Styles;
import RestApiSetup.MapiPojo.Topics;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseEmptyMapi {
    public ArrayList<ListOfResources> resourceList;
    public Facets facets;
    public Page page;
    public CategoryMaps categoryMaps;
    public Object didYouMean;

    public ResponseEmptyMapi(ArrayList<ListOfResources> resourceList, Facets facets, Page page,
                             CategoryMaps categoryMaps, Object didYouMean) {
        this.resourceList = resourceList;
        this.facets = facets;
        this.page = page;
        this.categoryMaps = categoryMaps;
        this.didYouMean = didYouMean;
    }

    public ResponseEmptyMapi() {
        super();
    }

    public ArrayList<ListOfResources> getResourceList() {
        return resourceList;
    }

    public Facets getFacets() {
        return facets;
    }

    public Page getPage() {
        return page;
    }

    public CategoryMaps getCategoryMaps() {
        return categoryMaps;
    }

    public Object getDidYouMean() {
        return didYouMean;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Page{
        public int totalElements;
        public int number;
        public int size;
        public int totalPages;

        public Page(int totalElements, int number, int size, int totalPages) {
            this.totalElements = totalElements;
            this.number = number;
            this.size = size;
            this.totalPages = totalPages;
        }

        public Page() {
            super();
        }

        public int getTotalElements() {
            return totalElements;
        }

        public int getNumber() {
            return number;
        }

        public int getSize() {
            return size;
        }

        public int getTotalPages() {
            return totalPages;
        }
    }

}
