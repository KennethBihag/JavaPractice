package Practice.jdbc;

import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
    public MyException(String message, Exception cause){
        super(message,cause);
    }
}
