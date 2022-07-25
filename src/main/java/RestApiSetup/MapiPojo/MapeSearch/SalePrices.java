package RestApiSetup.MapiPojo.MapeSearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SalePrices {
    public Double name;
    public int count;

    public Double getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
