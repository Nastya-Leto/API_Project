package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class TestBase {

    public static String name,
            recently_viewed_entities = "%5B%7B%22id%22%3A%224%22%2C%22type%22%3A%22runs%22%2C%22title%22%3A%22%5Cu0420%5Cu0435%5Cu0433%5Cu0440%5Cu0435%5Cu0441%5Cu0441+%5Cu043d%5Cu0430%5Cu0441+%5Cu0441%5Cu0431%5Cu043e%5Cu0440%5Cu043a%5Cu0435+3.2.0%22%7D%2C%7B%22id%22%3A%221%22%2C%22type%22%3A%22runs%22%2C%22title%22%3A%22Test+Run+5%5C%2F27%5C%2F2023%22%7D%2C%7B%22id%22%3A%222%22%2C%22type%22%3A%22suites%22%2C%22title%22%3A%22Master%22%7D%2C%7B%22id%22%3A%222%22%2C%22type%22%3A%22projects%22%2C%22title%22%3A%22%5Cu0422%5Cu0435%5Cu0441%5Cu0442%5Cu0438%5Cu0440%5Cu043e%5Cu0432%5Cu0430%5Cu043d%5Cu0438%5Cu0435+API+Testrail%22%7D%5D",
            tr_session = "6e32679e-11c9-4181-b5b0-162fef2ddd58",
            tr_rememberme = "1%3AViKmE.lnrtO5DiPeVkwj-KXm%2FyX%2FaW.1DslMnVo3%2F";

    public Integer sectionId = 35;
    public Integer projectId = 45;
    public Integer suiteId = 41;

    public String nameProject = "Тестирование API Testrail";
    public String announcementProject = "Проведение различных тестов для проверки основного функционала проекта";

    public String nameSuite = "Тестирование главной страницы";
    public String nameDescription = "Проверка основного функционала на главной странице";

    public String nameRuns = "Регресс нас сборке 3.2.0";

    public String stepContent = "Открыть страницу сайта и прокликать кнопки в хедере";
    public String stepExpected = "На главной странице активны кнопки в хедере";
    public String stepTitle = "Проверка работы кнопок в хедере";

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        //Selenide.closeWebDriver();
    }

    @BeforeAll
    static void setUp() {

        RestAssured.baseURI = "https://qaleto.testrail.io/index.php";
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://qaleto.testrail.io/index.php?/dashboard";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.browserSize = "1680x1050";
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true

        ));
        Configuration.browserCapabilities = capabilities;
    }
}
