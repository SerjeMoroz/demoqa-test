package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public static void setDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
