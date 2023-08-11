package dvb.service;

import dvb.model.Disease;
import dvb.model.MedicalDeclaration;
import dvb.repository.DeclarationRepositoryImpl;

import java.util.List;

public class DeclarationServiceImpl implements IDeclarationService {
    private DeclarationRepositoryImpl meDeclarationRepository = new DeclarationRepositoryImpl();

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        meDeclarationRepository.save(medicalDeclaration);
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return meDeclarationRepository.findAll();
    }

    @Override
    public MedicalDeclaration findByID(String id) {
        return meDeclarationRepository.findByID(id);
    }
}
