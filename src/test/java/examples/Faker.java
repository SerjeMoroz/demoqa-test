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

    public static String firstName = Faker.firstName();
    public static String lastName = Faker.lastName();
    public static String email = Faker.email();
    public static String phone = Faker.phone();
    public static String address = Faker.address();
    public static String gender = faker.options().option("Male", "Female", "Other");
    public static String hobbie = faker.options().option("Sports", "Reading", "Music");
    public static String subject = faker.options().option("English", "Chemistry", "Computer science", "Commerce", "Economics", "Social studies",
            "Arts", "History", "Maths", "Biology", "Physics", "Accounting", "Civics", "Hindi");
    public static String dayOfBirth = "16";
    public static String monthOfBirth = "July";
    public static String yearOfBirth = "2000";
    public static String state = "Uttar Pradesh";
    public static String city  = "Agra";
    
    public static String picture = "Screenshot.png";
}
