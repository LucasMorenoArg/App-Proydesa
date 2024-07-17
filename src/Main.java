import dao.AuthorDAOFActory;
import dao.BookDAOFactory;
import domain.Author;
import domain.Book;
import exceptions.DAOException;
import services.AuthorDao;
import services.BookDao;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args){


        AuthorDao authorDaoMemory = AuthorDAOFActory.createEmployeeDAO();
        BookDao bookDaoMemory = BookDAOFactory.createBookDao();


        try {

            //Creacion de Autores y libros
            createAuthor(authorDaoMemory);
            createBook(bookDaoMemory, authorDaoMemory);

            //Actualización de Autores y libros
            Book bookActualizado = new Book("CCC", 45.00, authorDaoMemory.byId(1));
            updateAuthor(3,"Jorge Lima","JLima@gmail.com",authorDaoMemory);
            updateBook(bookDaoMemory.byId(0),bookActualizado,bookDaoMemory);

            //Obtener Autores y libros

            getAllAuthors(authorDaoMemory);



        } catch (DAOException daoException){
            daoException.getMessage();
        }


    }

    public static void createAuthor(AuthorDao authorDaoMemory) throws DAOException{

            //Creación de Autores
        if (authorDaoMemory != null) {
            authorDaoMemory.create(new Author("Isabel Allende", "jlBorges@gmail.com"));
            authorDaoMemory.create(new Author("Jorge Luis Borges", "IAllende@gmail.com"));
            authorDaoMemory.create(new Author("Gabriel Garcia Marquez", "GMarquez@gmail.com"));
          }
    }


    public static void createBook(BookDao bookDaoMemory, AuthorDao authorDaoMemory) throws DAOException{

            //Creación de Libros
        if (bookDaoMemory != null || authorDaoMemory != null) {
            bookDaoMemory.create(new Book("AAA", 35.00, authorDaoMemory.byId(1)));
            bookDaoMemory.create(new Book("BBB", 30.00, authorDaoMemory.byId(2)));
            bookDaoMemory.create(new Book("CCC", 34.00, authorDaoMemory.byId(3)));
          }
    }

    public static void updateAuthor(Integer id,String nombre, String email, AuthorDao authorDaoMemory) throws DAOException{

           //Actualización de Authores

        try{
            authorDaoMemory.update(authorDaoMemory.byId(id),nombre,email);
        }catch (DAOException daoException){
            throw new DAOException();
        }
    }

    public static void updateBook(Book viejo,Book actualizado, BookDao bookDaoMemory) throws DAOException{

        try{
            bookDaoMemory.update(viejo,actualizado);
        }catch (DAOException daoException){
            throw new DAOException();
        }
      }


    public static void getAllAuthors(AuthorDao authorDaoMemory) throws DAOException {

        Map<Integer, Author> map = authorDaoMemory.getAll();
        for (Author mapa : map.values()){
            System.out.println(mapa);
        }

      }
    }

