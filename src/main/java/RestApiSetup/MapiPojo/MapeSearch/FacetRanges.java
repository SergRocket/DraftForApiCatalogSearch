package RestApiSetup.MapiPojo.MapeSearch;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacetRanges {
    public ArrayList<Price> price;

    public ArrayList<Price> getPrice() {
        return price;
    }
}
