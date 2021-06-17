package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    SelenideElement firstNameInput = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
            emailInput = $("[id=userEmail]"),
            phoneNumberInput = $("[id=userNumber]"),
            calendarInput = $("[id=dateOfBirthInput]"),
            calendarMonthInput = $(byClassName("react-datepicker__month-select")),
            calendarYearInput = $(byClassName("react-datepicker__year-select")),
            calendarDayInput = $(byClassName("react-datepicker__day--020")),
            subjectInput = $("#subjectsInput"),
            hobbies1Input = $("div#hobbiesWrapper label", 1),
            hobbies3Input = $("div#hobbiesWrapper label", 3),
            fileInput = $("[id=uploadPicture]"),
            addressInput = $("[id=currentAddress]"),
            stateInput = $("[id=state]"),
            cityInput = $("[id=city]"),
            submitInput = $("[id=submit]"),
            tableInput = $(byClassName("table-responsive")),
            tableCloseInput = $("[id=closeLargeModal]"),
            checkFormInput = $(".practice-form-wrapper");

    public void pageOpen(String value) {
        open("https://demoqa.com/automation-practice-form");
        checkFormInput.shouldHave(text(value));
    }

    public void typeFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void typeEmail(String value) {
        emailInput.setValue(value);
    }

    public void chooseGender(String value) {
        $(byText(value)).click();
    }

    public void typePhoneNumber(String value) {
        phoneNumberInput.setValue(value);
    }

    public void setDateOfBirth(String monthNum, String year) {
        calendarInput.click();     //открытие календаря
        calendarMonthInput.click();   //открытие списка с месяцем
        calendarMonthInput.selectOptionByValue(monthNum);     //выбор месяца
        calendarYearInput.click();    //открытие списка с годом
        calendarYearInput.selectOptionByValue(year);    //выбор года
        calendarDayInput.click();   //выбор дня
    }

    public void typeSubject(String value) {
        subjectInput.setValue(value).pressEnter();
    }

    public void chooseHobbies() {
        hobbies1Input.click();
        hobbies3Input.click();
    }

    public void upLoadFile(String value) {
        fileInput.uploadFile(new File(String.format("src/test/resources/%s", value)));
    }

    public void setAddressInput(String value) {
        addressInput.setValue(value).pressTab();
    }

    public void chooseState(String value) {
        stateInput.click();
        $(byText(value)).click();
    }

    public void chooseCity(String value) {
        cityInput.click();
        $(byText(value)).click();
    }

    public void clickSubmit() {
        submitInput.click();
    }

    public void checkTable(String firstName,
                           String lastname,
                           String email,
                           String gender,
                           String phoneNumber,
                           String monthText,
                           String year,
                           String subjects,
                           String picture,
                           String address,
                           String state,
                           String city) {
        tableInput.shouldHave(text("Student Name"), text(firstName + " " + lastname));
        tableInput.shouldHave(text("Student Email"), text(email));
        tableInput.shouldHave(text("Gender"), text(gender));
        tableInput.shouldHave(text("Mobile"), text(phoneNumber));
        tableInput.shouldHave(text("Date of Birth"), text("20" + " " + monthText + "," + year));
        tableInput.shouldHave(text("Subjects"), text(subjects));
        tableInput.shouldHave(text("Hobbies"), text("Sports" + ", " + "Music"));
        tableInput.shouldHave(text("Picture"), text(picture));
        tableInput.shouldHave(text("Address"), text(address));
        tableInput.shouldHave(text("State and City"), text(state + " " + city));
    }

    /*public void closeTable(String value) {
        tableCloseInput.click();
        checkFormInput.shouldHave(text(value));
    }*/
}
