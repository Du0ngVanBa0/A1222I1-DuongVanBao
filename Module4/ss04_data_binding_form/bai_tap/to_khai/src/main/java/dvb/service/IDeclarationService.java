package dvb.service;

import dvb.model.Disease;
import dvb.model.MedicalDeclaration;

import java.util.List;

public interface IDeclarationService {
    void save(MedicalDeclaration medicalDeclaration);

    List<MedicalDeclaration> findAll();

    MedicalDeclaration findByID(String id);
}
