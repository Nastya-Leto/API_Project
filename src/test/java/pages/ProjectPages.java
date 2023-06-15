package pages;

import com.codeborne.selenide.Condition;
import test.TestBase;
import test.TestDataUi;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectPages extends TestBase {

    TestDataUi testDataUi = new TestDataUi();

    public void createNewProject() {

        $("#sidebar-projects-add").click();
        $("#name").setValue(testDataUi.nameProjectUi);
        $("#announcement").setValue(testDataUi.announcementProjectUi);
        $("#show_announcement").click();
        $("#suite_mode_multi").click();
        $("#accept").click();
    }

    public void checkCreateNewProject() {
        $$("#content-inner").first().shouldBe(Condition.text(testDataUi.nameProjectUi));
    }


    public void updateProject() {

        $$("#content_container").first().$("[style=\"padding-left: 25px\"]").click();
        $(".button-edit").click();
        $("#announcement").clear();
        $("#announcement").setValue(testDataUi.newAnnouncementProjectUi);
        $("#accept").click();

    }

    public void checkUpdateProject() {
        $(byText("Successfully updated the project.")).shouldBe(Condition.visible);
    }


    public void deleteProject() {

        $("#navigation-admin").click();
        $("#navigation-sub-projects").click();
        $$("#content-inner").first().$(".icon-small-delete").click();
        $(byText("Yes, delete this project (cannot be undone)")).click();
        $("#deleteDialog").$(".button-ok").click();

    }

    public void checkDeleteProject() {
        $(byText("Successfully deleted the project.")).shouldBe(Condition.visible);
    }


}
