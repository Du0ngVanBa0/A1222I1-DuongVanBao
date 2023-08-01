package repository.customer;

import model.Customer;
import model.CustomerType;
import service.customer_type.CustomerTypeServiceImpl;
import util.Constants;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    static List<Customer> customers;
    private CustomerTypeServiceImpl customerTypeService = new CustomerTypeServiceImpl();

    @Override
    public void add(Customer customer) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.CREATE_CUSTOMER);
        ) {
            statement.setInt(1, customer.getType().getId());
            statement.setString(2, customer.getName());
            statement.setDate(3, new Date(customer.getBirthday().getTime()));
            statement.setBoolean(4, customer.isGender());
            statement.setString(5, customer.getCardID());
            statement.setString(6, customer.getPhone());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getAddress());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> findAll() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_ALL_CUSTOMER);
        ) {
            customers = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                CustomerType customerType = customerTypeService.findByID(rs.getInt(2));
                String name = rs.getString(3);
                java.util.Date birthday = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                String id_card = rs.getString(6);
                String phone = rs.getString(7);
                String email = rs.getString(8);
                String address = rs.getString(9);
                customers.add(new Customer(id, customerType, name, birthday, gender, id_card, phone, email, address));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public void deleteByID(int id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.DELETE_CUSTOMER_BY_ID);
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer findByID(int id) {
        Customer customer = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_CUSTOMER_BY_ID);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                CustomerType customerType = customerTypeService.findByID(rs.getInt(2));
                String name = rs.getString(3);
                java.util.Date birthday = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                String id_card = rs.getString(6);
                String phone = rs.getString(7);
                String email = rs.getString(8);
                String address = rs.getString(9);
                customer = new Customer(id, customerType, name, birthday, gender, id_card, phone, email, address);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public void edit(Customer customer) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.EDIT_CUSTOMER_BY_ID);
        ) {
            statement.setInt(9, customer.getId());
            statement.setInt(1, customer.getType().getId());
            statement.setString(2, customer.getName());
            statement.setDate(3, (Date) customer.getBirthday());
            statement.setBoolean(4, customer.isGender());
            statement.setString(5, customer.getCardID());
            statement.setString(6, customer.getPhone());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getAddress());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> findAllWithPaging(int page, int record) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_ALL_CUSTOMER_PAGING);
        ) {
            customers = new ArrayList<>();
            statement.setInt(1, record);
            statement.setInt(2, (page - 1) * record);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                CustomerType customerType = customerTypeService.findByID(rs.getInt(2));
                String name = rs.getString(3);
                java.util.Date birthday = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                String id_card = rs.getString(6);
                String phone = rs.getString(7);
                String email = rs.getString(8);
                String address = rs.getString(9);
                customers.add(new Customer(id, customerType, name, birthday, gender, id_card, phone, email, address));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public int countAll() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.COUNT_ALL_CUSTOMER);
        ) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public List<Customer> findAllByName(String name, int page, int record) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_CUSTOMER_BY_NAME);
        ) {
            statement.setString(1, "%" + name + "%");
            customers = new ArrayList<>();
            statement.setInt(2, record);
            statement.setInt(3, (page - 1) * record);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                CustomerType customerType = customerTypeService.findByID(rs.getInt(2));
                String cusName = rs.getString(3);
                java.util.Date birthday = rs.getDate(4);
                boolean gender = rs.getBoolean(5);
                String id_card = rs.getString(6);
                String phone = rs.getString(7);
                String email = rs.getString(8);
                String address = rs.getString(9);
                customers.add(new Customer(id, customerType, cusName, birthday, gender, id_card, phone, email, address));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}
