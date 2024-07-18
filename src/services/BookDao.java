package services;


import domain.Book;
import domain.Order;
import exceptions.DAOException;

import java.util.List;

public interface BookDao {

    List<Book> getAll()throws DAOException;
    Book byId(Integer id) throws DAOException;
    void create(Book book) throws DAOException;
    void update(Book book1, Book book2)throws DAOException;
    void getBooksSortedByTitle(Order order) throws DAOException;
    void getBooksSortedByPrice(Order order) throws DAOException;
    void delete(Integer id) throws DAOException;
}
