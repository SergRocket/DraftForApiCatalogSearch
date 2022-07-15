package RestApiSetup.MapiPojo;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.Nulls;
import org.apache.commons.lang3.ObjectUtils;

public class ResponseEmptyMapi {
    public class FacetFields{
        public ArrayList<Nulls> category;
        public ArrayList<Nulls> sizes;
        public ArrayList<Nulls> brand;
        public ArrayList<Nulls> colors;
        public ArrayList<Nulls> color_groups;
    }

    public class Facets{
        public FacetFields facet_fields;
    }

    public class Page{
        public int totalElements;
        public int number;
        public int size;
        public int totalPages;
    }

    public class Root{
        @JsonIgnoreProperties(ignoreUnknown = true)
        public ArrayList<Nulls> resourceList;
        public Facets facets;
        public Page page;
    }
}
