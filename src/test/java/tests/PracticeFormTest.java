//package tests;
//
//import com.codeborne.selenide.Browsers;
//import com.codeborne.selenide.Configuration;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//
//import java.io.File;
//
//import static com.codeborne.selenide.Condition.*;
//import static com.codeborne.selenide.Selectors.byText;
//import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
//
//public class PracticeFormTest {
//
//    @BeforeAll
//    static void beforeAll() {
//        Configuration.browser = Browsers.CHROME;
//        open();
//        getWebDriver().manage().window().maximize();
//        Configuration.baseUrl = "https://demoqa.com";
//    }
//
//    @Test
//    void practiceTest() {
//        open("/automation-practice-form");
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('#footer').remove()");
//        $("#firstName").setValue("Serje");
//        $("#lastName").setValue("Kowalski");
//        $("#userEmail").sendKeys("serje@gmail.com");
//        $("label[for='gender-radio-1']").click();
//        $("#userNumber").setValue("1234567890");
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__year-select").selectOption("2000");
//        $(".react-datepicker__day--016:not(react-datepicker__day--weekend)").click();
//        $("label[for='hobbies-checkbox-3']").click();
//        $("#uploadPicture").uploadFile(new File("picture/Screenshot.png"));
//        $("#currentAddress").setValue("pushkina-kolotushkina");
//        $("#state").click();
//        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
//        $("#city").click();
//        $("#stateCity-wrapper").$(byText("Agra")).click();
//        $("#submit").click();
//        $(".modal-content").should(appear);
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(By.xpath("//td[normalize-space()='Student Name']/following-sibling::td")).shouldHave(text("Serje Kowalski"));
//        $(By.xpath("//td[normalize-space()='Student Email']/following-sibling::td")).shouldHave(text("serje@gmail.com"));
//        $(By.xpath("//td[normalize-space()='Gender']/following-sibling::td")).shouldHave(text("Male"));
//        $(By.xpath("//td[normalize-space()='Mobile']/following-sibling::td")).shouldHave(text("1234567890"));
//        $(By.xpath("//td[normalize-space()='Date of Birth']/following-sibling::td")).shouldHave(text("16 July,200"));
//        $(By.xpath("//td[normalize-space()='Hobbies']/following-sibling::td")).shouldHave(text("Music"));
//        $(By.xpath("//td[normalize-space()='Picture']/following-sibling::td")).shouldHave(text("Screenshot.png"));
//        $(By.xpath("//td[normalize-space()='Address']/following-sibling::td")).shouldHave(text("pushkina-kolotushkina"));
//        $(By.xpath("//td[normalize-space()='State and City']/following-sibling::td")).shouldHave(text("Uttar Pradesh Agra"));
//        $("#closeLargeModal").click();
//
//    }
//}
