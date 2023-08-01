package repository.education_degree;

import model.EducationDegree;
import util.Constants;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements IEducationDegreeRepository {
    @Override
    public List<EducationDegree> findAll() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_ALL_EDUCATION_DEGREE);
        ) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                educationDegrees.add(new EducationDegree(id, name));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return educationDegrees;
    }

    @Override
    public EducationDegree findByID(int id) {
        EducationDegree educationDegree = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_EDUCATION_DEGREE_BY_ID);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int eDID = rs.getInt(1);
                String name = rs.getString(2);
                educationDegree = new EducationDegree(eDID, name);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return educationDegree;
    }
}
