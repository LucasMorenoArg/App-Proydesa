package services;

import domain.Author;
import domain.Order;
import exceptions.DAOException;

import java.util.Map;


public interface AuthorDao {

    Map<Integer,Author> getAll()throws DAOException;
    Author byId(Integer id)throws DAOException;
    void create(Author author)throws DAOException;
    void update(Author author, String nombre, String email)throws DAOException;
    void getAuthorsSortedByName(Order order);
    void delete(Integer id)throws DAOException;

}
