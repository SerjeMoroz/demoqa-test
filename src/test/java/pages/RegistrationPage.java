package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
            birthDate = $("#dateOfBirthInput"),
            closeModalButton = $("#closeLargeModal"),
            hobbieCheckbox = $("label[for='hobbies-checkbox-3']"),
            currentAddress = $("#currentAddress"),
            stateButton = $("#state"),
            cityButton = $("#city"),
            submitButton = $("#submit");


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

    public RegistrationPage setGender() {
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

    public RegistrationPage clickHobbieCheckbox() {
        hobbieCheckbox.click();
        return this;
    }

    public RegistrationPage uploadPicture() {
        $("#uploadPicture").uploadFile(new File("picture/Screenshot.png"));
        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateButton.click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityButton.click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        return this;
    }

    public RegistrationPage submitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears () {
        registrationresultmodal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult (String key, String value) {
        registrationresultmodal.verifyResult(key, value);
        return this;
    }

    public RegistrationPage closeModal() {
        closeModalButton.click();
        return this;
    }


}
