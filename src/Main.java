import dao.AuthorDAOFActory;
import dao.BookDAOFactory;
import domain.Author;
import domain.Book;
import domain.Order;
import exceptions.DAOException;
import services.AuthorDao;
import services.BookDao;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    static File file = new File("archivoPrueba.txt"/*,"iso-8859-1"*/);
    static AuthorDao authorDaoMemory = AuthorDAOFActory.createEmployeeDAO();
    static BookDao bookDaoMemory = BookDAOFactory.createBookDao();
    public static void main(String[] args){





        try {

            //Creacion de Autores y libros
            createAuthor(authorDaoMemory);
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
            escribirObjeto();
            leerObjeto();
        } catch (DAOException daoException){
            System.out.println(daoException.getMessage());
            daoException.getCause();
            daoException.getStackTrace();
            System.out.println(daoException.getLocalizedMessage());
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

        for (Book book:bookDaoMemory.getAll())
            System.out.println(book);
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

    public static void escribirObjeto(){

        try (OutputStream fos= new FileOutputStream(file);
             ObjectOutputStream oos= new ObjectOutputStream(fos)){

             oos.writeObject(authorDaoMemory.getAll());


        }catch (IOException e){

        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leerObjeto() {

        try (InputStream fis = Files.newInputStream(file.toPath());
             ObjectInputStream ois = new ObjectInputStream(fis)) {


            Author aut= (Author) ois.readObject();
            Scanner scanner = new Scanner(String.valueOf(aut)).useDelimiter(",");
            System.out.println("antes de ingresar al scanner");
            while (scanner.hasNext()){

                String a= scanner.next();
                System.out.println(a);
            }
//          List<Author> newP = (List<Author>) ois.readObject();
//          ois.defaultReadObject();

//          for (Author p : newP){
//              System.out.println(p);
//          }


        } catch (IOException i) {
            System.out.println( i.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}

