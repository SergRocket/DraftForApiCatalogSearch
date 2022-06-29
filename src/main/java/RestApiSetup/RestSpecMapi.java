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
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .addHeader("SFLY-brand","us-sfly")
            .addHeader("SFLY-channel","web")
            .build();
    }
}
