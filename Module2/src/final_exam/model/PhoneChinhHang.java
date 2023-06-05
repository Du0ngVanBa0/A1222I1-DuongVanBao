package final_exam.model;

public class PhoneChinhHang extends Phone {
    int secureDay;
    String secureType;

    public PhoneChinhHang(String phoneID, String phoneName, int phonePrice, int phoneQuantity, String producer, int secureTime, String secureType) {
        super(phoneID, phoneName, phonePrice, phoneQuantity, producer);
        this.secureDay = secureTime;
        this.secureType = secureType;
    }

    public int getSecureTime() {
        return secureDay;
    }

    public void setSecureTime(int secureTime) {
        this.secureDay = secureTime;
    }

    public String getSecureType() {
        return secureType;
    }

    public void setSecureType(String secureType) {
        this.secureType = secureType;
    }

    @Override
    public String toString() {
        return "PhoneChinhHang{" +
                "Ngày bảo hành= " + secureDay +
                ", Phạm vi bảo hành= '" + secureType + '\'' +
                ", phoneID= '" + phoneID + '\'' +
                ", phoneName= '" + phoneName + '\'' +
                ", phonePrice= " + phonePrice +
                ", phoneQuantity= " + phoneQuantity +
                ", Nhà sản xuất= '" + producer + '\'' +
                '}';
    }
}
