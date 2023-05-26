package case_study.FuramaResort.repository.interfaces;

import java.util.LinkedHashMap;

public interface IFacilityRepository<T> extends IRepository<T> {
    void displayMaintenance();

    LinkedHashMap<T, Integer> getMap();
}
