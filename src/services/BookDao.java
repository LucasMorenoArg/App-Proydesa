package services;

import domain.Author;
import domain.Book;
import domain.Order;
import exceptions.DAOException;

import java.util.List;

public interface BookDao {

    List<Book> getAll();
    Book byId(Integer id) throws DAOException;
    void create(Book book);
    void update(Book book1, Book book2)throws DAOException;
    void getBooksSortedByTitle(Order order);
    void getBooksSortedByPrice(Order order);
    void delete(Integer id);
}
