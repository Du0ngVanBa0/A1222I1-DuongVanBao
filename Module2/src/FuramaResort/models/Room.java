package FuramaResort.models;

public class Room extends Facility {
    private String freeService;

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", maxPeople=" + maxPeople +
                ", typeHire='" + typeHire + '\'' +
                '}';
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public Room(String name, int area, int cost, int maxPeople, String typeHire, String freeService) {
        super(name, area, cost, maxPeople, typeHire);
        this.freeService = freeService;
    }
}
