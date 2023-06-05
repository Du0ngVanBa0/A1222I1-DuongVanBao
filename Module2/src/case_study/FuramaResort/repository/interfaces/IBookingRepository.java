package case_study.FuramaResort.repository.interfaces;

import case_study.FuramaResort.model.Booking;

import java.util.List;

public interface IBookingRepository<T> extends IRepository<Booking> {
    List<Booking> getThisMonthList();
}
