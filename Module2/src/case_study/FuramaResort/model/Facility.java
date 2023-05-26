package case_study.FuramaResort.model;

public abstract class Facility {
    String facilityCode;
    String facilityName;
    double area;
    int cost;
    int maxPeople;
    String typeHire;

    public Facility(String facilityCode, String facilityName, double area, int cost, int maxPeople, String typeHire) {
        this.facilityCode = facilityCode;
        this.facilityName = facilityName;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.typeHire = typeHire;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeHire() {
        return typeHire;
    }

    public void setTypeHire(String typeHire) {
        this.typeHire = typeHire;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "facilityCode='" + facilityCode + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", maxPeople=" + maxPeople +
                ", typeHire='" + typeHire + '\'' +
                '}';
    }
}
