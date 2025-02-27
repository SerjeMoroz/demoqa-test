package pages;

import com.codeborne.selenide.SelenideElement;
import examples.Constants;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static examples.Constants.TITLE_TEXT;

public class RegistrationPage {

    RegistrationResultModal registrationresultmodal = new RegistrationResultModal();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            gender = $("label[for='gender-radio-3']"),
            phoneNumber = $("#userNumber"),
            birthDate = $("#dateOfBirthInput"),
            closeModalButton = $("#closeLargeModal"),
            hobbieCheckbox = $(byXpath("//div[@class='col-md-9 col-sm-12']//label[text()='Music']")),
            currentAddress = $("#currentAddress"),
            stateButton = $("#state"),
            cityButton = $("#city"),
            submitButton = $("#submit"),
            selectState = $("#stateCity-wrapper"),
            selectCity = $("#stateCity-wrapper");



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
        gender.click();
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

    public RegistrationPage clickHobbieCheckbox() {
        hobbieCheckbox.click();
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
