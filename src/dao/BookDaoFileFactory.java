package dao;

import services.BookDaoFile;

public class BookDaoFileFactory {

    public static BookDaoFile createDaoFile(){
        BookDaoFile dao= null;
        try {
            Class<?> clazz = Class.forName("dao.BookDaoFileImpl");
            dao= (BookDaoFile) clazz.newInstance();
        }catch (Exception error){
            error.getMessage();
        }

        return dao;
    }

}
