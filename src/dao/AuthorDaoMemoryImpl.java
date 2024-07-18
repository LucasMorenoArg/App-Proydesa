package dao;

import domain.Author;
import domain.Order;
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
    public Map<Integer,Author> getAll() throws DAOException{

        if (!authors.isEmpty()) {

            return authors;

        } else throw new DAOException("No hay autores registrados");

    }


    @Override
    public Author byId(Integer id) throws DAOException{

        if (authors.containsKey(id)){

            return authors.get(id);

        } else throw new DAOException();

    }

    @Override
    public void create(Author author) throws DAOException {

      if (!authors.containsKey(author.getAuthorId())) {

              authors.put(author.getAuthorId(), author);
         }
        else throw new DAOException();
    }


    @Override
    public void update(Author author,String nombre,String email) throws DAOException{

        int id=author.getAuthorId();

        if (authors.containsValue(author)) {
                author.setName(nombre);
                author.setEmail(email);
                authors.put(id, author);

            } else throw new DAOException("Failed to sort authors");
        }


    @Override
    public void delete(Integer id)throws DAOException{

        if (authors.containsKey(id)) {

            authors.remove(id);

        } else throw new DAOException("Failed to sort authors");
    }



    @Override
    public void getAuthorsSortedByName(Order order) throws DAOException {
        if (authors == null) {
            throw new DAOException("Authors collection is null");
        }

        TreeMap<Integer, Author> sortedAuthorMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer id1, Integer id2) {

                Author a1 = authors.get(id1);
                Author a2 = authors.get(id2);

                    int num = 0;
                    if (order == Order.Asc) {
                        num = a1.getName().compareTo(a2.getName());
                    } else if (order == Order.Desc) {
                        num = a2.getName().compareTo(a1.getName());
                    }

                    return num;
                }

        });

        try {
            sortedAuthorMap.putAll(authors);
        } catch (NullPointerException e) {
            throw new DAOException("Failed to sort authors", e);
        }

        for (Map.Entry<Integer, Author> entry : sortedAuthorMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}

