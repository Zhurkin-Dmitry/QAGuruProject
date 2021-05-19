import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class ToolsQAPracticeForm {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void selenideRegistrationForm() {
        open("https://demoqa.com/automation-practice-form");

        $("[id=firstName]").setValue("MyFirstName");
        $("[id=lastName]").setValue("MyLastName");
        $("[id=userEmail]").setValue("userEmail@gmail.com");
        $x("//label[text()='Male']").click();
        $("[id=userNumber]").setValue("9876543210");
        //выбор даты рождения
        $("[id=dateOfBirthInput]").click();     //открытие календаря
        $(byClassName("react-datepicker__month-select")).click();   //открытие списка с месяцем
        $(byClassName("react-datepicker__month-select")).selectOptionByValue("10");     //выбор месяца
        $(byClassName("react-datepicker__year-select")).click();    //открытие списка с годом
        $(byClassName("react-datepicker__year-select")).selectOptionByValue("2000");    //выбор года
        $(byClassName("react-datepicker__day--020")).click();   //выбор дня

        // subjectsContainer

        $("div#hobbiesWrapper label", 1).click();
        $("div#hobbiesWrapper label", 3).click();

        // ???picture???

        $("[id=currentAddress]").setValue("MyMainCurrentAddress").pressTab();

        // ???state???
        $("[id=state]").click();

        // ???city???

        $("[id=submit]").click();

        // зона проверок заполнения значений
        $(byClassName("table-responsive")).shouldHave(text("Student Name"), text("MyFirstName" + " " + "MyLastName"));
        $(byClassName("table-responsive")).shouldHave(text("Student Email"), text("userEmail@gmail.com"));
        $(byClassName("table-responsive")).shouldHave(text("Gender"), text("Male"));
        $(byClassName("table-responsive")).shouldHave(text("Mobile"), text("9876543210"));
        $(byClassName("table-responsive")).shouldHave(text("Date of Birth"), text("20" + " " + "November" + "," + "2000"));
        //$(byClassName("table-responsive")).shouldHave(text("Subjects"), text(""));
        $(byClassName("table-responsive")).shouldHave(text("Hobbies"), text("Sports" + ", " + "Music"));
        //$(byClassName("table-responsive")).shouldHave(text("Picture"), text(""));
        $(byClassName("table-responsive")).shouldHave(text("Address"), text("MyMainCurrentAddress"));
        //$(byClassName("table-responsive")).shouldHave(text("State and City"), text(""));


        System.out.println("ok");

    }
}
