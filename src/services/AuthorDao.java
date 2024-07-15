package services;

import domain.Author;
import domain.Order;
import exceptions.DAOException;


public interface AuthorDao {

    void getAll()throws DAOException;
    Author byId(Integer id)throws DAOException;
    void create(Author author)throws DAOException;
    void update(Author author)throws DAOException;
    void getAuthorsSortedByName(Order order);
    void delete(Integer id)throws DAOException;

}
