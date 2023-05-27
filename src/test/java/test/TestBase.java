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
            recently_viewed_entities = "%5B%7B%22id%22%3A%221%22%2C%22type%22%3A%22projects%22%2C%22title%22%3A%22Manual%22%7D%5D",
            tr_session = "726cd8da-99d5-416b-a713-6a3d19f27560",
            tr_rememberme = "1%3ArbClSrE6PCwOsV5gv7%2FW-nVBVKDd2pdgFIqdhaiwY";

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
        Selenide.closeWebDriver();
    }

    @BeforeAll
    static void setUp() {

        RestAssured.baseURI = "https://qanastya.testrail.io/index.php";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
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
