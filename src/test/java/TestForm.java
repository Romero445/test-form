import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void testForm() {
        open("https://demoqa.com/automation-practice-form");
        $x("//input[@placeholder='First Name']").setValue("Lena");
        $x("//input[@placeholder='Last Name']").setValue("Golovach");
        $x("//input[@placeholder='name@example.com']").setValue("lengen@gmail.com");
        $x("//input[@placeholder='Mobile Number']").setValue("8999818907");
        $x("//*[text() = 'Male']").click();
        $x("//*[text() = 'Sports']").click();
        $("[id = subjectsInput]").setValue("Math").pressEnter();
        $("[id = react-select-3-input]").setValue("Uttar Pradesh").pressEnter();
        $("[id = react-select-4-input]").setValue("Agra").pressEnter();
        $x("//textarea[@placeholder='Current Address']").setValue("gamag");
    }

}
