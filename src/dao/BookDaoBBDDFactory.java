package dao;

import services.AuthorDaoBBDD;
import services.BookDaoBBDD;

import java.io.FileInputStream;
import java.util.Properties;

public class BookDaoBBDDFactory {


    public static BookDaoBBDD createBookDaoBBDD(){
        Properties props = new Properties();
        BookDaoBBDD dao= null;
        try {
            FileInputStream fis = new FileInputStream("src/resources/config.properties");
            props.load(fis);
            String name = props.getProperty("daoBookBBDDImpl");
            Class<?> clazz = Class.forName(name);
            dao= (BookDaoBBDD) clazz.newInstance();
        }catch (Exception error){
            error.getMessage();
        }

        return dao;
    }
}
