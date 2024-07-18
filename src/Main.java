import dao.AuthorDAOFActory;
import dao.BookDAOFactory;
import domain.Author;
import domain.Book;
import domain.Order;
import exceptions.DAOException;
import services.AuthorDao;
import services.BookDao;
import java.util.Map;


public class Main {
    public static void main(String[] args){


        AuthorDao authorDaoMemory = AuthorDAOFActory.createEmployeeDAO();
        BookDao bookDaoMemory = BookDAOFactory.createBookDao();


        try {

            //Creacion de Autores y libros
            createAuthor(authorDaoMemory);
            getAllAuthors(authorDaoMemory);
            createBook(bookDaoMemory, authorDaoMemory);

            //Actualización  y eliminacios de Autores y libros
            Book bookActualizado = new Book("CCC", 45.00, authorDaoMemory.byId(3));
            Book viejo = bookDaoMemory.byId(2);
            updateAuthor(3,"Jorge Lima","JLima@gmail.com",authorDaoMemory);
            getAllAuthors(authorDaoMemory);
            updateBook(viejo,bookActualizado,bookDaoMemory);
            getAllBooks(bookDaoMemory);
            authorOrder(authorDaoMemory);
            deleteAuthor(authorDaoMemory);
            deleteBook(bookDaoMemory);



        } catch (DAOException daoException){
            daoException.getMessage();
            daoException.getCause();
            daoException.getStackTrace();
            daoException.getLocalizedMessage();
        }


    }

    public static void createAuthor(AuthorDao authorDaoMemory) throws DAOException{

            //Creación de Autores

            assert authorDaoMemory!=null;
            authorDaoMemory.create(new Author("Isabel Allende", "jlBorges@gmail.com"));
            authorDaoMemory.create(new Author("Jorge Luis Borges", "IAllende@gmail.com"));
            authorDaoMemory.create(new Author("Gabriel Garcia Marquez", "GMarquez@gmail.com"));

        }



    public static void createBook(BookDao bookDaoMemory, AuthorDao authorDaoMemory) throws DAOException{

            //Creación de Libros

            bookDaoMemory.create(new Book("AAA", 35.00, authorDaoMemory.byId(1)));
            bookDaoMemory.create(new Book("BBB", 30.00, authorDaoMemory.byId(2)));
            bookDaoMemory.create(new Book("CCC", 34.00, authorDaoMemory.byId(3)));

    }

    public static void updateAuthor(Integer id,String nombre, String email, AuthorDao authorDaoMemory) throws DAOException{

           //Actualización de Autores
            authorDaoMemory.update(authorDaoMemory.byId(id), nombre, email);

    }

    public static void updateBook(Book viejo, Book actualizado, BookDao bookDaoMemory) throws DAOException{

            bookDaoMemory.update(viejo,actualizado);

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

        System.out.println(bookDaoMemory.getAll());

        }

    public static void authorOrder(AuthorDao authorDaoMemory) throws DAOException{

        authorDaoMemory.getAuthorsSortedByName(Order.Desc);
    }

    public static void deleteBook(BookDao bookDaoMemory) throws DAOException{

        bookDaoMemory.delete(0);
    }

    }

