package RestApiSetup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class RestSpecRegressionVerifySizeId extends BaseSevice{
    public RequestSpecification REQUEST_SPECIFICATION;
    public RestSpecRegressionVerifySizeId(){
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(getBaseUrlRegVerifySizeId("beta"))
                .setBasePath(getBasePathRegVerifySizeId())
                .addHeader("Accept", "application/json")
                .build();
    }
}
