package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    RegistrationResultModal registrationresultmodal = new RegistrationResultModal();

    private String titleText = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            gender = $("label[for='gender-radio-3']"),
            phoneNumber = $("#userNumber"),
            birthDate = $("#dateOfBirthInput");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(titleText));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        gender.click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneNumber.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDate.click();
        CalendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultModalAppears () {
        registrationresultmodal.verifyModalAppears();
        return this;
    }

}
