package registration;

public class Validation {

    public static boolean isValidEmail(String email) {

        return email.contains("@");

    }

    public static boolean isValidMobile(String mobile) {

        return mobile.matches("\\d{10}");

    }

    public static boolean isValidPassword(String password) {

        return password.length() >= 8;

    }

}