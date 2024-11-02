package examples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @BeforeAll
    static void beforeAll() {
        Configuration.fastSetValue = false;
        open();
        getWebDriver().manage().window().maximize();
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void beforeEach() {
        Selenide.closeWebDriver();
    }
}
