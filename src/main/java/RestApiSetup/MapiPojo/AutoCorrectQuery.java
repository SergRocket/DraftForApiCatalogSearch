package RestApiSetup.MapiPojo;

import java.util.ArrayList;
import RestApiSetup.HashResponce.CategoryMap;
import RestApiSetup.HashResponce.KeyWordRedirect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AutoCorrectQuery {
    public ArrayList<String> didYouMean;
    public String autoCorrectQuery;
    public CategoryMap categoryMap;
    public KeyWordRedirect keywordRedirect;

    public AutoCorrectQuery(ArrayList<String> didYouMean, String autoCorrectQuery, CategoryMap categoryMap, KeyWordRedirect keywordRedirect) {
        this.didYouMean = didYouMean;
        this.autoCorrectQuery = autoCorrectQuery;
        this.categoryMap = categoryMap;
        this.keywordRedirect = keywordRedirect;
    }

    public AutoCorrectQuery () {
        super();
    }

    public ArrayList<String> getDidYouMean() {
        return didYouMean;
    }

    public String getAutoCorrectQuery() {
        return autoCorrectQuery;
    }

    public CategoryMap getCategoryMap() {
        return categoryMap;
    }

    public KeyWordRedirect getKeywordRedirect() {
        return keywordRedirect;
    }
}
