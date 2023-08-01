package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validate {
    private static final String USER_CODE_REGEX = "^U-\\d{4}$";
    private static final String USER_NAME_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)+$";

    public static boolean isUserName(String user_name) {
        return user_name.matches(USER_NAME_REGEX);
    }

    public static boolean isUserCode(String user_code) {
        return user_code.matches(USER_CODE_REGEX);
    }

    public static Date stringToDate(String str) throws ParseException, ParseException {
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        return format.parse(str);
    }
}
