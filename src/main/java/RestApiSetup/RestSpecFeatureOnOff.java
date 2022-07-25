package RestApiSetup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class RestSpecFeatureOnOff extends BaseSevice{
    public RequestSpecification REQUEST_SPECIFICATION;
    public RestSpecFeatureOnOff(){
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(getBaseUrlRegFeatureFlagonOff("stage"))
                .setBasePath(getBasePathRegFeatureFlagOnOff())
                .addHeader("Accept","*/*")
                .addHeader("Content-Type","text/plain")
                .build();
    }
}
