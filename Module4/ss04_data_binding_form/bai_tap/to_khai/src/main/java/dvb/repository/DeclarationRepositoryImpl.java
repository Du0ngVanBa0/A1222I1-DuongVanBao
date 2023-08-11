package dvb.repository;

import dvb.model.Disease;
import dvb.model.MedicalDeclaration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeclarationRepositoryImpl implements IDeclarationRepository {
    private static Map<String, MedicalDeclaration> medicalDeclarationMap;
    static {
        medicalDeclarationMap = new HashMap<>();
    }
    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationMap.put(medicalDeclaration.getId(),medicalDeclaration);
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return null;
    }

    @Override
    public MedicalDeclaration findByID(String id) {
        return null;
    }
}
