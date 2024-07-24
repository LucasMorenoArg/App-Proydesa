package dao;

import domain.Author;
import exceptions.DAOException;
import services.AuthorDaoFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AuthorDaoFileImpl implements AuthorDaoFile {


    public ObjectOutputStream configObjectOutput() throws IOException {

        OutputStream fos = new FileOutputStream("archivoPrueba.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        return oos;
    }

    public ObjectInputStream configObjectInput() throws IOException {

        InputStream fis = new FileInputStream("archivoPrueba.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        return ois;
    }

    @Override
    public void create(Author author) throws IOException {

        OutputStream fos = new FileOutputStream("archivoPrueba.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(author);


    }


    @Override
    public List<Author> getAll() throws DAOException, IOException, ClassNotFoundException {

        InputStream fis = new FileInputStream("archivoPrueba.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        //Object i = configObjectInput().readObject();
        ArrayList<Author> lista = (ArrayList<Author>) ois.readObject();

        System.out.println(lista);

        return lista;
    }


    @Override
        public void writeFile () throws DAOException {

        }

        @Override
        public void readFile () throws DAOException {

        }
    }



