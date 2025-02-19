package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static examples.Constants.REGISTRATION_FORM_TEXT;

public class RegistrationResultModal {

    public void verifyModalAppears() {
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(REGISTRATION_FORM_TEXT));
    }

    public void verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }

}
