package RestApiSetup.MapiPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Mediums {

    private String name;
    private int count;

    public String getName() {
        return name;
    }

}
