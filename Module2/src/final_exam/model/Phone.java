package final_exam.model;

public class Phone {
    String phoneID;
    String phoneName;
    int phonePrice;
    int phoneQuantity;
    String producer;

    public Phone(String phoneID, String phoneName, int phonePrice, int phoneQuantity, String producer) {
        this.phoneID = phoneID;
        this.phoneName = phoneName;
        this.phonePrice = phonePrice;
        this.phoneQuantity = phoneQuantity;
        this.producer = producer;
    }

    public String getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(String phoneID) {
        this.phoneID = phoneID;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(int phonePrice) {
        this.phonePrice = phonePrice;
    }

    public int getPhoneQuantity() {
        return phoneQuantity;
    }

    public void setPhoneQuantity(int phoneQuantity) {
        this.phoneQuantity = phoneQuantity;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneID='" + phoneID + '\'' +
                ", phoneName='" + phoneName + '\'' +
                ", phonePrice=" + phonePrice +
                ", phoneQuantity=" + phoneQuantity +
                ", producer='" + producer + '\'' +
                '}';
    }
}
