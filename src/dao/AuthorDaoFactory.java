package dao;

import services.AuthorDao;

public class AuthorDaoFactory {

    public static AuthorDao createEmployeeDAO() {
        AuthorDao dao = null;
        try {
            Class<?> clazz = Class.forName("dao.AuthorDaoMemoryImpl");
            dao = (AuthorDao) clazz.newInstance();
        } catch (Exception error) {
            System.err.println(error.getMessage());
        }
        return dao;
    }
}
