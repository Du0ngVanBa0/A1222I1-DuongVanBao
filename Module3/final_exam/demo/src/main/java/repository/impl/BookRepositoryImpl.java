package repository.impl;

import model.Book;
import repository.interf.IBookRepository;
import util.Constraints;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements IBookRepository {
    private List<Book> bookList;

    @Override
    public List<Book> findAll() {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.FIND_ALL_BOOK);
        ) {
            ResultSet rs = statement.executeQuery();
            bookList = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String author = rs.getString(3);
                int quantity = rs.getInt(4);
                String description = rs.getString(5);
                bookList.add(new Book(id, name, author, quantity, description));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }

    @Override
    public Book findByID(String book_id) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constraints.FIND_BOOK_BY_ID);
        ) {
            statement.setString(1, book_id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String author = rs.getString(3);
                int quantity = rs.getInt(4);
                String description = rs.getString(5);
                return new Book(id, name, author, quantity, description);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
