package test;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestBase {

    public static String name,
            recently_viewed_entities = "%5B%7B%22id%22%3A%221%22%2C%22type%22%3A%22projects%22%2C%22title%22%3A%22Manual%22%7D%5D",
            tr_session = "726cd8da-99d5-416b-a713-6a3d19f27560",
            tr_rememberme = "1%3ArbClSrE6PCwOsV5gv7%2FW-nVBVKDd2pdgFIqdhaiwY";

    public static Integer projectId, suiteID,sectionId;

    public Integer caseProjectID = 34,
            suiteProjectID = 33;
    public String nameProject = "Тестирование API Testrail";
    public String AnnouncementProject = "Проведение различных тестов для проверки основного функционала проекта";

    public String nameSections = "Авторизация";
    public String DescriptionSections = "Проверка авторизации";

    /*public static void assertJsonSchema(Response Response, String jsonSchema) {
        Response.then().assertThat().body(matchesJsonSchemaInClasspath("schemes/" + jsonSchema));
    }*/

    @BeforeAll
    static void setUp() {

        RestAssured.baseURI = "https://qanastya.testrail.io/index.php";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
    }
}
