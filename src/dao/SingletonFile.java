package dao;

import domain.Author;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class SingletonFile {

    public static SingletonFile singletonFile;



    public static SingletonFile getSingletonFile(){

        if (singletonFile == null){

            singletonFile = new SingletonFile();
        }
        return singletonFile;
    }

    public List<Author> readList() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("AuthorDaoFile.txt"));

        List<Author> lista = (List<Author>) ois.readObject();
        ois.close();

        return lista;
    }

    public void writeList(List<Author> lista) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("AuthorDaoFile.txt"));

        oos.writeObject(lista);
        oos.close();
    }
}
