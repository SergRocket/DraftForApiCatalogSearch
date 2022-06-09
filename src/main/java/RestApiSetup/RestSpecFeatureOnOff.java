package RestApiSetup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class RestSpecFeatureOnOff extends BaseSevice{
    public RequestSpecification REQUEST_SPECIFICATION;
    public RestSpecFeatureOnOff(){
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(getBaseUrlRegFeatureFlagonOff("beta"))
                .setBasePath(getBasePathRegFeatureFlagOnOff())
                .addHeader("sfly-ccs-api-key","19a169e6-2cd3-47ea-9e32-c952ff3cfcf4")
                .addHeader("Accept", "application/json")
                .build();
    }
}
