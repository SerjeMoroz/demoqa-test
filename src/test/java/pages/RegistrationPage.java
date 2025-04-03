package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import java.io.File;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static examples.Constants.TITLE_TEXT;
import static examples.Faker.months;

public class RegistrationPage {

    RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            phoneNumber = $("#userNumber"),
            birthDate = $("#dateOfBirthInput"),
            closeModalButton = $("#closeLargeModal"),
            hobbieCheckbox = $("#hobbiesWrapper"),
            currentAddress = $("#currentAddress"),
            stateButton = $("#state"),
            cityButton = $("#city"),
            submitButton = $("#submit"),
            selectState = $("#stateCity-wrapper"),
            selectCity = $("#stateCity-wrapper"),
            setSubject =$("#subjectsInput");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
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
        gender.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneNumber.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        birthDate.click();
        CalendarComponent.setDate(dayOfBirth, monthOfBirth, yearOfBirth);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        setSubject.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage clickHobbieCheckbox(String value) {
        hobbieCheckbox.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/Screenshot.png"));
        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateButton.scrollTo().click();
        selectState.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityButton.click();
        selectCity.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);
        return this;
    }

    public RegistrationPage closeModal() {
        closeModalButton.click();
        return this;
    }

}
