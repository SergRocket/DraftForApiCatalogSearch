package RestApiSetup;

import lombok.Data;

@Data
public class ConfigFeedResponse {
    private String feedName;
    private boolean saveFeed;
    private boolean ftpFeed;
    private int threshold;

}
