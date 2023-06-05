package case_study.FuramaResort.repository.implementations;

import case_study.FuramaResort.model.Booking;
import case_study.FuramaResort.model.BookingComparator;
import case_study.FuramaResort.repository.interfaces.IBookingRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class BookingRepositoryImpl implements IBookingRepository<Booking> {
    static TreeSet<Booking> bookingTreeSet = new TreeSet<>(new BookingComparator());

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            bookingTreeSet.add(new Booking("BK-0034", dateFormat.parse("10/5/2023"), dateFormat.parse("12/5/2023"), dateFormat.parse("15/5/2023"), "KH-2309", "SVVL-1234"));
            bookingTreeSet.add(new Booking("BK-0001", dateFormat.parse("11/5/2023"), dateFormat.parse("12/5/2023"), dateFormat.parse("12/5/2023"), "KH-2309", "SVVL-1234"));
            bookingTreeSet.add(new Booking("BK-0133", dateFormat.parse("08/5/2023"), dateFormat.parse("30/5/2023"), dateFormat.parse("18/5/2023"), "KH-2309", "SVVL-1234"));
        } catch (ParseException e) {
            System.out.println("->Error: Wrong date format(dd/MM/yyyy)!");
        }
    }

    @Override
    public List<Booking> getList() {
        return new LinkedList<>(bookingTreeSet);
    }

    @Override
    public void addNew(Booking booking) {
        bookingTreeSet.add(booking);
    }

    @Override
    public List<Booking> getThisMonthList() {
        List<Booking> thisMonthList = getList();
        //Get the booking with the month = this month and before today
        thisMonthList.removeIf(booking -> booking.getBeginDate().getMonth() != new Date().getMonth() || booking.getBeginDate().after(new Date()));
        return thisMonthList;
    }
}
