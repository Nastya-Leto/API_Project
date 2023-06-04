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

//    static String
//            recently_viewed_entities = "%5B%7B%22id%22%3A%225%22%2C%22type%22%3A%22projects%22%2C%22title%22%3A%22%5Cu0422%5Cu0435%5Cu0441%5Cu0442%5Cu0438%5Cu0440%5Cu043e%5Cu0432%5Cu0430%5Cu043d%5Cu0438%5Cu0435+API+Testrail%22%7D%2C%7B%22id%22%3A%2238%22%2C%22type%22%3A%22projects%22%2C%22title%22%3A%22name%22%7D%2C%7B%22id%22%3A%2219%22%2C%22type%22%3A%22suites%22%2C%22title%22%3A%22API%22%7D%2C%7B%22id%22%3A%2235%22%2C%22type%22%3A%22projects%22%2C%22title%22%3A%22%5Cu0422%5Cu0435%5Cu0441%5Cu0442%5Cu0438%5Cu0440%5Cu043e%5Cu0432%5Cu0430%5Cu043d%5Cu0438%5Cu0435+API+Testrail%22%7D%2C%7B%22id%22%3A%222%22%2C%22type%22%3A%22projects%22%2C%22title%22%3A%22%5Cu0422%5Cu0435%5Cu0441%5Cu0442%5Cu0438%5Cu0440%5Cu043e%5Cu0432%5Cu0430%5Cu043d%5Cu0438%5Cu0435+API+Testrail%22%7D%5D",
//            tr_session = "33b62eb7-bf75-4dc6-ae79-73db1d44836d",
//            tr_rememberme = "1%3A5X4zBIQIDU3cdvTicuLw-hJwVZXLVaBFSlQ9fAU4o; suites_overview_pagination17=0";

    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://qaleto.testrail.io/index.php")
//            .cookies("recently_viewed_entities", recently_viewed_entities,
//                    "tr_session", tr_session,
//                    "tr_rememberme", tr_rememberme)
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
