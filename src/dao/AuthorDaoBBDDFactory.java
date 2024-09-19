package dao;


import services.AuthorDaoBBDD;

import java.io.FileInputStream;
import java.util.Properties;


public class AuthorDaoBBDDFactory {


    public static AuthorDaoBBDD createDaoBBDD() {
        Properties props = new Properties();
        AuthorDaoBBDD dao = null;
        try {
            FileInputStream fis = new FileInputStream("src/resources/config.properties");
            props.load(fis);
            String name = props.getProperty("daoAuthorBBDDImpl");
            Class<?> clazz = Class.forName(name);
            dao = (AuthorDaoBBDD) clazz.newInstance();
        } catch (Exception error) {
            error.getMessage();
        }

        return dao;
    }
}
