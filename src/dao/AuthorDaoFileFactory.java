package dao;


import services.AuthorDaoFile;

public class AuthorDaoFileFactory {


    public static AuthorDaoFile createDaoFile() {
        AuthorDaoFile dao = null;
        try {
            Class<?> clazz = Class.forName("dao.AuthorDaoFileImpl");
            dao = (AuthorDaoFile) clazz.newInstance();
        } catch (Exception error) {
            error.getMessage();
        }

        return dao;
    }
}
