package ss19_string_regex.validate_class_name;

public class RegexClassName {
    private static final String CLASS_REGEX = "^[ACP]\\d{4}[GHIKLM]$";

    public boolean isClassName(String name) {
        return name.matches(CLASS_REGEX);
    }
}
