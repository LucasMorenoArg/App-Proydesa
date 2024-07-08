import dao.AuthorDaoMemoryImpl;
import dao.BookDaoMemoryImpl;
import domain.Author;
import domain.Book;
import exceptions.DAOException;

import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {

        AuthorDaoMemoryImpl authorDaoMemory = new AuthorDaoMemoryImpl();
        BookDaoMemoryImpl bookDaoMemory = new BookDaoMemoryImpl();

        authorDaoMemory.create(new Author("Jorge Luis Borges", "jlBorges@gmail.com"));
        authorDaoMemory.create(new Author("Isabel Allende", "IAllende@gmail.com"));
        authorDaoMemory.create(new Author("Gabriel Garcia Marquez", "GMarquez@gmail.com"));

        bookDaoMemory.create(new Book("El Aleph",35.00,authorDaoMemory.byId(1)));
        bookDaoMemory.create(new Book("Eva Luna",30.00,authorDaoMemory.byId(2)));
        bookDaoMemory.create(new Book("En Agosto nos vemos",34.00,authorDaoMemory.byId(3)));

        Author authorActualizado = new Author(3 ,"Juan Lima","JLima@gmail.com");
        Book bookActualizado = new Book("El Despertar", 45.00, authorDaoMemory.byId(3));
        Book book2 = bookDaoMemory.byId(0);

        authorDaoMemory.update(authorActualizado);
        authorDaoMemory.getAll();

        System.out.println("-------------------------------------------");
        System.out.println("bookDaoMemory");
        System.out.println("-------------------------------------------");
        bookDaoMemory.getAll();
        System.out.println("Lista actualizada");
        bookDaoMemory.update(book2,bookActualizado);
        bookDaoMemory.getAll();




    }
}