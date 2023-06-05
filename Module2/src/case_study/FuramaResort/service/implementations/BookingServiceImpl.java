package case_study.FuramaResort.service.implementations;

import case_study.FuramaResort.model.Booking;
import case_study.FuramaResort.model.Customer;
import case_study.FuramaResort.model.Facility;
import case_study.FuramaResort.repository.implementations.BookingRepositoryImpl;
import case_study.FuramaResort.repository.implementations.CustomerRepositoryImpl;
import case_study.FuramaResort.repository.implementations.FacilityRepositoryImpl;
import case_study.FuramaResort.service.interfaces.IBookingService;
import case_study.FuramaResort.utils.Validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BookingServiceImpl implements IBookingService {

    BookingRepositoryImpl bookingRepository = new BookingRepositoryImpl();
    Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        List<Booking> bookingList = bookingRepository.getList();
        System.out.println("--Display Booking List--");
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
    }

    @Override
    public void add() {
        String code = autoEnterCode();
        String customerCode = enterCustomerCode();
        String facilityCode = enterFacilityCode();
        Date bookingDate = enterBookingDate();
        Date beginDate = enterBeginDate();
        Date endDate = enterEndDate(beginDate);
        bookingRepository.addNew(new Booking(code, bookingDate, beginDate, endDate, customerCode, facilityCode));
        System.out.println("-Add successfully--");
    }

    private String autoEnterCode() {
        String numCode = String.valueOf(getMaxNumberCode() + 1);
        for (int i = 0; i < 4 - numCode.length(); i++) {
            numCode = "0".concat(numCode);
        }
        return "BK-" + numCode;
    }

    private int getMaxNumberCode() {
        int maxNum = 0;
        List<Booking> bookingList = bookingRepository.getList();
        for (Booking booking : bookingList) {
            int codeNum = getNumberCode(booking.getBookingCode());
            if (maxNum < codeNum) {
                maxNum = codeNum;
            }
        }
        return maxNum;
    }

    private int getNumberCode(String code) {
        try {
            String numStr = code.substring(3);
            return Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            System.out.println(code + " wrong format yyyy number!");
        }
        return 0;
    }

    private Date enterBookingDate() {
        Date bookingDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        do {
            try {
                System.out.print("Enter Booking Date(dd/MM/yyyy): ");
                bookingDate = dateFormat.parse(sc.nextLine());
                return bookingDate;
            } catch (ParseException ex) {
                System.out.println("->Error: Wrong format date(dd/MM/yyyy)!");
            }
        } while (true);
    }

    private Date enterBeginDate() {
        Date beginDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        do {
            try {
                System.out.print("Enter Begin Date(dd/MM/yyyy): ");
                beginDate = dateFormat.parse(sc.nextLine());
                if (new Validation().isBeginBookingDate(beginDate)) {
                    return beginDate;
                } else {
                    System.out.println("->Error: Begin Date must not be before today!");
                }
            } catch (ParseException ex) {
                System.out.println("->Error: Wrong format date(dd/MM/yyyy)!");
            }
        } while (true);
    }

    private Date enterEndDate(Date beginDate) {
        Date endDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        do {
            try {
                System.out.print("Enter End Date(dd/MM/yyyy): ");
                endDate = dateFormat.parse(sc.nextLine());
                if (new Validation().isEndBookingDate(beginDate, endDate)) {
                    return endDate;
                } else {
                    System.out.println("->Error: End Date must not be before the begin day!");
                }
            } catch (ParseException ex) {
                System.out.println("->Error: Wrong format date(dd/MM/yyyy)!");
            }
        } while (true);
    }

    private String enterFacilityCode() {
        new FacilityServiceImpl().display();
        String code = "";
        boolean valid = false;
        do {
            System.out.print("Enter Facility's code: ");
            code = sc.nextLine();
            List<Facility> facilityList = new FacilityRepositoryImpl().getList();
            for (Facility facility : facilityList) {
                if (facility.getFacilityCode().equals(code)) {
                    valid = true;
                    break;
                }
            }
            if (valid) {
                return code;
            } else {
                System.out.println("->Error: This code don't match with the Facility's list!");
            }
        } while (true);
    }

    private String enterCustomerCode() {
        new CustomerServiceImpl().display();
        String code = "";
        boolean valid = false;
        do {
            System.out.print("Enter Customer's code(Ex: KH-1234): ");
            code = sc.nextLine();
            if (new Validation().isCustomerCode(code)) {
                List<Customer> customerList = new CustomerRepositoryImpl().getList();
                for (Customer customer : customerList) {
                    if (customer.getCustomerCode().equals(code)) {
                        valid = true;
                        break;
                    }
                }
                if (valid) {
                    return code;
                } else {
                    System.out.println("->Error: This code don't match with the Customer's list!");
                }
            } else {
                System.out.println("->Error: Wrong format of Customer's code(KH-yyyy with y is a number 0-9)");
            }
        } while (true);
    }
}
