package RestApiSetup.HashResponce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AltViewsItem {
   public String label;
   public String imageurl;

    public AltViewsItem(String label, String imageurl) {
        this.label = label;
        this.imageurl = imageurl;
    }
    public AltViewsItem() {
        super();
    }

    public String getLabel() {
        return label;
    }

    public String getImageurl() {
        return imageurl;
    }
}
