package specs;

import config.Auth;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class Specification {

    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://qaleto.testrail.io/index.php")
            .cookies("recently_viewed_entities", Auth.config.recently_viewed_entities(),
                    "tr_session", Auth.config.tr_session(),
                    "tr_rememberme", Auth.config.tr_rememberme())
            .contentType(JSON)
            .log().all();


    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

}
