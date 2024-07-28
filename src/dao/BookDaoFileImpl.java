package dao;

import domain.Book;
import domain.Order;
import exceptions.DAOException;
import java.io.*;
import java.util.List;

public class BookDaoFileImpl implements services.BookDaoFile {
    @Override
    public void create(List<Book> book) throws DAOException, IOException {

        OutputStream fos = new FileOutputStream("BookDaoFile.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(book);

    }

    @Override
    public List<Book> getAll() throws DAOException, IOException, ClassNotFoundException {

        InputStream fis = new FileInputStream("BookDaoFile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Book> list = (List<Book>) ois.readObject();

        return list;
    }

    @Override
    public Book byId(Integer id) throws DAOException, IOException, ClassNotFoundException {

        InputStream fis = new FileInputStream("BookDaoFile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        List<Book> list = (List<Book>) ois.readObject();

        return list.get(id);
    }

    @Override
    public void update(Book book1, Book book2) throws DAOException, IOException {

        InputStream fis = new FileInputStream("BookDaoFile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        System.out.println(ois
        );

    }

    @Override
    public void getBooksSortedByTitle(Order order) throws DAOException {

    }

    @Override
    public void getBooksSortedByPrice(Order order) throws DAOException {

    }

    @Override
    public void delete(Integer id) throws DAOException {

    }


}
