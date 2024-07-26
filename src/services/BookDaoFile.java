package services;

import domain.Author;
import domain.Book;
import exceptions.DAOException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BookDaoFile {


    void create(List<Book> book) throws DAOException, IOException;
    List<Book> getAll() throws DAOException, IOException, ClassNotFoundException;
    Book byId(Integer id) throws DAOException, IOException, ClassNotFoundException;
}
