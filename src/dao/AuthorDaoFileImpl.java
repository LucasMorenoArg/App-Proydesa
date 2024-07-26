package dao;

import domain.Author;

import domain.Order;
import exceptions.DAOException;
import services.AuthorDaoFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AuthorDaoFileImpl implements AuthorDaoFile {


    @Override
    public void create(List<Author> author) throws IOException {

        OutputStream fos = new FileOutputStream("AuthorDaoFile.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(author);

    }


    @Override
    public List<Author> getAll() throws IOException, ClassNotFoundException {

        InputStream fis = new FileInputStream("AuthorDaoFile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Author> lista = (ArrayList<Author>) ois.readObject();

        return lista;
    }

    @Override
    public Author byId(Integer id) throws DAOException, IOException, ClassNotFoundException {
        InputStream fis = new FileInputStream("AuthorDaoFile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Author> lista = (ArrayList<Author>) ois.readObject();


        return lista.get(id);
    }

    @Override
    public void getAuthorsSortedByName(Order order) throws DAOException {


    }

}



