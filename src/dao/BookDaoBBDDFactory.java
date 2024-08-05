package dao;

import services.AuthorDaoBBDD;
import services.BookDaoBBDD;

public class BookDaoBBDDFactory {


    public static BookDaoBBDD createBookDaoBBDD(){
        BookDaoBBDD dao= null;
        try {
            Class<?> clazz = Class.forName("dao.BookDaoBBDDImpl");
            dao= (BookDaoBBDD) clazz.newInstance();
        }catch (Exception error){
            error.getMessage();
        }

        return dao;
    }
}
