package tests;

import examples.Faker;
import examples.TestBase;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static pages.components.TestData.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationTest() {
        String userName = Faker.firstName();
        String lastName = Faker.lastName();
        String email = Faker.email();
        String phone = Faker.phone();
        String address = Faker.address();

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .clickHobbieCheckbox()
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitButton();


                registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city + " ")
                .closeModal();
    }
}
