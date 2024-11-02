package pages.components;

import examples.Faker;

public class TestData extends Faker {
    public static String userName = Faker.userName();
    public static String lastName = Faker.lastName();
    public static String email = Faker.email();
    public static String phone = Faker.phone();
    public static String address = Faker.address();
    public static String gender = "Other";
    public static String dayOfBirth = "16";
    public static String monthOfBirth = "July";
    public static String yearOfBirth = "2000";


    public static String picture = "Screenshot.png";

}
