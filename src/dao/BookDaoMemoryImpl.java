package dao;

import domain.Book;
import exceptions.DAOException;
import services.BookDao;


import java.util.ArrayList;
import java.util.List;

public class BookDaoMemoryImpl implements BookDao {

    List<Book> books = new ArrayList<>();

    @Override
    public void getAll() {
            Book bcc=null;
        try {
            for (Book b:books){
                System.out.println(b.getTitle());

            }
        }catch (Exception d){
            d.getMessage();
        }


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
}
