package RestApiSetup.HashResponce;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeyWordRedirect {
    @JsonProperty("redirected url")
    public String redirectedUrl;
    @JsonProperty("redirected query")
    public String redirectedQuery;
    @JsonProperty("original query")
    public String originalQuery;

    public KeyWordRedirect(String redirectedUrl, String redirectedQuery, String originalQuery) {
        this.redirectedUrl = redirectedUrl;
        this.redirectedQuery = redirectedQuery;
        this.originalQuery = originalQuery;
    }

    public KeyWordRedirect() {
        super();
    }

    public String getRedirectedUrl() {
        return redirectedUrl;
    }

    public String getRedirectedQuery() {
        return redirectedQuery;
    }

    public String getOriginalQuery() {
        return originalQuery;
    }
}
