package case_study.FuramaResort.model;

public class Room extends Facility {
    private String freeService;

    public Room(String facilityCode, String facilityName, double area, int cost, int maxPeople, String typeHire, String freeService) {
        super(facilityCode, facilityName, area, cost, maxPeople, typeHire);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
