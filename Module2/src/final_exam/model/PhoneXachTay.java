package final_exam.model;

public class PhoneXachTay extends Phone{
    String country;
    String status;

    public PhoneXachTay(String phoneID, String phoneName, int phonePrice, int phoneQuantity, String producer, String country, String status) {
        super(phoneID, phoneName, phonePrice, phoneQuantity, producer);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PhoneXachTay{" +
                "country= '" + country + '\'' +
                ", trạng thái= '" + status + '\'' +
                ", phoneID= '" + phoneID + '\'' +
                ", phoneName= '" + phoneName + '\'' +
                ", phonePrice= " + phonePrice +
                ", phoneQuantity= " + phoneQuantity +
                ", Nhà sản xuất= '" + producer + '\'' +
                '}';
    }
}
