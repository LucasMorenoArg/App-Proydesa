package services;

import domain.Author;
import domain.Book;
import exceptions.DAOException;

import java.util.List;

public interface BookDao {

    List<Book> getAll();
    Book byId(Integer id) throws Exception;
    void create(Book book);
    void update(Book book1, Book book2)throws DAOException;
    void delete(Integer id);
}
