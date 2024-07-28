package dao;

import domain.Author;

import domain.Order;
import exceptions.DAOException;
import services.AuthorDaoFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AuthorDaoFileImpl implements AuthorDaoFile, Comparator<Author> {


    private List<Author> getObjectFileList() throws IOException, ClassNotFoundException {
        InputStream fis = new FileInputStream("AuthorDaoFile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Author> lista = (ArrayList<Author>) ois.readObject();

        return lista;
    }

    private ObjectOutputStream objectOutputStream ( ) throws IOException {
        OutputStream fos = new FileOutputStream("AuthorDaoFile.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        return oos;
    }

    @Override
    public Author byId(Integer id) throws DAOException, IOException, ClassNotFoundException {

        ArrayList<Author> lista = (ArrayList<Author>) getObjectFileList();

        return lista.get(id);
    }

    @Override
    public List<Author>
    update(Author author1, Author author2) throws DAOException, IOException, ClassNotFoundException {
        System.out.println(author1.getAuthorId());
        if ( author1 !=null && author2 != null) {

            deleteId(0);

        }

        for (Author a:getObjectFileList()){
            System.out.println(a);}
        objectOutputStream().reset();
        objectOutputStream().writeObject(getObjectFileList());
        for (Author a : getObjectFileList()){
            System.out.println(a);
        }
        return getObjectFileList();
    }

    @Override
    public void create(List<Author> author) throws IOException {

        objectOutputStream().writeObject(author);

    }

    @Override
    public List<Author> getAllAuthors() throws IOException, ClassNotFoundException {

        ArrayList<Author> lista = (ArrayList<Author>) getObjectFileList();

        return lista;
    }


    @Override
    public void getAuthorsSortedByName(Order order) throws DAOException, IOException, ClassNotFoundException {

        InputStream fis = new FileInputStream("AuthorDaoFile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Author> lista = (ArrayList<Author>) ois.readObject();

        Collections.sort(lista, new AuthorDaoFileImpl());

        for (Author author : lista ){
            System.out.println(author);
        }

    }

    @Override
    public void deleteId(Integer id) throws DAOException, IOException, ClassNotFoundException {

        getObjectFileList().remove(0);
    }

    @Override
    public int compare(Author author1, Author author2) {
        return author1.getName().compareTo(author2.getName());
    }


}



