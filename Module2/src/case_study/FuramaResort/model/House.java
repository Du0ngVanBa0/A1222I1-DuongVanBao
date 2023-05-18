package case_study.FuramaResort.model;

public class House extends Facility{
    private String standard;
    private int numFloor;

    public House(String facilityCode, String facilityName, int area, int cost, int maxPeople, String typeHire, String standard, int numFloor) {
        super(facilityCode, facilityName, area, cost, maxPeople, typeHire);
        this.standard = standard;
        this.numFloor = numFloor;
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
