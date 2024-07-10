package services;

import domain.Order;

public interface BookService {

    void getBooksSortedByTitle(Order o);
    void getBooksSortedByPrice(Order o);
}
