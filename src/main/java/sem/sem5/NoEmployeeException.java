package sem.sem5;

public class NoEmployeeException extends RuntimeException {
    public NoEmployeeException(String id) {
        super("Отстуствует пользователь с id " + id);
    }
}
