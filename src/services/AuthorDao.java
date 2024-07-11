package services;

import domain.Author;
import domain.Book;
import exceptions.DAOException;

import java.util.List;
import java.util.Map;

public interface AuthorDao {

    void getAll()throws DAOException;
    Author byId(Integer id)throws DAOException;
    void create(Author author)throws DAOException;
    void update(Author author)throws DAOException;
    void delete(Integer id)throws DAOException;

}
