package RestApiSetup;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public abstract class RestSpecMapi extends BaseSevice {
    public RequestSpecification REQUEST_SPECIFICATION;
    public RestSpecMapi(){
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri(getBaseUrlMapiApi2("stage"))
            .setBasePath(getBasePathMapi())
            //.addHeader("Accept", "application/json")
            //.addHeader("Content-Type", "application/json")
            //.addHeader("sfly-apikey","G8z1COg2lGr0SqDO38yg7Lc9ImaKo45o")
            .build();
    }
}
