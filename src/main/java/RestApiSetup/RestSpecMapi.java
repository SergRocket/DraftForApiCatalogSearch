package RestApiSetup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class RestSpecMapi extends BaseSevice {
    public RequestSpecification REQUEST_SPECIFICATION;
    public RestSpecMapi(){
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri(getBaseUrlMapiApi2("stage"))
            .setBasePath(getBasePathMapi())
            .addHeader("Accept", "application/json")
            .build();
    }
}
