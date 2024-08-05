package services;

import domain.Author;
import domain.Order;
import exceptions.DAOException;

import java.util.Map;

public interface AuthorDaoBBDD {

    void getAll() throws DAOException;
    String byId(int id) throws DAOException;
    void create(Author author) throws DAOException;
    void update(Author author) throws DAOException;
    void getAuthorsSortedByName(Order order) throws DAOException;
    void delete(Integer id)throws DAOException;
}
