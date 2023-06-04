package test.UI;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import pages.CreateNewUserPages;
import pages.components.AuthorizationComponent;
import test.TestBase;


import static io.qameta.allure.Allure.step;

public class CreateNewUserTest extends TestBase {

    AuthorizationComponent loginComponent = new AuthorizationComponent();
    CreateNewUserPages createNewUserPages = new CreateNewUserPages();

    @Test
    void createNewUser() {


        step("Авторизация", () -> {
            loginComponent.setCredentials();
        });

        step("Создание нового пользователя", () -> {
            createNewUserPages.createNewUser();
        });

        step("Проверка успешного создания пользователя", () -> {
            createNewUserPages.checkCreateNewUser();
        });
    }

}
