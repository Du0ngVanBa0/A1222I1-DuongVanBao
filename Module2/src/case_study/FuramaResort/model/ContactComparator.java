package case_study.FuramaResort.model;

import case_study.FuramaResort.repository.implementations.BookingRepositoryImpl;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ContactComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        List<Booking> bookingList = new BookingRepositoryImpl().getList();
        Date date1 = new Date();
        Date date2 = new Date();
        for (Booking booking : bookingList) {
            if (Objects.equals(booking.getBookingCode(), o1.getBookingCode())) {
                date1 = booking.getBookingDate();
            } else if (Objects.equals(booking.getBookingCode(), o2.getBookingCode())) {
                date2 = booking.getBookingDate();
            }
        }
        return date1.compareTo(date2);
    }
}
