package dao;

import domain.Author;
import domain.Book;
import domain.Order;
import exceptions.DAOException;
import services.BookDaoBBDD;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookDaoBBDDImpl implements BookDaoBBDD {


    @Override
    public List<Book> getAll() throws DAOException {
        return Collections.emptyList();
    }

    @Override
    public String byId(Integer id) throws DAOException {

        String selectSQL = "SELECT * FROM Book WHERE bookId = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proydesa", "root", "root");
             PreparedStatement preparedStatement = conn.prepareStatement(selectSQL)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int bookId = resultSet.getInt("bookId");
                    String title = resultSet.getString("title");
                    double price = resultSet.getDouble("price");
                    int authorId = resultSet.getInt("authorId");


                    String book= "bookId: "+bookId+"\n"
                            +"name: "+title+"\n"
                            +"price: " + price+"\n"
                            +"authorId: "+authorId;

                    return book;
                } else {
                    return "Libro no encntrado";
                }
            }

        } catch (SQLException e) {
            throw new DAOException("Error al leer el libro");
        }

    }

    @Override
    public void create(Book book) throws DAOException {

        String insertSQL = "INSERT INTO Book (bookId, title, price, authorId) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proydesa", "root", "root");
            PreparedStatement preparedStatement = conn.prepareStatement(insertSQL)) {
            preparedStatement.setInt(1, book.getBookId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.setInt(4, book.getAuthor().getAuthorId());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DAOException("Error al crear el libro");
        }
    }

    @Override
    public void update(Book book1, Book book2) throws DAOException {

        String updateSQL = "UPDATE Book SET title = ?, price = ?, authorId = ? WHERE bookId = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proydesa", "root", "root");
             PreparedStatement preparedStatement = conn.prepareStatement(updateSQL)) {

            preparedStatement.setString(1, book2.getTitle());
            preparedStatement.setDouble(2, book2.getPrice());
            preparedStatement.setInt(3, book2.getAuthor().getAuthorId());
            preparedStatement.setInt(4, book2.getBookId());
            preparedStatement.executeUpdate();
            System.out.println("El registro ha sido actualizado");

        } catch (SQLException e) {
            throw new DAOException("Error al actualizar el libro");
        }
    }



    @Override
    public List<String> getBooksSortedByTitle(Order order) throws DAOException {
        AuthorDaoBBDDImpl authorDaoBBDD= new AuthorDaoBBDDImpl();


        String orderByClause = (order == Order.Asc) ? "ASC" : "DESC";
        String selectSQL = "SELECT bookId, title, price, authorId FROM Book ORDER BY title " + orderByClause;
        String selectAuthor = "SELECT * from Author where id=?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proydesa", "root", "root");
             PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {

                int bookId = resultSet.getInt("bookId");
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                Integer authorId = resultSet.getInt("authorId");



//                String book= "bookId: "+bookId+"\n"
//                        +"name: "+title+"\n"
//                        +"price: " + price+"\n"
//                        +"authorId: "+authorId;




                List<String> list = new ArrayList<>();

                list.add("bookId: "+ bookId);
                list.add("name: "+ title);
                list.add("price: " + price);
                list.add("authorId: "+ authorId);

                return list;

            }

        } catch (SQLException e) {
            throw new DAOException("Error al obtener los libros ordenados por título");
        }
        return null;
    }


    @Override
    public void getBooksSortedByPrice(Order order) throws DAOException {

    }

    @Override
    public void delete(Integer Id) throws DAOException {

        String deleteSQL = "DELETE FROM Book WHERE bookId = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proydesa", "root", "root");
             PreparedStatement preparedStatement = conn.prepareStatement(deleteSQL)) {

            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();
            System.out.println("Registro eliminado correctamente");
        } catch (SQLException e) {
            throw new DAOException("Error al eliminar el libro");
        }

    }
}
