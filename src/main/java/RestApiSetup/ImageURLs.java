package RestApiSetup;

import java.util.ArrayList;

public class ImageURLs {
    public ArrayList<String> imageUrls;

    public ImageURLs(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public ImageURLs() {
        super();
    }


    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public static class ImageURL {

        public String label;
        public String imageUrl;


        public ImageURL() {
            super();
        }

        public ImageURL(String label, String imageUrl) {
            this.label = label;
            this.imageUrl = imageUrl;
        }

        public String getLabel() {
            return label;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }
}
