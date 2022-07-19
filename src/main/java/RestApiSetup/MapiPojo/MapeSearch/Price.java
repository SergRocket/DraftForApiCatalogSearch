package RestApiSetup.MapiPojo.MapeSearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
    public String start;
    public String end;
    public int count;

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getCount() {
        return count;
    }
}
