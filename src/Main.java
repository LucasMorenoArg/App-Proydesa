import dao.*;
import domain.Author;
import domain.Book;
import domain.Order;
import exceptions.DAOException;
import services.AuthorDao;
import services.AuthorDaoFile;
import services.BookDao;
import services.BookDaoFile;

import java.io.*;
import java.util.*;



public class Main {

    static AuthorDao authorDaoMemory = AuthorDaoFactory.createEmployeeDAO();
    static AuthorDaoFile authorDaoFile = AuthorDaoFileFactory.createDaoFile();
    static BookDao bookDaoMemory = BookDAOFactory.createBookDao();
    static BookDaoFile bookDaoFile = BookDaoFileFactory.createDaoFile();
    public static void main(String[] args){


        try {

            //Creación de autores y libros en memoria
            createAuthor(authorDaoMemory);
            createBook(bookDaoMemory, authorDaoMemory);
            //Creación de autores y libros en archivo
            createAuthorFile(authorDaoFile, authorDaoMemory);
            createBookFile(bookDaoFile, bookDaoMemory);

            //Creación de autores y libros en BBDD


            //Actualización  y eliminación de autores y libros
            updateAuthor(authorDaoMemory);
            updateBook(bookDaoMemory, authorDaoMemory);
            getAllBooks(bookDaoMemory);
            authorOrder(authorDaoMemory);
            deleteAuthor(authorDaoMemory);
            deleteBook(bookDaoMemory);
            booksSortedByPrice(bookDaoMemory);
            booksSortedByTitle(bookDaoMemory);
            getAllAuthors(authorDaoMemory);
            System.out.println("Lectura en archivo");
            readBookFile(authorDaoFile);
            System.out.println("byId");
            getBookId(1, bookDaoFile);

        } catch (DAOException daoException){

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }

    public static void createAuthor(AuthorDao authorDaoMemory) throws DAOException{

            assert authorDaoMemory!=null;
            authorDaoMemory.create(new Author("Isabel Allende", "jlBorges@gmail.com"));
            authorDaoMemory.create(new Author("Jorge Luis Borges", "IAllende@gmail.com"));
            authorDaoMemory.create(new Author("Gabriel Garcia Marquez", "GMarquez@gmail.com"));
    }

    public static void createBook(BookDao bookDaoMemory, AuthorDao authorDaoMemory) throws DAOException{

            bookDaoMemory.create(new Book("AAA", 35.00, authorDaoMemory.byId(1)));
            bookDaoMemory.create(new Book("BBB", 30.00, authorDaoMemory.byId(2)));
            bookDaoMemory.create(new Book("CCC", 34.00, authorDaoMemory.byId(3)));
    }

    public static void updateAuthor(AuthorDao authorDaoMemory) throws DAOException{

            String nombre = "Jorge Lima";
            String email = "JLima@gmail.com";
            authorDaoMemory.update(authorDaoMemory.byId(3), nombre, email);
    }

    public static void updateBook(BookDao bookDaoMemory, AuthorDao authorDaoMemory) throws DAOException{

            Book bookActualizado = new Book("CCC", 45.00, authorDaoMemory.byId(3));
            Book viejo = bookDaoMemory.byId(2);
            bookDaoMemory.update(viejo,bookActualizado);
      }

    public static void getAllAuthors(AuthorDao authorDaoMemory) throws DAOException {

            Map<Integer, Author> map = authorDaoMemory.getAll();
            for (Author mapa : map.values()){
                 System.out.println(mapa);
            }
    }

    public static void deleteAuthor(AuthorDao authorDaoMemory) throws DAOException {

            authorDaoMemory.delete(1);
    }

    public static void getAllBooks(BookDao bookDaoMemory) throws DAOException{

           for (Book book:bookDaoMemory.getAll()){
                System.out.println(book);}
    }

    public static Author byIds(AuthorDao authorDaoMemory, Integer id) throws DAOException {

       return  authorDaoMemory.byId(id);

    }

    public static void authorOrder(AuthorDao authorDaoMemory) throws DAOException{

            authorDaoMemory.getAuthorsSortedByName(Order.Desc);
    }

    public static void booksSortedByTitle(BookDao bookDaoMemory) throws DAOException{

            bookDaoMemory.getBooksSortedByTitle(Order.Asc);
    }

    public static void booksSortedByPrice(BookDao bookDaoMempory) throws DAOException{

            bookDaoMempory.getBooksSortedByPrice(Order.Desc);
    }

    public static void deleteBook(BookDao bookDaoMemory) throws DAOException{

            bookDaoMemory.delete(0);
    }

    public static void createAuthorFile(AuthorDaoFile authorDaoFile, AuthorDao authorDaoMemory) throws DAOException, IOException {

        List<Author> lista = new ArrayList<>();
        lista.add(authorDaoMemory.byId(1));
        lista.add(authorDaoMemory.byId(2));
        lista.add(authorDaoMemory.byId(3));

        authorDaoFile.create(lista);

    }

    public static void readBookFile(AuthorDaoFile authorDaoFile) throws DAOException, IOException, ClassNotFoundException {

        List<Author> lista =  authorDaoFile.getAll();

        for (Author author:lista){
            System.out.println(author);
        }

    }

    public static void createBookFile(BookDaoFile bookDaoFile, BookDao bookDao) throws DAOException, IOException, ClassNotFoundException {

        List<Book> lista = new ArrayList<>();
        lista.add(bookDao.byId(0));
        lista.add(bookDao.byId(1));
        lista.add(bookDao.byId(2));
        bookDaoFile.create(lista);

    }

    public static void getBookId(Integer id, BookDaoFile bookDaoFile) throws DAOException, IOException, ClassNotFoundException {


        System.out.println(bookDaoFile.byId(id));

    }






}


