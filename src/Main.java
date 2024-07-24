import dao.AuthorDaoFactory;
import dao.AuthorDaoFileFactory;
import dao.BookDAOFactory;
import domain.Author;
import domain.Book;
import domain.Order;
import exceptions.DAOException;
import services.AuthorDao;
import services.AuthorDaoFile;
import services.BookDao;

import java.io.*;
import java.util.*;



public class Main {

    static AuthorDao authorDaoMemory = AuthorDaoFactory.createEmployeeDAO();
    static AuthorDaoFile authorDaoFile = AuthorDaoFileFactory.createDaoFile();
    static BookDao bookDaoMemory = BookDAOFactory.createBookDao();


    public static void main(String[] args){


        try {

            //Creacion de Autores y libros
            createAuthor(authorDaoMemory);
            createAuthorFile(authorDaoFile, authorDaoMemory);
            createBook(bookDaoMemory, authorDaoMemory);

            //Actualización  y eliminacion de Autores y libros
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

            readFiles(authorDaoFile);

        } catch (DAOException daoException){

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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



    public static void readFiles(AuthorDaoFile authorDaoFile) throws DAOException, IOException, ClassNotFoundException {

         authorDaoFile.getAll();
        //Author i = byIds(authorDaoMemory,1);
        //authorDaoFile.getAll();
        //System.out.println(i);
    }




}


