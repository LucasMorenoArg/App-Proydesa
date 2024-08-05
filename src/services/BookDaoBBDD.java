package services;

import domain.Book;
import domain.Order;
import exceptions.DAOException;

import java.util.List;

public interface BookDaoBBDD {

    List<Book> getAll()throws DAOException;
    String byId(Integer Id) throws DAOException;
    void create(Book book) throws DAOException;
    void update(Book book1, Book book2)throws DAOException;
    List<String> getBooksSortedByTitle(Order order) throws DAOException;
    void getBooksSortedByPrice(Order order) throws DAOException;
    void delete(Integer Id) throws DAOException;
}
