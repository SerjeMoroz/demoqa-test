import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void registrationTest() {
        String userName = "Serje";
        registrationPage.openPage();

        registrationPage.setFirstName(userName);
        registrationPage.setLastName(userName);
        registrationPage.setEmail(userName);
        registrationPage.setGender();
        registrationPage.setGender();



        $("#dateOfBirthInput").click();
        $(".react-datepicker-popper").shouldBe((visible));
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__month-select").click();
        $("option[value='0']").shouldBe(visible).click();
        $("option[value='1994']").shouldBe(visible).click();
        $("div[aria-label='Choose Saturday, January 29th, 1994']").click();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("picture/Screenshot.png"));
        $("#currentAddress").setValue("pushkina-kolotushkina");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();
        $(".modal-open").shouldHave(text("Thanks for submitting the form"));
        $(By.xpath("//td[normalize-space()='Student Name']/following-sibling::td")).shouldHave(text("Serje Kowalski"));
        $(By.xpath("//td[normalize-space()='Student Email']/following-sibling::td")).shouldHave(text("serje@gmail.com"));
        $(By.xpath("//td[normalize-space()='Gender']/following-sibling::td")).shouldHave(text("Male"));
        $(By.xpath("//td[normalize-space()='Mobile']/following-sibling::td")).shouldHave(text("1234567890"));
        $(By.xpath("//td[normalize-space()='Date of Birth']/following-sibling::td")).shouldHave(text("29 January,1994"));
        $(By.xpath("//td[normalize-space()='Hobbies']/following-sibling::td")).shouldHave(text("Music"));
        $(By.xpath("//td[normalize-space()='Picture']/following-sibling::td")).shouldHave(text("Screenshot.png"));
        $(By.xpath("//td[normalize-space()='Address']/following-sibling::td")).shouldHave(text("pushkina-kolotushkina"));
        $(By.xpath("//td[normalize-space()='State and City']/following-sibling::td")).shouldHave(text("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();

    }
}
