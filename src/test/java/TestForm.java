import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl="https://demoqa.com";


    }

    @Test
    void testPracticeForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Boris");
        $("#lastName").setValue("Britva");
        $("#userEmail").setValue("borisbritva@gmail.com");
        $("#userNumber").setValue("8999818907");
        $(byText("Male")).click();
        $(byText("Sports")).click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        $x("//textarea[@placeholder='Current Address']").setValue("USSR");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__month-select]").selectOptionByValue("8");
        $("[class=react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--013").click();
        $("#uploadPicture").uploadFile(new File(("src/test/resources/Pictest.png")));
        $("#submit").click();



        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        $("[class=table-responsive]").shouldHave(
                Condition.textCaseSensitive("Student Name"), Condition.textCaseSensitive("Boris Britva"),
                Condition.textCaseSensitive("Student Email"), Condition.textCaseSensitive("borisbritva@gmail.com"),
                Condition.textCaseSensitive("Gender"), Condition.textCaseSensitive("Male"),
                Condition.textCaseSensitive("Date of Birth"), Condition.textCaseSensitive("13 September,1990"),
                Condition.textCaseSensitive("Subjects"), Condition.textCaseSensitive("Math"),
                Condition.textCaseSensitive("Hobbies"), Condition.textCaseSensitive("Sports"),
                Condition.textCaseSensitive("Picture"), Condition.textCaseSensitive("Pictest.png"),
                Condition.textCaseSensitive("Address"), Condition.textCaseSensitive("USSR"),
                Condition.textCaseSensitive("State and City"), Condition.textCaseSensitive("Uttar Pradesh Agra")
        );

        $("#closeLargeModal").click();
    }
}
