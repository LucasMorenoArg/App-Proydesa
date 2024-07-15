package dao;


import domain.Book;
import domain.Order;
import services.BookDao;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookDaoMemoryImpl implements BookDao {

    List<Book> books = new ArrayList<>();



    @Override
    public List<Book> getAll() {
           List<Book> bcc=null;
        try {

            for (Book b:books){
                System.out.println(b);
            }
            bcc = books;
        }catch (Exception d){
            d.getMessage();
        }
        return bcc;



    }

    @Override
    public Book byId(Integer id)  {

        Book book=null;

        try {
            if (id !=null && id >= 0){
                book = books.get(id);
            } else System.out.print("Id no valido");
        }catch (Exception e){
            e.getMessage();
        }


        return book;
    }

    @Override
    public void create(Book book) {

        if (!books.contains(book)){

            try {

                books.add(book);

            }catch (Exception e){
                e.getMessage();
            }
        }else System.out.println("No fue posible guardar el registro");

    }

    @Override
    public void update(Book book1, Book book2) {

        if (books.contains(book1)){

            try {
                books.remove(book1);
                books.add(book2);
            }catch (Exception e){
                e.getMessage();
            }

        } else System.out.println("No se pudo actualizar libro solicitado");

    }

    @Override
    public void delete(Integer id) {

        if (id != null && id >= 0) {
            try {
                books.remove(id);
            }catch (Exception e){
                e.getMessage();
            }
        }
    }


    @Override
    public void getBooksSortedByTitle(Order order) {

        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (order == Order.Asc) {
                 return o1.getTitle().compareTo(o2.getTitle());
                } else if (order ==Order.Desc) {
                    return o2.getTitle().compareTo(o1.getTitle());
                } else return 0;
            }

        });
        for (Book book: books){
            System.out.println(book);
        }
    }

    @Override
    public void getBooksSortedByPrice(Order order) {
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (order == Order.Asc){
                 return(int) (o1.getPrice() - (o2.getPrice()));
                } else if (order == Order.Desc) {
                    return(int) (o2.getPrice() - (o1.getPrice()));
                } else return 0;
            }
        });
        for (Book book: books){
            System.out.println(book);
        }
    }
}
