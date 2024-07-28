package services;


import domain.Book;
import domain.Order;
import exceptions.DAOException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BookDaoFile {


    void create(List<Book> book) throws DAOException, IOException;
    List<Book> getAll() throws DAOException, IOException, ClassNotFoundException;
    Book byId(Integer id) throws DAOException, IOException, ClassNotFoundException;
    void update(Book book1, Book book2) throws DAOException, IOException;
    void getBooksSortedByTitle(Order order) throws DAOException;
    void getBooksSortedByPrice(Order order) throws DAOException;
    void delete(Integer id) throws DAOException;
}
