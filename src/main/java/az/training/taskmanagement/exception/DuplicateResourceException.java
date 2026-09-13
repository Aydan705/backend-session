package az.training.taskmanagement.exception;

/**
 * Unikal olması gözlənilən dəyər (məs. email) təkrarlandıqda atılır.
 * Lesson 6-da bu, HTTP 409 (Conflict)-ə map olunacaq.
 */
public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String message) {
        super(message);
    }
}
