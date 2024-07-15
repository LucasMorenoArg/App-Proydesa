package dao;

import services.BookDao;

public class BookDAOFactory {

    public static BookDao createBookDoa(){
        BookDao dao= null;
        try {
            Class<?> clazz = Class.forName("dao.BookDaoMemoryImpl");
        dao= (BookDao) clazz.newInstance();
        }catch (Exception error){
            error.getMessage();
        }

        return dao;
    }
}
