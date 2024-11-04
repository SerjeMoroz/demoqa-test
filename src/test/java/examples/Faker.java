package examples;

@SuppressWarnings("ALL")
public class Faker {
    public static net.datafaker.Faker faker = new net.datafaker.Faker();

    public static String firstName() {
        return "Test_" + faker.name().firstName();
    }

    public static String lastName() {
        return faker.name().lastName();
    }

    public static String email() {
        return faker.internet().emailAddress();
    }

    public static String text() {
        return faker.lorem().sentence();
    }

    public static String phone() {
        return "8" + faker.phoneNumber().subscriberNumber(9);
    }

    public static String address() {
        return faker.address().fullAddress();
    }
}
