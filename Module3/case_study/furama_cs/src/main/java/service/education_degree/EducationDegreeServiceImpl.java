package service.education_degree;

import model.EducationDegree;
import repository.education_degree.EducationDegreeRepositoryImpl;

import java.util.List;

public class EducationDegreeServiceImpl implements IEducationDegreeService {
    private EducationDegreeRepositoryImpl educationDegreeRepository = new EducationDegreeRepositoryImpl();

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findByID(int id) {
        return educationDegreeRepository.findByID(id);
    }
}
