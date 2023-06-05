package case_study.FuramaResort.model;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {

    @Override
    public int compare(Booking bk1, Booking bk2) {
        if (bk1.getBeginDate().equals(bk2.getBeginDate())) {
            if (bk1.getEndDate().before(bk2.getEndDate())) {
                return 1;
            } else if (bk1.getEndDate().after(bk2.getEndDate())) {
                return -1;
            } else {
                return 0;
            }
        } else {
            if (bk1.getBeginDate().before(bk2.getBeginDate())) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
