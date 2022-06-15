package RestApiSetup.HashResponce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageUrlsItem {
public String label;
public String imageUrl;

    public ImageUrlsItem(String label, String imageUrl) {
        this.label = label;
        this.imageUrl = imageUrl;
    }
    public ImageUrlsItem() {
        super();
    }

    public String getLabel() {
        return label;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
