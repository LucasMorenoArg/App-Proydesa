package services;


import domain.Author;
import domain.Order;
import exceptions.DAOException;

import java.io.IOException;
import java.util.List;


public interface AuthorDaoFile  {

    void create(List<Author> author) throws DAOException, IOException;
    List<Author> getAllAuthors() throws DAOException, IOException, ClassNotFoundException;
    Author byId(Integer id) throws DAOException, IOException, ClassNotFoundException;
    List<Author> update(Author author1, Author author2) throws DAOException, IOException, ClassNotFoundException;
    void getAuthorsSortedByName(Order order) throws DAOException, IOException, ClassNotFoundException;
    void deleteId(int id) throws DAOException, IOException, ClassNotFoundException;
}
