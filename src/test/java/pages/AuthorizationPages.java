package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPages {

    public void checkHaveUserName() {

        $(".navigation-username").shouldBe(Condition.visible);
    }

    public void logout() {

        $("#navigation-user").click();
        $("#navigation-user-logout").click();
    }

    public void checkLogout() {

        $(byText("Log into Your Account")).shouldBe(Condition.visible);
    }
}
