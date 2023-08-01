package repository.employee;

import model.*;
import service.division.DivisionServiceImpl;
import service.education_degree.EducationDegreeServiceImpl;
import service.position.PositionServiceImpl;
import service.user.UserServiceImpl;
import util.Constants;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private List<Employee> employees;
    PositionServiceImpl positionService = new PositionServiceImpl();
    EducationDegreeServiceImpl educationDegreeService = new EducationDegreeServiceImpl();
    DivisionServiceImpl divisionService = new DivisionServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void add(Employee employee) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.CREATE_EMPLOYEE);
        ) {
            statement.setString(1, employee.getName());
            System.out.println(employee.getBirthday());
            statement.setDate(2, new java.sql.Date(employee.getBirthday().getTime()));
            statement.setString(3, employee.getCardID());
            statement.setDouble(4, employee.getSalary());
            statement.setString(5, employee.getPhone());
            statement.setString(6, employee.getEmail());
            statement.setString(7, employee.getAddress());
            statement.setInt(8, employee.getPosition().getId());
            statement.setInt(9, employee.getEducationDegree().getId());
            statement.setInt(10, employee.getDivision().getId());
            statement.setString(11, employee.getUser().getUsername());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> findAll() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_ALL_EMPLOYEE);
        ) {
            ResultSet rs = statement.executeQuery();
            employees = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Date birthday = rs.getDate(3);
                String id_card = rs.getString(4);
                Double salary = rs.getDouble(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String address = rs.getString(8);
                int position_id = rs.getInt(9);
                int education_degree_id = rs.getInt(10);
                int division_id = rs.getInt(11);
                Position position = positionService.findByID(position_id);
                EducationDegree educationDegree = educationDegreeService.findByID(education_degree_id);
                Division division = divisionService.findByID(division_id);
                String username = rs.getString(12);
                User user = userService.findByUsername(username);
                employees.add(new Employee(id, name, birthday, id_card, salary, phone, email, address, position, educationDegree, division, user));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public List<Employee> findByName(String search_name) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_EMPLOYEE_BY_NAME);
        ) {
            statement.setString(1, "%" + search_name + "%");
            ResultSet rs = statement.executeQuery();
            employees = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Date birthday = rs.getDate(3);
                String id_card = rs.getString(4);
                Double salary = rs.getDouble(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String address = rs.getString(8);
                int position_id = rs.getInt(9);
                int education_degree_id = rs.getInt(10);
                int division_id = rs.getInt(11);
                Position position = positionService.findByID(position_id);
                EducationDegree educationDegree = educationDegreeService.findByID(education_degree_id);
                Division division = divisionService.findByID(division_id);
                String username = rs.getString(12);
                User user = userService.findByUsername(username);
                employees.add(new Employee(id, name, birthday, id_card, salary, phone, email, address, position, educationDegree, division, user));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public List<Employee> findByNameAndID(String search_name, int search_id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_EMPLOYEE_BY_NAME_OR_ID);
        ) {
            statement.setString(1, "%" + search_name + "%");
            statement.setInt(2, search_id);
            ResultSet rs = statement.executeQuery();
            employees = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Date birthday = rs.getDate(3);
                String id_card = rs.getString(4);
                Double salary = rs.getDouble(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String address = rs.getString(8);
                int position_id = rs.getInt(9);
                int education_degree_id = rs.getInt(10);
                int division_id = rs.getInt(11);
                Position position = positionService.findByID(position_id);
                EducationDegree educationDegree = educationDegreeService.findByID(education_degree_id);
                Division division = divisionService.findByID(division_id);
                String username = rs.getString(12);
                User user = userService.findByUsername(username);
                employees.add(new Employee(id, name, birthday, id_card, salary, phone, email, address, position, educationDegree, division, user));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public void deleteByID(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.DELETE_EMPLOYEE_BY_ID);
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAllByID(String[] ids) {
        Connection connection = null;
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.DELETE_EMPLOYEE_BY_ID);
            connection.setAutoCommit(false);
            for (String id : ids) {
                statement.setInt(1, Integer.parseInt(id));
                statement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException | ClassNotFoundException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
