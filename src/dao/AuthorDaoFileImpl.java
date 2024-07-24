package dao;

import domain.Author;
import exceptions.DAOException;
import services.AuthorDaoFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class AuthorDaoFileImpl implements AuthorDaoFile {



    @Override
    public void create(List<Author> author) throws IOException {

        OutputStream fos = new FileOutputStream("archivoPrueba.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(author);

    }


    @Override
    public List<Author> getAll() throws DAOException, IOException, ClassNotFoundException {

        InputStream fis = new FileInputStream("archivoPrueba.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Author> lista = (ArrayList<Author>) ois.readObject();

        for (Author l:lista){
            System.out.println(l);
        }

        return null;
    }


    @Override
        public void writeFile () throws DAOException {


        }

        @Override
        public void readFile () throws DAOException {

        }
    }



