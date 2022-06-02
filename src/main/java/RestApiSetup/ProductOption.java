package RestApiSetup;

import java.util.ArrayList;

public class ProductOption {

        public String key;
        public String displayName;
        public ArrayList<PipDataResponse.Value> values;

        public ProductOption()
        {
            super();
        }

        public ProductOption(String key, String displayName, ArrayList<PipDataResponse.Value> values) {
            this.key = key;
            this.displayName = displayName;
            this.values = values;
        }

        public String getKey() {
            return key;
        }

        public String getDisplayName() {
            return displayName;
        }

        public ArrayList<PipDataResponse.Value> getValues() {
            return values;
        }
    }

