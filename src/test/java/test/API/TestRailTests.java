package test.API;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import models.*;
import org.junit.jupiter.api.*;
import test.TestDataAPI;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static specs.Specification.requestSpec;
import static specs.Specification.responseSpec;

@DisplayName("API тесты")
public class TestRailTests {

    TestDataAPI testDataAPI = new TestDataAPI();

    @BeforeEach
        //убрать
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Проверка возможности создания нового проекта")
    void AddProject() {

        AddProjectRequestModel addProjectRequestBody = new AddProjectRequestModel();
        addProjectRequestBody.setName(testDataAPI.nameProjectApi);
        addProjectRequestBody.setAnnouncement(testDataAPI.announcementProjectApi);
        addProjectRequestBody.setShow_announcement(true);

        AddProjectResponseModel addProjectResponseModel = step("Создание нового проекта", () ->
                given(requestSpec)
                        .body(addProjectRequestBody)
                        .queryParam("/api/v2/add_project")
                        .when()
                        .post()
                        .then()
                        .spec(responseSpec)
                        .extract().as(AddProjectResponseModel.class)

        );

        step("Проверка успешного создания проекта", () -> {
                    assertThat(addProjectResponseModel.getName()).isEqualTo(testDataAPI.nameProjectApi);
                    assertThat(addProjectResponseModel.getAnnouncement()).isEqualTo(testDataAPI.announcementProjectApi);
                }
        );
    }


    @Test
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Проверка возможности создания нового тестового набора")
    void AddSuite() {

        AddSuiteRequestModel addSuiteRequestModelBody = new AddSuiteRequestModel();
        addSuiteRequestModelBody.setName(testDataAPI.nameSuite);
        addSuiteRequestModelBody.setDescription(testDataAPI.nameDescription);
        String addSuiteUrl = format("/api/v2/add_suite/%s", testDataAPI.projectId);

        AddSuiteResponseModel addSuiteResponseModel = step("Создание тестового набора", () ->
                given(requestSpec)
                        .body(addSuiteRequestModelBody)
                        .queryParam(addSuiteUrl)
                        .when()
                        .post()
                        .then()
                        .spec(responseSpec)
                        .extract().as(AddSuiteResponseModel.class)

        );

        step("Проверка успешного создания тестового набора", () -> {
                    assertThat(addSuiteResponseModel.getName()).isEqualTo(testDataAPI.nameSuite);
                    assertThat(addSuiteResponseModel.getDescription()).isEqualTo(testDataAPI.nameDescription);
                }
        );
    }

    @Test
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Получение списка разделов")
    void GetSections() {

        String getSectionsURL = format("/api/v2/get_sections/%s", testDataAPI.projectId);

        GetSectionsResponseModel getSectionsResponseModel = step("Получить список разделов", () ->
                given(requestSpec)
                        .queryParam(getSectionsURL)
                        .queryParam("suite_id", testDataAPI.suiteId)
                        .when()
                        .get()
                        .then()
                        .spec(responseSpec)
                        .extract().as(GetSectionsResponseModel.class)

        );

        step("Проверка, что разделы существуют", () -> {

                    assertThat(getSectionsResponseModel).isNotNull();

                }
        );
    }


    @Test
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Проверка возможности добавление нового тест-кейса")
    void AddTestCases() {

        AddTestCasesRequestModel.ListStepsData step = new AddTestCasesRequestModel.ListStepsData();
        step.setContent(testDataAPI.stepContent);
        step.setExpected(testDataAPI.stepExpected);

        AddTestCasesRequestModel addTestCasesRequestModelBody = new AddTestCasesRequestModel();
        addTestCasesRequestModelBody.setTitle(testDataAPI.stepTitle);
        addTestCasesRequestModelBody.setSection_id(testDataAPI.sectionId);
        addTestCasesRequestModelBody.setTemplate_id(1);
        addTestCasesRequestModelBody.setType_id(9);
        addTestCasesRequestModelBody.setPriority_id(2);
        List<AddTestCasesRequestModel.ListStepsData> steps = new ArrayList<>();
        steps.add(step);
        addTestCasesRequestModelBody.setCustom_steps_separated(steps);

        String addTestCasesUrl = format("/api/v2/add_case/%s", testDataAPI.sectionId);

        AddTestCasesResponseModel addTestCasesResponseModel = step("Создание тест кейса", () ->
                given(requestSpec)
                        .body(addTestCasesRequestModelBody)
                        .queryParam(addTestCasesUrl)
                        .when()
                        .post()
                        .then()
                        .spec(responseSpec)
                        .extract().as(AddTestCasesResponseModel.class)

        );

        step("Проверка, что тест-кейс создан", () -> {

                    assertThat(addTestCasesResponseModel.getTitle()).isEqualTo(testDataAPI.stepTitle);

                }
        );

    }

    @Test
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Получение списка тест-кейсов")
    void GetCases() {

        String getCaseURL = format("/api/v2/get_cases/%s", testDataAPI.projectId);

        GetListCasesResponseModel getListCaseResponseModel = step("Создание тест кейса", () ->
                given(requestSpec)
                        .queryParam(getCaseURL)
                        .queryParam("suite_id", testDataAPI.suiteId)
                        .when()
                        .get()
                        .then()
                        .spec(responseSpec)
                        .extract().as(GetListCasesResponseModel.class)

        );

        step("Проверка, что тест-кейсы существуют", () ->
                assertThat(getListCaseResponseModel).isNotNull());

    }

}