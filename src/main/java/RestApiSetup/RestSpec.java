package RestApiSetup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class RestSpec extends BaseSevice {
    protected abstract String getBasePath();
    public RequestSpecification REQUEST_SPECIFICATION;
    public RestSpec(){
                REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(getBaseUrl("beta"))
                .setBasePath(getBasePath())
                .addHeader("Accept", "application/json")
                .build();
    }


}
