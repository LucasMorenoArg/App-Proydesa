import dao.AuthorDAOFActory;
import dao.BookDAOFactory;
import domain.Author;
import domain.Book;
import domain.Order;
import services.AuthorDao;
import services.BookDao;


public class Main {
    public static void main(String[] args) throws Exception {


        AuthorDao authorDaoMemory = AuthorDAOFActory.createEmployeeDAO();
        BookDao bookDaoMemory = BookDAOFactory.createBookDao();

        //Creación de Autores
        authorDaoMemory.create(new Author("Isabel Allende", "jlBorges@gmail.com"));
        authorDaoMemory.create(new Author("Jorge Luis Borges", "IAllende@gmail.com"));
        authorDaoMemory.create(new Author("Gabriel Garcia Marquez", "GMarquez@gmail.com"));
        //Creación de Libros
        bookDaoMemory.create(new Book("AAA",35.00,authorDaoMemory.byId(1)));
        bookDaoMemory.create(new Book("BBB",30.00,authorDaoMemory.byId(2)));
        bookDaoMemory.create(new Book("CCC",34.00,authorDaoMemory.byId(3)));

        //Actualización de Authores
        Author author = authorDaoMemory.byId(3);
        authorDaoMemory.update(author,"Jorge Lima","JLima@gmail.com");

        System.out.println("-------------------------------------------");
        System.out.println("auhorDaoMemory");
        System.out.println("-------------------------------------------");
        authorDaoMemory.getAll();


        //Actualización de Book
        Book bookActualizado = new Book("CCC", 45.00, authorDaoMemory.byId(1));
        Book book2 = bookDaoMemory.byId(0);
        bookDaoMemory.update(book2,bookActualizado);


        System.out.println("-------------------------------------------");
        System.out.println("bookDaoMemory");
        System.out.println("-------------------------------------------");

        bookDaoMemory.getAll();








    }
}