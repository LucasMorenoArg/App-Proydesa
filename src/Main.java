import dao.AuthorDaoMemoryImpl;
import dao.BookDaoMemoryImpl;
import domain.Author;
import domain.Book;
import domain.Order;


public class Main {
    public static void main(String[] args) throws Exception {

        AuthorDaoMemoryImpl authorDaoMemory = new AuthorDaoMemoryImpl();
        BookDaoMemoryImpl bookDaoMemory = new BookDaoMemoryImpl();

        authorDaoMemory.create(new Author("Jorge Luis Borges", "jlBorges@gmail.com"));
        authorDaoMemory.create(new Author("Isabel Allende", "IAllende@gmail.com"));
        authorDaoMemory.create(new Author("Gabriel Garcia Marquez", "GMarquez@gmail.com"));

        bookDaoMemory.create(new Book("AAA",35.00,authorDaoMemory.byId(1)));
        bookDaoMemory.create(new Book("BBB",30.00,authorDaoMemory.byId(2)));
        bookDaoMemory.create(new Book("CCC",34.00,authorDaoMemory.byId(3)));

        //Author authorActualizado = new Author(3 ,"Juan Lima","JLima@gmail.com");

        //Book bookActualizado = new Book("CCC", 45.00, authorDaoMemory.byId(3));
        //Book book2 = bookDaoMemory.byId(0);
        //authorDaoMemory.getAll();
        //authorDaoMemory.update(authorActualizado);


        System.out.println("-------------------------------------------");
        System.out.println("bookDaoMemory");
        System.out.println("-------------------------------------------");
        //bookDaoMemory.update(book2,bookActualizado);


        bookDaoMemory.getBooksSortedByTitle(Order.Desc);

        System.out.println("-------------------------------------------");

        bookDaoMemory.getBooksSortedByPrice(Order.Desc);



    }
}