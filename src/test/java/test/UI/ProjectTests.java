package test.UI;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProjectPages;
import pages.components.AuthorizationComponent;
import test.TestBase;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@DisplayName("Проверка функциональности раздела Projects")
public class ProjectTests extends TestBase {

    AuthorizationComponent loginComponent = new AuthorizationComponent();
    ProjectPages projectPages = new ProjectPages();

    @Test
    void addingNewProject() {


        step("Авторизация", () -> {
            loginComponent.setCredentials();
        });

        step("Создание нового проекта", () -> {
            projectPages.createNewProject();

        });

        step("Проверка успешного создания проекта", () -> {
            projectPages.checkCreateNewProject();
        });
    }

    @Test
    void UpdateProject() {

        step("Авторизация", () -> {
            loginComponent.setCredentials();
        });

        step("Редактирование проекта", () -> {
            projectPages.updateProject();
        });

        step("Проверка успешного редактирования проекта", () -> {
            projectPages.checkUpdateProject();
        });


    }

    @Test
    void addingNewRunInProject() {
        //Починить тест

        step("Авторизация", () -> {
            loginComponent.setCredentials();
        });

        step("Добавление нового прогона", () -> {
            projectPages.createNewRun();
        });

        step("Проверка успешного добавления нового прогона", () -> {
            projectPages.checkCreateNewRun();
        });
    }


    @Test
    void deleteProject() {


        step("Авторизация", () -> {
            loginComponent.setCredentials();
        });

        step("Удаление проекта", () -> {
            projectPages.deleteProject();
        });

        step("Проверка успешного удаления проекта", () -> {
            projectPages.checkDeleteProject();
        });

    }
}
