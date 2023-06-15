package test.UI;


import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.ProjectPages;
import pages.components.AuthorizationComponent;
import test.TestBase;

import static io.qameta.allure.Allure.step;

@DisplayName("Проверка функциональности раздела Projects")
public class ProjectTests extends TestBase {

    AuthorizationComponent loginComponent = new AuthorizationComponent();
    ProjectPages projectPages = new ProjectPages();

    @Test
    @DisplayName("Проверка возможности создания нового проекта")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    void addingNewProject() {

        step("Авторизация", () -> loginComponent.setCredentials());
        step("Создание нового проекта", () -> projectPages.createNewProject());
        step("Проверка успешного создания проекта", () ->  projectPages.checkCreateNewProject());

    }

    @Test
    @DisplayName("Проверка возможности редактирования проекта")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    void UpdateProject() {

        step("Авторизация", () ->  loginComponent.setCredentials());
        step("Редактирование проекта", () ->  projectPages.updateProject());
        step("Проверка успешного редактирования проекта", () -> projectPages.checkUpdateProject());
    }

    @Test
    @DisplayName("Проверка возможности удаления проекта")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    void deleteProject() {


        step("Авторизация", () -> loginComponent.setCredentials());
        step("Удаление проекта", () -> projectPages.deleteProject());
        step("Проверка успешного удаления проекта", () -> projectPages.checkDeleteProject());

    }
}
