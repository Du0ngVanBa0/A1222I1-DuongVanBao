package case_study.FuramaResort.utils;

import java.util.Calendar;
import java.util.Date;

public class Validation {
    private static final String VILLA_CODE_REGEX = "^SVVL-\\d{4}$";
    private static final String ROOM_CODE_REGEX = "^SVRO-\\d{4}$";
    private static final String HOUSE_CODE_REGEX = "^SVHO-\\d{4}$";
    private static final String CUSTOMER_CODE_REGEX = "^KH-\\d{4}$";
    private static final String EMPLOYEE_CODE_REGEX = "^NV-\\d{4}$";
    private static final String FULL_NAME_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)+$";
    private static final String SERVICE_NAME_REGEX = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
    private static final String EMAIL_REGEX = "^[\\w.]+@[\\w&&^_]+(.[\\w&&^_]+){1,2}$";
    private static final String PHONE_NUMBER_REGEX = "^0\\d{9}$";
    private static final String IDENTITY_CARD_REGEX = "^\\d{9}(\\d{3})?$";

    public boolean isVillaCode(String code) {
        return code.matches(VILLA_CODE_REGEX);
    }

    public boolean isHouseCode(String code) {
        return code.matches(HOUSE_CODE_REGEX);
    }

    public boolean isRoomCode(String code) {
        return code.matches(ROOM_CODE_REGEX);
    }

    public boolean isPhoneNumber(String phoneNumber) {
        return phoneNumber.matches(PHONE_NUMBER_REGEX);
    }

    public boolean isIdentityCard(String identityCard) {
        return identityCard.matches(IDENTITY_CARD_REGEX);
    }

    public boolean isEnough18Age(Date dOB) {
        Date now = new Date();
        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(now);
        Calendar dOBCalendar = Calendar.getInstance();
        dOBCalendar.setTime(dOB);
        int age = nowCalendar.get(Calendar.YEAR) - dOBCalendar.get(Calendar.YEAR);
        int nowMonth = nowCalendar.get(Calendar.MONTH);
        int dOBMonth = dOBCalendar.get(Calendar.MONTH);
        if (nowMonth < dOBMonth) {
            age--;
        } else if (nowMonth == dOBMonth) {
            if (nowCalendar.get(Calendar.DAY_OF_MONTH) > dOBCalendar.get(Calendar.DAY_OF_MONTH)) {
                age--;
            }
        }
        return age >= 18;
    }

    public boolean isBeginBookingDate(Date beginDate) {
        Date now = new Date();
        return !(beginDate.before(now));
    }

    public boolean isEndBookingDate(Date beginDate,Date endDate){
        return !(endDate.before(beginDate));
    }

    public boolean isEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    public boolean isEmployeeCode(String code) {
        return code.matches(EMPLOYEE_CODE_REGEX);
    }

    public boolean isCustomerCode(String code) {
        return code.matches(CUSTOMER_CODE_REGEX);
    }

    public boolean isFullName(String name) {
        return name.matches(FULL_NAME_REGEX);
    }

    public boolean isServiceName(String name) {
        return name.matches(SERVICE_NAME_REGEX);
    }
}
