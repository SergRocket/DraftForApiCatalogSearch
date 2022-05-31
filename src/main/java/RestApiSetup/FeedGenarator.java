package RestApiSetup;

import APITests.ResponseBody;

public class FeedGenarator {
    public static ParamatersForFeedCreation updateFeed(){
        return ResponseBody.builder().feedName("6TestQA").
                ftpFeed(true).runNightly(true).saveFeed(true).threshold(0).build();
    }
}
