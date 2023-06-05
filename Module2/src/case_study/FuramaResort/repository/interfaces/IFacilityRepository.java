package case_study.FuramaResort.repository.interfaces;

import case_study.FuramaResort.model.Facility;

import java.util.LinkedHashMap;

public interface IFacilityRepository extends IRepository<Facility> {
    LinkedHashMap<Facility,Integer> getMaintenance();

    LinkedHashMap<Facility, Integer> getMap();
}
