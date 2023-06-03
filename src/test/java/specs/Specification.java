package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class Specification {

public static String
        recently_viewed_entities = "%5B%7B%22id%22%3A%224%22%2C%22type%22%3A%22runs%22%2C%22title%22%3A%22%5Cu0420%5Cu0435%5Cu0433%5Cu0440%5Cu0435%5Cu0441%5Cu0441+%5Cu043d%5Cu0430%5Cu0441+%5Cu0441%5Cu0431%5Cu043e%5Cu0440%5Cu043a%5Cu0435+3.2.0%22%7D%2C%7B%22id%22%3A%221%22%2C%22type%22%3A%22runs%22%2C%22title%22%3A%22Test+Run+5%5C%2F27%5C%2F2023%22%7D%2C%7B%22id%22%3A%222%22%2C%22type%22%3A%22suites%22%2C%22title%22%3A%22Master%22%7D%2C%7B%22id%22%3A%222%22%2C%22type%22%3A%22projects%22%2C%22title%22%3A%22%5Cu0422%5Cu0435%5Cu0441%5Cu0442%5Cu0438%5Cu0440%5Cu043e%5Cu0432%5Cu0430%5Cu043d%5Cu0438%5Cu0435+API+Testrail%22%7D%5D",
        tr_session = "6e32679e-11c9-4181-b5b0-162fef2ddd58",
        tr_rememberme = "1%3AViKmE.lnrtO5DiPeVkwj-KXm%2FyX%2FaW.1DslMnVo3%2F";
    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://qaleto.testrail.io/index.php")
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
