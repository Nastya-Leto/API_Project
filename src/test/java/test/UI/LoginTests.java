package test.UI;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.TestBase;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests extends TestBase {

    @Test
    void loginTest() {

        open(baseUrl);
        $("#name").setValue("zakharova.an.an@yandex.ru");
        $("#password").setValue("Yfcnz123**");
        $("#button_primary").click();
    }

    @Test
    void logoutTest() {

        open(baseUrl);
        $("#name").setValue("zakharova.an.an@yandex.ru");
        $("#password").setValue("Yfcnz123**");
        $("#button_primary").click();
        $("#navigation-user").click();
        $("#navigation-user-logout").click();

    }

}
