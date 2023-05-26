package case_study.FuramaResort.repository.implementations;

import case_study.FuramaResort.model.Facility;
import case_study.FuramaResort.model.House;
import case_study.FuramaResort.model.Room;
import case_study.FuramaResort.model.Villa;
import case_study.FuramaResort.repository.interfaces.IFacilityRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class FacilityRepository implements IFacilityRepository<Facility> {
    static LinkedHashMap<Facility, Integer> facilityList = new LinkedHashMap<>();

    static {
        House house1 = new House("SVHO-1234", "House Emilia", 250, 1050, 6, "Month", "high standard", 3);
        Villa villa1 = new Villa("SVVL-1234", "Villa Emilia", 150, 550, 2, "Month", "normal standard", 150, 2);
        Room room1 = new Room("SVRO-1234", "Room Emilia", 100, 350, 4, "Month", "free fire");
        House house2 = new House("SVHO-1234", "House Emilia", 250, 1050, 6, "Month", "high standard", 3);
        facilityList.put(room1, 0);
        facilityList.put(villa1, 0);
        facilityList.put(house1, 0);
        facilityList.put(house2, 5);
    }

    @Override
    public void displayMaintenance() {

    }

    @Override
    public List<Facility> getList() {
        return new ArrayList<>(facilityList.keySet());
    }

    @Override
    public void addNew(Facility facility) {
        facilityList.put(facility, 0);
    }

    @Override
    public LinkedHashMap<Facility, Integer> getMap() {
        return facilityList;
    }
}
