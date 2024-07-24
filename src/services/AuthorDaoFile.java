package services;


import domain.Author;
import exceptions.DAOException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface AuthorDaoFile {

    void create(List<Author> author) throws DAOException, IOException;
    List<Author> getAll() throws DAOException, IOException, ClassNotFoundException;
    void writeFile() throws DAOException;
    void readFile() throws DAOException;

}
