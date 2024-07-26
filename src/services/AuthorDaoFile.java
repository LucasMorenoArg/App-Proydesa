package services;


import domain.Author;
import domain.Order;
import exceptions.DAOException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public interface AuthorDaoFile {

    void create(List<Author> author) throws DAOException, IOException;
    List<Author> getAll() throws DAOException, IOException, ClassNotFoundException;
    Author byId(Integer id) throws DAOException, IOException, ClassNotFoundException;
    void getAuthorsSortedByName(Order order) throws DAOException;
}
