package test.UI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.TestBase;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Проверка функциональности раздела Projects")
public class ProjectTests extends TestBase {

    @Test
    void addingNewProject() {


        open(baseUrl);
        $("#name").setValue("zakharova.an.an@yandex.ru");
        $("#password").setValue("Yfcnz123**");
        $("#button_primary").click();

        $("#sidebar-projects-add").click();
        $("#name").setValue(nameProject);
        $("#announcement").setValue(announcementProject);
        $("#suite_mode_multi").click();
        $("#accept").click();
    }

    @Test
    void likeProject() {

        open(baseUrl);
        $("#name").setValue("zakharova.an.an@yandex.ru");
        $("#password").setValue("Yfcnz123**");
        $("#button_primary").click();
       // $$("#content_container").first().sibling(0).$("[style=\"position: absolute; top: -1px\"]").click();
       $$("#content_container").first().$("[style=\"position: absolute; top: -1px\"]").click();
    }

    @Test
    void UpdateProject() {

        open(baseUrl);
        $("#name").setValue("zakharova.an.an@yandex.ru");
        $("#password").setValue("Yfcnz123**");
        $("#button_primary").click();
        $$("#content_container").first().$("[style=\"padding-left: 25px\"]").click();
        $(".button-edit").click();
        $("#show_announcement").click();
        $("#accept").click();
    }

    @Test
    void addingNewRunsInProject() {

        open(baseUrl);
        $("#name").setValue("zakharova.an.an@yandex.ru");
        $("#password").setValue("Yfcnz123**");
        $("#button_primary").click();
        $(".summary-links").$(byText("Test Runs")).click();
        $("#navigation-runs-add").click();
        $(".button-group").$(byText("OK")).click();
        $("#name").clear();
        $("#name").setValue(nameRuns);
        $("#refs").setValue("текст");
        $("#refs").setValue("текст1");
        $("#description_display").setValue("текст2");
        $("#accept").click();
    }



    @Test
    void deleteProject() {

        open(baseUrl);
        $("#name").setValue("zakharova.an.an@yandex.ru");
        $("#password").setValue("Yfcnz123**");
        $("#button_primary").click();
        $("#navigation-admin").click();
        $("#navigation-sub-projects").click();
        $$("#content-inner").first().$(".icon-small-delete").click();
    }
}
