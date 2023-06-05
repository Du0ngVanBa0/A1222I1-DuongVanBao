package case_study.FuramaResort.model;

public class Contact {
    private String contactCode;
    private String bookingCode;
    private int depositMoney;
    private int totalPayment;

    public Contact(String contactCode, String bookingCode, int depositMoney, int totalPayment) {
        this.contactCode = contactCode;
        this.bookingCode = bookingCode;
        this.depositMoney = depositMoney;
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactCode='" + contactCode + '\'' +
                ", bookingCode='" + bookingCode + '\'' +
                ", depositMoney=" + depositMoney +
                ", totalPayment=" + totalPayment +
                '}';
    }

    public String getContactCode() {
        return contactCode;
    }

    public void setContactCode(String contactCode) {
        this.contactCode = contactCode;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public int getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(int depositMoney) {
        this.depositMoney = depositMoney;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }
}
