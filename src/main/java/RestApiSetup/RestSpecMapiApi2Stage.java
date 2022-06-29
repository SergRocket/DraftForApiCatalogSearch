package RestApiSetup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestSpecMapiApi2Stage extends BaseSevice{
    public RequestSpecification REQUEST_SPECIFICATION;
    public RestSpecMapiApi2Stage(){
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri(getBaseUrlMapi("beta"))
            .setBasePath(getBasePathMapi())
            .addHeader("Accept", "application/json")
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .addHeader("SFLY-brand","us-sfly")
            .addHeader("SFLY-channel","web")
            .build();
    }
}
