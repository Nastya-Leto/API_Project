package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static test.TestBase.*;

public class Specification {


    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .cookies("recently_viewed_entities", recently_viewed_entities,
                    "tr_session", tr_session,
                    "tr_rememberme",tr_rememberme )
            .contentType(JSON)
            .log().all();



    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

}
