package pages.components;

import config.Auth;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationComponent {
    public void setCredentials() {

        open(baseUrl);
        $("#name").setValue(Auth.config.usernameTestRail());
        $("#password").setValue(Auth.config.passwordTestRail());
        $("#button_primary").click();
    }


}
