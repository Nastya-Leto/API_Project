package pages;

import com.codeborne.selenide.Condition;
import test.TestDataUi;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreateNewUserPages {

    TestDataUi testDataUi = new TestDataUi();

    public void createNewUser() {

        $("#navigation-admin").click();
        $("#navigation-sub-users").click();
        $("#sidebar-add-users").$(byText("Add User")).click();
        $("#name").setValue(testDataUi.name);
        $("#email").setValue(testDataUi.email);
        $("#accept").click();

    }

    public void checkCreateNewUser() {

        $("#users-tab-frame").$(byText(testDataUi.email)).shouldBe(Condition.visible);
    }
}
