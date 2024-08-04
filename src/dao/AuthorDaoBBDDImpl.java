package dao;

import domain.Author;
import domain.Order;
import exceptions.DAOException;
import services.AuthorDao;

import java.sql.*;
import java.util.Map;

public class AuthorDaoBBDDImpl implements AuthorDao {

    public ResultSet connection(){

    try {

        Connection conn =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebatec",
        "root", "root");
        Statement statement = conn.createStatement();
        return statement.executeQuery("select * from tmp_items");

    } catch (SQLException e){
        throw new RuntimeException(e);
    }

    }
    @Override
    public Map<Integer, Author> getAll() throws DAOException {
        return null;
    }

    @Override
    public Author byId(Integer id) throws DAOException {
        return null;
    }

    @Override
    public void create(Author author) throws DAOException {

    }

    @Override
    public void update(Author author, String nombre, String email) throws DAOException {

    }

    @Override
    public void getAuthorsSortedByName(Order order) throws DAOException {

    }

    @Override
    public void delete(Integer id) throws DAOException {

    }
}
