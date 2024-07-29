package dao;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import domain.Author;

import domain.Order;
import exceptions.DAOException;
import services.AuthorDaoFile;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AuthorDaoFileImpl implements AuthorDaoFile, Comparator<Author> {

    private final SingletonFile singletonFile = SingletonFile.getSingletonFile();


    @Override
    public Author byId(Integer id) throws DAOException, IOException, ClassNotFoundException {

        return singletonFile.getObjectFileList().get(id);
    }

    @Override
    public List<Author> update(Author author1, Author author2) throws DAOException, IOException, ClassNotFoundException {


        if ( author1 !=null && author2 != null) {

            return singletonFile.getObjectFileList();
        }

        return null;
    }

    @Override
    public void create(List<Author> author) throws IOException {

        singletonFile.objectOutputStream(author);

    }

    @Override
    public List<Author> getAllAuthors() throws IOException, ClassNotFoundException {

        System.out.println("getAllAuthorsfromFile");
        System.out.println(singletonFile.getObjectFileList().hashCode());
        return singletonFile.getObjectFileList();
    }


    @Override
    public void getAuthorsSortedByName(Order order) throws DAOException, IOException, ClassNotFoundException {

        List<Author> lista = singletonFile.getObjectFileList();
        Collections.sort(lista, new AuthorDaoFileImpl());

        for (Author author : lista ){
            System.out.println(author);
        }

    }

    @Override
    public void deleteId(int id) throws DAOException, IOException, ClassNotFoundException {

        singletonFile.getObjectFileList().remove(id);

        singletonFile.objectOutputStream(singletonFile.getObjectFileList());

        for(Author author:singletonFile.getObjectFileList()){
            System.out.println(author);
        }
    }

    @Override
    public int compare(Author author1, Author author2) {
        return author1.getName().compareTo(author2.getName());
    }


}



