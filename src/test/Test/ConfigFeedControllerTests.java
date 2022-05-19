import Config.BaseSevice;
import groovy.transform.ASTTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class ConfigFeedControllerTests  extends BaseSevice {



    @Test
    public void putConfigInsertController(){
        String responce1 = given().spec(requestSpecification).when().post().
                then().statusCode(200).extract().asString();
        System.out.println(responce1);
    }

}
