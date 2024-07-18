package dao;


import domain.Book;
import domain.Order;
import exceptions.DAOException;
import services.BookDao;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookDaoMemoryImpl implements BookDao {

    List<Book> books = new ArrayList<>();


    @Override
    public List<Book> getAll() throws DAOException {

            if (!books.isEmpty()){

                 return books;

            } else throw new DAOException();

    }

    @Override
    public Book byId(Integer id) throws DAOException  {

        if (id !=null && id >= 0){

                return books.get(id);

        } else throw new DAOException();

    }

    @Override
    public void create(Book book) throws DAOException {

        if (!books.contains(book)){

                books.add(book);

            } else throw new DAOException("No fue posible crear nuevo Book");
    }

    @Override
    public void update(Book book1, Book book2) throws DAOException {

        if (books.contains(book1)){

                books.remove(book1);
                books.add(book2);

        } else throw new DAOException ("No se pudo actualizar libro solicitado");

    }

    @Override
    public void delete(Integer id) throws DAOException{

        if (id != null && books.contains(books.get(id))) {

               int idBook= id.byteValue();
               books.remove(idBook);

            } else throw new DAOException("No fue posible el borrado del registro");
        }



    @Override
    public void getBooksSortedByTitle(Order order) throws DAOException {

        if (books==null){
            throw new DAOException("Lista en estado nulo");
        }
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
    public void getBooksSortedByPrice(Order order) throws DAOException{
        if (books==null){
            throw new DAOException("Lista en estado nulo");

        } else books.sort(new Comparator<Book>() {
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
