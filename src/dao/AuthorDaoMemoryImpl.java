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
    public Author byId(Integer id){
        Author author = null;

        if (authors.containsKey(id)){
            author = authors.get(id);

        }else {
            System.out.println("El id seleccionado no esta registrado");
        }
        return author;
    }



    @Override
    public void create(Author author) throws DAOException {

      if (!authors.containsKey(author.getAuthorId())) {

              authors.put(author.getAuthorId(), author);
         }
        else {throw new DAOException();}
    }



    @Override
    public void update(Author author,String nombre,String email) throws DAOException{

        int id=author.getAuthorId();

        if (authors.containsValue(author)) {
                author.setName(nombre);
                author.setEmail(email);
                authors.put(id, author);
            }else throw new DAOException();
        }


    @Override
    public void delete(Integer id)throws DAOException{

        if (authors.containsKey(id)) {

            authors.remove(id);

        } else throw new DAOException();
    }


    public void getAuthorsSortedByName(Order order){

        TreeMap<Integer, Author> sortedAuthorMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer id1, Integer id2) {
                int num = 0;
                Author a1 = authors.get(id1);
                Author a2 = authors.get(id2);

                if (order == Order.Asc) {
                    num = a1.getName().compareTo(a2.getName());
                } else if (order == Order.Desc) {
                    num = a2.getName().compareTo(a1.getName());
                }

                return num;
            }
        });
            sortedAuthorMap.putAll(authors);
            for (Map.Entry<Integer, Author> entry : sortedAuthorMap.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

