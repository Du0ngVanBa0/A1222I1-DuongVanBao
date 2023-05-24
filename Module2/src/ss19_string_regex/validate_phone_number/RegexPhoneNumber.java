package ss19_string_regex.validate_phone_number;

public class RegexPhoneNumber {
    private static final String PHONE_NUMBER_REGEX = "";

    public boolean isPhoneNumber(String name) {
        return name.matches(PHONE_NUMBER_REGEX);
    }
}
