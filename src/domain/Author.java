package domain;

import java.io.Serializable;

public class Author implements Serializable {

    public static final long uid=1l;

    private static int idGenerator =1;
    private int authorId;
    private String name;
    private String email;

    public Author(String name, String email) {
        this.authorId = idGenerator++;
        this.name = name;
        this.email = email;
    }


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
