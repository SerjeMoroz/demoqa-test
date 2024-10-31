package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;
import pages.components.RegistrationResultModal;


import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    @Test
    void registrationTest() {
        String userName = "Serje";
        String lastName = "Kowalski";
        String phone = "1234567890";
        String email = "serje@gmail.com";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender()
                .setPhone(phone)
                .setBirthDate("16", "July", "2000")
                .clickHobbieCheckbox()
                .uploadPicture()
                .setAddress("pushkina-kolotushkina")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .submitButton();



        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", "other")
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", "16 July,2000")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "Screenshot.png")
                .verifyResult("Address", "pushkina-kolotushkina")
                .verifyResult("State and City", "Uttar Pradesh Agra")
                .closeModal();
    }
}
