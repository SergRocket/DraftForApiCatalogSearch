package Config;

public class FeedGenarator {
    public static ParamatersForFeedCreation createFeed(){
        return ResponseBody.builder().feedname("TestSerg").
                ftpFeed(true).runNightly(true).saveFeed(true).threshold(1).build();
    }
}
