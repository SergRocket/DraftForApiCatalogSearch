package RestApiSetup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Deseralization {
    public String getFeedName() { return feedName; }

    public void setFeedName(int feedName) {
        this.feedName = String.valueOf(feedName);
    }

    private String feedName;

    public boolean getSaveFeed() { return saveFeed; }

    public void setSaveFeed(boolean saveFeed) {
        this.saveFeed = saveFeed;
    }

    private boolean saveFeed;

    public boolean getFtpFeed() { return ftpFeed; }

    public void setFtpFeed(boolean ftpFeed) {
        this.ftpFeed = ftpFeed;
    }

    private boolean ftpFeed;

    public boolean getRunNightly() { return runNightly; }

    public void setRunNightly(boolean runNightly) {
        this.runNightly = runNightly;
    }

    private boolean runNightly;

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    private int threshold;


}
