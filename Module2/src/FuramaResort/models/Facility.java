package FuramaResort.models;

public abstract class Facility {
    String name;
    int area;
    int cost;
    int maxPeople;
    String typeHire;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
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

    public Facility(String name, int area, int cost, int maxPeople, String typeHire) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.typeHire = typeHire;
    }
}
