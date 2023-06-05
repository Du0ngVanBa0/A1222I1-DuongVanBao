package case_study.FuramaResort.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    private String bookingCode;
    private Date bookingDate;
    private Date beginDate;
    private Date endDate;
    private String customerCode;
    private String facilityCode;

    public Booking(String bookingCode, Date bookingDate, Date beginDate, Date endDate, String customerCode, String facilityCode) {
        this.bookingCode = bookingCode;
        this.bookingDate = bookingDate;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.customerCode = customerCode;
        this.facilityCode = facilityCode;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Booking{" +
                "bookingCode='" + bookingCode + '\'' +
                ", bookingDate=" + dateFormat.format(bookingDate) +
                ", beginDate=" + dateFormat.format(beginDate) +
                ", endDate=" + dateFormat.format(endDate) +
                ", customerCode='" + customerCode + '\'' +
                ", facilityCode='" + facilityCode + '\'' +
                '}';
    }
}
