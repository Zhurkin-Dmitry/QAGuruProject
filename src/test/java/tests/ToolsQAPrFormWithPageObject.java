package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;

public class ToolsQAPrFormWithPageObject extends TestBase {

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
            state = "NCR",
            city = "Delhi",
            checkForm = "Student Registration Form";

    @Test
    void selenideRegistrationForm() {
        step("Открываем форму", () -> {
            registrationPage.pageOpen(checkForm);
        });

        step("Заполняем форму регистрации", () -> {
            step("Вводим имя", () -> {
                registrationPage.typeFirstName(firstName);
            });
            step("Вводим фамилию", () -> {
                registrationPage.typeLastName(lastName);
            });
            step("Вводим email", () -> {
                registrationPage.typeEmail(email);
            });
            step("Выбираем пол", () -> {
                registrationPage.chooseGender(gender);
            });
            step("Вводим номер телефона", () -> {
                registrationPage.typePhoneNumber(phoneNumber);
            });
            step("Выбираем дату рождения", () -> {
                registrationPage.setDateOfBirth(monthNum, year);
            });
            step("Выбираем предмет", () -> {
                registrationPage.typeSubject(subjects);
            });
            step("Выбираем любимые хобби", () -> {
                registrationPage.chooseHobbies();
            });
            step("Загружаем изображение", () -> {
                registrationPage.upLoadFile(picture);
            });
            step("Вводим адресс", () -> {
                registrationPage.setAddressInput(address);
            });
            step("Выбираем штат", () -> {
                registrationPage.chooseState(state);
            });
            step("Выбираем город", () -> {
                registrationPage.chooseCity(city);
            });
            step("Отправляем данные", () -> {
                registrationPage.clickSubmit();
            });
        });

        step("Проверяем заполнение данных", () -> {
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
        });
        /* step("Закрываем таблицу с данными", () -> {
            registrationPage.closeTable(checkForm);
        }); */
    }
}