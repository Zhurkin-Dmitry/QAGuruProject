package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class ToolsQAPrFormWithPageObject {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            phoneNumber = faker.number().digits(10),
            monthNum = "10",
            monthText = "November",
            year = "2000",
            subjects = "Math",
            picture = "1.jpg",
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal",
            checkForm = "Student Registration Form";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void selenideRegistrationForm() {
        registrationPage.pageOpen(checkForm);
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email);
        registrationPage.chooseGender(gender);
        registrationPage.typePhoneNumber(phoneNumber);
        registrationPage.setDateOfBirth(monthNum, year);
        registrationPage.typeSubject(subjects);
        registrationPage.chooseHobbies();
        registrationPage.upLoadFile(picture);
        registrationPage.setAddressInput(address);
        registrationPage.chooseState(state);
        registrationPage.chooseCity(city);
        registrationPage.clickSubmit();
        registrationPage.checkTable(firstName,
                lastName,
                email,
                gender,
                phoneNumber,
                monthText,
                year,
                subjects,
                picture,
                address,
                state,
                city);
        registrationPage.closeTable(checkForm);
    }
}