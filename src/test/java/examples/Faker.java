package examples;

public class Faker {
    private static final net.datafaker.Faker faker = new net.datafaker.Faker();


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

    public static String gender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String hobbie() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String subject() {
        return faker.options().option("English", "Chemistry", "Computer science", "Commerce",
                "Economics", "Social studies", "Arts", "History", "Maths",
                "Biology", "Physics", "Accounting", "Civics", "Hindi");
    }

    public static String dayOfBirth() {
        return String.valueOf(faker.number().numberBetween(1, 29));
    }

    public static String monthOfBirth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return faker.options().option(months);
    }

    public static String yearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1980, 2010));
    }
}
