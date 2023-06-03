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
public class TestRailTests extends TestDataAPI {

    @BeforeEach //убрать
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
        addProjectRequestBody.setName("name");
        addProjectRequestBody.setAnnouncement("announcementProject");
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
                    assertThat(addProjectResponseModel.getName()).isEqualTo("name");
                    assertThat(addProjectResponseModel.getAnnouncement()).isEqualTo("announcementProject");
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
        addSuiteRequestModelBody.setName(nameSuite);
        addSuiteRequestModelBody.setDescription(nameDescription);
        String addSuiteUrl = format("/api/v2/add_suite/%s", projectId);

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
                    assertThat(addSuiteResponseModel.getName()).isEqualTo(nameSuite);
                    assertThat(addSuiteResponseModel.getDescription()).isEqualTo(nameDescription);
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

        String getSectionsURL = format("/api/v2/get_sections/%s", projectId);

        GetSectionsResponseModel getSectionsResponseModel = step("Получить список разделов", () ->
                given(requestSpec)
                        .queryParam(getSectionsURL)
                        .queryParam("suite_id", suiteId)
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
        step.setContent(stepContent);
        step.setExpected(stepExpected);

        AddTestCasesRequestModel addTestCasesRequestModelBody = new AddTestCasesRequestModel();
        addTestCasesRequestModelBody.setTitle(stepTitle);
        addTestCasesRequestModelBody.setSection_id(sectionId);
        addTestCasesRequestModelBody.setTemplate_id(1);
        addTestCasesRequestModelBody.setType_id(9);
        addTestCasesRequestModelBody.setPriority_id(2);
        List<AddTestCasesRequestModel.ListStepsData> steps = new ArrayList<>();
        steps.add(step);
        addTestCasesRequestModelBody.setCustom_steps_separated(steps);

        String addTestCasesUrl = format("/api/v2/add_case/%s" ,sectionId);

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

    }

    @Test
    @Order(6)
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Получение списка тест-кейсов")
    void GetCases() {

        String getCaseURL = format("/api/v2/get_cases/%s", projectId);

        GetListCasesResponseModel getListCaseResponseModel = step("Создание тест кейса", () ->
                given(requestSpec)
                        .queryParam(getCaseURL)
                        .queryParam("suite_id", suiteId)
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