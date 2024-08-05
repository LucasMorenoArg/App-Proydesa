package dao;


import services.AuthorDaoBBDD;


public class AuthorDaoBBDDFactory {


    public static AuthorDaoBBDD createDaoBBDD(){
        AuthorDaoBBDD dao= null;
        try {
            Class<?> clazz = Class.forName("dao.AuthorDaoBBDDImpl");
            dao= (AuthorDaoBBDD) clazz.newInstance();
        }catch (Exception error){
            error.getMessage();
        }

        return dao;
    }
}
