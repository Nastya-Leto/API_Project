package test.UI;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.CreateNewUserPages;
import pages.components.AuthorizationComponent;
import test.TestBase;


import static io.qameta.allure.Allure.step;
@DisplayName("Проверка работы с пользователями")
public class CreateNewUserTest extends TestBase {

    AuthorizationComponent loginComponent = new AuthorizationComponent();
    CreateNewUserPages createNewUserPages = new CreateNewUserPages();

    @Test
    @DisplayName("Проверка создания нового пользователя")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    void createNewUser() {

        step("Авторизация", () -> loginComponent.setCredentials());
        step("Создание нового пользователя", () -> createNewUserPages.createNewUser());
        step("Проверка успешного создания пользователя", () -> createNewUserPages.checkCreateNewUser());
    }
}
