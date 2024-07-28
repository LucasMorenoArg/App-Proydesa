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
import java.sql.SQLOutput;
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


            //Actualización  y eliminación de autores y libros en memoria.
//            updateAuthor(authorDaoMemory);
//            updateBook(bookDaoMemory, authorDaoMemory);
//            getAllBooks(bookDaoMemory);
//            authorOrder(authorDaoMemory);
//            deleteAuthor(authorDaoMemory);
//            deleteBook(bookDaoMemory);
//            booksSortedByPrice(bookDaoMemory);
//            booksSortedByTitle(bookDaoMemory);
//            getAllAuthors(authorDaoMemory);
//            System.out.println("Lectura en archivo");
//            readBookFile(bookDaoFile);
//            System.out.println("byId");
//            getBookById(1, bookDaoFile);
//            //sortedAuthorsByName(authorDaoFile);
//            //authorById(0,authorDaoFile);
//            updateAuthor(authorDaoMemory);
            //getAllAuthors(authorDaoMemory);

            //Actualización  y eliminación de autores y libros en archivo.

              createAuthorFile(authorDaoFile,authorDaoMemory);
    //        authorByIdDaoFile(1,authorDaoFile);
              updateAuthorDaoFile(authorDaoFile);
    //        sortedAuthorsByNameFile(authorDaoFile);
              //getAllAuthorsDaoFile(authorDaoFile);




        } catch (DAOException daoException){

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }

    //--------------------AuthorDaoMemory-----------------------------------------------------------
    //--------------------AuthorDaoMemory-----------------------------------------------------------

    public static void createAuthor(AuthorDao authorDaoMemory) throws DAOException{

        assert authorDaoMemory!=null;
        authorDaoMemory.create(new Author("Isabel Allende", "IAllende@gmail.com"));
        authorDaoMemory.create(new Author("Jorge Luis Borges", "jlBorges@gmail.com"));
        authorDaoMemory.create(new Author("Gabriel Garcia Marquez", "GMarquez@gmail.com"));
    }


    public static void updateAuthor(AuthorDao authorDaoMemory) throws DAOException, IOException, ClassNotFoundException {

        String nombre = "Jorge Lima";
        String email = "JLima@gmail.com";
        authorDaoMemory.update(authorDaoMemory.byId(3), nombre, email);
    }


    public static void getAllAuthors(AuthorDao authorDaoMemory) throws DAOException {

        Map<Integer, Author> map = authorDaoMemory.getAll();
        for (Author mapa : map.values()){
            System.out.println(mapa);
        }
    }

    public static void authorOrder(AuthorDao authorDaoMemory) throws DAOException{

        authorDaoMemory.getAuthorsSortedByName(Order.Desc);
    }


    public static void deleteAuthor(AuthorDao authorDaoMemory) throws DAOException {

        authorDaoMemory.delete(1);
    }

    //--------------------BookDaoMemory--------------------------------------------------------------
    //--------------------BookDaoMemory--------------------------------------------------------------

    public static void createBook(BookDao bookDaoMemory, AuthorDao authorDaoMemory) throws DAOException{

            bookDaoMemory.create(new Book("AAA", 35.00, authorDaoMemory.byId(1)));
            bookDaoMemory.create(new Book("BBB", 30.00, authorDaoMemory.byId(2)));
            bookDaoMemory.create(new Book("CCC", 34.00, authorDaoMemory.byId(3)));
    }

    public static void getAllBooks(BookDao bookDaoMemory) throws DAOException{

           for (Book book:bookDaoMemory.getAll()){
                System.out.println(book);}
    }


    public static void updateBook(BookDao bookDaoMemory, AuthorDao authorDaoMemory) throws DAOException{

        Book bookActualizado = new Book("CCC", 45.00, authorDaoMemory.byId(3));
        Book viejo = bookDaoMemory.byId(2);
        bookDaoMemory.update(viejo,bookActualizado);
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


//--------------------AuthorDaoFile------------------------------------------------------------------
//--------------------AuthorDaoFile------------------------------------------------------------------


    public static void createAuthorFile(AuthorDaoFile authorDaoFile, AuthorDao authorDaoMemory) throws DAOException, IOException {

        List<Author> lista = new ArrayList<>();
        lista.add(authorDaoMemory.byId(1));
        lista.add(authorDaoMemory.byId(2));
        lista.add(authorDaoMemory.byId(3));

        authorDaoFile.create(lista);

    }

    public static void authorByIdDaoFile(Integer id, AuthorDaoFile authorDaoFile) throws DAOException, IOException, ClassNotFoundException {

        System.out.println(authorDaoFile.byId(id));
    }

    public static void getAllAuthorsDaoFile(AuthorDaoFile authorDaoFile) throws DAOException, IOException, ClassNotFoundException {

        for (Author a : authorDaoFile.getAllAuthors()){
            System.out.println(a);
        }
    }

    public static void updateAuthorDaoFile(AuthorDaoFile authorDaoFile) throws DAOException, IOException, ClassNotFoundException {

        Author author1 = authorDaoFile.byId(0);
        Author author2 = authorDaoFile.byId(0);
        author2.setName("Juan Lopez");
        author2.setEmail("JLopez@gmail.com");
        authorDaoFile.update(author1, author2);



    }

    public static void sortedAuthorsByNameFile(AuthorDaoFile authorDaoFile) throws DAOException, IOException, ClassNotFoundException {
        authorDaoFile.getAuthorsSortedByName(Order.Asc);
    }

    //------------------------BookDaoFile--------------------------------------------------------------
    //------------------------BookDaoFile--------------------------------------------------------------

    public static void createBookFile(BookDaoFile bookDaoFile, BookDao bookDao) throws DAOException, IOException, ClassNotFoundException {

        List<Book> lista = new ArrayList<>();
        lista.add(bookDao.byId(0));
        lista.add(bookDao.byId(1));
        lista.add(bookDao.byId(2));
        bookDaoFile.create(lista);

    }

    public static void readBookFile(BookDaoFile bookDaoFile) throws DAOException, IOException, ClassNotFoundException {

        List<Book> lista =  bookDaoFile.getAll();

        for (Book book:lista){
            System.out.println(book);
        }

    }

    public static void getBookById(Integer id, BookDaoFile bookDaoFile) throws DAOException, IOException, ClassNotFoundException {

        System.out.println(bookDaoFile.byId(id));

    }





}


