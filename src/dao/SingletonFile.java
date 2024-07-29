package dao;

import domain.Author;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class SingletonFile {

    public static SingletonFile singletonFile;

    private ArrayList<Author> lista;

    public static SingletonFile getSingletonFile(){
        if (singletonFile == null){

            singletonFile = new SingletonFile();
        }
        return singletonFile;
    }

    public List<Author> getObjectFileList() throws IOException, ClassNotFoundException {
        InputStream fis = new FileInputStream("AuthorDaoFile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        lista = (ArrayList<Author>) ois.readObject();

        return lista;
    }

    public ObjectOutputStream objectOutputStream (List<Author> lista ) throws IOException {
        OutputStream fos = new FileOutputStream("AuthorDaoFile.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lista);
        return oos;
    }
}
