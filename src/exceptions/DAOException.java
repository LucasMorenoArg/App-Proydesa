package exceptions;

public class DAOException extends Exception{

    public DAOException(String failedToSortAuthors, NullPointerException e) {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException() {
        super();
    }


    @Override
    public String getMessage() {
        return "[DAOException] " + super.getMessage();
    }
}
