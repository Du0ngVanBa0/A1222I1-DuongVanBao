package dvb.repository;

import dvb.model.MedicalDeclaration;

import java.util.List;

public interface IDeclarationRepository {
    void save(MedicalDeclaration medicalDeclaration);

    List<MedicalDeclaration> findAll();

    MedicalDeclaration findByID(String id);
}
