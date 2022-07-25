package RestApiSetup.MapiPojo.MapeSearch;

import java.util.ArrayList;
import RestApiSetup.MapiResponseClass;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacetRanges {
    public ArrayList<Price> price;
    @JsonProperty("Sale Price")
    public ArrayList<SalePrices> salePrices;

    public ArrayList<SalePrices> getSalePrices() {
        return salePrices;
    }

    public ArrayList<Price> getPrice() {
        return price;
    }
}
