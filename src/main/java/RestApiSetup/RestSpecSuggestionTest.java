package RestApiSetup;

import static RestApiSetup.BaseSevice.getBaseUrlReg;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class RestSpecSuggestionTest extends BaseSevice {
    public RequestSpecification REQUEST_SPECIFICATION_SUGGESTIONS;
    public RestSpecSuggestionTest(){
        REQUEST_SPECIFICATION_SUGGESTIONS = new RequestSpecBuilder()
            .setBaseUri("https://catalog-nextgen-services.beta.shutterfly.com")
            .setBasePath("/v1/search")
            .addHeader("Accept", "application/json")
            .build();
    }

}
