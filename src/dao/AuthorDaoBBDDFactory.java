package dao;

import services.AuthorDao;
import services.AuthorDaoFile;

public class AuthorDaoBBDDFactory {


    public static AuthorDao createDaoBBDD(){
        AuthorDao dao= null;
        try {
            Class<?> clazz = Class.forName("dao.AuthorDaoBBDDImpl");
            dao= (AuthorDao) clazz.newInstance();
        }catch (Exception error){
            error.getMessage();
        }

        return dao;
    }
}
