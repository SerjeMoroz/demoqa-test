package tests;

import examples.TestBase;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import examples.TestData;

public class RegistrationWithPageObjectsTests extends TestBase {
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationTest() {
        TestData testdata = new TestData();

        registrationPage.openPage()
                .setFirstName(testdata.firstName)
                .setLastName(testdata.lastName)
                .setEmail(testdata.email)
                .setGender(testdata.gender)
                .setPhone(testdata.phone)
                .setBirthDate(testdata.dayOfBirth, testdata.monthOfBirth, testdata.yearOfBirth)
                .setSubject(testdata.subject)
                .clickHobbieCheckbox(testdata.hobbie)
                .uploadPicture(testdata.picture)
                .setAddress(testdata.address)
                .setState(testdata.state)
                .setCity(testdata.city)
                .submitButton();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", testdata.firstName + " " + testdata.lastName)
                .verifyResult("Student Email", testdata.email)
                .verifyResult("Gender", testdata.gender)
                .verifyResult("Mobile", testdata.phone)
                .verifyResult("Date of Birth", testdata.dayOfBirth + " " + testdata.monthOfBirth + "," + testdata.yearOfBirth)
                .verifyResult("Subjects", testdata.subject)
                .verifyResult("Hobbies", testdata.hobbie)
                .verifyResult("Picture", testdata.picture)
                .verifyResult("Address", testdata.address)
                .verifyResult("State and City", testdata.state + " " + testdata.city)
                .closeModal();
    }
}
