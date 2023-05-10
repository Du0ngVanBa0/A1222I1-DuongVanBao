package FuramaResort.models;

public class Villa extends Facility {
    private String standard;
    private int areaPool;
    private int numFloor;

    public Villa(String name, int area, int cost, int maxPeople, String typeHire, String standard, int areaPool, int numFloor) {
        super(name, area, cost, maxPeople, typeHire);
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

    @Override
    public String toString() {
        return "Villa{" +
                "standard='" + standard + '\'' +
                ", areaPool=" + areaPool +
                ", numFloor=" + numFloor +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", maxPeople=" + maxPeople +
                ", typeHire='" + typeHire + '\'' +
                '}';
    }
}
