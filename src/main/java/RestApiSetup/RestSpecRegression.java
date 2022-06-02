package RestApiSetup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class RestSpecRegression extends BaseSevice {
    //protected abstract String getBasePath();
    public RequestSpecification REQUEST_SPECIFICATION;
    public RestSpecRegression(){
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(getBaseUrlReg("beta"))
                .setBasePath(getBasePathReg())
                .addHeader("Accept", "application/json")
                .build();
    }
}
