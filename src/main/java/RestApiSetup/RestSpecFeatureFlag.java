package RestApiSetup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class RestSpecFeatureFlag extends BaseSevice{
    public RequestSpecification REQUEST_SPECIFICATION;
    public RestSpecFeatureFlag(){
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(getBaseUrlRegFeatureFlag("beta"))
                .setBasePath(getBasePathRegFeatureFlag())
                .addHeader("Accept", "application/json")
                .build();
    }
}
