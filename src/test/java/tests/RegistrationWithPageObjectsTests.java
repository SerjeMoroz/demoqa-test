package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void registrationTest() {
        String userName = "Serje";
        String lastName = "Kowalski";
        String phone = "1234567890";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail("serje@gmail.com")
                .setGender("other")
                .setPhone(phone)
                .setBirthDate("30", "July", "2000");


        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("picture/Screenshot.png"));
        $("#currentAddress").setValue("pushkina-kolotushkina");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();

        $(By.xpath("//td[normalize-space()='Student Name']/following-sibling::td")).shouldHave(text("Serje Kowalski"));
        $(By.xpath("//td[normalize-space()='Student Email']/following-sibling::td")).shouldHave(text("serje@gmail.com"));
        $(By.xpath("//td[normalize-space()='Gender']/following-sibling::td")).shouldHave(text("Male"));
        $(By.xpath("//td[normalize-space()='Mobile']/following-sibling::td")).shouldHave(text("1234567890"));
        $(By.xpath("//td[normalize-space()='Date of Birth']/following-sibling::td")).shouldHave(text("16 July,2000"));
        $(By.xpath("//td[normalize-space()='Hobbies']/following-sibling::td")).shouldHave(text("Music"));
        $(By.xpath("//td[normalize-space()='Picture']/following-sibling::td")).shouldHave(text("Screenshot.png"));
        $(By.xpath("//td[normalize-space()='Address']/following-sibling::td")).shouldHave(text("pushkina-kolotushkina"));
        $(By.xpath("//td[normalize-space()='State and City']/following-sibling::td")).shouldHave(text("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();

        registrationPage.verifyResultModalAppears();
    }
}
