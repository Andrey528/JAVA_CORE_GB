package sem.sem3;

public class NoBanknotesToWithdrawException extends RuntimeException {
    public NoBanknotesToWithdrawException(int amount) {
        super(String.format("Запрашиваемая сумма(%s) не может быть выдана", amount));
    }
}
