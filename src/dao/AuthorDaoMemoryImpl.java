package dao;

import domain.Author;
import exceptions.DAOException;

import services.AuthorDao;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AuthorDaoMemoryImpl implements AuthorDao{

    private static Map<Integer, Author> authors;


    public AuthorDaoMemoryImpl(){
        authors = new HashMap<>();
    }



    @Override
    public void getAll() throws DAOException {

        for (Author author: authors.values()){
            System.out.println(author);
        }
    }


    @Override
    public Author byId(Integer id) {
        Author author = null;

        if (authors.containsKey(id)){
            try {

                author= authors.get(id);

            }catch (Exception exception){
                exception.getMessage();
            }
        }else {

            System.out.println("El id seleccionado no esta registrado");

        }
        return author;
    }



    @Override
    public void create(Author author) throws DAOException {

        if (!authors.containsKey(author.getAuthorId())) {
    try {

    authors.put(author.getAuthorId(), author);

    }catch (Exception e ){
        e.getMessage();

          }
        }else {
            System.out.println("Registro duplicado");
        }
    }



    @Override
    public void update(Author author) throws DAOException{

        int id=author.getAuthorId();

        if (authors.containsKey(id)) {
            try {
                authors.put(id, author);
            } catch (Exception daoException) {
                daoException.getMessage();
            }
        }
        System.out.println("author actualizado: " + author);
    }

    @Override
    public void delete(Integer id) throws DAOException{

        if (authors.containsKey(id)) {

            try {

                authors.remove(id);

            } catch (Exception e) {
                e.getMessage();
            }
        } else {
            System.out.println("Ingresar un Id válido");
        }
    }


    TreeMap<Integer, Author> sortedAuthorMap = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer id1, Integer id2) {
            Author a1 = authors.get(id1);
            Author a2 = authors.get(id2);
            return a1.getName().compareTo(a2.getName());
        }
    });


    public void getAuthorsSortedByName(){

        sortedAuthorMap.putAll(authors);
        for (Map.Entry<Integer, Author> entry : sortedAuthorMap.entrySet()) {
            System.out.println(entry.getValue());
        }



    }


}
