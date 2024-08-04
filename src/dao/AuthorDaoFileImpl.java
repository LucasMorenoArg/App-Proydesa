package dao;

import domain.Author;

import domain.Order;
import exceptions.DAOException;
import services.AuthorDaoFile;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AuthorDaoFileImpl implements AuthorDaoFile, Comparator<Author>{

    private final SingletonFile singletonFile = SingletonFile.getSingletonFile();


    @Override
    public Author byId(Integer id) throws DAOException, IOException, ClassNotFoundException {

        return singletonFile.readList().get(id);
    }

    @Override
    public List<Author> update(Author author1, Author author2) throws DAOException, IOException, ClassNotFoundException {


        return singletonFile.readList();
    }

    @Override
    public void create(List<Author> author) throws IOException {

        singletonFile.writeList(author);

    }

    @Override
    public List<Author> getAllAuthors() throws IOException, ClassNotFoundException {

        System.out.println("getAllAuthorsfromFile");

        return singletonFile.readList();
    }


    @Override
    public void getAuthorsSortedByName(Order order) throws DAOException, IOException, ClassNotFoundException {

        List<Author> lista = singletonFile.readList();
        Collections.sort(lista, new AuthorDaoFileImpl());

        for (Author author : lista ){
            System.out.println(author);
        }

    }

    @Override
    public void deleteId(int id) throws DAOException, IOException, ClassNotFoundException {

        singletonFile.readList().remove(id);

        singletonFile.writeList(singletonFile.readList());

        for(Author author:singletonFile.readList()){
            System.out.println(author);
        }
    }

    @Override
    public int compare(Author author1, Author author2) {
        return author1.getName().compareTo(author2.getName());
    }


}



