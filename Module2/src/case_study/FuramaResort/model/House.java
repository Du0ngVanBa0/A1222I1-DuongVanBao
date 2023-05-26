package case_study.FuramaResort.model;

public class House extends Facility{
    private String standard;
    private double numFloor;

    public House(String facilityCode, String facilityName, double area, int cost, int maxPeople, String typeHire, String standard, int numFloor) {
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

    public double getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(int numFloor) {
        this.numFloor = numFloor;
    }
}
