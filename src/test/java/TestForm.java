import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class TestForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void testPracticeForm() {
        open("https://demoqa.com/automation-practice-form");
        $x("//input[@placeholder='First Name']").setValue("Boris");
        $x("//input[@placeholder='Last Name']").setValue("Britva");
        $x("//input[@placeholder='name@example.com']").setValue("borisbritva@gmail.com");
        $x("//input[@placeholder='Mobile Number']").setValue("8999818907");
        $x("//*[text() = 'Male']").click();
        $x("//*[text() = 'Sports']").click();
        $("[id = subjectsInput]").setValue("Math").pressEnter();
        $("[id = react-select-3-input]").setValue("Uttar Pradesh").pressEnter();
        $("[id = react-select-4-input]").setValue("Agra").pressEnter();
        $x("//textarea[@placeholder='Current Address']").setValue("USSR");
        $("[id = dateOfBirthInput").click();
        $("[class=react-datepicker__month-select]").selectOptionByValue("8");
        $("[class=react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--013").click();
        $("[id = uploadPicture]").uploadFile(new File("src/test/resources/Pictest.png"));
        $x("//button[@id='submit']").click();


        $("[id=example-modal-sizes-title-lg]").shouldHave(Condition.text("Thanks for submitting the form"));
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

        $("[id=closeLargeModal]").click();
    }
}
