package test;


import io.qameta.allure.Owner;
import models.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static specs.Specification.requestSpec;
import static specs.Specification.responseSpec;

@DisplayName("API тесты")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class APIAddProject extends TestBase {


    @Test
    @Order(1)
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Проверка возможности создания нового проекта")
    void AddProject() {

        AddProjectRequestModel addProjectRequestBody = new AddProjectRequestModel();
        addProjectRequestBody.setName(nameProject);
        addProjectRequestBody.setAnnouncement(AnnouncementProject);
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
                    assertThat(addProjectResponseModel.getName()).isEqualTo(nameProject);
                    assertThat(addProjectResponseModel.getAnnouncement()).isEqualTo(AnnouncementProject);
                }
        );

        projectId = addProjectResponseModel.getId();
    }


    @Test
    @Order(2)
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Проверка возможности создания нового тестового набора")
    void AddSuite() {

        AddSuiteRequestModel addSuiteRequestModelBody = new AddSuiteRequestModel();
        addSuiteRequestModelBody.setName("Тестовый набор");
        addSuiteRequestModelBody.setDescription("Описание тестового набор");
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
        suiteID = addSuiteResponseModel.getId();
    }


    @Test
    @Order(3)
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Проверка возможности создания нового раздела")
    void AddSections() {

        AddSectionsRequestModel addSectionsRequestModelBody = new AddSectionsRequestModel();
        addSectionsRequestModelBody.setName(nameSections);
        addSectionsRequestModelBody.setDescription(DescriptionSections);
        addSectionsRequestModelBody.setSuite_id(suiteID);


        String addSectionsUrl = format("/api/v2/add_section/%s", projectId);

        AddSuiteResponseModel addSuiteResponseModel = step("Создание раздела", () ->
                given(requestSpec)
                        .body(addSectionsRequestModelBody)
                        .queryParam(addSectionsUrl)
                        .when()
                        .post()
                        .then()
                        .spec(responseSpec)
                        .extract().as(AddSuiteResponseModel.class)
        );

    }

    @Test
    @Order(4)
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
                        .queryParam("suite_id", suiteID)
                        .when()
                        .get()
                        .then()
                        .spec(responseSpec)
                        .extract().as(GetSectionsResponseModel.class)

        );
        // sectionId = getSectionsResponseModel.getId();

        step("Проверка, что разделы существуют", () -> {

                    assertThat(getSectionsResponseModel).isNotNull();

                }
        );
    }


    @Test
    @Disabled
    @Order(5)
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Проверка возможности добавление нового тест-кейса")
    void AddTestCases() {

        AddTestCasesRequestModel.ListStepsData step = new AddTestCasesRequestModel.ListStepsData();
        step.setContent("Открыть страницу сайта");
        step.setExpected("Что то нажать");
        AddTestCasesRequestModel.ListStepsData step1 = new AddTestCasesRequestModel.ListStepsData();
        step1.setContent("Нажать что то еще раз");
        step1.setExpected("Восхищаться");

        AddTestCasesRequestModel addTestCasesRequestModelBody = new AddTestCasesRequestModel();
        addTestCasesRequestModelBody.setTitle("Уляля");
        addTestCasesRequestModelBody.setSection_id(8);
        addTestCasesRequestModelBody.setTemplate_id(1);
        addTestCasesRequestModelBody.setType_id(9);
        addTestCasesRequestModelBody.setPriority_id(2);
        List<AddTestCasesRequestModel.ListStepsData> steps = new ArrayList<>();
        steps.add(step);
        steps.add(step1);
        addTestCasesRequestModelBody.setCustom_steps_separated(steps);


        //String addTestCasesUrl = format("/api/v2/add_case/%s", projectId);
        String addTestCasesUrl = format("/api/v2/add_case/34");

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

        String getCaseURL = format("/api/v2/get_cases/%s", caseProjectID);

        GetListCasesResponseModel getListCaseResponseModel = step("Создание тест кейса", () ->
                given(requestSpec)
                        .queryParam(getCaseURL)
                        .queryParam("suite_id", suiteProjectID)
                        .when()
                        .get()
                        .then()
                        .spec(responseSpec)
                        .extract().as(GetListCasesResponseModel.class)

        );

        step("Проверка, что тест-кейсы существуют", () ->
                assertThat(getListCaseResponseModel).isNotNull());

    }


    @Test
    @Order(7)
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Получение информации по тест-кейсу")
    void GetCase() {

        String getCaseURL = ("/api/v2/get_case/5");
        //Response responseInfoCase = apiRequests.makePostRequest("/api/users", body);

        GetInfoCaseResponseModel getInfoCaseResponseModel = step("Создание тест кейса", () ->
                given(requestSpec)
                        .queryParam(getCaseURL)
                        .when()
                        .get()
                        .then()
                        .spec(responseSpec)
                        .extract().as(GetInfoCaseResponseModel.class)

        );

        step("Проверка корректности информации о тест-кейсе", () -> {

                    assertThat(getInfoCaseResponseModel).isNotNull();

                   // assertThat(getInfoCaseResponseModel, matchesJsonSchemaInClasspath("GetCaseSchema.json"))
           // assertThat().getInfoCaseResponseModel(matchesJsonSchemaInClasspath("GetCaseSchema.json"));
           // TestBase.assertJsonSchema(getInfoCaseResponseModel, "createUserScheme.json");
                }
        );
    }

    @Test
    @Disabled
    @Order(8)
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Проверка возможности редактирования тест-кейса")
    void UpdateTestCases() {


        UpdateTestCasesRequestModel updateTestCasesRequestModelBody = new UpdateTestCasesRequestModel();
        //updateTestCasesRequestModelBody.setCase_id(6);
        updateTestCasesRequestModelBody.setTitle("Уляля");
        updateTestCasesRequestModelBody.setPriority_id(1);
        updateTestCasesRequestModelBody.setType_id(9);

        //String addTestCasesUrl = format("/api/v2/update_case/%s", projectId);
        String addTestCasesUrl = format("/api/v2/update_case/7");

        AddTestCasesResponseModel addTestCasesResponseModel = step("Редактирование тест-кейса", () ->
                given(requestSpec)
                        .body(updateTestCasesRequestModelBody)
                        .queryParam(addTestCasesUrl)
                        .when()
                        .post()
                        .then()
                        .spec(responseSpec)
                        .extract().as(AddTestCasesResponseModel.class)

        );

    }

    @Test
    @Order(9)
    @Tags({
            @Tag("API"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    @DisplayName("Проверка возможности удаления тестового набора")
    void DeleteSuite() {

        String deleteSuiteUrl = format("/api/v2/delete_suite/%s", suiteID);

        step("Удаление тестового набора", () ->
                given()
                        .queryParam(deleteSuiteUrl)
                        .when()
                        .post()
                        .then());
    }
}