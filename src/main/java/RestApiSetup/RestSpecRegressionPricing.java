package RestApiSetup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class RestSpecRegressionPricing extends BaseSevice {
    public RequestSpecification REQUEST_SPECIFICATION;
    public RestSpecRegressionPricing(){
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(getBaseUrlRegGetPricing("beta"))
                .setBasePath(getBasePathRegPricing())
                .addHeader("Accept", "application/json")
                .build();
    }
}
