package FuramaResort.models;

public class House extends Facility {
    private String standard;
    private int numFloor;

    public House(String name, int area, int cost, int maxPeople, String typeHire, String standard, int numFloor) {
        super(name, area, cost, maxPeople, typeHire);
        this.standard = standard;
        this.numFloor = numFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "standard='" + standard + '\'' +
                ", numFloor=" + numFloor +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", maxPeople=" + maxPeople +
                ", typeHire='" + typeHire + '\'' +
                '}';
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(int numFloor) {
        this.numFloor = numFloor;
    }
}
