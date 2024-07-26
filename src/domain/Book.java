package domain;

import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable {

    public static final long uid=1l;

    private static int idGenerator=1;
    private Integer bookId;
    private String title;
    private double price;
    private Author author;

    public Book() {
    }

    public Book(String title, double price, Author author) {
        this.bookId = idGenerator++;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return 0;
    }
}

