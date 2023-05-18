package case_study.FuramaResort.model;

public class Villa extends Facility {

    private String standard;
    private int areaPool;
    private int numFloor;

    public Villa(String facilityCode, String facilityName, int area, int cost, int maxPeople, String typeHire, String standard, int areaPool, int numFloor) {
        super(facilityCode, facilityName, area, cost, maxPeople, typeHire);
        this.standard = standard;
        this.areaPool = areaPool;
        this.numFloor = numFloor;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(int areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(int numFloor) {
        this.numFloor = numFloor;
    }
}
