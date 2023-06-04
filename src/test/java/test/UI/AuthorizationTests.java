package test.UI;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPages;
import pages.components.AuthorizationComponent;
import test.TestBase;

import static io.qameta.allure.Allure.step;

@DisplayName("Проверка работы с аккаунтом")
public class AuthorizationTests extends TestBase {
    AuthorizationComponent loginComponent = new AuthorizationComponent();
    AuthorizationPages authorizationPages = new AuthorizationPages();

    @Test
    @DisplayName("Проверка авторизации")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    void loginTest() {

        step("Авторизация", () -> {


            loginComponent.setCredentials();
        });

        step("Проверка успешной авторизации", () -> {

            authorizationPages.checkHaveUserName();
        });
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта")
    @Tags({
            @Tag("WEB"),
            @Tag("Story")
    })
    @Owner("ZakharovaAA")
    void logoutTest() {

        step("Авторизация", () -> {

            loginComponent.setCredentials();
        });

        step("Выход из аккаунта", () ->
        {
            authorizationPages.logout();
        });

        step("Проверка выходы из аккаунта", () -> {

            authorizationPages.checkLogout();
        });
    }
}
