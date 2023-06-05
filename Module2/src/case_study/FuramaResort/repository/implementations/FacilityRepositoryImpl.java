package case_study.FuramaResort.repository.implementations;

import case_study.FuramaResort.model.*;
import case_study.FuramaResort.repository.interfaces.IFacilityRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepositoryImpl implements IFacilityRepository {
    static LinkedHashMap<Facility, Integer> facilityList = new LinkedHashMap<>();

    static {
        House house1 = new House("SVHO-1233", "House Emilia", 250, 1050, 6, "Month", "high standard", 3);
        Villa villa1 = new Villa("SVVL-1234", "Villa Emilia", 150, 550, 2, "Month", "normal standard", 150, 2);
        Room room1 = new Room("SVRO-1234", "Room Emilia", 100, 350, 4, "Month", "free fire");
        House house2 = new House("SVHO-1234", "House 2 Emilia", 250, 1050, 6, "Month", "high standard", 3);
        facilityList.put(room1, 0);
        facilityList.put(villa1, 0);
        facilityList.put(house1, 0);
        facilityList.put(house2, 0);
    }

    @Override
    public LinkedHashMap<Facility, Integer> getMaintenance() {
        LinkedHashMap<Facility, Integer> maintenanceMap = new LinkedHashMap<>();
        for (Map.Entry<Facility, Integer> entry : facilityList.entrySet()) {
            if (entry.getValue() >= 5) {
                maintenanceMap.put(entry.getKey(), entry.getValue());
            }
        }
        return maintenanceMap;
    }

    @Override
    public List<Facility> getList() {
        setUsedValue();
        return new ArrayList<>(facilityList.keySet());
    }

    @Override
    public void addNew(Facility facility) {
        facilityList.put(facility, 0);
    }

    @Override
    public LinkedHashMap<Facility, Integer> getMap() {
        setUsedValue();
        return facilityList;
    }

    private Facility findFacilityCode(String code) {
        for (Map.Entry<Facility, Integer> entry : facilityList.entrySet()) {
            if (entry.getKey().getFacilityCode().equals(code)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private void setUsedValue() {
        BookingRepositoryImpl bookingRepository = new BookingRepositoryImpl();
        for (Booking booking : bookingRepository.getThisMonthList()) {
            Facility currentFacility = findFacilityCode(booking.getFacilityCode());
            if (facilityList.containsKey(currentFacility)) {
                facilityList.replace(currentFacility, facilityList.get(currentFacility) + 1);
            }
        }
    }
}
