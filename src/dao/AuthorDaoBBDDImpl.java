package dao;

import domain.Author;
import domain.Order;
import exceptions.DAOException;
import org.w3c.dom.ls.LSOutput;
import services.AuthorDao;
import services.AuthorDaoBBDD;

import java.sql.*;
import java.util.Map;

public class AuthorDaoBBDDImpl implements AuthorDaoBBDD {

    public ResultSet connection(){

    try {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/author",
        "root", "root");
        Statement statement = conn.createStatement();
        ResultSet rs;
        rs = null;
        return rs;

    } catch (SQLException e){
        throw new RuntimeException(e);
    }

    }
    @Override
    public void getAll() throws DAOException {

        String selectSQL = "SELECT authorId, name, email FROM Author";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proydesa", "root", "root");
             PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int authorId = resultSet.getInt("authorId");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("Id:" + authorId);
                System.out.println("Nombre:" +name);
                System.out.println("Email:" + email);
            }
        }catch (SQLException e) {
            //throw new DAOException("Error al recuperar todos los autores");
            System.out.println("Sql state: " + e.getSQLState());
            System.out.println("Error code: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());

            Throwable t = e.getCause();
            while(t!=null){
                System.out.println("Cause: " + t);
                t = t.getCause();
                e = e.getNextException();
            }
        }
    }
    @Override
    public String byId(int id) throws DAOException {
        String selectSQL = "SELECT authorId, name, email FROM Author WHERE authorId = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proydesa", "root", "root");
             PreparedStatement preparedStatement = conn.prepareStatement(selectSQL)) {
             preparedStatement.setInt(1, id);
             ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int authorId = resultSet.getInt("authorId");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");

                    String author= "Id:"+authorId+"\n"
                            +"name:"+name+"\n"
                            +"Email:" + email;

                    return author ;

                } else {
                    return "Author no encontrado"; // No author found with the given ID
                }
            }

        catch (SQLException e) {
            System.out.println(e.getMessage());;
        } return null;
    }

    @Override
    public void create(Author author) throws DAOException {

            String insertSQL = "INSERT INTO Author (authorId, name, email) VALUES (?, ?, ?)";
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proydesa", "root", "root");
                 PreparedStatement preparedStatement = conn.prepareStatement(insertSQL)) {

                preparedStatement.setInt(1, author.getAuthorId());
                preparedStatement.setString(2, author.getName());
                preparedStatement.setString(3, author.getEmail());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Author insertado exitosamente: " + author);
                } else {
                    System.out.println("No sé pudo insertar Author: " + author);
                }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Author author) throws DAOException {

        String updateSQL = "UPDATE Author SET name = ?, email = ? WHERE authorId = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proydesa", "root", "root");
             PreparedStatement preparedStatement = conn.prepareStatement(updateSQL)) {

            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getEmail());
            preparedStatement.setInt(3, author.getAuthorId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Autor actualizado con éxito: " + author);
            } else {
                System.out.println("No se encontró ningún autor con el ID proporcionado: " + author.getAuthorId());
            }

        } catch (SQLException e) {
            throw new DAOException("Error updating author");
        }

    }

    @Override
    public void getAuthorsSortedByName(Order order) throws DAOException {

    }

    @Override
    public void delete(Integer id) throws DAOException {
        String deleteSQL = "DELETE FROM Author WHERE authorId = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proydesa", "root", "root");
             PreparedStatement preparedStatement = conn.prepareStatement(deleteSQL)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Autor eliminado exitosamente con ID: " + id);
            } else {
                System.out.println("No se encontró ningún autor con el ID proporcionado: " + id);
            }

        } catch (SQLException e) {
            throw new DAOException("Error al eliminar el autor");
        }
    }
}
